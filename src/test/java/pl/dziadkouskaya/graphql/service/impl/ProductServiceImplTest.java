package pl.dziadkouskaya.graphql.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.dziadkouskaya.graphql.codegen.types.CreateProductInput;
import pl.dziadkouskaya.graphql.codegen.types.ProductFilter;
import pl.dziadkouskaya.graphql.codegen.types.UpdateProductInput;
import pl.dziadkouskaya.graphql.entity.Product;
import pl.dziadkouskaya.graphql.mapper.ProductMapper;
import pl.dziadkouskaya.graphql.repository.sql.ProductRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        productService = new ProductServiceImpl(productRepository, productMapper);
    }

    @ParameterizedTest
    @MethodSource("provideProducts")
    void testGetAllProducts(List<Product> products) {
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.getAll();

        assertEquals(products.size(), result.size());
        verify(productRepository, times(1)).findAll();
    }

    private static Stream<Arguments> provideProducts() {
        return Stream.of(
                Arguments.of(Collections.emptyList()),
                Arguments.of(List.of(new Product(), new Product()))
        );
    }

    @ParameterizedTest
    @MethodSource("provideProductFilter")
    void testGetProductsByFields(ProductFilter filter, List<Product> products) {
        when(productRepository.findByFilters(any(), any(), any(), any())).thenReturn(products);

        List<Product> result = productService.getProductsByFields(filter);

        assertEquals(products.size(), result.size());
        verify(productRepository, times(1)).findByFilters(any(), any(), any(), any());
    }

    private static Stream<Arguments> provideProductFilter() {
        return Stream.of(
                Arguments.of(new ProductFilter("name", "firm", "type", "version"), List.of(new Product(), new Product())),
                Arguments.of(new ProductFilter(null, null, null, null), Collections.emptyList())
        );
    }

    @ParameterizedTest
    @MethodSource("provideProductId")
    void testGetProductById(UUID id, Optional<Product> product) {
        when(productRepository.findById(id)).thenReturn(product);

        Optional<Product> result = productService.getProductById(id);

        assertEquals(product.isPresent(), result.isPresent());
        verify(productRepository, times(1)).findById(id);
    }

    private static Stream<Arguments> provideProductId() {
        return Stream.of(
                Arguments.of(UUID.randomUUID(), Optional.of(new Product())),
                Arguments.of(UUID.randomUUID(), Optional.empty())
        );
    }

    @ParameterizedTest
    @MethodSource("provideCreateProductInput")
    void testCreateProduct(CreateProductInput input, Product product) {
        when(productMapper.toEntity(input)).thenReturn(product);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product result = productService.createProduct(input);

        assertEquals(product.getId(), result.getId());
        verify(productMapper, times(1)).toEntity(input);
        verify(productRepository, times(1)).save(product);
    }

    private static Stream<Arguments> provideCreateProductInput() {
        return Stream.of(
                Arguments.of(new CreateProductInput(), new Product())
        );
    }

    @ParameterizedTest
    @MethodSource("provideUpdateProductInput")
    void testUpdateProduct(UpdateProductInput input, Product product) {
        when(productMapper.toEntity(input)).thenReturn(product);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product result = productService.updateProduct(input);

        assertEquals(product.getId(), result.getId());
        verify(productMapper, times(1)).toEntity(input);
        verify(productRepository, times(1)).save(product);
    }

    private static Stream<Arguments> provideUpdateProductInput() {
        return Stream.of(
                Arguments.of(new UpdateProductInput(), new Product())
        );
    }

    @ParameterizedTest
    @MethodSource("provideDeleteProductId")
    void testDeleteProduct(UUID id, boolean exists, boolean expected) {
        when(productRepository.existsById(id)).thenReturn(exists);

        boolean result = productService.deleteProduct(id);

        assertEquals(expected, result);
        verify(productRepository, times(1)).existsById(id);
        if (exists) {
            verify(productRepository, times(1)).deleteById(id);
        }
    }

    private static Stream<Arguments> provideDeleteProductId() {
        return Stream.of(
                Arguments.of(UUID.randomUUID(), true, true),
                Arguments.of(UUID.randomUUID(), false, false)
        );
    }
}