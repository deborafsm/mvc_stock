create database estoque;
use estoque;
select * from pc;
select * from operador;
select * from head;
select * from webcam;
select *from monitor;	
select * from mouse;
select * from teclado;
select * from kit;
describe kit;
create table pc(
	id_formulario int primary key auto_increment,
    datacad varchar(100),
    codpc varchar(100) not null unique,
    nome_pc varchar(100) unique,
    processador varchar(50),
    marca_pc varchar(100),
	hd varchar(10),
    memoria varchar(10),
    so varchar(50),
    arquitetura varchar(10),
    garantia varchar(100),
    status_pc varchar(50),
    modelo varchar(100)
);
create table monitor(    
	id_monitor int primary key auto_increment,
    marca_monitor varchar(100),
    modelo_monitor varchar(100),
    cod_monitor varchar(200)
);    
  create table mouse(  
	id_mouse int primary key auto_increment,
    marca_mouse varchar(100)
    
);    
 create table teclado(   
	id_teclado int primary key auto_increment,
    teclado_marca varchar(100)
);
create table head(
	id_head int primary key auto_increment,
    head_marca varchar(100)
);
create table webcam(
	id_webcam int primary key auto_increment,
    webcam_marca varchar(100)
);
create table operador(
	id_operador int primary key auto_increment,
    nome_operador varchar(200),
    email_operador varchar(200) unique,
    tel varchar(20) unique,
    endereco varchar(300),
    setor varchar(100),
    cargo varchar (100),
    status_operador varchar(50),
    empresa varchar(200),
    supervisor varchar(100)
);
create table defeitos(
	id_defeitos int primary key auto_increment,
    comentarios varchar(400),
    defeito_pc varchar(200),
    defeito_mouse varchar(200),
    defeito_teclado varchar(200),
    defeito_webcam varchar(200),
    defeito_head varchar(200)
);
create table kit(
	id_kit int primary key auto_increment ,
	data_kit varchar(200),
	status_kit varchar(200),
    id_operador varchar(200),
    nome_operador varchar(200),
    telefone varchar(200),
    email varchar(200),
    endereco varchar(200),
    cargo varchar(200),
    setor varchar(200),
    supervisor varchar(200),
    operacao varchar(200),
    id_pc varchar(200),
    cod_pc varchar(200),
    marca_pc varchar(200),
    modelo_pc varchar(200),
    processador varchar(200),
    memoria varchar(200),
    so varchar(200),
    hd varchar(200),
    garantia varchar(200),
    marca_monitor varchar(200),
    marca_teclado varchar(200),
    marca_mouse varchar(200),
	marca_head varchar(200),
    marca_webcam varchar(200),
    qnt_vga varchar(200),
    qnt_e varchar(200),
    rede varchar(200)
);


select  id_operador,tel,email_operador,endereco,cargo,setor,supervisor from operador where status_operador = "Ok";

select cod_mouse ,marca_mouse from mouse where status_envio_mouse = "No Estoque";

select teclado_cod, teclado_marca from teclado where status_envio_teclado = "No Estoque";

select webcam_cod, webcam_marca from webcam where status_envio_webcam = "No Estoque";

select nome_operador from kit where status_pc = "Saida";

SELECT COUNT(status_kit)  FROM kit WHERE status_kit='Saida';

select COUNT(status_pc)  FROM pc WHERE status_pc = 'No Estoque';



select datacad,codpc,nome_pc,processador,marca_pc,hd ,memoria ,so,garantia,status_pc,modelo from pc;

select * from pc where status_pc ="No Estoque";

select * from pc;	
select id_formulario,codpc from pc where status_pc = "No Estoque";
select codpc , status_pc from pc where status_pc = "No Estoque";
select count(*) from pc;
select count(*) from monitor where status_monitor = "No Estoque";
select id_marca,cod_monitor from monitor where status_monitor = "No Estoque";
select * from KIT;

