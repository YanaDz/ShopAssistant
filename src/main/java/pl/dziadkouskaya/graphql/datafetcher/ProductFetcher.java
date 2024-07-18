package pl.dziadkouskaya.graphql.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import pl.dziadkouskaya.graphql.datasource.ProductDataSource;
import pl.dziadkouskaya.graphql.model.ProductModel;

import java.io.IOException;
import java.util.List;

@DgsComponent
public class ProductFetcher {
    private final ProductDataSource productDataSource;

    public ProductFetcher(ProductDataSource productDataSource) {
        this.productDataSource = productDataSource;
    }

    @DgsQuery
    public List<ProductModel> getAllProducts() {
        return productDataSource.getProductModels();
    }
}
