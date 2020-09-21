# SalesmanApi

All URIs are relative to *http://api.hotmart.com.br/v1/hotmart-challenge*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deletarVendedor**](SalesmanApi.md#deletarVendedor) | **DELETE** /Salesman | Deletar cadastro de vendedor
[**getConsultarVendedor**](SalesmanApi.md#getConsultarVendedor) | **GET** /Salesman | Recupera a lista geral de vendedores
[**getConsultarVendedorId**](SalesmanApi.md#getConsultarVendedorId) | **GET** /Salesman/{IdSalesMan} | Buscar informações cadastro de vendedor por id
[**postCadastrarVendedor**](SalesmanApi.md#postCadastrarVendedor) | **POST** /Salesman | Salvar cadastro de vendedor
[**putAlterarVendedor**](SalesmanApi.md#putAlterarVendedor) | **PUT** /Salesman | Alterar o cadastro de vendedor


<a name="deletarVendedor"></a>
# **deletarVendedor**
> deletarVendedor(salesManCode)

Deletar cadastro de vendedor

Deletar produto

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SalesmanApi;


SalesmanApi apiInstance = new SalesmanApi();
Integer salesManCode = 56; // Integer | Código do Vedendor
try {
    apiInstance.deletarVendedor(salesManCode);
} catch (ApiException e) {
    System.err.println("Exception when calling SalesmanApi#deletarVendedor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **salesManCode** | **Integer**| Código do Vedendor |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConsultarVendedor"></a>
# **getConsultarVendedor**
> SalesManReturn getConsultarVendedor()

Recupera a lista geral de vendedores

Recupera a lista de vendedores

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SalesmanApi;


SalesmanApi apiInstance = new SalesmanApi();
try {
    SalesManReturn result = apiInstance.getConsultarVendedor();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SalesmanApi#getConsultarVendedor");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SalesManReturn**](SalesManReturn.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConsultarVendedorId"></a>
# **getConsultarVendedorId**
> SalesManReturn getConsultarVendedorId(idSalesMan)

Buscar informações cadastro de vendedor por id

Buscar informações de produtos por id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SalesmanApi;


SalesmanApi apiInstance = new SalesmanApi();
Integer idSalesMan = 56; // Integer | 
try {
    SalesManReturn result = apiInstance.getConsultarVendedorId(idSalesMan);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SalesmanApi#getConsultarVendedorId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idSalesMan** | **Integer**|  |

### Return type

[**SalesManReturn**](SalesManReturn.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postCadastrarVendedor"></a>
# **postCadastrarVendedor**
> postCadastrarVendedor(salesManCode, salesMan)

Salvar cadastro de vendedor

Salvar cadastro de vendedor

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SalesmanApi;


SalesmanApi apiInstance = new SalesmanApi();
Integer salesManCode = 56; // Integer | Código do Vedendor
String salesMan = "salesMan_example"; // String | Nome do vendedor
try {
    apiInstance.postCadastrarVendedor(salesManCode, salesMan);
} catch (ApiException e) {
    System.err.println("Exception when calling SalesmanApi#postCadastrarVendedor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **salesManCode** | **Integer**| Código do Vedendor |
 **salesMan** | **String**| Nome do vendedor |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="putAlterarVendedor"></a>
# **putAlterarVendedor**
> putAlterarVendedor(salesManCode, salesMan)

Alterar o cadastro de vendedor

Alterar o cadastro de vendedor

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SalesmanApi;


SalesmanApi apiInstance = new SalesmanApi();
Integer salesManCode = 56; // Integer | Código do Vedendor
String salesMan = "salesMan_example"; // String | Nome do vendedor
try {
    apiInstance.putAlterarVendedor(salesManCode, salesMan);
} catch (ApiException e) {
    System.err.println("Exception when calling SalesmanApi#putAlterarVendedor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **salesManCode** | **Integer**| Código do Vedendor |
 **salesMan** | **String**| Nome do vendedor |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

