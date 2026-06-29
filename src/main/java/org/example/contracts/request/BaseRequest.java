package org.example.contracts.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public abstract class BaseRequest {

    private Integer page = 0;

    private Integer pageSize = 20;

    private String sortField;

    public Pageable toPageable() {

        return PageRequest.of(
                page,
                Math.min(pageSize, 100)
        );
    }
}