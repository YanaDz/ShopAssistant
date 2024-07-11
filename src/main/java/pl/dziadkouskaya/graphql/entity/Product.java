package pl.dziadkouskaya.graphql.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AuditableEntity<UUID> {

    private String name;
    private String firm;
    private String productVersion;
    private ProductType productType;

}
