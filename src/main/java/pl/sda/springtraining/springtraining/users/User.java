package pl.sda.springtraining.springtraining.users;

import lombok.*;
import pl.sda.springtraining.springtraining.roles.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id; //TODO utworzyc 'BaseEntity', zeby ID było w osobnej klasie

    private String firstName;
    private String lastName;

    @Embedded
    private UserAddress userAddress;

    private String birthDate;
    private String pesel;
    private String username;
    private String passwordHash;
    private String phone;
    private boolean preferEmails;

    @ManyToMany
    @JoinTable(name = "users_roles")
    private Set<Role> roles = new HashSet<>();

}
