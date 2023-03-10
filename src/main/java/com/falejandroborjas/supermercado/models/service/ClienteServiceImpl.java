package com.falejandroborjas.supermercado.models.service;

import com.falejandroborjas.supermercado.models.dao.IClienteDao;
import com.falejandroborjas.supermercado.models.dao.IFacturaDao;
import com.falejandroborjas.supermercado.models.dao.IProductoDao;
import com.falejandroborjas.supermercado.models.entity.Cliente;
import com.falejandroborjas.supermercado.models.entity.Factura;
import com.falejandroborjas.supermercado.models.entity.Producto;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ClienteServiceImpl implements IClienteService {


    @Autowired
    private IClienteDao clienteDao;
    @Autowired
    private IProductoDao productoDao;
    @Autowired
    private IFacturaDao facturaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageRequest) {
        return clienteDao.findAll(pageRequest);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);

    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long id) {
        return (Cliente) clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    public List<Producto> findByNombre(String term) {
        return productoDao.findByNombreLikeIgnoreCase("%"+term+"%");
    }

    @Override
    public void saveFactura(Factura factura) {
        facturaDao.save(factura);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findProductoById(Long id) {
        return (Producto) productoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findFacturaById(Long id) {
        return  facturaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteFactura(Long id) {
        facturaDao.deleteById(id);
    }


}
