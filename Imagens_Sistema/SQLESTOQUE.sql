create database estoque;
use estoque;
select * from pc;
select * from operador;
SELECT * FROM operador WHERE nome_operador like "teste";
select * from head;
select * from webcam;
select *from monitor;	
select * from mouse;
select * from teclado;
select * from kit;

select * from monitordef;
select * from usuarios;
select * from defeitopc; 
alter table monitor add column status_monitor varchar(200);
alter table monitordef add column data_defeito varchar(200) after cod_monitor;
create table usuarios(
 id_usuario int primary key auto_increment,
 usuario varchar(20),
 senha varchar(10)
);
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
    cod_monitor varchar(200),
    status_monitor varchar(200)
    
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
alter table operador add column data_cad varchar(200) after id_operador;
select * from operador;
alter table operador add column celular varchar(200) after tel;
alter table operador add column cep varchar(200)after endereco;

alter table operador add column numero varchar(200) after cep ;
alter table operador add column complemento varchar(200) after numero;

alter table operador add column referencia varchar(200) after complemento;

alter table operador add column bairro varchar(200) after referencia;
alter table operador add column cidade varchar(200) after bairro;
alter table operador add column estado varchar(200) after cidade;
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
create table defeitoPC(
	id_pcDef  int primary key auto_increment ,
    data_def varchar(200),
    cod_pc varchar(200),
    marca varchar(200),
    modelo varchar(200),
    so varchar(200),
    garantia varchar(50),
    ram varchar(10),
    processador varchar(10),
    hd varchar(10),
    statusd varchar(10),
    descricao varchar(200)
);

create table monitorDef(
	id_monitorDefeito  int primary key auto_increment ,
	id_monitor varchar(200),
	cod_monitor varchar(200),
    marca_monitor varchar(200),
    descricao varchar(200),
    statusm varchar(200)
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

-- Inserir PC com defeito
insert into defeitopc(cod_pc,marca,modelo,so,garantia,ram,processador,hd,statusd,descricao)values(?,?,?,?,?,?,?,?,?,?);
-- Inserir MONITOR com defeito
insert into monitordef(id_monitor,cod_monitor,marca_monitor,statusm) values (?,?,?,?);
-- Selecionar todos que tem kit
select * from kit;
-- Selecionar todos os pcs que estão no estoque
select * FROM pc WHERE status_pc = 'No Estoque';
-- Selecionar todos os monitores que estao no estoque
select * FROM monitor WHERE status_monitor = 'No Estoque';
-- ATUAlizar KIT  PC
UPDATE kit SET nome_pc= ?,cod_pc = ? ,marca_pc = ?,modelo_pc = ?,processador= ?,memoria= ?,so= ?,hd= ?,garantia= ?   WHERE id_kit = ?;
-- Atualizar KIT Monitor
UPDATE kit SET marca_monitor= ?,id_monitor = ? ,cod_monitor = ?  WHERE id_kit = ?;


select * from kit ;


alter table kit add column lacre varchar(200);
alter table kit add column id_monitor varchar(200);
alter table kit add column cod_monitor varchar(200);
