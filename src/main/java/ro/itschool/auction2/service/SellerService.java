package ro.itschool.auction2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.itschool.auction2.dtos.SellerDTO;
import ro.itschool.auction2.entities.AuctionEntity;
import ro.itschool.auction2.entities.SellerEntity;
import ro.itschool.auction2.exceptions.NonexistentResourceException;
import ro.itschool.auction2.repositories.SellerRepository;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public Iterable<SellerEntity> getAllSellers() {
        return sellerRepository.findAll();
    }

    public AuctionEntity getSellerById(int id) throws NonexistentResourceException {
        return this.sellerRepository.findById(id).orElseThrow(() -> new NonexistentResourceException("Seller does not exist", id));
    }

    @Transactional
    public void addSeller(SellerDTO sellerDTO) {
        SellerEntity seller = new SellerEntity();

        seller.setFirstName(sellerDTO.getFirstName());
        seller.setLastName(sellerDTO.getLastName());
        seller.setBirthDate(sellerDTO.getBirthDate());
        seller.setAge(sellerDTO.getAge());
        seller.setEmail(sellerDTO.getEmail());

        sellerRepository.save(seller);
    }
    @Transactional
    public void updateSeller(int id, SellerDTO sellerDTO) throws NonexistentResourceException {
        SellerEntity seller = sellerRepository.findById(id).orElseThrow(() -> new NonexistentResourceException("Seller does not exist", id)).getSeller();

        seller.setFirstName(sellerDTO.getFirstName());
        seller.setLastName(sellerDTO.getLastName());
        seller.setBirthDate(sellerDTO.getBirthDate());
        seller.setAge(sellerDTO.getAge());
        seller.setEmail(sellerDTO.getEmail());

        sellerRepository.save(seller);
    }
    public void delete(int id) {
        this.sellerRepository.deleteById(id);
    }
}

