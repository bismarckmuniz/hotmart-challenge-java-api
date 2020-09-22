# hotmart-challenge-java-api
All URIs are relative to *http://api.hotmart.com.br/v1/hotmart-challenge*

## About the API
API de produto para gerenciamento de transações.

## Features
Esta API fornece endpoints HTTP e ferramentas para o seguinte:
* BuyerApi
* Delete Transaction: `[**deletarComprador**](docs/BuyerApi.md#deletarComprador) | **DELETE** /Buyer | Deletar comprador`
* Get Transaction: `[**getConsultarCommprador**](docs/BuyerApi.md#getConsultarCommprador) | **GET** /Buyer | Recupera a lista geral de comprador`
* GetId Transaction: `[**getConsultarCompradorId**](docs/BuyerApi.md#getConsultarCompradorId) | **GET** /Buyer/{buyerCode} | Buscar informações do comprador especifico por id`
* Post Transaction: `[**postCadastrarComprador**](docs/BuyerApi.md#postCadastrarComprador) | **POST** /Buyer | Cadastro de comprador`
* Put Transaction: `[**putAlterarComprador**](docs/BuyerApi.md#putAlterarComprador) | **PUT** /Buyer | Alterar cadastro do comprador`

`*ProductApi* | [**deletarProduto**](docs/ProductApi.md#deletarProduto) | **DELETE** /Product | Deletar produto`
`*ProductApi* | [**getConsultarProdutoId**](docs/ProductApi.md#getConsultarProdutoId) | **GET** /Product/{idProduct} | Buscar informações de produtos por Id`
`*ProductApi* | [**getConsultarProdutos**](docs/ProductApi.md#getConsultarProdutos) | **GET** /Product | Recupera a lista geral de produtos`
`*ProductApi* | [**postCadastrarProduto**](docs/ProductApi.md#postCadastrarProduto) | **POST** /Product | Faz cadastro de produto`
`*ProductApi* | [**putAlterarProduto**](docs/ProductApi.md#putAlterarProduto) | **PUT** /Product | Alterar cadastro de um produto`
`*ProductCategoryApi* | [**deletarProductCategory**](docs/ProductCategoryApi.md#deletarProductCategory) | **DELETE** /ProductCategory | Deletar categoria produto`
`*ProductCategoryApi* | [**getConsultarCategoria**](docs/ProductCategoryApi.md#getConsultarCategoria) | **GET** /ProductCategory | Recupera a lista geral de categoria de produtos`
`*ProductCategoryApi* | [**getConsultarCategoriaProdutoId**](docs/ProductCategoryApi.md#getConsultarCategoriaProdutoId) | **GET** /ProductCategory/{IdCategoriaProduto} | Buscar informações de produtos por id`
`*ProductCategoryApi* | [**postCadastrarCategoria**](docs/ProductCategoryApi.md#postCadastrarCategoria) | **POST** /ProductCategory | Cadastro de categoria de produtos`
`*ProductCategoryApi* | [**putAlterarCategoriaProduto**](docs/ProductCategoryApi.md#putAlterarCategoriaProduto) | **PUT** /ProductCategory | Alterar categoria produto`
`*SalesApi* | [**deletarVenda**](docs/SalesApi.md#deletarVenda) | **DELETE** /Sales | Deletar venda`
`*SalesApi* | [**getConsultarVenda**](docs/SalesApi.md#getConsultarVenda) | **GET** /Sales | Recupera a lista geral de vendas`
`*SalesApi* | [**getConsultarVendasId**](docs/SalesApi.md#getConsultarVendasId) | **GET** /Sales/{IdSalesman} | Buscar informações da lista de vendas por id`
`*SalesApi* | [**postCadastrarVendas**](docs/SalesApi.md#postCadastrarVendas) | **POST** /Sales | Salva a vendas`
`*SalesApi* | [**putAlterarVendas**](docs/SalesApi.md#putAlterarVendas) | **PUT** /Sales | Alterar a lista de vendas`
`*SalesmanApi* | [**deletarVendedor**](docs/SalesmanApi.md#deletarVendedor) | **DELETE** /Salesman | Deletar cadastro de vendedor`
`*SalesmanApi* | [**getConsultarVendedor**](docs/SalesmanApi.md#getConsultarVendedor) | **GET** /Salesman | Recupera a lista geral de vendedores`
`*SalesmanApi* | [**getConsultarVendedorId**](docs/SalesmanApi.md#getConsultarVendedorId) | **GET** /Salesman/{IdSalesMan} | Buscar informações cadastro de vendedor por id`
`*SalesmanApi* | [**postCadastrarVendedor**](docs/SalesmanApi.md#postCadastrarVendedor) | **POST** /Salesman | Salvar cadastro de vendedor`
`*SalesmanApi* | [**putAlterarVendedor**](docs/SalesmanApi.md#putAlterarVendedor) | **PUT** /Salesman | Alterar o cadastro de vendedor`
`*TransactionsApi* | [**getTransactions**](docs/TransactionsApi.md#getTransactions) | **GET** /Transactions | obter as transactions`


