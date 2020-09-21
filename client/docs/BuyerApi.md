# BuyerApi

All URIs are relative to *http://api.hotmart.com.br/v1/hotmart-challenge*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deletarComprador**](BuyerApi.md#deletarComprador) | **DELETE** /Buyer | Deletar comprador
[**getConsultarCommprador**](BuyerApi.md#getConsultarCommprador) | **GET** /Buyer | Recupera a lista geral de comprador
[**getConsultarCompradorId**](BuyerApi.md#getConsultarCompradorId) | **GET** /Buyer/{buyerCode} | Buscar informações do comprador especifico por id
[**postCadastrarComprador**](BuyerApi.md#postCadastrarComprador) | **POST** /Buyer | Cadastro de comprador
[**putAlterarComprador**](BuyerApi.md#putAlterarComprador) | **PUT** /Buyer | Alterar cadastro do comprador


<a name="deletarComprador"></a>
# **deletarComprador**
> deletarComprador(buyerCode)

Deletar comprador

Deletar comprador

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BuyerApi;


BuyerApi apiInstance = new BuyerApi();
Integer buyerCode = 56; // Integer | Código do comprador
try {
    apiInstance.deletarComprador(buyerCode);
} catch (ApiException e) {
    System.err.println("Exception when calling BuyerApi#deletarComprador");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **buyerCode** | **Integer**| Código do comprador |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConsultarCommprador"></a>
# **getConsultarCommprador**
> BuyerReturn getConsultarCommprador()

Recupera a lista geral de comprador

Recupera a lista de comprador

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BuyerApi;


BuyerApi apiInstance = new BuyerApi();
try {
    BuyerReturn result = apiInstance.getConsultarCommprador();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BuyerApi#getConsultarCommprador");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BuyerReturn**](BuyerReturn.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConsultarCompradorId"></a>
# **getConsultarCompradorId**
> BuyerReturn getConsultarCompradorId(buyerCode)

Buscar informações do comprador especifico por id

Buscar informações do comprador especifico por id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BuyerApi;


BuyerApi apiInstance = new BuyerApi();
Integer buyerCode = 56; // Integer | 
try {
    BuyerReturn result = apiInstance.getConsultarCompradorId(buyerCode);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BuyerApi#getConsultarCompradorId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **buyerCode** | **Integer**|  |

### Return type

[**BuyerReturn**](BuyerReturn.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postCadastrarComprador"></a>
# **postCadastrarComprador**
> postCadastrarComprador(buyerCode, buyer)

Cadastro de comprador

Cadastro de comprador

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BuyerApi;


BuyerApi apiInstance = new BuyerApi();
Integer buyerCode = 56; // Integer | Código do comprador
String buyer = "buyer_example"; // String | Nome do comprador
try {
    apiInstance.postCadastrarComprador(buyerCode, buyer);
} catch (ApiException e) {
    System.err.println("Exception when calling BuyerApi#postCadastrarComprador");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **buyerCode** | **Integer**| Código do comprador |
 **buyer** | **String**| Nome do comprador |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="putAlterarComprador"></a>
# **putAlterarComprador**
> putAlterarComprador(buyerCode, buyer)

Alterar cadastro do comprador

Alterar cadastro do comprador

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.BuyerApi;


BuyerApi apiInstance = new BuyerApi();
Integer buyerCode = 56; // Integer | Código do comprador
String buyer = "buyer_example"; // String | Nome do comprador
try {
    apiInstance.putAlterarComprador(buyerCode, buyer);
} catch (ApiException e) {
    System.err.println("Exception when calling BuyerApi#putAlterarComprador");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **buyerCode** | **Integer**| Código do comprador |
 **buyer** | **String**| Nome do comprador |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

