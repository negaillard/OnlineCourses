package org.example.contracts.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest extends BaseRequest{
    private Integer id;
    private String username;
    private String email;
    private String passwordHash;
    private Boolean isAdmin;
    private String bill;
}
