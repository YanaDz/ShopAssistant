package pl.dziadkouskaya.graphql.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.graphql.data.GraphQlRepository;
import pl.dziadkouskaya.graphql.entity.Product;

import java.util.List;
import java.util.UUID;

@GraphQlRepository
public interface ProductRepository extends JpaRepository<Product, UUID>, QueryByExampleExecutor<Product> {
    @Query("SELECT p FROM Product p WHERE " +
            "(LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) OR :name IS NULL) AND " +
            "(LOWER(p.firm) LIKE LOWER(CONCAT('%', :firm, '%')) OR :firm IS NULL) AND " +
            "(p.productType = :type OR :type IS NULL) AND " +
            "(LOWER(p.productVersion) LIKE LOWER(CONCAT('%', :productVersion, '%')) OR :productVersion IS NULL)")
    List<Product> findByFilters(@Param("name") String name,
                                @Param("firm") String firm,
                                @Param("type") Integer type,
                                @Param("productVersion") String productVersion);


}
