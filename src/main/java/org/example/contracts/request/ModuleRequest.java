package org.example.contracts.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModuleRequest extends BaseRequest{
    private Integer id;
    private String name;
    private String description;
    private Integer courseId;
}
