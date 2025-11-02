package ecom.mlslsenarathna.repository;

import ecom.mlslsenarathna.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,String> {
}
