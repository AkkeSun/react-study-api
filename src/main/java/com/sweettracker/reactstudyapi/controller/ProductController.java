package com.sweettracker.reactstudyapi.controller;

import com.sweettracker.reactstudyapi.domain.Product;
import com.sweettracker.reactstudyapi.domain.ProductName;
import com.sweettracker.reactstudyapi.dto.CommonErrorResponse;
import com.sweettracker.reactstudyapi.dto.ProductListResponse;
import com.sweettracker.reactstudyapi.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;


    @GetMapping
    public ResponseEntity<?> findList(@RequestParam(defaultValue = "0") int page){
        if (page < 0) {
            return ResponseEntity.badRequest().body(CommonErrorResponse.builder()
                    .errorCode(1001)
                    .errorMessage("페이지는 0보다 작을 수 없습니다.")
                    .build());
        }

        ProductListResponse response = productService.getProductList(page);
        if(response == null) {
            return ResponseEntity.internalServerError().body(CommonErrorResponse.builder()
                .errorCode(1002)
                .errorMessage("조회된 정보가 없습니다.")
                .build());
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> findProductInfo(@PathVariable int productId) {
        Product product = productService.getProduct(productId);
        if(product == null) {
            return ResponseEntity.internalServerError().body(CommonErrorResponse.builder()
                .errorCode(1003)
                .errorMessage("조회된 시용자 정보가 없습니다.")
                .build());
        }

        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

}
