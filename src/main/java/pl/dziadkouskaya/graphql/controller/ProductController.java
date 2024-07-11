package pl.dziadkouskaya.graphql.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import pl.dziadkouskaya.graphql.entity.Product;

import java.util.UUID;

@Slf4j
@Controller
public class ProductController {
    @QueryMapping
    public Product getProduct(UUID id) {
        log.info("Get product with id {}.", id);
        return null;
    }
}
