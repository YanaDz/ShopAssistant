package pl.dziadkouskaya.graphql.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dziadkouskaya.graphql.codegen.types.ProductFilter;
import pl.dziadkouskaya.graphql.entity.Product;
import pl.dziadkouskaya.graphql.entity.enums.ProductType;
import pl.dziadkouskaya.graphql.repository.sql.ProductRepository;
import pl.dziadkouskaya.graphql.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        log.info("Get all products.");
        var products = productRepository.findAll();
        log.info("Returned {} products. ", products.size());
        return products;
    }

    @Override
    public List<Product> getProductsByFields(ProductFilter filter) {
        log.info("Get products by params: {}.", filter);
        var products =  productRepository.findByFilters(filter.getName(), filter.getFirm(),
                ProductType.codeByName(filter.getProductType()), filter.getProductVersion());
        log.info("Returned {} products. ", products.size());
        return products;
    }

    @Override
    public Optional<Product> getProductById(UUID id) {
        log.info("Get product by ID: {}.", id);
        return productRepository.findById(id);
    }
}
