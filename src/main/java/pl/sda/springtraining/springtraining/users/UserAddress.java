package pl.sda.springtraining.springtraining.users;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {
    private String zipCode;
    private String city;
    private Countries country;
    private String street;
}
