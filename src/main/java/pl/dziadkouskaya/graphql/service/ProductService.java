package pl.dziadkouskaya.graphql.service;


import pl.dziadkouskaya.graphql.codegen.types.ProductFilter;
import pl.dziadkouskaya.graphql.entity.Product;
import pl.dziadkouskaya.graphql.entity.enums.ProductType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    List<Product> getAll();

    List<Product> getProductsByFields(ProductFilter filter);

    Optional<Product> getProductById(UUID id);
}
