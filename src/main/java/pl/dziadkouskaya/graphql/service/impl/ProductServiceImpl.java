package pl.dziadkouskaya.graphql.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.dziadkouskaya.graphql.codegen.types.CreateProductInput;
import pl.dziadkouskaya.graphql.codegen.types.ProductFilter;
import pl.dziadkouskaya.graphql.codegen.types.UpdateProductInput;
import pl.dziadkouskaya.graphql.entity.Product;
import pl.dziadkouskaya.graphql.entity.enums.ProductType;
import pl.dziadkouskaya.graphql.mapper.ProductMapper;
import pl.dziadkouskaya.graphql.repository.sql.ProductRepository;
import pl.dziadkouskaya.graphql.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
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

    @Override
    public Product createProduct(CreateProductInput input) {
        log.info("Get new product with input: {}.", input);
        var initialProduct = productMapper.toEntity(input);
        var product = productRepository.save(initialProduct);
        log.info("Create entity with id {}.", product.getId());
        return product;
    }

    @Override
    public Product updateProduct(UpdateProductInput input) {
        log.info("Update product with id {}.", input.getId());
        var initialProduct = productMapper.toEntity(input);
        var product = productRepository.save(initialProduct);
        log.info("Update entity with id {}.", product.getId());
        return product;
    }

    @Override
    public Boolean deleteProduct(UUID id) {
        if (productRepository.existsById(id)) {
            log.info("Product with id {} exists.", id);
            productRepository.deleteById(id);
            log.info("Product with id {} has been deleted.", id);
            return true;
        } else {
            log.info("Product with id {} doesn't exist.", id);
            return false;
        }
    }
}
