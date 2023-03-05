package com.falejandroborjas.supermercado.models.dao;

import com.falejandroborjas.supermercado.models.entity.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface IClienteDao  extends PagingAndSortingRepository<Cliente,Long> {
    List<Cliente> findAll();

    void save(Cliente cliente);

    Optional<Object> findById(Long id);

    void deleteById(Long id);

}
