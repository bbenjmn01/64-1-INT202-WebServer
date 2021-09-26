package sit.int202.classicmodelweb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "offices")
public class Office {
    @Id
    private String officeCode;
    private String city;
    private String country;
    private String postalCode;
}
