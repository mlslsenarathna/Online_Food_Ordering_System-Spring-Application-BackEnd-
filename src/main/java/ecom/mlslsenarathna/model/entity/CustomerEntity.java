package ecom.mlslsenarathna.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class CustomerEntity {
    @Id
    private String custId;
    private String custName;
    private String custAddress;
    private String custMobbileNumber;
}
