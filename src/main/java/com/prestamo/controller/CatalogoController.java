package com.prestamo.controller;

import com.prestamo.entity.Catalogo;
import com.prestamo.service.CatalogoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/url/catalogo")
public class CatalogoController {

    private final CatalogoService catalogoService;

    public CatalogoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    @PostMapping("/inserta")
    public Catalogo insertaCatalogo(@RequestBody Catalogo catalogo) {
        return catalogoService.insertaCatalogo(catalogo);
    }
}