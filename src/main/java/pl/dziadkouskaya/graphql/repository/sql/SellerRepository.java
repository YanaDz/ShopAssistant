package pl.dziadkouskaya.graphql.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.graphql.data.GraphQlRepository;
import pl.dziadkouskaya.graphql.entity.Product;
import pl.dziadkouskaya.graphql.entity.Seller;

import java.util.UUID;

@GraphQlRepository
public interface SellerRepository extends JpaRepository<Seller, UUID>, QueryByExampleExecutor<Seller> {
}
