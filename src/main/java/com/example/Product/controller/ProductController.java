package com.example.Product.controller;


import com.example.Product.dto.ProductRequest;
import com.example.Product.dto.ProductResponse;
import com.example.Product.entity.Product;
import com.example.Product.service.ProductService;


import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/save")
    public void createProduct(@RequestBody ProductRequest productRequest) {
        System.out.println("Saved the product");
        productService.createProduct(productRequest);
    }

    @GetMapping("/findAll")
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Product>> getProductByName(@RequestParam(required = false)final String name) {
        List<Product> product = (List<Product>) productService.getProductByName(name);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable int id){
       return new ResponseEntity<>(productService.updateProduct(id, product),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);

    }
   @GetMapping("/sort/{field}")
    public List<Product> getAllProducts(@PathVariable String field){
       List<Product> allProducts=productService.findProductWithSorting(field);
       return allProducts;
   }
   @GetMapping("/pagination/{offset}/{pagesize}")
    public Page<Product> paginationByField(@PathVariable int offset,@PathVariable int pagesize){
      Page<Product> pagination=productService.findProductsWithPagination(offset, pagesize);
      return pagination;
   }
}
