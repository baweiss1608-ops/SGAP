-- --------------------------------------------
-- Schema sgap
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sgap`;
USE `sgap` ;

-- -----------------------------------------------------
-- Table `sgap`.`psicologos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgap`.`psicologos` (
  `id_psicologo` INT(11) NOT NULL AUTO_INCREMENT,
  `crp` VARCHAR(20) NOT NULL,
  `cnpj` VARCHAR(20) NULL DEFAULT NULL,
  `especialidade` VARCHAR(100) NULL DEFAULT NULL,
  `contato` VARCHAR(20) NULL DEFAULT NULL,
  `horario_inicial` TIME NULL DEFAULT NULL,
  `horario_final` TIME NULL DEFAULT NULL,
  `valor_cobrado` DECIMAL(10,2) NULL,
  `nome` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `senha` VARCHAR(128) NULL,
  PRIMARY KEY (`id_psicologo`));


-- -----------------------------------------------------
-- Table `sgap`.`pacientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgap`.`pacientes` (
  `id_paciente` INT(11) NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(14) NOT NULL,
  `contato` VARCHAR(20) NULL DEFAULT NULL,
  `contato_emergencia` VARCHAR(20) NULL DEFAULT NULL,
  `nome` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `senha` VARCHAR(128) NULL,
  PRIMARY KEY (`id_paciente`));


-- -----------------------------------------------------
-- Table `sgap`.`agendamentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgap`.`agendamentos` (
  `id_agendamento` INT(11) NOT NULL AUTO_INCREMENT,
  `id_psicologo` INT(11) NOT NULL,
  `id_paciente` INT(11) NOT NULL,
  `data` DATE NOT NULL,
  `horario` TIME NOT NULL,
  `status` INT NULL  COMMENT 'ENUM(0 - \'Pendente\',1 -  \'Confirmado\', 2 - \'Cancelado\', 3 - \'Concluído\')',
  PRIMARY KEY (`id_agendamento`),
  CONSTRAINT `agendamentos_ibfk_1`
    FOREIGN KEY (`id_psicologo`)
    REFERENCES `sgap`.`psicologos` (`id_psicologo`),
  CONSTRAINT `agendamentos_ibfk_2`
    FOREIGN KEY (`id_paciente`)
    REFERENCES `sgap`.`pacientes` (`id_paciente`));


-- -----------------------------------------------------
-- Table `sgap`.`atendimentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgap`.`atendimentos` (
  `id_atendimento` INT(11) NOT NULL AUTO_INCREMENT,
  `id_agendamento` INT(11) NOT NULL,
  `relato` TEXT NULL DEFAULT NULL,
  `preco` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id_atendimento`),
  CONSTRAINT `atendimentos_ibfk_1`
    FOREIGN KEY (`id_agendamento`)
    REFERENCES `sgap`.`agendamentos` (`id_agendamento`)
    ON DELETE CASCADE);

