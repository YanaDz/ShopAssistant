package pl.dziadkouskaya.graphql.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import pl.dziadkouskaya.graphql.codegen.types.CreateProductInput;
import pl.dziadkouskaya.graphql.codegen.types.CreateProductPayload;
import pl.dziadkouskaya.graphql.codegen.types.ProductFilter;
import pl.dziadkouskaya.graphql.codegen.types.UpdateProductInput;
import pl.dziadkouskaya.graphql.entity.Product;
import pl.dziadkouskaya.graphql.service.PayloadService;
import pl.dziadkouskaya.graphql.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DgsComponent
public class ProductFetcher {
    private final ProductService productService;
    private final PayloadService payloadService;

    public ProductFetcher(ProductService productService, PayloadService payloadService) {
        this.productService = productService;
        this.payloadService = payloadService;
    }

    @DgsQuery
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @DgsQuery
    public List<Product> getProductsByFields(@InputArgument ProductFilter productFilter) {
        return productService.getProductsByFields(productFilter);
    }

    @DgsQuery
    public Optional<Product> getProductById(UUID id) {
        return productService.getProductById(id);
    }

    @DgsMutation
    public CreateProductPayload createProduct(@InputArgument CreateProductInput input) {
        try {
            var product = productService.createProduct(input);
            return payloadService.createCreateProductPayload(product.getId(), true);
        } catch (Exception exception) {
            return payloadService.createCreateProductPayload(null, false, exception);
        }
    }

    @DgsMutation
    public CreateProductPayload updateProduct(@InputArgument UpdateProductInput input) {
        try {
            var product = productService.updateProduct(input);
            return payloadService.createCreateProductPayload(product.getId(), true);
        } catch (Exception exception) {
            return payloadService.createCreateProductPayload(null, false, exception);
        }
    }

    @DgsMutation
    public CreateProductPayload deleteProduct(@InputArgument UUID id) {
        var result = productService.deleteProduct(id);
        return result
                ? payloadService.createCreateProductPayload(id, true)
                : payloadService.createCreateProductPayload(null, false);
    }
}
