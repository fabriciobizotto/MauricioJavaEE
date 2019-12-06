# MauricioJavaEE
Exemplo Projeto JSF EJB JPA MYSQL

### Requisitos Básicos
 - Baixar e instalar o Glassfish 5
 - Baixar e Instalar o Netbeans 8.2

## SQL - MySQL
 - Executar o seguinte comando:
```
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `email` varchar(255) NOT NULL UNIQUE,
  `senha` varchar(100) NOT NULL,
  `nome` text NOT NULL,
  `dthrcadastro` timestamp NULL DEFAULT CURRENT_TIMESTAMP
);
```

### Rodar e testar
