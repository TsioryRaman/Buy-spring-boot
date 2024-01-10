package com.commerce.buy.http.api;

import com.commerce.buy.http.service.CrudAdvancedServiceInterface;
import com.commerce.buy.http.service.CrudServiceInterface;
import com.commerce.buy.domain.product.dto.ProductDto;
import com.commerce.buy.domain.product.model.Product;
import com.commerce.buy.infrastructure.repository.ProductRepository;
import com.commerce.buy.infrastructure.search.dto.RequestDto;
import com.commerce.buy.infrastructure.search.dto.SearchRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductApiController {
    @Autowired
    CrudAdvancedServiceInterface<Product> productService;

    @Autowired
    ProductRepository productRepository;

    @PostMapping(path = "findName")
    public List<Product> findByName(@RequestBody RequestDto requestDto)
    {
        return this.productService.findByName(requestDto.getSearchRequestDto());
    }

    @PostMapping(path = "findMultiple")
    public List<Product> findMultipleProductByName(@RequestBody List<RequestDto> requestDto)
    {
        return this.productService.findByMultipleName(requestDto);
    }

    @PostMapping(path="")
    public ResponseEntity createProduct(@RequestBody ProductDto productDto) {
        try{
            return this.productService.create(productDto);
        }catch (Exception e)
        {
            return new ResponseEntity<>((new HashMap<String,String>()).put("error",e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProduct()
    {
        return this.productService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id)
    {
        return this.productService.getById(id);
    }

    @GetMapping(path = "filter")
    public List<Product> findByName(@RequestParam @NotEmpty String name)
    {
        return this.productService.findByName(new SearchRequestDto("name",name));
    }


}
