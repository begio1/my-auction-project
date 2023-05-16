package ro.itschool.auction2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.itschool.auction2.dtos.ItemDTO;
import ro.itschool.auction2.entities.ItemEntity;
import ro.itschool.auction2.exceptions.NonexistentResourceException;
import ro.itschool.auction2.service.ItemService;

@RequestMapping
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items/{id}")
    public ItemDTO getItem(@PathVariable int id) throws NonexistentResourceException {
        ItemEntity item = itemService.getItemById(id);
        return ItemDTO.from(item);
    }

    @PostMapping("/items")
    public void createItem(@RequestBody ItemDTO itemDto) {
        ItemEntity item = new ItemEntity(itemDto.getName(), itemDto.getCategory());
        itemService.addItem(item);
    }
}

