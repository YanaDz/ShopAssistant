package pl.dziadkouskaya.graphql.service;

import pl.dziadkouskaya.graphql.codegen.types.CreateProductPayload;
import pl.dziadkouskaya.graphql.entity.Product;

import java.util.UUID;


public interface PayloadService {
    CreateProductPayload createCreateProductPayload(UUID id, boolean isSuccess, Exception ... exception);
}
