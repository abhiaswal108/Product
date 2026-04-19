package com.AA.product.controller;


import com.AA.product.entity.Product;
import com.AA.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }
    @PostMapping("/addproduct")
    String addProduct(@RequestBody Product p){
       return productService.addProduct(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOneProduct(@PathVariable int id){
        Product p=productService.getOnrProduct(id);
        if(p!=null){
            return new ResponseEntity<>(p,HttpStatus.OK);
        }
        else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/{id}")
    Product updateProduct(@RequestBody Product p,@PathVariable int id){
        return productService.updateProduct(p,id);
    }
    @DeleteMapping("/{id}")
    void  deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProduct(String keyword){
        List<Product> p =productService.seachProduct(keyword);
        return new ResponseEntity<>(p,HttpStatus.OK);

    }

}
