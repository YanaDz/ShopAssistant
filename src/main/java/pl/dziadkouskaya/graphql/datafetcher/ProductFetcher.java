package pl.dziadkouskaya.graphql.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import pl.dziadkouskaya.graphql.datasource.ProductDataSource;
import pl.dziadkouskaya.graphql.datasource.entity.ProductType;
import pl.dziadkouskaya.graphql.model.ProductModel;

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

    @DgsQuery
    public List<ProductModel> getProductsByType(@InputArgument ProductType productType) {
        return productDataSource.getProductsByType(productType);
    }
}
