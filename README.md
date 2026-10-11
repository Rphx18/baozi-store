# Baozi Store - API REST

Trabalho de Desenvolvimento Web Back-End (UNINTER).
Tecnologias: Java 17, Spring Boot 3, Spring Data JPA, H2 (ou MySQL), Postman.

## Como executar
1. Abra a pasta no IntelliJ / Eclipse / VS Code (projeto Maven) e execute `BaoziStoreApplication`,
   ou pelo terminal: `mvn spring-boot:run`
2. A API sobe em `http://localhost:8080`
3. Console do banco H2: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:baozidb`, usuario `sa`, sem senha)

Para usar MySQL, edite `src/main/resources/application.properties`.

## Endpoints (clientes, produtos e pedidos)
| Metodo | Rota | Descricao |
|---|---|---|
| POST | /clientes, /produtos, /pedidos | Criar |
| GET | /clientes, /produtos, /pedidos | Listar todos |
| GET | /clientes/{id}, /produtos/{id}, /pedidos/{id} | Consultar por ID |
| PUT | /clientes/{id}, /produtos/{id}, /pedidos/{id} | Atualizar (opcional) |
| DELETE | /clientes/{id}, /produtos/{id}, /pedidos/{id} | Apagar |

## Exemplos de JSON
POST /clientes
{ "nome": "Raphaela5566996", "clienteDesde": "2026-10-11" }

POST /produtos
{ "nome": "Baozi de Carne", "preco": 8.50, "estoque": true }

POST /pedidos
{ "clienteId": 1, "produtoId": 1, "quantidade": 10 }
