package com.example.Product.service;

import com.example.Product.dto.ProductRequest;
import com.example.Product.dto.ProductResponse;
import com.example.Product.entity.Product;
import com.example.Product.exception.RecordNotFoundException;
import com.example.Product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.LogManager;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {


    private final  ProductRepository productRepository;
// @Autowired
// RedisTemplate template;
//public static final String Hash_Key="Product";
    public void createProduct(ProductRequest productRequest){
        log.info("create product request started...."+productRequest);
 Product product=Product.builder().
         name(productRequest.getName())
                 .descripation(productRequest.getDescripation())
                         .price(productRequest.getPrice())
                                 .build();

//template.opsForHash().put(Hash_Key,product.getId(),product);
log.info(" product is saved"+product);
productRepository.save(product);

    }
    public List<ProductResponse> getAllProducts(){
        log.info("GetAllProducts: request stareted");
       List<Product> product= productRepository.findAll();
     //  template.opsForHash().values(Hash_Key);
        log.info("Available products in the list");
       return product.stream().map(this::mapToProductResponse).toList();


    }


    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .descripation(product.getDescripation())
                .price(product.getPrice())
                .build();
    }
    public List<Product> getProductByName(String name){
        log.info("GetProductByName request started",name);
       List<Product> product= (List<Product>) productRepository.findByName(name);
     //  template.opsForHash().get(Hash_Key,name);
        log.info("return the product by name",product);
        return product;
    }
    public Product updateProduct(int id, Product product){
        Product updateProduct=productRepository.findById(id)
                .orElseThrow(()->new RecordNotFoundException("product with id is not found"+id));
        updateProduct.setId(product.getId());
        updateProduct.setName(product.getName());
        updateProduct.setDescripation(product.getDescripation());
        updateProduct.setPrice(product.getPrice());
        productRepository.save(product);
       // template.opsForHash().put(Hash_Key,updateProduct(id,updateProduct));
        return updateProduct;
    }

    public void deleteProduct(int id) {
        log.info("Deleted the product with id:"+ productRepository.getById(id));
        //template.opsForHash().delete(id);
       productRepository.deleteById(id);

    }
    //Sorting
    public List<Product> findProductWithSorting(String field){
        return  productRepository.findAll(Sort.by(field));
    }
    //Paginaftion technique
    public Page<Product> findProductsWithPagination(int offset,int pagesize){
        Page<Product> pagination=productRepository.findAll(PageRequest.of(offset, pagesize));
        return pagination;
    }
}
