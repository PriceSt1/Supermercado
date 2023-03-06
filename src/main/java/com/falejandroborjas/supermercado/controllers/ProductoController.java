package com.falejandroborjas.supermercado.controllers;

import com.falejandroborjas.supermercado.models.service.IClienteService;
import com.falejandroborjas.supermercado.models.service.IProductoService;
import com.falejandroborjas.supermercado.models.service.IUploadFileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
@Controller
@SessionAttributes("producto")
public class ProductoController {

    public IProductoService productoService;
    public IUploadFileService fileService;



}
