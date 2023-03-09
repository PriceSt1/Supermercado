package com.falejandroborjas.supermercado.models.service;

import com.falejandroborjas.supermercado.models.entity.Cliente;
import com.falejandroborjas.supermercado.models.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductoService {
    public List<Producto> findAll();
    public Page<Producto> findAll(Pageable pageRequest);
    public void save(Producto producto);
    public Producto findOne(Long id);
    public void delete(Long id);
}
