package org.example.contracts.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    public int Id;
    public String Email;
    public Boolean IsAdmin;
    public String Username;
    public String PasswordHash;
}
