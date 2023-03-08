package com.falejandroborjas.supermercado.models.dao;

import com.falejandroborjas.supermercado.models.entity.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura,Long> {}
