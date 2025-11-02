package ecom.mlslsenarathna.service;

import ecom.mlslsenarathna.model.dto.CartItemDTO;
import ecom.mlslsenarathna.model.dto.ItemDTO;
import ecom.mlslsenarathna.model.entity.ItemEntity;
import ecom.mlslsenarathna.model.entity.OrderDetailsEntity;
import ecom.mlslsenarathna.model.entity.OrderEntity;
import ecom.mlslsenarathna.repository.ItemRepository;
import ecom.mlslsenarathna.repository.OrderDetailsRepository;
import ecom.mlslsenarathna.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {


    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;


    public void placeNewOrder(CartItemDTO[] cartItemDTOList) {
        List<ItemEntity> itemEntityList= new ArrayList<>();
        double totalPrice= getTotalBillPrice(cartItemDTOList);
        String orderID=generateOrderID();

        saveOrder(
                new OrderEntity(
                        orderID,
                        LocalDate.now(),
                        totalPrice,
                        "Pending"

                ));

        for(CartItemDTO cartItem:cartItemDTOList){
            itemEntityList.add(new ItemEntity(
                    cartItem.getItemId(),
                    cartItem.getItemName(),
                    getItemByID(cartItem.getItemId()).getItemPrice(),
                    getItemByID(cartItem.getItemId()).getStockecount()-cartItem.getQuantity()

            ));
            System.out.println("inerrr");
            saveOrderDetails(new OrderDetailsEntity(
                    generateOrderDetailsID(),
                    cartItem.getItemId(),
                    orderID,
                    cartItem.getQuantity()


                    ));

        }
        for (ItemEntity itemEntity:itemEntityList){
            itemRepository.save(itemEntity);

        }




    }
    public  void saveOrder(OrderEntity orderEntity){
        orderRepository.save(orderEntity);
    }
    public void saveOrderDetails(OrderDetailsEntity orderDetailsEntity){
        orderDetailsRepository.save(orderDetailsEntity);
    }
    public double getTotalBillPrice(CartItemDTO[] cartItemDTOS){
        double TotalPrice=0;
        for(CartItemDTO cartItemDTO:cartItemDTOS){
            TotalPrice+=(cartItemDTO.getQuantity()*getItemByID(cartItemDTO.getItemId()).getItemPrice());
        }
        return TotalPrice;

    }
    public ItemEntity getItemByID(String id){
        Optional<ItemEntity> byId = itemRepository.findById(id);
        return byId.orElseThrow();
    }
    public void updateItem(ItemEntity itemEntity){
        itemRepository.save(itemEntity);

    }
    public String getLastOrderID(){
        String lastOrderID=null;
        List<OrderEntity> ordersList=orderRepository.findAll();
        for(OrderEntity orderEntity:ordersList){
            lastOrderID=orderEntity.getOrderId();

        }
        return lastOrderID;
    }
    public String generateOrderID(){
        if(getLastOrderID()!=null){
            String lastId=getLastOrderID();
            lastId=lastId.split("[A-Z]")[1];
            lastId=String.format("O%03d",(Integer.parseInt(lastId)+1));
            return  lastId;
        }
        return "O001";
    }
    public String getLastOrderDetailsID(){
        String lastOrderDetailsID=null;
        List<OrderDetailsEntity> ordersList=orderDetailsRepository.findAll();
        for(OrderDetailsEntity orderDetailsEntity:ordersList){
            lastOrderDetailsID=orderDetailsEntity.getOrderId();

        }
        return lastOrderDetailsID;

    }
    public String generateOrderDetailsID(){
        if(getLastOrderDetailsID()!=null){
            String lastId=getLastOrderDetailsID();
            lastId=lastId.split("[A-Z]")[1];
            lastId=String.format("D%03d",(Integer.parseInt(lastId)+1));
            return  lastId;
        }
        return "D001";
    }

    public void changeStatustoComplete() {
    }
}
