package estudo.spring.crud.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String city;
    private String uf;

    public Address(DataRegisterAddress address) {
        this.city = address.city();
        this.uf = address.uf();
    }
}
