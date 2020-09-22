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


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * CategoryReturn
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-09-22T11:27:03.523Z")



public class CategoryReturn {
  @SerializedName("productCategoryCode")
  private Integer productCategoryCode = null;

  @SerializedName("productCategory")
  private String productCategory = null;

  public CategoryReturn productCategoryCode(Integer productCategoryCode) {
    this.productCategoryCode = productCategoryCode;
    return this;
  }

   /**
   * id do categoria
   * @return productCategoryCode
  **/
  @ApiModelProperty(example = "1", value = "id do categoria")
  public Integer getProductCategoryCode() {
    return productCategoryCode;
  }

  public void setProductCategoryCode(Integer productCategoryCode) {
    this.productCategoryCode = productCategoryCode;
  }

  public CategoryReturn productCategory(String productCategory) {
    this.productCategory = productCategory;
    return this;
  }

   /**
   * Nome do categoria
   * @return productCategory
  **/
  @ApiModelProperty(example = "Nome do categoria", value = "Nome do categoria")
  public String getProductCategory() {
    return productCategory;
  }

  public void setProductCategory(String productCategory) {
    this.productCategory = productCategory;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryReturn categoryReturn = (CategoryReturn) o;
    return Objects.equals(this.productCategoryCode, categoryReturn.productCategoryCode) &&
        Objects.equals(this.productCategory, categoryReturn.productCategory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productCategoryCode, productCategory);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryReturn {\n");
    
    sb.append("    productCategoryCode: ").append(toIndentedString(productCategoryCode)).append("\n");
    sb.append("    productCategory: ").append(toIndentedString(productCategory)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
