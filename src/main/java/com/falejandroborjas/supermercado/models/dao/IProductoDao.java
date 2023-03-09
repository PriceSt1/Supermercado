package com.falejandroborjas.supermercado.models.dao;

import com.falejandroborjas.supermercado.models.entity.Cliente;
import com.falejandroborjas.supermercado.models.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface IProductoDao  extends PagingAndSortingRepository<Producto, Long> {
    @Query("select p from Producto p where p.nombre like %?1%")
    List<Producto> findByNombre(String term);
    List<Producto> findByNombreLikeIgnoreCase(String term);
    void deleteById(Long id);
    void save(Producto producto);
    List<Producto> findAll();
    Optional<Object> findById(Long id);
}
