package com.project1.project_study.services;

import com.project1.project_study.DTOs.ProductsDTO;
import com.project1.project_study.DTOs.ProductsUpdateDTO;
import com.project1.project_study.core.utils.ApiObjectMapper;
import com.project1.project_study.models.Products;
import com.project1.project_study.repositories.ProductsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsRepository productsRepository;
    private final ApiObjectMapper<Products> apiObjectMapper;
    private final CategoryService categoryService;

    @Transactional
    public void create (ProductsDTO productsDTO) {
        var product = apiObjectMapper.dtoToModel(productsDTO, Products.class);
        productsRepository.save(product);
    }
    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    public Products findOne(Long productId){
        return findById(productId);
    }

    @Transactional
    public Products update(ProductsDTO productsDTO, Long productId, Object productsUpdateDTO) {

        var product = findById(productId);
        var updatedProduct = apiObjectMapper.dtoToModel(productsUpdateDTO,
                Products.class);
        var newProduct = apiObjectMapper.updateModel(product, updatedProduct);
        updateProductCategory(newProduct, (ProductsUpdateDTO) productsUpdateDTO);
        return productsRepository.save(newProduct);
    }

    private void updateProductCategory(Products products, ProductsUpdateDTO productsUpdateDTO){
        if (productsUpdateDTO.categoryId() != null){
            var category = categoryService.findCategoryById(
                    productsUpdateDTO.categoryId()
            );
            products.setCategory(category);
        }

    }

    @Transactional
    public  void delete(Long productId){
        var product = findById(productId);
        productsRepository.deleteById(product.getId());
    }

    private Products findById(Long productId) {
        return productsRepository.findById(productId)
                .orElseThrow(RuntimeException::new);
    }
}
