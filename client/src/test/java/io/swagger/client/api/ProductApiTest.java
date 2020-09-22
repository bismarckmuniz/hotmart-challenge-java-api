/*
 * hotmart-challenge
 * API Hotmart Challenge
 *
 * OpenAPI spec version: 1.0.0
 * Contact: bismarck@ufmg.br
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.ErrorReturn;
import io.swagger.client.model.ProductReturn;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProductApi
 */
@Ignore
public class ProductApiTest {

    private final ProductApi api = new ProductApi();

    
    /**
     * Deletar produto
     *
     * Deletar produto
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deletarProdutoTest() throws ApiException {
        Integer productCode = null;
        api.deletarProduto(productCode);

        // TODO: test validations
    }
    
    /**
     * Buscar informações de produtos por Id
     *
     * Buscar informações de produtos por Id
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getConsultarProdutoIdTest() throws ApiException {
        Integer idProduct = null;
        ProductReturn response = api.getConsultarProdutoId(idProduct);

        // TODO: test validations
    }
    
    /**
     * Recupera a lista geral de produtos
     *
     * Recupera a lista de produtos
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getConsultarProdutosTest() throws ApiException {
        ProductReturn response = api.getConsultarProdutos();

        // TODO: test validations
    }
    
    /**
     * Faz cadastro de produto
     *
     * Faz cadastro de produto
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void postCadastrarProdutoTest() throws ApiException {
        Integer productCode = null;
        String product = null;
        String description = null;
        api.postCadastrarProduto(productCode, product, description);

        // TODO: test validations
    }
    
    /**
     * Alterar cadastro de um produto
     *
     * Alterar cadastro de um produto
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void putAlterarProdutoTest() throws ApiException {
        Integer productCode = null;
        String product = null;
        String description = null;
        api.putAlterarProduto(productCode, product, description);

        // TODO: test validations
    }
    
}