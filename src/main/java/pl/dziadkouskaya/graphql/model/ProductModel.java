package pl.dziadkouskaya.graphql.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pl.dziadkouskaya.graphql.codegen.types.Product;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductModel extends Product {
}
