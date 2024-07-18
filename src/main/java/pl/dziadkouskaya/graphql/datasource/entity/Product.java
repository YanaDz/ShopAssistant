package pl.dziadkouskaya.graphql.datasource.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;


@Entity
@Table(name = "product")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    @EqualsAndHashCode.Include
    private UUID id;

    private String name;

    private String firm;

    @Column(name = "product_version")
    private String productVersion;

    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)
    private ProductType productType;

}
