# Baozi Store - API REST

Trabalho de Desenvolvimento Web Back-End (UNINTER).
Tecnologias: Java 17, Spring Boot 3, Spring Data JPA, H2 (ou MySQL), Postman.

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
