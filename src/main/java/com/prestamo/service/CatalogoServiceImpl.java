package com.prestamo.service;

import com.prestamo.entity.Catalogo;
import com.prestamo.kafka.service.CatalogoEventService;
import com.prestamo.repository.CatalogoRepository;
import org.springframework.stereotype.Service;

@Service
public class CatalogoServiceImpl implements CatalogoService {

    private final CatalogoRepository catalogoRepository;

    private final CatalogoEventService catalogoEventService;

    public CatalogoServiceImpl(CatalogoRepository catalogoRepository, CatalogoEventService catalogoEventService) {
        this.catalogoRepository = catalogoRepository;
        this.catalogoEventService = catalogoEventService;
    }

    @Override
    public Catalogo insertaCatalogo(Catalogo catalogo) {
        catalogoEventService.publish(catalogo);
        return catalogoRepository.save(catalogo);
    }
}