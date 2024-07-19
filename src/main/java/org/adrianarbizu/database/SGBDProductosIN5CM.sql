drop database  if exists SGBDProductosIN5CM;

create database SGBDProductosIN5CM;

use SGBDProductosIN5CM;        

create table Productos(

	productoId int not null auto_increment,
    nombreProducto varchar(30),
    marcaProducto varchar(30),
    descripcionProducto varchar(30),
    precio decimal(10,2),
	primary key PK_productoId(productoId)

);



Delimiter $$
create procedure sp_listarProductos()
	begin
		select
			Productos.productoId,
            Productos.nombreProducto,
            Productos.marcaProducto,
            Productos.descripcionProducto,
            Productos.precio
				from Productos;
	end $$
Delimiter ;



INSERT INTO Productos(productoId,nombreProducto,marcaProducto,descripcionProducto,precio) VALUES

(1,'Coca-Cola','Coke','Bebida  gaseosa carbonatada','6.00'),

(2,'Coca-Cola','Coke','Bebida  gaseosa carbonatada','6.00'),

(3,'Coca-Cola','Coke','Bebida  gaseosa carbonatada','6.00'),

(4,'Coca-Cola','Coke','Bebida  gaseosa carbonatada','6.00'),

(5,'Coca-Cola','Coke','Bebida  gaseosa carbonatada','6.00'),

(6,'Coca-Cola','Coke','Bebida  gaseosa carbonatada','6.00')