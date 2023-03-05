package com.falejandroborjas.supermercado.models.service;

import com.falejandroborjas.supermercado.models.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClienteService {
    public List<Cliente> findAll();
    public Page<Cliente> findAll(Pageable pageRequest);
    public void save(Cliente cliente);
    public Cliente findOne(Long id);
    public void delete(Long id);
}
