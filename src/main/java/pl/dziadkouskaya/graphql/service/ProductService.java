package pl.dziadkouskaya.graphql.service;


import pl.dziadkouskaya.graphql.codegen.types.ProductFilter;
import pl.dziadkouskaya.graphql.entity.Product;
import pl.dziadkouskaya.graphql.entity.enums.ProductType;

import java.util.List;

public interface ProductService {
//    List<Product> getByProductType(ProductType type);

    List<Product> getAll();

    List<Product> getProductsByFields(ProductFilter filter);
}
