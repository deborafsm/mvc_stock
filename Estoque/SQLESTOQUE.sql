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
create table head(
	id_head int primary key auto_increment,
    status_envio_head varchar(10),
    head_marca varchar(100),
    modelo varchar (100),
	status_head varchar(50),
    head_cod varchar(200) unique
);
create table webcam(
	id_webcam int primary key auto_increment,
    status_envio_webcam varchar(10),
    webcam_marca varchar(100),
    modelo varchar (100),
    webcam_status varchar(50),
    webcam_cod varchar(200) unique
);
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
select id_formulario,codpc from pc where status_pc = "No Estoque";
select count(*) from pc;
select count(*) from pc where status_pc = "No Estoque";
/*
private String id_kit;
    private String datakitSaida;
    private String id_pc;
    private String cod_pc;
    private String id_monitor;
    private String cod_monitor;
    private String id_operador;
    private String nome;
    private String telefone;
    private String email;
    private String cargo;
    private String setor;
    private String supervisor;
    private String status;
*/
create table kitExit(
	id_kit int primary key auto_increment,
    datekit varchar(50),
    id_pc varchar(50) unique,
    cod_pc varchar(50) unique,
    id_mon varchar(50)unique,
    cod_mon varchar(50)unique,
    
    cod_mouse varchar(50)unique,
    cod_teclado varchar(50)unique,
	id_head varchar(50)unique,
	cod_webcam varchar(50)unique,
    
    id_op varchar(50)unique,
    nome varchar(200)unique,
    tel varchar(20)unique,
    email varchar(200)unique,
    cargo varchar(200)unique,
    setor varchar(200)unique,
    supervisor varchar(200)unique,
    statuskit varchar(200)
);
select * from kitExit;

alter table kitExit add qnt_en varchar(50);
alter table kitExit add qnt_vga varchar(50);
