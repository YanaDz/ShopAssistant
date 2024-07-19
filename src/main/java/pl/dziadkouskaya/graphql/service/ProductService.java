package pl.dziadkouskaya.graphql.service;


import pl.dziadkouskaya.graphql.entity.Product;
import pl.dziadkouskaya.graphql.entity.ProductType;

import java.util.List;

public interface ProductService {
    List<Product> getByProductType(ProductType type);

    List<Product> getAll();
}
