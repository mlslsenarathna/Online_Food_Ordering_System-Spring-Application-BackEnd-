package ecom.mlslsenarathna.controller;

import ecom.mlslsenarathna.model.dto.CustomerDTO;
import ecom.mlslsenarathna.model.dto.ItemDTO;
import ecom.mlslsenarathna.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    ItemService itemService;
    @GetMapping("/getItem")
    public String getItems(){
        return "Fish Bun";
    }
    @GetMapping("/getById/{itemId}")
    public ItemDTO getItemByID(@PathVariable String itemId){
        return itemService.getById(itemId);
    }
    @PostMapping("/addItemList")
    public void addCustomer(@RequestBody ItemDTO[] itemDTOSList){
        itemService.addCustomerList(itemDTOSList);

    }
    @DeleteMapping("/deleteById/{itemId}")
    public void deleteItemById(@PathVariable String itemId){
        itemService.deleteById(itemId);
    }
    @GetMapping("/getAllItems")
    public List<ItemDTO> getAllItems(){
        return itemService.getAllItems();
    }
    @PostMapping("/updateItemStock/{itemId}")
    public void updateItemStock(@PathVariable String itemId){
        itemService.updateStockCount(itemId);
    }


}
