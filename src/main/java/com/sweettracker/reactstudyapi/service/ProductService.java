package com.sweettracker.reactstudyapi.service;

import com.sweettracker.reactstudyapi.domain.Product;
import com.sweettracker.reactstudyapi.domain.ProductName;
import com.sweettracker.reactstudyapi.dto.ProductListResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    static List<Product> TBL_PRODUCT;

    public ProductService() {
        TBL_PRODUCT = new ArrayList<>();
        for(int i =0 ; i<20; i++) {
            TBL_PRODUCT.add(Product.builder()
                    .id(i)
                    .name(i + " 번 상품 이름")
                    .price(5000 + i)
                    .description(i + " 번 상품 설명 입니다.")
                .build());
        }
    }

    public ProductListResponse getProductList(int page) {
        int pageSize = 10;
        int startIndex = page * pageSize;
        int endIndex = Math.min(startIndex + pageSize, TBL_PRODUCT.size());
        if (startIndex >= TBL_PRODUCT.size()) {
            return null;
        }

        return ProductListResponse.builder()
            .maxPage((int) Math.ceil((double) TBL_PRODUCT.size() / pageSize) - 1)
            .nowPage(startIndex)
            .productList(TBL_PRODUCT.subList(startIndex, endIndex).stream()
                .map(product -> ProductName.builder()
                    .name(product.getName())
                    .id(product.getId())
                    .build())
                .collect(Collectors.toList()))
            .build();
    }

    public Product getProduct(int productId) {
        return TBL_PRODUCT.stream()
            .filter(product -> product.getId() == productId)
            .findFirst().orElse(null);
    }

    public Product addProduct(Product product) {
        int lastId = TBL_PRODUCT.stream()
            .map(Product::getId)
            .max(Integer::compareTo).get();

        product.updateId(lastId + 1);

        TBL_PRODUCT.add(product);
        return product;
    }
}
