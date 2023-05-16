package ro.itschool.auction2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.itschool.auction2.entities.AuctionEntity;
import ro.itschool.auction2.repositories.AuctionRepository;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private final AuctionRepository auctionRepository;

    @Autowired
    public AuctionController(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @GetMapping("/{id}")
    public AuctionEntity getAuction(@PathVariable int id) {
        return auctionRepository.findById(id).orElse(null);
    }

    @PostMapping
    public AuctionEntity createAuction(@RequestBody AuctionEntity auction) {
        return auctionRepository.save(auction);
    }

    @PutMapping("/{id}")
    public AuctionEntity updateAuction(@PathVariable int id, @RequestBody AuctionEntity auction) {
        AuctionEntity existingAuction = auctionRepository.findById(id).orElse(null);
        if (existingAuction != null) {
            existingAuction.setItem(auction.getItem());
            existingAuction.setHighestBid(auction.getHighestBid());
            return auctionRepository.save(existingAuction);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAuction(@PathVariable int id) {
        auctionRepository.deleteById(id);
    }
}
