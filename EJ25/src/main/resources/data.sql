DROP table IF EXISTS fabricantes;
DROP table IF EXISTS articulos;

create table fabricantes(
	id int auto_increment PRIMARY KEY,
	nombre varchar(100)
	);

create table articulos(
	id int auto_increment PRIMARY KEY,
	nombre varchar(100),
	precio INT,
    fabricante_id INT,
    FOREIGN KEY (fabricante_id) REFERENCES fabricantes(id) ON DELETE CASCADE ON UPDATE CASCADE 
    );
    


insert into fabricantes (nombre) values('Xiaomi');
insert into fabricantes (nombre) values('Apple');
insert into fabricantes (nombre) values('Nokia');
insert into fabricantes (nombre) values('Samsung');


insert into articulos (nombre, precio, fabricante_id) values('MI9','400', '1');
insert into articulos (nombre, precio, fabricante_id) values('Iphone 6','600', '2');
insert into articulos (nombre, precio, fabricante_id) values('5800','100', '3');
insert into articulos (nombre, precio, fabricante_id) values('S20','999', '4');