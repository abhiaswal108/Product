package com.AA.product.service;

import com.AA.product.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProduct();
    public String addProduct(Product p);

    Product getOnrProduct(int id);

    Product updateProduct(Product p, int id);

    void deleteProduct(int id);

    List<Product> seachProduct(String keyword);
}
