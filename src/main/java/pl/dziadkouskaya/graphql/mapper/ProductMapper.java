package pl.dziadkouskaya.graphql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pl.dziadkouskaya.graphql.codegen.types.CreateProductInput;
import pl.dziadkouskaya.graphql.codegen.types.UpdateProductInput;
import pl.dziadkouskaya.graphql.entity.Product;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "productType", source = "productType")
    @Mapping(target = "firm", source = "firm")
    @Mapping(target = "productVersion", source = "productVersion")
    Product toEntity(CreateProductInput input);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "productType", source = "productType")
    @Mapping(target = "firm", source = "firm")
    @Mapping(target = "productVersion", source = "productVersion")
    Product toEntity(UpdateProductInput input);

}
