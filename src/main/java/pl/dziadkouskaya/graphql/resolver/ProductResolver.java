package pl.dziadkouskaya.graphql.resolver;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import pl.dziadkouskaya.graphql.entity.Product;

import java.util.UUID;

@Controller
public class ProductResolver {
    @QueryMapping
    public Product getProduct(UUID id) {
        return
    }
}
