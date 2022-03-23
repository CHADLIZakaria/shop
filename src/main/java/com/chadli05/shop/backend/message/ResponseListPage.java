package com.chadli05.shop.backend.message;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseListPage {
    public int totalPages;
    public Long totalElements;
    public int page;
    public List<?> results;
}
