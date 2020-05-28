create database estoque;
use estoque;
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
    status_pc varchar(50)
);
alter table pc add column modelo varchar(100);
alter table pc drop column arquitetura;
alter table pc drop column analista;
alter table pc drop column email ;
alter table pc drop column telefone;
alter table pc drop column datUpdate;

select * from pc;

create table monitor(    
	id_marca int primary key auto_increment,
    marca_monitor varchar(100),
    modelo varchar (100),
    status_monitor varchar(50),
    cod_monitor varchar(200) unique
    
);    
select * from pc;
select * from operador;
select * from head;
select * from webcam;
select *from monitor;	
select * from mouse;
select * from teclado;
alter  table kit drop column data_saida;
ALTER TABLE kit CHANGE data_entrada data_saida varchar(50);
alter table kit add column rede varchar(10);
alter table kit add column status_op varchar(100);
select * from kit;

describe pc;
  create table mouse(  
	id_mouse int primary key auto_increment,
    status_envio_mouse varchar(10),
    marca_mouse varchar(100),
    modelo varchar (100),
    status_mouse varchar(50),
    cod_mouse varchar(200) unique
);    
 create table teclado(   
	id_teclado int primary key auto_increment,
    status_envio_teclado varchar(10),
    teclado_marca varchar(100),
    modelo varchar (100),
    status_teclado varchar(50),
    teclado_cod varchar(200) unique
    
);
select * from mouse;
select cod_mouse ,marca_mouse from mouse where status_envio_mouse = "No Estoque";
alter table mouse drop column status_mouse;
select * from teclado;
select teclado_cod, teclado_marca from teclado where status_envio_teclado = "No Estoque";
select * from webcam;
select webcam_cod, webcam_marca from webcam where status_envio_webcam = "No Estoque";
create table head(
	id_head int primary key auto_increment,
    status_envio_head varchar(10),
    head_marca varchar(100),
    modelo varchar (100),
	status_head varchar(50),
    head_cod varchar(200) unique
);

select * from head;
select head_cod from head where status_envio_head = "No Estoque";
alter table head drop column status_head;
create table webcam(
	id_webcam int primary key auto_increment,
    status_envio_webcam varchar(10),
    webcam_marca varchar(100),
    modelo varchar (100),
    webcam_status varchar(50),
    webcam_cod varchar(200) unique
);
select * from webcam;
alter table webcam drop webcam_status;
create table cabo(
	id_cabo int primary key auto_increment,
    cabo_tipo varchar(10),
    status_cabo varchar(50),
    quantidade_cabo varchar(20)
);
alter table cabo add column modelo varchar (100);
create table operador(
	id_operador int primary key auto_increment,
    nome_operador varchar(200),
    email_operador varchar(200) unique,
    tel varchar(20) unique,
    setor varchar(100),
    cargo varchar (100),
    status_operador varchar(50),
    empresa varchar(200),
    supervisor varchar(100)
);
select * from operador;
alter table operador add column endereco varchar(200);
select  id_operador,tel,email_operador,endereco,cargo,setor,supervisor from operador where status_operador = "Ok";

create table defeitos(
	id_defeitos int primary key auto_increment,
    comentarios varchar(400),
    defeito_pc varchar(200),
    defeito_mouse varchar(200),
    defeito_teclado varchar(200),
    defeito_webcam varchar(200),
    defeito_head varchar(200)
    
);

create table periodo(
	id_periodo int primary key auto_increment,
	data_entrada varchar(20),
    data_saida varchar(20), 
    hora_entrada varchar(20),
    hora_saida varchar(20)
);

select datacad,codpc,nome_pc,processador,marca_pc,hd ,memoria ,so,garantia,status_pc,modelo from pc;

select * from pc where status_pc ="No Estoque";

select * from pc;
select id_formulario,codpc from pc where status_pc = "No Estoque";
select codpc , status_pc from pc where status_pc = "No Estoque";
select count(*) from pc;
select count(*) from monitor where status_monitor = "No Estoque";
select id_marca,cod_monitor from monitor where status_monitor = "No Estoque";
select * from monitor;

create table kit(
	id_kit int primary key auto_increment ,
	data_entrada varchar(50),
	data_saida varchar(50),
    
	id_operador varchar(100) unique,
	nome varchar(200),
	telefone varchar(20),
	email varchar(100) unique,
	endereco varchar(100),
	setor varchar(50),
	cargo varchar(50),
	supervisor varchar(100),
    
	id_pc varchar(100) unique,
	cod_pc varchar(200) unique,
	marca varchar(50),
	modelo varchar(50),
	processador varchar(50),
	memoria varchar(50),
	so varchar(50),
	hd varchar(50),
	garantia varchar(50),
    
	id_monitor varchar(100) unique,
	codigo_monitor varchar(200),
	marca_monitor varchar(50),
    
	status_kit varchar(100),
    
	codigo_head varchar(200) unique,
	codigo_webcam varchar(200) unique,
    
	codigo_mouse varchar(200) unique,
	marca_mouse varchar (200) unique,
    
	codigo_teclado varchar(200) unique,
	marca_teclado varchar(200) unique,
    
	qnt_caboE varchar(100),
	qnt_caboVga varchar(100)
);

alter table kit add column rede varchar(100);
alter table kit add column empresa varchar(50);
select * from kit;
drop table kitExit;

alter table kitExit add qnt_en varchar(50);
alter table kitExit add qnt_vga varchar(50);
