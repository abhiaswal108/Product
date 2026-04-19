package com.AA.product.service;

import com.AA.product.entity.Product;
import com.AA.product.repository.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl  implements ProductService{

    private final ProductRepo productRepo;

    public  List<Product> getAllProduct(){
        return productRepo.findAll();
    }
    public String addProduct(Product p){
         productRepo.save(p);
        return "Product added successfully with ID: " + p.getId();
    }

    @Override
    public Product getOnrProduct(int id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Product p, int id) {
        Product o=productRepo.findById(id).orElse(null);
        if(o!=null){
            o.setName(p.getName());
            o.setDesc(p.getDesc());
            o.setPrice(p.getPrice());
            return productRepo.save(o);
        }
        return null;
    }

    @Override
    public void deleteProduct(int id) {

        productRepo.deleteById(id);
    }

    @Override
    public List<Product> seachProduct(String keyword) {
        return productRepo.searchKeyword(keyword);
    }


}
