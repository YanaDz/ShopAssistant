package pl.dziadkouskaya.graphql.datasource.service;


import pl.dziadkouskaya.graphql.datasource.entity.Product;
import pl.dziadkouskaya.graphql.datasource.entity.ProductType;

import java.util.List;

public interface ProductService {
    List<Product> getByProductType(ProductType type);
    List<Product> getAll();
}
