package com.falejandroborjas.supermercado.models.service;

import com.falejandroborjas.supermercado.models.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductoService {

    List<Producto> findAll();
    Page<Producto> findAll(Pageable pageRequest);
    void save(Producto producto);
    Producto findOne(Long id);
    void delete(Long id);
}
