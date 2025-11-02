package ecom.mlslsenarathna.repository;

import ecom.mlslsenarathna.model.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository  extends JpaRepository<ItemEntity,String> {
}
