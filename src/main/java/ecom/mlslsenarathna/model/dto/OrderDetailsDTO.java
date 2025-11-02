package ecom.mlslsenarathna.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetailsDTO {
    private String orderDetailsID;
    private String itemId;
    private String orderId;
}
