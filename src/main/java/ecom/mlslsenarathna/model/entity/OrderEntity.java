package ecom.mlslsenarathna.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class OrderEntity {
    @Id
    private String orderId;
    private LocalDate orderDate;
    private double totalPrice;
    private String orderStatus;
}
