create database estoque;
use estoque;
create table pc(
	id_formulario int primary key auto_increment,
    nome_pc varchar(100),
    processador varchar(50),
    marca_pc varchar(100),
	hd varchar(10),
    memoria varchar(10),
    so varchar(50),
    arquitetura varchar(10),
	cod_pc varchar(200) unique,
    garantia varchar(100),
    status_pc varchar(50)
);    
create table monitor(    
	id_marca int primary key auto_increment,
    marca_monitor varchar(100),
    status_monitor varchar(50),
    cod_monitor varchar(200) unique,
    status_monitor varchar(50)
);    
  create table mouse(  
	id_mouse int primary key auto_increment,
    status_envio_mouse varchar(10),
    marca_mouse varchar(100),
    status_mouse varchar(50),
    cod_mouse varchar(200) unique
);    
 create table teclado(   
	id_teclado int primary key auto_increment,
    status_envio_teclado varchar(10),
    teclado_marca varchar(100),
    status_teclado varchar(50),
    teclado_cod varchar(200) unique
    
);
create table head(
	id_head int primary key auto_increment,
    status_envio_head varchar(10),
    head_marca varchar(100),
	status_head varchar(50),
    head_cod varchar(200) unique
);
create table webcam(
	id_webcam int primary key auto_increment,
    status_envio_webcam varchar(10),
    webcam_marca varchar(100),
    webcam_status varchar(50),
    webcam_cod varchar(200) unique
);
create table cabo(
	id_cabo int primary key auto_increment,
    cabo_tipo varchar(10),
    status_cabo varchar(50),
    quantidade_cabo varchar(20)
);
create table operador(
	id_operador int primary key auto_increment,
    nome_operador varchar(200),
    email_operador varchar(200) unique,
    tel varchar(20) unique,
    setor varchar(100),
    cargo varchar (100),
    status_operador varchar(50),
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
create table periodo(
	id_periodo int primary key auto_increment,
	data_entrada varchar(20),
    data_saida varchar(20), 
    hora_entrada varchar(20),
    hora_saida varchar(20)
);


