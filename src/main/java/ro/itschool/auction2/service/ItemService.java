package ro.itschool.auction2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.itschool.auction2.entities.ItemEntity;
import ro.itschool.auction2.exceptions.NonexistentResourceException;
import ro.itschool.auction2.repositories.ItemRepository;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public void addItem(String name, String category) {
        ItemEntity item = new ItemEntity();
        item.setName(name);
        item.setCategory(category);
        itemRepository.save(item);
    }

    public ItemEntity getItemById(int id) throws NonexistentResourceException {
        return this.itemRepository.findById(id).orElseThrow(() -> new NonexistentResourceException("Item does not exist", id));
    }

    public ItemEntity updateItem(int id, String name, String category) throws NonexistentResourceException {
        Optional<ItemEntity> optionalAuction = this.itemRepository.findById(id);

        if (!optionalAuction.isPresent()) {
            throw new NonexistentResourceException("Item does not exist!", id);
        }

        ItemEntity item = optionalAuction.get();
        item.setName(name);
        item.setCategory(category);

        return item;
    }
    public void delete(int id){

        this.itemRepository.deleteById(id);
    }

    public void addItem(ItemEntity item) {
    }
}
