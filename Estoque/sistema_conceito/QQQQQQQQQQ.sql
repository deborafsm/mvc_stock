CREATE DATABASE IF NOT EXISTS `estoque` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `estoque`;

-- Copiando estrutura para tabela estoque.defeitopc
CREATE TABLE IF NOT EXISTS `defeitopc` (
  `id_pcDef` int(11) NOT NULL AUTO_INCREMENT,
  `datadef` varchar(200) DEFAULT NULL,
  `cod_pc` varchar(200) DEFAULT NULL,
  `nome_pc` varchar(200) DEFAULT NULL,
  `marca` varchar(200) DEFAULT NULL,
  `modelo` varchar(200) DEFAULT NULL,
  `so` varchar(200) DEFAULT NULL,
  `garantia` varchar(50) DEFAULT NULL,
  `ram` varchar(10) DEFAULT NULL,
  `processador` varchar(10) DEFAULT NULL,
  `hd` varchar(10) DEFAULT NULL,
  `statusd` varchar(10) DEFAULT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `nome_operador` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_pcDef`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Copiando estrutura para tabela estoque.head
CREATE TABLE IF NOT EXISTS `head` (
  `id_head` int(11) NOT NULL AUTO_INCREMENT,
  `head_marca` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_head`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Copiando estrutura para tabela estoque.kit
CREATE TABLE IF NOT EXISTS `kit` (
  `id_kit` int(11) NOT NULL AUTO_INCREMENT,
  `data_kit` varchar(200) DEFAULT NULL,
  `status_kit` varchar(200) DEFAULT NULL,
  `id_operador` varchar(200) DEFAULT NULL,
  `nome_operador` varchar(200) DEFAULT NULL,
  `telefone` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `endereco` varchar(200) DEFAULT NULL,
  `cargo` varchar(200) DEFAULT NULL,
  `setor` varchar(200) DEFAULT NULL,
  `supervisor` varchar(200) DEFAULT NULL,
  `operacao` varchar(200) DEFAULT NULL,
  `nome_pc` varchar(200) DEFAULT NULL,
  `cod_pc` varchar(200) DEFAULT NULL,
  `marca_pc` varchar(200) DEFAULT NULL,
  `modelo_pc` varchar(200) DEFAULT NULL,
  `processador` varchar(200) DEFAULT NULL,
  `memoria` varchar(200) DEFAULT NULL,
  `so` varchar(200) DEFAULT NULL,
  `hd` varchar(200) DEFAULT NULL,
  `garantia` varchar(200) DEFAULT NULL,
  `marca_monitor` varchar(200) DEFAULT NULL,
  `marca_teclado` varchar(200) DEFAULT NULL,
  `marca_mouse` varchar(200) DEFAULT NULL,
  `marca_head` varchar(200) DEFAULT NULL,
  `marca_webcam` varchar(200) DEFAULT NULL,
  `qnt_vga` varchar(200) DEFAULT NULL,
  `qnt_e` varchar(200) DEFAULT NULL,
  `rede` varchar(200) DEFAULT NULL,
  `lacre` varchar(200) DEFAULT NULL,
  `id_monitor` varchar(200) DEFAULT NULL,
  `cod_monitor` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_kit`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


-- Copiando estrutura para tabela estoque.monitor
CREATE TABLE IF NOT EXISTS `monitor` (
  `id_monitor` int(11) NOT NULL AUTO_INCREMENT,
  `marca_monitor` varchar(100) DEFAULT NULL,
  `modelo_monitor` varchar(100) DEFAULT NULL,
  `cod_monitor` varchar(200) DEFAULT NULL,
  `status_monitor` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_monitor`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


-- Copiando estrutura para tabela estoque.monitordef
CREATE TABLE IF NOT EXISTS `monitordef` (
  `id_monitorDefeito` int(11) NOT NULL AUTO_INCREMENT,
  `cod_monitor` varchar(200) DEFAULT NULL,
  `data_defeito` varchar(200) DEFAULT NULL,
  `marca_monitor` varchar(200) DEFAULT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `statusm` varchar(200) DEFAULT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_monitorDefeito`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Copiando estrutura para tabela estoque.mouse
CREATE TABLE IF NOT EXISTS `mouse` (
  `id_mouse` int(11) NOT NULL AUTO_INCREMENT,
  `marca_mouse` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_mouse`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Copiando estrutura para tabela estoque.operador
CREATE TABLE IF NOT EXISTS `operador` (
  `id_operador` int(11) NOT NULL AUTO_INCREMENT,
  `data_cad` varchar(200) DEFAULT NULL,
  `nome_operador` varchar(200) DEFAULT NULL,
  `email_operador` varchar(200) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `celular` varchar(200) DEFAULT NULL,
  `endereco` varchar(300) DEFAULT NULL,
  `cep` varchar(200) DEFAULT NULL,
  `numero` varchar(200) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `referencia` varchar(200) DEFAULT NULL,
  `bairro` varchar(200) DEFAULT NULL,
  `cidade` varchar(200) DEFAULT NULL,
  `estado` varchar(200) DEFAULT NULL,
  `setor` varchar(100) DEFAULT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  `status_operador` varchar(50) DEFAULT NULL,
  `empresa` varchar(200) DEFAULT NULL,
  `supervisor` varchar(100) DEFAULT NULL,
  `cpf` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_operador`),
  UNIQUE KEY `email_operador` (`email_operador`),
  UNIQUE KEY `tel` (`tel`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Copiando estrutura para tabela estoque.pc
CREATE TABLE IF NOT EXISTS `pc` (
  `id_formulario` int(11) NOT NULL AUTO_INCREMENT,
  `datacad` varchar(100) DEFAULT NULL,
  `codpc` varchar(100) NOT NULL,
  `nome_pc` varchar(100) DEFAULT NULL,
  `processador` varchar(50) DEFAULT NULL,
  `marca_pc` varchar(100) DEFAULT NULL,
  `hd` varchar(10) DEFAULT NULL,
  `memoria` varchar(10) DEFAULT NULL,
  `so` varchar(50) DEFAULT NULL,
  `garantia` varchar(100) DEFAULT NULL,
  `status_pc` varchar(50) DEFAULT NULL,
  `modelo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_formulario`),
  UNIQUE KEY `codpc` (`codpc`),
  UNIQUE KEY `nome_pc` (`nome_pc`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


-- Copiando estrutura para tabela estoque.teclado
CREATE TABLE IF NOT EXISTS `teclado` (
  `id_teclado` int(11) NOT NULL AUTO_INCREMENT,
  `teclado_marca` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_teclado`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `webcam` (
  `id_webcam` int(11) NOT NULL AUTO_INCREMENT,
  `webcam_marca` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_webcam`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
