package ecom.mlslsenarathna.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDTO {
    private String orderId;
    private LocalDate orderDate;
    private double totalPrice;
    private String orderStatus;
}
