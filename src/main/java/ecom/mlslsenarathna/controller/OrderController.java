package ecom.mlslsenarathna.controller;

import ecom.mlslsenarathna.model.dto.CartItemDTO;
import ecom.mlslsenarathna.service.ItemService;
import ecom.mlslsenarathna.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/getOrder")
    public String getOrder(){
        return "Order";
    }
    @PutMapping("")
    public void placeOrder(@RequestBody CartItemDTO[] cartItemDTO){


    }
}
