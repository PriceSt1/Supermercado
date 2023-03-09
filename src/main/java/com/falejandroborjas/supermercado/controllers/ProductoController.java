package com.falejandroborjas.supermercado.controllers;

import com.falejandroborjas.supermercado.models.entity.Cliente;
import com.falejandroborjas.supermercado.models.entity.Producto;
import com.falejandroborjas.supermercado.models.service.IProductoService;
import com.falejandroborjas.supermercado.models.service.IUploadFileService;
import com.falejandroborjas.supermercado.util.paginator.PageRender;
import jakarta.validation.Valid;
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
@RequestMapping("/producto")
@SessionAttributes("producto")
public class ProductoController {

    @Autowired
    private IProductoService productoService;
    @Autowired
    private IUploadFileService fileService;


    @RequestMapping(value = "/listarProductos", method = RequestMethod.GET)
    private String listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageRequest = PageRequest.of(page, 15);
        Page<Producto> productos = productoService.findAll(pageRequest);
        PageRender<Producto> pageRender = new PageRender<>("listarProductos", productos);
        model.addAttribute("titulo", "Listado de productos");
        model.addAttribute("productos", productos);
        model.addAttribute("page", pageRender);
        return "producto/listarProductos";
    }
    @RequestMapping(value = "/nuevoProducto")
    public String crear(Map<String, Object> model) {
        Producto producto = new Producto();
        model.put("producto", producto);
        model.put("titulo", "Formulario para crear un producto");
        return "producto/nuevoProducto";
    }

    @RequestMapping(value = "/nuevoProducto", method = RequestMethod.POST)
    private String guardar(@Valid Producto producto, BindingResult result, Model model, RedirectAttributes flash,
                           SessionStatus status, @RequestParam("file") MultipartFile foto) throws IOException {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario para añadir productos");
            return "producto/nuevoProducto";
        }

        if (!foto.isEmpty()) {
            /*
             * Path directorioRecurso = Paths.get("src//main//resources//static/uploads");
             * String rootPath=directorioRecurso.toFile().getAbsolutePath(); String
             * rootPath="C://Temp//uploads";
             */

            // Aqui se sustituye la foto antigua por una nueva
            if (producto.getId() != null && producto.getId() > 0 && producto.getFoto().length() > 0) {
                fileService.delete(producto.getFoto());
            }

            String uniqueFilename = null;
            try {
                uniqueFilename = fileService.copy(foto);
            } catch (IOException e) {
                e.printStackTrace();
            }
            flash.addFlashAttribute("info", "Has subido correctamente " + uniqueFilename);
            producto.setFoto(uniqueFilename);
        }
        String mensajeFlash = (producto.getId() != null) ? "Producto editado correctamente"
                : "Producto inseratado correctamente";
        productoService.save(producto);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        return "redirect:/producto/listarProductos";
    }

    @RequestMapping(value = "/eliminarProducto/{id}")
    private String Eliminar(@PathVariable("id") Long id, RedirectAttributes flash) {
        if (id > 0) {
            Producto producto = productoService.findOne(id);
            productoService.delete(id);
            flash.addFlashAttribute("success", "Cliente eliminado correctamente");

            if (fileService.delete(producto.getFoto())) {
                flash.addFlashAttribute("info", "La Foto " + producto.getFoto() + " ha sido borrada con exito.");

            }

        }

        return "redirect:/producto/listarProductos";
    }
    @RequestMapping(value = "/nuevoProducto/{id}")
    private String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
        Producto producto = null;
        if (id > 0) {
            producto = productoService.findOne(id);
            if (producto == null) {
                flash.addFlashAttribute("error", "Producto no existe en la base de datos");
                return "redirect:/producto/listarProductos";
            }
        } else {
            flash.addFlashAttribute("error", "Id erroneo");
            return "redirect:/producto/listarProductos";

        }
        model.put("producto", producto);
        model.put("Titulo", "Editar Cliente");
        return "producto/nuevoProducto";
    }

    @GetMapping(value = "/verProducto/{id}")
    public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

        Producto producto = productoService.findOne(id);
        if (producto == null) {
            flash.addFlashAttribute("error", "El producto no existe en nuestra BBDD");
            return "redirect:/producto/listarProductos";
        }
        model.put("producto", producto);
        model.put("titulo", "Detalles del producto: " + producto.getNombre() + " - " + producto.getPrecio() + "€");
        return "producto/verProducto";
    }
}
