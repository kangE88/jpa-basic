package hellojpa;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Address {
    private String city;
    private String street;
    private String zipcode;


}
