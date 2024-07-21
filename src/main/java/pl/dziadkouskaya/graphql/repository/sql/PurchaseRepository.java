package pl.dziadkouskaya.graphql.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.graphql.data.GraphQlRepository;
import pl.dziadkouskaya.graphql.entity.Purchase;

import java.util.UUID;

@GraphQlRepository
public interface PurchaseRepository extends JpaRepository<Purchase, UUID>, QueryByExampleExecutor<Purchase>,
        CustomPurchaseRepository {

}
