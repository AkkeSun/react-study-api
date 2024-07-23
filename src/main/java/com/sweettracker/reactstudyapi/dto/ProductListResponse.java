package com.sweettracker.reactstudyapi.dto;

import com.sweettracker.reactstudyapi.domain.ProductName;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductListResponse {
    private int maxPage;
    private int nowPage;
    private List<ProductName> productList;

    @Builder
    public ProductListResponse(int maxPage, int nowPage, List<ProductName> productList) {
        this.maxPage = maxPage;
        this.nowPage = nowPage;
        this.productList = productList;
    }
}
