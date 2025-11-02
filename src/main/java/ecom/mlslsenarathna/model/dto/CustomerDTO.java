package ecom.mlslsenarathna.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO {
    private String custId;
    private String custName;
    private String custAddress;
    private String custMobbileNumber;
}
