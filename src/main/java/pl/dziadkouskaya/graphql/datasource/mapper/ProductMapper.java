package pl.dziadkouskaya.graphql.datasource.mapper;

import org.springframework.stereotype.Component;
import pl.dziadkouskaya.graphql.codegen.types.ProductType;
import pl.dziadkouskaya.graphql.datasource.entity.Product;
import pl.dziadkouskaya.graphql.model.ProductModel;

@Component
public class ProductMapper {

    public ProductModel toDto(Product product) {
        ProductModel productModel = new ProductModel();
        productModel.setId(product.getId().toString());
        productModel.setName(product.getName());
        productModel.setFirm(product.getFirm());
        productModel.setProductVersion(product.getProductVersion());
        productModel.setProductType(getModelProductType(product.getProductType()));
        return productModel;
    }

    private ProductType getModelProductType(pl.dziadkouskaya.graphql.datasource.entity.ProductType type) {
        return switch (type) {
            case COMPUTERS -> ProductType.COMPUTERS;
            case HOME_APPLIANCE -> ProductType.HOME_APPLIANCE;
            case KITCHEN_APPLIANCE -> ProductType.KITCHEN_APPLIANCE;
            default -> ProductType.SMARTPHONES;
        };
    }

}
