# ProductCategoryApi

All URIs are relative to *http://api.hotmart.com.br/v1/hotmart-challenge*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deletarProductCategory**](ProductCategoryApi.md#deletarProductCategory) | **DELETE** /ProductCategory | Deletar categoria produto
[**getConsultarCategoria**](ProductCategoryApi.md#getConsultarCategoria) | **GET** /ProductCategory | Recupera a lista geral de categoria de produtos
[**getConsultarCategoriaProdutoId**](ProductCategoryApi.md#getConsultarCategoriaProdutoId) | **GET** /ProductCategory/{IdCategoriaProduto} | Buscar informações de produtos por id
[**postCadastrarCategoria**](ProductCategoryApi.md#postCadastrarCategoria) | **POST** /ProductCategory | Cadastro de categoria de produtos
[**putAlterarCategoriaProduto**](ProductCategoryApi.md#putAlterarCategoriaProduto) | **PUT** /ProductCategory | Alterar categoria produto


<a name="deletarProductCategory"></a>
# **deletarProductCategory**
> deletarProductCategory(productCategoryCode)

Deletar categoria produto

Deletar categoria produto

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductCategoryApi;


ProductCategoryApi apiInstance = new ProductCategoryApi();
Integer productCategoryCode = 56; // Integer | Código da cartegoria de Produto
try {
    apiInstance.deletarProductCategory(productCategoryCode);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductCategoryApi#deletarProductCategory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productCategoryCode** | **Integer**| Código da cartegoria de Produto |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConsultarCategoria"></a>
# **getConsultarCategoria**
> CategoryReturn getConsultarCategoria()

Recupera a lista geral de categoria de produtos

Recupera a lista de categoria de produtos

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductCategoryApi;


ProductCategoryApi apiInstance = new ProductCategoryApi();
try {
    CategoryReturn result = apiInstance.getConsultarCategoria();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductCategoryApi#getConsultarCategoria");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**CategoryReturn**](CategoryReturn.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getConsultarCategoriaProdutoId"></a>
# **getConsultarCategoriaProdutoId**
> ProductCategoryReturn getConsultarCategoriaProdutoId(idCategoriaProduto)

Buscar informações de produtos por id

Buscar informações de produtos por id

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductCategoryApi;


ProductCategoryApi apiInstance = new ProductCategoryApi();
Integer idCategoriaProduto = 56; // Integer | 
try {
    ProductCategoryReturn result = apiInstance.getConsultarCategoriaProdutoId(idCategoriaProduto);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductCategoryApi#getConsultarCategoriaProdutoId");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idCategoriaProduto** | **Integer**|  |

### Return type

[**ProductCategoryReturn**](ProductCategoryReturn.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postCadastrarCategoria"></a>
# **postCadastrarCategoria**
> postCadastrarCategoria(productCategoryCode, product)

Cadastro de categoria de produtos

Cadastro de categoria produto

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductCategoryApi;


ProductCategoryApi apiInstance = new ProductCategoryApi();
Integer productCategoryCode = 56; // Integer | Código da cartegoria de Produto
String product = "product_example"; // String | Nome do produto
try {
    apiInstance.postCadastrarCategoria(productCategoryCode, product);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductCategoryApi#postCadastrarCategoria");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productCategoryCode** | **Integer**| Código da cartegoria de Produto |
 **product** | **String**| Nome do produto |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="putAlterarCategoriaProduto"></a>
# **putAlterarCategoriaProduto**
> putAlterarCategoriaProduto(productCategoryCode, product)

Alterar categoria produto

Alterar categoria produto

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProductCategoryApi;


ProductCategoryApi apiInstance = new ProductCategoryApi();
Integer productCategoryCode = 56; // Integer | Código da cartegoria de Produto
String product = "product_example"; // String | Nome do produto
try {
    apiInstance.putAlterarCategoriaProduto(productCategoryCode, product);
} catch (ApiException e) {
    System.err.println("Exception when calling ProductCategoryApi#putAlterarCategoriaProduto");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **productCategoryCode** | **Integer**| Código da cartegoria de Produto |
 **product** | **String**| Nome do produto |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