* Create a Transaction: `POST/financial/v1/transactions`
* Update a Transaction: `PUT/financial/v1/transactions`
* Delete a Transaction (by id): `DELETE/financial/v1/transactions/1`
* Get report of transactions in a period of time (sorted and paginated): `GET/financial/v1/transactions?startDate=2020-01-01&endDate=2020-09-20&page=2&size=5&sort=DESC`
* Find a unique transaction by id: `GET/financial/v1/transactions/1`
* Find a unique transaction by id, but filtering JSON fields: `GET/financial/v1/transactions/1?fields=id,nsu,transactionDate,amount`
* Find transactions by NSU (Unique sequential number): `GET/financial/v1/transactions/byNsu/{nsuNumber}`
* Get Statistics about the transactions of the API: `GET/financial/v1/statistics`

### Details
Este end-point é chamado para criar uma nova transação.

`POST/productor/v1/transaction`


**Body:**

```json
{
  "nsu": "123456",
  "authorizationNumber": "010203",
  "amount": "22.88",
  "transactionDate": "2020-09-18T09:59:51.312Z",
  "type": "CARD",
}
```

**Where:**

`id` - id de transação. Ele é gerado automaticamente.

`nsu` - número de identificação de uma transação de venda com cartões. Pode ser nulo se a transação foi paga em dinheiro;

`authorizationNumber` - é um código único usado no processamento de transações online;

`amount` – valor da transação; uma sequência de comprimento arbitrário que pode ser analisada como BigDecimal;

`transactionDate` – hora da transação no formato ISO 8601 AAAA-MM-DDThh: mm: ss.sssZ no fuso horário local.

`type` - tipo de transação: CARD (cartão de crédito) ou MONEY (pago em dinheiro).

`links` - URL de auto-link para a transação. Ele é gerado automaticamente.

Retorna um corpo com um dos seguintes:

* 201 - Created: Everything worked as expected.
* 400 - Bad Request: the request was unacceptable, often due to missing a required parameter or invalid JSON.
* 404 - Not Found: The requested resource doesn't exist.
* 409 - Conflict: The request conflicts with another request (perhaps due to using the same idempotent key).
* 422 – Unprocessable Entity: if any of the fields are not parsable or the transaction date is in the future.
* 429 - Too Many Requests: Too many requests hit the API too quickly. We recommend an exponential back-off of your requests.
* 500, 502, 503, 504 - Server Errors: something went wrong on API end (These are rare).

`PUT/productor/v1/transaction/{id}`

Este end-point é chamado para dar update na transação.

**Body:**

```json
{
   "id": 1,
   "nsu": "123456",
   "authorizationNumber": "010203",
   "amount": "30.06",
   "transactionDate": "2020-09-18T09:59:51.312Z",
   "type": "CARD"
}
```

Deve ser enviado o objeto que será modificado. Deve retornar uma transação especificada por ID e todos os campos registrados acima, incluindo links e
aquele que foi atualizado.

