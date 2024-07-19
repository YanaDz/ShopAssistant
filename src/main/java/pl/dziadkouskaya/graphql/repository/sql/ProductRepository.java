package pl.dziadkouskaya.graphql.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.graphql.data.GraphQlRepository;
import pl.dziadkouskaya.graphql.entity.Product;
import pl.dziadkouskaya.graphql.entity.ProductType;

import java.util.List;
import java.util.UUID;

@GraphQlRepository
public interface ProductRepository extends JpaRepository<Product, UUID>, QueryByExampleExecutor<Product> {
    List<Product> findByProductType(ProductType productType);
}
