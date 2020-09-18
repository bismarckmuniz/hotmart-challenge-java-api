# hotmart-challenge-java-api

## About the API
Uma API de produto para gerenciamento de transações. The API main URL `/productor/v1`.

## Features
Esta API fornece endpoints HTTP e ferramentas para o seguinte:

* Create a Transaction: `POST/productor/v1/transactions`
* Update a Transaction: `PUT/productor/v1/transactions`
* Delete a Transaction (by id): `DELETE/productor/v1/transactions/1`
* Get report of all transactions created: `GET/productor/v1/transactions`
* Find a unique transaction by id: `GET/productor/v1/transactions/1`
* Find transactions by NSU (Unique sequential number): `GET/productor/v1/transactions/byNsu/{nsuNumber}`
* Get Statistics about the transactions of the API: `GET/productor/v1/statistics`

### Details
Este ponto final é chamado para criar uma nova transação.

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

This end-point is chamda de update a transaction.

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

This end-point retorna todas as transações created.

`DELETE/productor/v1/transaction/{id}`

This end-point transação para um id específico seja excluído, aceitando um corpo de solicitação vazio e retornando um código de status 204.

**Where:**

`id` - transaction id to be deleted.

`GET/productor/v1/statistics`

This end-point retorno the statistics based on the transactions created.

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

This project was developed with:

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

### Compile and Package

The API also was developed to run with an `jar`. In order to generate this `jar`, you should run:

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

* Swagger (development environment): [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

#### Medium Articles


### License

This API is licensed under the MIT License.

### Contributing
