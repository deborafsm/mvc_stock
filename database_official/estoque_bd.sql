create table head(
	id_head int primary key auto_increment,
    head_marca varchar(100)
);
  create table mouse(  
	id_mouse int primary key auto_increment,
    marca_mouse varchar(100)
    
);    
 create table teclado(   
	id_teclado int primary key auto_increment,
    teclado_marca varchar(100)
);
create table webcam(
	id_webcam int primary key auto_increment,
    webcam_marca varchar(100)
);

create table monitor(    
	id_monitor int primary key auto_increment,
    marca_monitor varchar(100),
    modelo_monitor varchar(100),
    cod_monitor varchar(200),
    status_monitor varchar(200)
    
);  
create table monitorDef(
	id_monitorDefeito  int primary key auto_increment ,
	cod_monitor varchar(200),
	data_defeito varchar(200),
    marca_monitor varchar(200),
    descricao varchar(200),
    statusm varchar(200),
    nome varchar(200),
	email varchar(200)
);

create table operador(
	id_operador int primary key auto_increment,
	data_cad varchar(200),
    nome_operador varchar(500),
    email_operador varchar(500) unique,
    tel varchar(20) unique,
	celular varchar(500),
    endereco varchar(500),
	cep varchar(500),
	numero varchar(500),
	complemento varchar(500),
	referencia varchar(500),
	bairro varchar(500),
	cidade varchar(500),
	estado varchar(500),
    setor varchar(500),
    cargo varchar (500),
    status_operador varchar(500),
    empresa varchar(500),
    supervisor varchar(500),
    cpf VARCHAR(500)
);
create table pc(
	id_formulario int primary key auto_increment,
    datacad varchar(100),
    codpc varchar(500) not null unique,
    nome_pc varchar(500) unique,
    processador varchar(500),
    marca_pc varchar(500),
	hd varchar(500),
    memoria varchar(500),
    so varchar(500),
    garantia varchar(500),
    status_pc varchar(500),
    modelo varchar(500)
);

create table defeitoPC(
	id_pcDef  int primary key auto_increment ,
    cod_pc varchar(500),
    data_def varchar(500),
    nomePc varchar(500),
    marca varchar(500),
    modelo varchar(500),
    so varchar(500),
    garantia varchar(500),
    ram varchar(500),
    processador varchar(500),
    hd varchar(500),
    statusd varchar(500),
    descricao varchar(500),
    email	varchar(500)
);

create table kit(
	id_kit int primary key auto_increment ,
	data_kit varchar(500),
	status_kit varchar(500),
    id_operador varchar(500),
    nome_operador varchar(500),
    telefone varchar(500),
    email varchar(500),
    endereco varchar(500),
    cargo varchar(500),
    setor varchar(500),
    supervisor varchar(500),
    operacao varchar(500),
    nome_pc VARCHAR(500),
    cod_pc varchar(500),
    marca_pc varchar(500),
    modelo_pc varchar(500),
    processador varchar(500),
    memoria varchar(500),
    so varchar(500),
    hd varchar(500),
    garantia varchar(500),
    marca_monitor varchar(500),
    marca_teclado varchar(500),
    marca_mouse varchar(500),
	marca_head varchar(500),
    marca_webcam varchar(500),
    qnt_vga varchar(500),
    qnt_e varchar(500),
    rede varchar(500),
    lacre varchar(500),
	 id_monitor varchar(500),
	 cod_monitor varchar(500)
);
  