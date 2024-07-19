package pl.dziadkouskaya.graphql.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.dziadkouskaya.graphql.datasource.entity.Product;
import pl.dziadkouskaya.graphql.datasource.entity.ProductType;
import pl.dziadkouskaya.graphql.datasource.mapper.ProductMapper;
import pl.dziadkouskaya.graphql.datasource.service.ProductService;
import pl.dziadkouskaya.graphql.model.ProductModel;

import java.util.List;

@Component
@Slf4j
public class ProductDataSourceImpl implements ProductDataSource {
    private final ProductService productService;
    private final ProductMapper mapper;

    public ProductDataSourceImpl(ProductService productService, ProductMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }


    public List<ProductModel> getProductModels() {
        List<Product> products = productService.getAll();
        log.info("Received {} products from database", products.size());
        return products
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<ProductModel> getProductsByType(ProductType type) {
        List<Product> products = productService.getByProductType(type);
        log.info("Received {} products of {} type from database", products.size(), type);
        return products
                .stream()
                .map(mapper::toDto)
                .toList();
    }

}
