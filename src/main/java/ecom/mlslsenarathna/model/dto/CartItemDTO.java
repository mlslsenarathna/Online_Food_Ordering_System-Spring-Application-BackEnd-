package ecom.mlslsenarathna.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartItemDTO {
    private String orderId;
    private String itemId;
    private String itemName;
    private int quantity;
    private double price;
}
