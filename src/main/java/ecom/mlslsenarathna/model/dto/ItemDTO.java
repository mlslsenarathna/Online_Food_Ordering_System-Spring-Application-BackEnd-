package ecom.mlslsenarathna.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemDTO {
    private String itemID;
    private String itemName;
    private String itemPrice;
    private int stockecount;

}
