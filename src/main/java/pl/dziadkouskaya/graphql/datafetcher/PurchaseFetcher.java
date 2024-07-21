package pl.dziadkouskaya.graphql.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import pl.dziadkouskaya.graphql.codegen.types.PurchaseFilter;
import pl.dziadkouskaya.graphql.entity.Purchase;
import pl.dziadkouskaya.graphql.service.PurchaseService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DgsComponent
public class PurchaseFetcher {
    private final PurchaseService purchaseService;

    public PurchaseFetcher(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @DgsQuery
    public List<Purchase>  getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @DgsQuery
    public Optional<Purchase> getPurchaseById(UUID id) {
        return purchaseService.getPurchaseById(id);
    }

    @DgsQuery
    public List<Purchase> getPurchasesByFields(@InputArgument PurchaseFilter purchaseFilter) {
        return purchaseService.getPurchasesByFilter(purchaseFilter);
    }
}
