package pl.dziadkouskaya.graphql.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import pl.dziadkouskaya.graphql.entity.Seller;
import pl.dziadkouskaya.graphql.service.SellerService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@DgsComponent
public class SellerFetcher {
    private final SellerService sellerService;

    public SellerFetcher(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @DgsQuery
    public List<Seller> getAllSellers() {
        return sellerService.getAll();
    }

    @DgsQuery
    public Optional<Seller> getSellerById(UUID id) {
        return sellerService.getById(id);
    }
}
