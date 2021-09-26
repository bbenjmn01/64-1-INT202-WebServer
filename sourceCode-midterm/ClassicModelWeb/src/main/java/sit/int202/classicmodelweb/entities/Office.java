package sit.int202.classicmodelweb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="offices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Office {
    @Id
    private String officeCode;
    private String city;
    private String country;
    private String postalCode;
}
