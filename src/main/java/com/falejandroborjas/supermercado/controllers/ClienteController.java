package com.falejandroborjas.supermercado.controllers;

import com.falejandroborjas.supermercado.models.entity.Cliente;
import com.falejandroborjas.supermercado.models.service.IClienteService;
import com.falejandroborjas.supermercado.models.service.IUploadFileService;
import com.falejandroborjas.supermercado.util.paginator.PageRender;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;
    @Autowired
    private IUploadFileService fileService;

   // private final Logger log = LoggerFactory.getLogger(getClass());
   // private final static String UPLOADS_FOLDER = "uploads";

    @GetMapping(value = "/uploads/{filename:.+}")
    public ResponseEntity<Resource> verFoto(@PathVariable String filename) {

        Resource recurso = null;

        try {
            recurso = fileService.load(filename);

        } catch (MalformedURLException e) {
            // TODO: handle exception
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"")
                .body(recurso);

    }

    @GetMapping(value = "/ver/{id}")
    public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

        Cliente cliente = clienteService.findOne(id);
        if (cliente == null) {
            flash.addFlashAttribute("error", "El cliente no existe en nuestra BBDD");
            return "redirect:/listar";
        }
        model.put("cliente", cliente);
        model.put("titulo", "Detalles del cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        return "ver";
    }

    @RequestMapping(value = { "", "/" })
    public String Index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    private String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 5);
        Page<Cliente> clientes = clienteService.findAll(pageRequest);
        PageRender<Cliente> pageRender = new PageRender<>("/listar", clientes);
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clientes);
        model.addAttribute("page", pageRender);
        return "listar";
    }

    @RequestMapping(value = "/nuevoCliente")
    public String crear(Map<String, Object> model) {
        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Formulario de alta de Clientes");
        return "nuevoCliente";
    }

    // con la session lo que conseguimos es que se guarden variables como el cliente
    // en la session del usuario
    // en lugar de poner lineas como esta en la pagina de listar:
    // <input type="hidden" th:field="*{id}" />
    // para que sepamos quienes somos

    @RequestMapping(value = "/nuevoCliente", method = RequestMethod.POST)
    private String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash,
                           SessionStatus status, @RequestParam("file") MultipartFile foto) throws IOException {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de alta de Clientes");
            return "nuevoCliente";
        }

        if (!foto.isEmpty()) {
            /*
             * Path directorioRecurso = Paths.get("src//main//resources//static/uploads");
             * String rootPath=directorioRecurso.toFile().getAbsolutePath(); String
             * rootPath="C://Temp//uploads";
             */

            // Aqui se sustituye la foto antigua por una nueva
            if (cliente.getId() != null && cliente.getId() > 0 && cliente.getFoto().length() > 0) {
                fileService.delete(cliente.getFoto());
            }

            String uniqueFilename = null;
            try {
                uniqueFilename = fileService.copy(foto);
            } catch (IOException e) {
                // TODO: handle exception
            }
            flash.addFlashAttribute("info", "Has subido correctamente " + uniqueFilename);
            cliente.setFoto(uniqueFilename);
        }
        String mensajeFlash = (cliente.getId() != null) ? "Cliente editado correctamente"
                : "Cliente inseratado correctamente";
        clienteService.save(cliente);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        return "redirect:/listar";
    }

    @RequestMapping(value = "/eliminarCliente/{id}")
    private String Eliminar(@PathVariable("id") Long id, RedirectAttributes flash) {
        if (id > 0) {
            Cliente cliente = clienteService.findOne(id);
            clienteService.delete(id);
            flash.addFlashAttribute("success", "Cliente eliminado correctamente");

            if (fileService.delete(cliente.getFoto())) {
                flash.addFlashAttribute("info", "La Foto " + cliente.getFoto() + " ha sido borrada con exito.");

            }

        }

        return "redirect:/listar";
    }

    @RequestMapping(value = "/nuevoCliente/{id}")
    private String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
        Cliente cliente = null;
        if (id > 0) {
            cliente = clienteService.findOne(id);
            if (cliente == null) {
                flash.addFlashAttribute("error", "Cliente no existe en la base de datos");
                return "redirect:/listar";
            }
        } else {
            flash.addFlashAttribute("error", "Id erroneo");
            return "redirect:/listar";

        }
        model.put("cliente", cliente);
        model.put("Titulo", "Editar Cliente");
        return "nuevoCliente";
    }
}

