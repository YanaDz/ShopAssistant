package pl.dziadkouskaya.graphql.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dziadkouskaya.graphql.entity.Product;
import pl.dziadkouskaya.graphql.entity.ProductType;
import pl.dziadkouskaya.graphql.repository.sql.ProductRepository;
import pl.dziadkouskaya.graphql.service.ProductService;

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
        log.info("Get products by type: {}", type);
        var products =  productRepository.findByProductType(type);
        log.info("Returned {} products by type {}.", products.size(), type);
        return products;
    }

    @Override
    public List<Product> getAll() {
        log.info("Get all products.");
        var products =  productRepository.findAll();
        log.info("Returned {} products. ", products.size());
        return products;
    }
}
