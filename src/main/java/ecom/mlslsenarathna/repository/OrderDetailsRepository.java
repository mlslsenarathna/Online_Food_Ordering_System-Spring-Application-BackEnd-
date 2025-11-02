package ecom.mlslsenarathna.repository;

import ecom.mlslsenarathna.model.entity.OrderDetailsEntity;
import ecom.mlslsenarathna.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity,String> {

}
