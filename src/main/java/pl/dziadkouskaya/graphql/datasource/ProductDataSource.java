package pl.dziadkouskaya.graphql.datasource;

import pl.dziadkouskaya.graphql.datasource.entity.ProductType;
import pl.dziadkouskaya.graphql.model.ProductModel;

import java.util.List;

public interface ProductDataSource {
    List<ProductModel> getProductModels();
    List<ProductModel> getProductsByType(ProductType type);

}
