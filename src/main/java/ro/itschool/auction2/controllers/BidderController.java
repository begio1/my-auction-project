package ro.itschool.auction2.controllers;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.auction2.dtos.BidderDTO;
import ro.itschool.auction2.entities.BidderEntity;
import ro.itschool.auction2.exceptions.NonexistentResourceException;
import ro.itschool.auction2.service.BidderService;


@RestController
@RequestMapping("/bidders")
public class BidderController {
    private final BidderService bidderService;

    @Autowired
    public BidderController(BidderService bidderService) {
        this.bidderService = bidderService;
    }

    @PostMapping
    public ResponseEntity<Void> addBidder(@RequestBody BidderDTO bidderDTO) {
        bidderService.add(bidderDTO.getName(), bidderDTO.getBirthDate(), bidderDTO.getAge(), bidderDTO.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BidderEntity> getBidderById(@PathVariable int id) {
        try {
            BidderEntity bidder = bidderService.getBidderById(id);
            return ResponseEntity.ok(bidder);
        } catch (NonexistentResourceException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BidderEntity> updateBidderDetails(@PathVariable int id, @RequestBody BidderDTO bidderDTO) {
        try {
            BidderEntity bidder = bidderService.updateBidderDetails(id, bidderDTO.getName(), bidderDTO.getBirthDate(), bidderDTO.getAge(), bidderDTO.getEmail());
            return ResponseEntity.ok(bidder);
        } catch (NonexistentResourceException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBidder(@PathVariable int id) {
        bidderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
