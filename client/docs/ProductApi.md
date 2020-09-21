# ProductApi

All URIs are relative to *http://api.hotmart.com.br/v1/hotmart-challenge*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deletarProduto**](ProductApi.md#deletarProduto) | **DELETE** /Product | Deletar produto
[**getConsultarProdutoId**](ProductApi.md#getConsultarProdutoId) | **GET** /Product/{idProduct} | Buscar informações de produtos por Id
[**getConsultarProdutos**](ProductApi.md#getConsultarProdutos) | **GET** /Product | Recupera a lista geral de produtos
[**postCadastrarProduto**](ProductApi.md#postCadastrarProduto) | **POST** /Product | Faz cadastro de produto
[**putAlterarProduto**](ProductApi.md#putAlterarProduto) | **PUT** /Product | Alterar cadastro de um produto


<a name="deletarProduto"></a>
# **deletarProduto**
> deletarProduto(productCode)

Deletar produto

Deletar produto

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductApi;


ProductApi apiInstance = new ProductApi();
Integer productCode = 56; // Integer | Código do produto
try {
    apiInstance.deletarProduto(productCode);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductApi#deletarProduto");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productCode** | **Integer**| Código do produto |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConsultarProdutoId"></a>
# **getConsultarProdutoId**
> ProductReturn getConsultarProdutoId(idProduct)

Buscar informações de produtos por Id

Buscar informações de produtos por Id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductApi;


ProductApi apiInstance = new ProductApi();
Integer idProduct = 56; // Integer | 
try {
    ProductReturn result = apiInstance.getConsultarProdutoId(idProduct);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductApi#getConsultarProdutoId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idProduct** | **Integer**|  |

### Return type

[**ProductReturn**](ProductReturn.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConsultarProdutos"></a>
# **getConsultarProdutos**
> ProductReturn getConsultarProdutos()

Recupera a lista geral de produtos

Recupera a lista de produtos

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductApi;


ProductApi apiInstance = new ProductApi();
try {
    ProductReturn result = apiInstance.getConsultarProdutos();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductApi#getConsultarProdutos");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ProductReturn**](ProductReturn.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postCadastrarProduto"></a>
# **postCadastrarProduto**
> postCadastrarProduto(productCode, product, description)

Faz cadastro de produto

Faz cadastro de produto

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductApi;


ProductApi apiInstance = new ProductApi();
Integer productCode = 56; // Integer | Código do produto
String product = "product_example"; // String | Nome do produto
String description = "description_example"; // String | Descricao do produto
try {
    apiInstance.postCadastrarProduto(productCode, product, description);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductApi#postCadastrarProduto");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productCode** | **Integer**| Código do produto |
 **product** | **String**| Nome do produto |
 **description** | **String**| Descricao do produto |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="putAlterarProduto"></a>
# **putAlterarProduto**
> putAlterarProduto(productCode, product, description)

Alterar cadastro de um produto

Alterar cadastro de um produto

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductApi;


ProductApi apiInstance = new ProductApi();
Integer productCode = 56; // Integer | Código do produto
String product = "product_example"; // String | Nome do produto
String description = "description_example"; // String | Descricao do produto
try {
    apiInstance.putAlterarProduto(productCode, product, description);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductApi#putAlterarProduto");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productCode** | **Integer**| Código do produto |
 **product** | **String**| Nome do produto |
 **description** | **String**| Descricao do produto |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

