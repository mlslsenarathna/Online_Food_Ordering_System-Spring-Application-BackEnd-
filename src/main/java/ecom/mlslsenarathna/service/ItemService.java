package ecom.mlslsenarathna.service;

import ecom.mlslsenarathna.model.dto.ItemDTO;
import ecom.mlslsenarathna.model.entity.ItemEntity;
import ecom.mlslsenarathna.repository.ItemRepository;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ItemService {
    ItemRepository itemRepository;

    public ItemDTO getById(String itemId) {
        Optional<ItemEntity> itemEntity=itemRepository.findById(itemId);
        ItemEntity item=itemEntity.orElseThrow();
        return new ItemDTO(item.getItemID(),
                item.getItemName(),
                item.getItemPrice(),
                item.getStockecount());

    }

    public void addCustomerList(ItemDTO[] itemDTOSList) {
        for(ItemDTO itemDTO:itemDTOSList){
            itemRepository.save(
                    new ItemEntity(
                            itemDTO.getItemID(),
                            itemDTO.getItemName(),
                            itemDTO.getItemPrice(),
                            itemDTO.getStockecount()
                    )
            );

        }
    }

    public void deleteById(String itemId) {
        itemRepository.deleteById(itemId);
    }



  /*  private void setOrderID(){
        if(getLastOrderID()!=null){
            String lastId=getLastOrderID();
            lastId=lastId.split("[A-Z]")[1];
            lastId=String.format("D%03d",(Integer.parseInt(lastId)+1));
            lblOrderID.setText(lastId);
        }
    }*/
}
