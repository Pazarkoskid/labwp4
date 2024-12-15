package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.swing.tree.ExpandVetoException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Convert(converter = UserFullnameConverter.class)
    private UserFullname fullname;

    private String password;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Event> events;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Event> event = new HashSet<>();
    public void addTicketOrder(Event event) {
        this.event.add(event);
        event.setUser(this);
    }
    public User() {

    }
    public User(String username, UserFullname fullname, String password, LocalDate dateOfBirth) {
        this.username = username;
        this.fullname=fullname;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, username, fullname, password, dateOfBirth);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;
        User other = (User) obj;
        return id != null && id.equals(other.id);
    }


}