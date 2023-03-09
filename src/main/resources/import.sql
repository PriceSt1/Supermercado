INSERT INTO clientes (id, nombre, apellido, email, create_at,foto) VALUES(1, 'Pablo', 'Perez', 'pablop@gmail.com', '2022-08-28','unknown.jpg');
--INSERT INTO clientes (id, nombre, apellido, email, create_at,foto) VALUES(2, 'Luis', 'Garcia', 'luisg@gmail.com', '2022-08-28','unknown.jpg');
--INSERT INTO clientes (id, nombre, apellido, email, create_at,foto) VALUES(3, 'Raquel', 'Muñoz', 'raquelm@gmail.com', '2022-08-28','unknown.jpg');
--INSERT INTO clientes (id, nombre, apellido, email, create_at,foto) VALUES(4, 'Monica', 'Diaz', 'monicad@gmail.com', '2022-08-28','unknown.jpg');
--INSERT INTO clientes (id, nombre, apellido, email, create_at,foto) VALUES(5, 'Javier', 'Diaz', 'javierd@gmail.com', '2022-08-28','unknown.jpg');

--INSERT INTO clientes (id, nombre, apellido, email, create_at,foto) VALUES(6, 'Pablo', 'Jose', 'pablop@gmail.com', '2022-08-28','unknown.jpg');
--INSERT INTO clientes (id, nombre, apellido, email, create_at,foto) VALUES(7, 'Luis', 'Pablo', 'luisg@gmail.com', '2022-08-28','unknown.jpg');
--INSERT INTO clientes (id, nombre, apellido, email, create_at,foto) VALUES(8, 'Raquel', 'Muñoz', 'raquelm@gmail.com', '2022-08-28','unknown.jpg');
--INSERT INTO clientes (id, nombre, apellido, email, create_at,foto) VALUES(9, 'Monica', 'Muñoz', 'monicad@gmail.com', '2022-08-28','unknown.jpg');
--INSERT INTO clientes (id, nombre, apellido, email, create_at,foto) VALUES(10, 'Javier', 'Diaz', 'javierd@gmail.com', '2022-08-28','unknown.jpg');

--INSERT INTO clientes (id, nombre, apellido, email, create_at,foto) VALUES(11, 'Javier', 'Perez', 'pablop@gmail.com', '2022-08-28','unknown.jpg');
--INSERT INTO clientes (id, nombre, apellido, email, create_at,foto) VALUES(12, 'Luis', 'Perez', 'luisg@gmail.com', '2022-08-28','unknown.jpg');
--INSERT INTO clientes (id, nombre, apellido, email, create_at,foto) VALUES(13, 'Monica', 'Muñoz', 'raquelm@gmail.com', '2022-08-28','unknown.jpg');
--INSERT INTO clientes (id, nombre, apellido, email, create_at,foto) VALUES(14, 'Javier', 'Diaz', 'monicad@gmail.com', '2022-08-28','unknown.jpg');
--INSERT INTO clientes (id, nombre, apellido, email, create_at,foto) VALUES(15, 'Pablo', 'Diaz', 'javierd@gmail.com', '2022-08-28','unknown.jpg');

/* Creamos productos */

INSERT INTO productos (nombre, precio, create_at, foto) VALUES ('Leche', 1.5, NOW(),'Leche.jpg');
INSERT INTO productos (nombre, precio, create_at, foto) VALUES ('Huevos', 2.5, NOW(),'Huevos.jpg');
INSERT INTO productos (nombre, precio, create_at, foto) VALUES ('Pan de molde', 1.2, NOW(),'Pan-de-molde.jpg');
INSERT INTO productos (nombre, precio, create_at, foto) VALUES ('Queso cheddar', 3.6, NOW(),'Queso-cheddar.jpg');
INSERT INTO productos (nombre, precio, create_at, foto) VALUES ('Jamón cocido', 2.9, NOW(),'Jamon-cocido.jpg');
INSERT INTO productos (nombre, precio, create_at, foto) VALUES ('Yogur natural', 1.3, NOW(),'Yogur-natural.jpg');
INSERT INTO productos (nombre, precio, create_at, foto) VALUES ('Arroz', 1.8, NOW(),'Arroz.jpg');
INSERT INTO productos (nombre, precio, create_at, foto) VALUES ('Fideos', 1.2, NOW()'Fideos.jpg');
INSERT INTO productos (nombre, precio, create_at, foto) VALUES ('Atún en lata', 2.1, NOW(),'Atun-en-lata.jpg');
INSERT INTO productos (nombre, precio, create_at, foto) VALUES ('Aceite de oliva', 3.5, NOW(),'Aceite-de-oliva.jpg');
INSERT INTO productos (nombre, precio, create_at, foto) VALUES ('Aceitunas', 1.9, NOW(),'Aceitunas.jpg');
INSERT INTO productos (nombre, precio, create_at, foto) VALUES ('Café', 3.1, NOW(),'Cafe.jpg');
INSERT INTO productos (nombre, precio, create_at, foto) VALUES ('Té', 2.5, NOW(),'Te.jpg');
INSERT INTO productos (nombre, precio, create_at, foto) VALUES ('Azúcar', 1.4, NOW(),'Azucar.jpg');
INSERT INTO productos (nombre, precio, create_at, foto) VALUES ('Sal', 0.8, NOW(),'Sal.jpg');

--INSERT INTO productos (nombre, precio, create_at) VALUES('Patatas 1kg', 1, NOW());
--INSERT INTO productos (nombre, precio, create_at) VALUES('Tomtates 1kg', 1, NOW());
--INSERT INTO productos (nombre, precio, create_at) VALUES('Naranjas 1kg', 1, NOW());
--INSERT INTO productos (nombre, precio, create_at) VALUES('Chocolate', 2, NOW());
--INSERT INTO productos (nombre, precio, create_at) VALUES('Lays', 1, NOW());
--INSERT INTO productos (nombre, precio, create_at) VALUES('Salsa de soja', 2, NOW());
--INSERT INTO productos (nombre, precio, create_at) VALUES('Vino', 2, NOW());

/* Creamos algunas facturas */
--INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura compra dia 1', null, 1, NOW());
--INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
--INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
--INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
--INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

--INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura compra dia 2', 'Me faltan lechugas', 1, NOW());
--INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);


