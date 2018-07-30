-- Insert data of buyer
insert into compradores(buyer_id,nombre) 
values ('0','buyer_0');
insert into compradores(buyer_id,nombre) 
values ('1','buyer_1');
insert into compradores(buyer_id,nombre) 
values ('2','buyer_2');

-- Insert data to country
insert into paises(country_id,nombre) 
values ('0','country_0');
insert into paises(country_id,nombre) 
values ('1','country_1');
insert into paises(country_id,nombre) 
values ('2','country_2');
-- Insert data to province
insert into provincias(province_id,nombre,country_id) 
values ('0','province_0', '0');
insert into provincias(province_id,nombre,country_id) 
values ('1','province_1', '1');
insert into provincias(province_id,nombre,country_id) 
values ('2','province_2', '2');
-- Insert data to city
insert into ciudades(city_id,nombre, province_id) 
values ('0','city_0', '0');
insert into ciudades(city_id,nombre, province_id) 
values ('1','city_1', '1');
insert into ciudades(city_id,nombre, province_id) 
values ('2','city_2', '2');

-- Insert data to sale
insert into ventas(id,buyer_id,city_id,cantidad,valor,fecha) 
values ('0','0','0','1','100','2018-07-01');
insert into ventas(id,buyer_id,city_id,cantidad,valor,fecha) 
values ('1','0','2','2','149.99','2018-06-04');
insert into ventas(id,buyer_id,city_id,cantidad,valor,fecha) 
values ('2','1','0','6','150','2018-05-05');
insert into ventas(id,buyer_id,city_id,cantidad,valor,fecha) 
values ('3','2','0','14','100','2018-04-01');
insert into ventas(id,buyer_id,city_id,cantidad,valor,fecha) 
values ('4','1','1','2','1000','2018-04-01');
insert into ventas(id,buyer_id,city_id,cantidad,valor,fecha) 
values ('5','2','0','2','1000','2018-03-01');
insert into ventas(id,buyer_id,city_id,cantidad,valor,fecha) 
values ('6','1','1','2','1000','2018-02-01');
insert into ventas(id,buyer_id,city_id,cantidad,valor,fecha) 
values ('7','2','0','2','1000','2018-01-01');
insert into ventas(id,buyer_id,city_id,cantidad,valor,fecha) 
values ('8','2','1','2','1000','2017-04-01');
