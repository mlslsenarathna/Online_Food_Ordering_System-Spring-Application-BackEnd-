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
public class ItemEntity {
    @Id
    private String itemID;
    private String itemName;
    private String itemPrice;
    private int stockecount;
}
