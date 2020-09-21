/*
 * hotmart-challenge
 * Especificação da API Hotmart Challenge
 *
 * OpenAPI spec version: 1.0.0
 * Contact: bismarck@ufmg.br
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.CategoryReturn;
import io.swagger.client.model.ErrorReturn;
import io.swagger.client.model.ProductCategoryReturn;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCategoryApi {
    private ApiClient apiClient;

    public ProductCategoryApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ProductCategoryApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for deletarProductCategory
     * @param productCategoryCode Código da cartegoria de Produto (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deletarProductCategoryCall(Integer productCategoryCode, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/ProductCategory"
            .replaceAll("\\{" + "ProductCategoryCode" + "\\}", apiClient.escapeString(productCategoryCode.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deletarProductCategoryValidateBeforeCall(Integer productCategoryCode, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'productCategoryCode' is set
        if (productCategoryCode == null) {
            throw new ApiException("Missing the required parameter 'productCategoryCode' when calling deletarProductCategory(Async)");
        }
        

        com.squareup.okhttp.Call call = deletarProductCategoryCall(productCategoryCode, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletar categoria produto
     * Deletar categoria produto
     * @param productCategoryCode Código da cartegoria de Produto (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deletarProductCategory(Integer productCategoryCode) throws ApiException {
        deletarProductCategoryWithHttpInfo(productCategoryCode);
    }

    /**
     * Deletar categoria produto
     * Deletar categoria produto
     * @param productCategoryCode Código da cartegoria de Produto (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deletarProductCategoryWithHttpInfo(Integer productCategoryCode) throws ApiException {
        com.squareup.okhttp.Call call = deletarProductCategoryValidateBeforeCall(productCategoryCode, null, null);
        return apiClient.execute(call);
    }

    /**
     * Deletar categoria produto (asynchronously)
     * Deletar categoria produto
     * @param productCategoryCode Código da cartegoria de Produto (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deletarProductCategoryAsync(Integer productCategoryCode, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deletarProductCategoryValidateBeforeCall(productCategoryCode, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getConsultarCategoria
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getConsultarCategoriaCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/ProductCategory";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getConsultarCategoriaValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = getConsultarCategoriaCall(progressListener, progressRequestListener);
        return call;

    }

    /**
     * Recupera a lista geral de categoria de produtos
     * Recupera a lista de categoria de produtos
     * @return CategoryReturn
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CategoryReturn getConsultarCategoria() throws ApiException {
        ApiResponse<CategoryReturn> resp = getConsultarCategoriaWithHttpInfo();
        return resp.getData();
    }

    /**
     * Recupera a lista geral de categoria de produtos
     * Recupera a lista de categoria de produtos
     * @return ApiResponse&lt;CategoryReturn&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CategoryReturn> getConsultarCategoriaWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = getConsultarCategoriaValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<CategoryReturn>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Recupera a lista geral de categoria de produtos (asynchronously)
     * Recupera a lista de categoria de produtos
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getConsultarCategoriaAsync(final ApiCallback<CategoryReturn> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getConsultarCategoriaValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CategoryReturn>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getConsultarCategoriaProdutoId
     * @param idCategoriaProduto  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getConsultarCategoriaProdutoIdCall(Integer idCategoriaProduto, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/ProductCategory/{IdCategoriaProduto}"
            .replaceAll("\\{" + "IdCategoriaProduto" + "\\}", apiClient.escapeString(idCategoriaProduto.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getConsultarCategoriaProdutoIdValidateBeforeCall(Integer idCategoriaProduto, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'idCategoriaProduto' is set
        if (idCategoriaProduto == null) {
            throw new ApiException("Missing the required parameter 'idCategoriaProduto' when calling getConsultarCategoriaProdutoId(Async)");
        }
        

        com.squareup.okhttp.Call call = getConsultarCategoriaProdutoIdCall(idCategoriaProduto, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Buscar informações de produtos por id
     * Buscar informações de produtos por id
     * @param idCategoriaProduto  (required)
     * @return ProductCategoryReturn
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ProductCategoryReturn getConsultarCategoriaProdutoId(Integer idCategoriaProduto) throws ApiException {
        ApiResponse<ProductCategoryReturn> resp = getConsultarCategoriaProdutoIdWithHttpInfo(idCategoriaProduto);
        return resp.getData();
    }

    /**
     * Buscar informações de produtos por id
     * Buscar informações de produtos por id
     * @param idCategoriaProduto  (required)
     * @return ApiResponse&lt;ProductCategoryReturn&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ProductCategoryReturn> getConsultarCategoriaProdutoIdWithHttpInfo(Integer idCategoriaProduto) throws ApiException {
        com.squareup.okhttp.Call call = getConsultarCategoriaProdutoIdValidateBeforeCall(idCategoriaProduto, null, null);
        Type localVarReturnType = new TypeToken<ProductCategoryReturn>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Buscar informações de produtos por id (asynchronously)
     * Buscar informações de produtos por id
     * @param idCategoriaProduto  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getConsultarCategoriaProdutoIdAsync(Integer idCategoriaProduto, final ApiCallback<ProductCategoryReturn> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getConsultarCategoriaProdutoIdValidateBeforeCall(idCategoriaProduto, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ProductCategoryReturn>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for postCadastrarCategoria
     * @param productCategoryCode Código da cartegoria de Produto (required)
     * @param product Nome do produto (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCadastrarCategoriaCall(Integer productCategoryCode, String product, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/ProductCategory"
            .replaceAll("\\{" + "ProductCategoryCode" + "\\}", apiClient.escapeString(productCategoryCode.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (product != null)
        localVarHeaderParams.put("product", apiClient.parameterToString(product));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postCadastrarCategoriaValidateBeforeCall(Integer productCategoryCode, String product, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'productCategoryCode' is set
        if (productCategoryCode == null) {
            throw new ApiException("Missing the required parameter 'productCategoryCode' when calling postCadastrarCategoria(Async)");
        }
        
        // verify the required parameter 'product' is set
        if (product == null) {
            throw new ApiException("Missing the required parameter 'product' when calling postCadastrarCategoria(Async)");
        }
        

        com.squareup.okhttp.Call call = postCadastrarCategoriaCall(productCategoryCode, product, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Cadastro de categoria de produtos
     * Cadastro de categoria produto
     * @param productCategoryCode Código da cartegoria de Produto (required)
     * @param product Nome do produto (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void postCadastrarCategoria(Integer productCategoryCode, String product) throws ApiException {
        postCadastrarCategoriaWithHttpInfo(productCategoryCode, product);
    }

    /**
     * Cadastro de categoria de produtos
     * Cadastro de categoria produto
     * @param productCategoryCode Código da cartegoria de Produto (required)
     * @param product Nome do produto (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> postCadastrarCategoriaWithHttpInfo(Integer productCategoryCode, String product) throws ApiException {
        com.squareup.okhttp.Call call = postCadastrarCategoriaValidateBeforeCall(productCategoryCode, product, null, null);
        return apiClient.execute(call);
    }

    /**
     * Cadastro de categoria de produtos (asynchronously)
     * Cadastro de categoria produto
     * @param productCategoryCode Código da cartegoria de Produto (required)
     * @param product Nome do produto (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postCadastrarCategoriaAsync(Integer productCategoryCode, String product, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postCadastrarCategoriaValidateBeforeCall(productCategoryCode, product, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for putAlterarCategoriaProduto
     * @param productCategoryCode Código da cartegoria de Produto (required)
     * @param product Nome do produto (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call putAlterarCategoriaProdutoCall(Integer productCategoryCode, String product, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/ProductCategory"
            .replaceAll("\\{" + "ProductCategoryCode" + "\\}", apiClient.escapeString(productCategoryCode.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (product != null)
        localVarHeaderParams.put("product", apiClient.parameterToString(product));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putAlterarCategoriaProdutoValidateBeforeCall(Integer productCategoryCode, String product, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'productCategoryCode' is set
        if (productCategoryCode == null) {
            throw new ApiException("Missing the required parameter 'productCategoryCode' when calling putAlterarCategoriaProduto(Async)");
        }
        
        // verify the required parameter 'product' is set
        if (product == null) {
            throw new ApiException("Missing the required parameter 'product' when calling putAlterarCategoriaProduto(Async)");
        }
        

        com.squareup.okhttp.Call call = putAlterarCategoriaProdutoCall(productCategoryCode, product, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Alterar categoria produto
     * Alterar categoria produto
     * @param productCategoryCode Código da cartegoria de Produto (required)
     * @param product Nome do produto (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void putAlterarCategoriaProduto(Integer productCategoryCode, String product) throws ApiException {
        putAlterarCategoriaProdutoWithHttpInfo(productCategoryCode, product);
    }

    /**
     * Alterar categoria produto
     * Alterar categoria produto
     * @param productCategoryCode Código da cartegoria de Produto (required)
     * @param product Nome do produto (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> putAlterarCategoriaProdutoWithHttpInfo(Integer productCategoryCode, String product) throws ApiException {
        com.squareup.okhttp.Call call = putAlterarCategoriaProdutoValidateBeforeCall(productCategoryCode, product, null, null);
        return apiClient.execute(call);
    }

    /**
     * Alterar categoria produto (asynchronously)
     * Alterar categoria produto
     * @param productCategoryCode Código da cartegoria de Produto (required)
     * @param product Nome do produto (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putAlterarCategoriaProdutoAsync(Integer productCategoryCode, String product, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putAlterarCategoriaProdutoValidateBeforeCall(productCategoryCode, product, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
}
