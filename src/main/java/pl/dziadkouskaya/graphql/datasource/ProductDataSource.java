package pl.dziadkouskaya.graphql.datasource;

import org.springframework.stereotype.Component;
import pl.dziadkouskaya.graphql.datasource.entity.Product;
import pl.dziadkouskaya.graphql.datasource.mapper.ProductMapper;
import pl.dziadkouskaya.graphql.datasource.service.ProductService;
import pl.dziadkouskaya.graphql.model.ProductModel;

import java.util.List;

@Component
public class ProductDataSource {
    private final ProductService productService;
    private final ProductMapper mapper;

    public ProductDataSource(ProductService productService, ProductMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }


    public List<ProductModel> getProductModels() {
        List<Product> products = productService.getAll();
        return products
                .stream()
                .map(product -> mapper.toDto(product))
                .toList();
    }

}