```json
{
   "data": {   
   		"id": 1,
   		"nsu": "123456",
   		"authorizationNumber": "010203",
   		"amount": "30.06",
   		"transactionDate": "2020-09-18T09:59:51.312Z",
   		"type": "CARD",
   		"links": [
	    	{
	       		"rel": "self",
	        	"href": "http://localhost:8080/productor/v1/transactions/1"
	    	}
   		]
	}
}
```

`GET/productor/v1/transactions`

Este end-point retorna todas as transações creadas.

`DELETE/productor/v1/transaction/{id}`

This end-point transação para um id específico seja excluído, aceitando um corpo de solicitação vazio e retornando um código de status 204.

**Where:**

`id` - transaction id to be deleted.

`GET/productor/v1/statistics`

Este end-point retorno a statistics com base na transações creadas.

**Returns:**

```json
{
	"data": { 
  		"sum": "150.06",
  		"avg": "75.3",
  		"max": "120.0",
  		"min": "30.06",
  		"count": 2,
  		"links": [
	    	{
	       		"rel": "self",
	        	"href": "http://localhost:8080/productor/v1/statistics/1"
	    	}
   		]
   	}
}
```
 
**Where:**

`sum` – a BigDecimal specifying the total sum of transaction value.

`avg` – a BigDecimal specifying the average amount of transaction value.

`max` – a BigDecimal specifying single highest transaction value.

`min` – a BigDecimal specifying single lowest transaction value.

`count` – a long specifying the total number of transactions.

`links` - self-linking URL for the statistic. It is automatically generated.

All `BigDecimal` values always contain exactly two decimal places, e.g: `15.385` is returned as `15.39`.

### Technologies used

Este project foi elaborado e desenvolvido em cima desses pacotes:

* **Java 11 (Java Development Kit - JDK: 11.0.7)**
* **Spring Boot 2.3.3**
* **Spring Admin Client 2.3.0**
* **Maven**
* **JUnit 5**
* **Surfire**
* **PostgreSQL 12**
* **Flyway 6.4.4**
* **Swagger 3.0.0**
* **Model Mapper 2.3.8**
* **Heroku**
* **EhCache**
* **Bucket4j 4.10.0**
* **Swagger editor 3.0**

### Compile and Package

A API também foi desenvolvida para rodar `jar`. A fim de gerar esse `jar`, procedimento é esse:

```bash
mvn package
```

It will clean, compile and generate a `jar` at target directory, e.g. `hotmart-challenge-java-api-3.1.2-SNAPSHOT.jar`

### Execution

You need to have **PostgreSQL 9.6.17 or above** installed on your machine to run the API on `dev` profile. After installed, on the `pgAdmin` create a database named `productor`. If you don't have `pgAdmin` installed you can run on the `psql` console the follow command:

```sql
CREATE database productor;
```

After creating the API database, you need to add your **Postgres** root `username` and `password` in the `application.properties` file on `src/main/resource`. The lines that must be modified are as follows:

```properties
spring.datasource.username=
spring.datasource.password=
```

When the application is running **Flyway** will create the necessary tables for the creation of the words and the execution of the compare between the end-points. In the test profile, the application uses **H2** database (data in memory).

### Test

* For unit test phase, you can run:

```bash
mvn test
```

* To run all tests (including Integration Tests):

```bash
mvn integration-test
```

### Run

In order to run the API, run the jar simply as following:

```bash
java -jar hotmart-challenge-java-api-3.1.2-SNAPSHOT.jar --spring.profiles.active=dev
```
    
or

```bash
mvn spring-boot:run -Dspring.profiles.active=dev
```

By default, the API will be available at [http://localhost:8080/productor/v1](http://localhost:8080/productor/v1)

### Documentation

* Swagger (development environment): [http://localhost:8080/swagger.yaml](http://localhost:8080/swagger.yaml)

#### Medium Articles


### License

This API is licensed under the MIT License.

### Contributing
