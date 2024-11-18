# Projeto MVC de Solicitação de Compra

Este projeto é uma aplicação web para gerenciar solicitações de compra. Ele permite criar pedidos de compra e seus itens.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Thymeleaf
- Oracle Database
- JavaScript

## Estrutura do Projeto

- **Controller**: Controladores que lidam com as requisições HTTP.
- **Service**: Serviços que contêm a lógica de negócios.
- **Model**: Modelos que representam as entidades do banco de dados.
- **Repository**: Repositórios que interagem com o banco de dados.

## Funcionalidades

- Controle de Acesso por Usúario
- Cadastro de Usúario
- Cadastro de Produtos
- Criar uma nova solicitação de compra.

## Configuração do Projeto

1. Clone o repositório:
    ```sh
    git clone https://github.com/joaodourado2/ProjetoMVC.git
    cd ProjetoMVC
    ```

2. Configure o banco de dados no arquivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
    spring.datasource.username=seu-usuario
    spring.datasource.password=sua-senha
    spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
    spring.jpa.hibernate.ddl-auto=update
    ```
