package org.example.contracts.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CourseRequest extends BaseRequest{
    private Integer id;
    private String name;
    private String username;
    private String description;
    private Boolean isPaid;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Integer userId;
}
