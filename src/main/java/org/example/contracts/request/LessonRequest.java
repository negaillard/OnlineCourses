package org.example.contracts.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LessonRequest extends BaseRequest{
    private Integer id;
    private String name;
    private String description;
    private String link;
    private LocalDateTime dateTime;
    private Integer moduleId;
}
