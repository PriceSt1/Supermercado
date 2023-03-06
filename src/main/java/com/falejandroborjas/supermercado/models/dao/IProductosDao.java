package com.falejandroborjas.supermercado.models.dao;

import com.falejandroborjas.supermercado.models.entity.Cliente;
import com.falejandroborjas.supermercado.models.entity.Producto;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface IProductosDao extends PagingAndSortingRepository<Producto,Long> {

    List<Producto> findAll();

    void save(Producto producto);

    Optional<Object> findById(Long id);

    void deleteById(Long id);
}
