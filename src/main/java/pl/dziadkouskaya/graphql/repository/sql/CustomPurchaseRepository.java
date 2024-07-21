package pl.dziadkouskaya.graphql.repository.sql;

import pl.dziadkouskaya.graphql.codegen.types.PurchaseFilter;
import pl.dziadkouskaya.graphql.entity.Purchase;

import java.util.List;

public interface CustomPurchaseRepository {
    List<Purchase> findByPurchaseFilter(PurchaseFilter purchaseFilter);
}
