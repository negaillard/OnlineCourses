package org.example.contracts.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PageResponse<T> {

    private List<T> data;

    private long totalElements;

    private int totalPages;

    private int currentPage;

    private int pageSize;
}