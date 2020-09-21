# SalesApi

All URIs are relative to *http://api.hotmart.com.br/v1/hotmart-challenge*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deletarVenda**](SalesApi.md#deletarVenda) | **DELETE** /Sales | Deletar venda
[**getConsultarVenda**](SalesApi.md#getConsultarVenda) | **GET** /Sales | Recupera a lista geral de vendas
[**getConsultarVendasId**](SalesApi.md#getConsultarVendasId) | **GET** /Sales/{IdSalesman} | Buscar informações da lista de vendas por id
[**postCadastrarVendas**](SalesApi.md#postCadastrarVendas) | **POST** /Sales | Salva a vendas
[**putAlterarVendas**](SalesApi.md#putAlterarVendas) | **PUT** /Sales | Alterar a lista de vendas


<a name="deletarVenda"></a>
# **deletarVenda**
> deletarVenda(salesCode)

Deletar venda

Deletar venda

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SalesApi;


SalesApi apiInstance = new SalesApi();
Integer salesCode = 56; // Integer | Código do Vedas
try {
    apiInstance.deletarVenda(salesCode);
} catch (ApiException e) {
    System.err.println("Exception when calling SalesApi#deletarVenda");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **salesCode** | **Integer**| Código do Vedas |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConsultarVenda"></a>
# **getConsultarVenda**
> SalesReturn getConsultarVenda()

Recupera a lista geral de vendas

Recupera a lista de vendas

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SalesApi;


SalesApi apiInstance = new SalesApi();
try {
    SalesReturn result = apiInstance.getConsultarVenda();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SalesApi#getConsultarVenda");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SalesReturn**](SalesReturn.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConsultarVendasId"></a>
# **getConsultarVendasId**
> SalesManReturn getConsultarVendasId(idSalesman)

Buscar informações da lista de vendas por id

Buscar informações da lista de vendas por id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SalesApi;


SalesApi apiInstance = new SalesApi();
Integer idSalesman = 56; // Integer | 
try {
    SalesManReturn result = apiInstance.getConsultarVendasId(idSalesman);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SalesApi#getConsultarVendasId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idSalesman** | **Integer**|  |

### Return type

[**SalesManReturn**](SalesManReturn.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postCadastrarVendas"></a>
# **postCadastrarVendas**
> postCadastrarVendas(salesMan, buyer, product)

Salva a vendas

Salva a vendas

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SalesApi;


SalesApi apiInstance = new SalesApi();
String salesMan = "salesMan_example"; // String | Nome do vendedor
String buyer = "buyer_example"; // String | Nome do comprador
String product = "product_example"; // String | Nome do produto
try {
    apiInstance.postCadastrarVendas(salesMan, buyer, product);
} catch (ApiException e) {
    System.err.println("Exception when calling SalesApi#postCadastrarVendas");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **salesMan** | **String**| Nome do vendedor |
 **buyer** | **String**| Nome do comprador |
 **product** | **String**| Nome do produto |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="putAlterarVendas"></a>
# **putAlterarVendas**
> putAlterarVendas(salesCode, product)

Alterar a lista de vendas

Alterar a lista de vendas

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SalesApi;


SalesApi apiInstance = new SalesApi();
Integer salesCode = 56; // Integer | Código do Vedas
String product = "product_example"; // String | Nome do produto
try {
    apiInstance.putAlterarVendas(salesCode, product);
} catch (ApiException e) {
    System.err.println("Exception when calling SalesApi#putAlterarVendas");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **salesCode** | **Integer**| Código do Vedas |
 **product** | **String**| Nome do produto |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

