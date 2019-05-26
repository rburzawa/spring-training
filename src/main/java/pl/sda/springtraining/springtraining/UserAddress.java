package pl.sda.springtraining.springtraining;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserAddress {
    private String zipCode;
    private String city;
    private Countries country;
    private String street;
}
