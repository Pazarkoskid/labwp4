package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserFullname {
    private String name;
    private String surname;

    public UserFullname() {
    }
}
