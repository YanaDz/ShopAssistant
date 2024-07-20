package pl.dziadkouskaya.graphql.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import pl.dziadkouskaya.graphql.codegen.types.ProductFilter;
import pl.dziadkouskaya.graphql.entity.Product;
import pl.dziadkouskaya.graphql.entity.enums.ProductType;
import pl.dziadkouskaya.graphql.service.ProductService;

import java.util.List;

@DgsComponent
public class ProductFetcher {
    private final ProductService productService;

    public ProductFetcher(ProductService productService) {
        this.productService = productService;
    }

    @DgsQuery
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

//    @DgsQuery
//    public List<Product> getProductsByType(@InputArgument ProductType productType) {
//        return productService.getByProductType(productType);
//    }

    @DgsQuery
    public List<Product> getProductsByFields(@InputArgument ProductFilter productFilter) {
        return productService.getProductsByFields(productFilter);
    }
}
