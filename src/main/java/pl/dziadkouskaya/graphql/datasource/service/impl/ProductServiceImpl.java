package pl.dziadkouskaya.graphql.datasource.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dziadkouskaya.graphql.datasource.entity.Product;
import pl.dziadkouskaya.graphql.datasource.entity.ProductType;
import pl.dziadkouskaya.graphql.datasource.repository.sql.ProductRepository;
import pl.dziadkouskaya.graphql.datasource.service.ProductService;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getByProductType(ProductType type) {
        return List.of();
    }

    @Override
    public List<Product> getAll() {
        log.info("Get all products.");
        return productRepository.findAll();
    }
}
