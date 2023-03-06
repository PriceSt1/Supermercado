package com.falejandroborjas.supermercado.models.service;

import com.falejandroborjas.supermercado.models.dao.IProductosDao;
import com.falejandroborjas.supermercado.models.entity.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductoServiceImpl implements IProductoService{
    @Autowired
    private IProductosDao productosDao;
    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return productosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Producto> findAll(Pageable pageRequest) {
        return productosDao.findAll(pageRequest);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productosDao.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findOne(Long id) {
        return (Producto) productosDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productosDao.deleteById(id);
    }
}
