package ro.itschool.auction2.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.itschool.auction2.dtos.ItemDTO;
import ro.itschool.auction2.entities.AuctionEntity;
import ro.itschool.auction2.entities.ItemEntity;
import ro.itschool.auction2.exceptions.NonexistentResourceException;
import ro.itschool.auction2.repositories.AuctionRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    public Iterable<AuctionEntity> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public AuctionEntity getAuctionById(int id) throws NonexistentResourceException {
        return this.auctionRepository.findById(id).orElseThrow(() -> new NonexistentResourceException("Auction does not exist", id));
    }

    @Transactional
    public void addAuction(String name, String description, double startPrice, LocalDateTime startTime, LocalDateTime endTime, String lastBidder,
                           double highestBid, int callCount) {

//        log.info("info in service");
//        log.debug("debug in service");
//        log.warn("warn in service");
//        log.error("error in service");

        AuctionEntity auction = new AuctionEntity();

        auction.setName(name);
        auction.setDescription(description);
        auction.setStartPrice(startPrice);
        auction.setStartTime(startTime);
        auction.setEndTime(endTime);
        auction.setLastBidder(lastBidder);
        auction.setHighestBid(BigDecimal.valueOf(highestBid));
        auction.setCallCount(callCount);

        auctionRepository.save(auction);

    }

    @Transactional
    public void addItemToAuction(ItemDTO itemDto) {
        AuctionEntity auction = auctionRepository.findById(itemDto.getAuctionId()).orElseThrow(() ->
                new EntityNotFoundException("Auction not found"));

        ItemEntity item = new ItemEntity();
        item.setName(itemDto.getName());
        item.setAuction(auction);
    }

    public AuctionEntity updateAuction(int id, String name, String description, double startPrice, LocalDateTime startTime) throws NonexistentResourceException {
        Optional<AuctionEntity> optionalAuction = this.auctionRepository.findById(id);

        if (!optionalAuction.isPresent()) {
            throw new NonexistentResourceException("Auction does not exist!", id);
        }

        AuctionEntity auction = optionalAuction.get();
        auction.setName(name);
        auction.setDescription(description);
        auction.setStartPrice(startPrice);
        auction.setStartTime(startTime);

        return auction;
    }

    public void delete(int id) {
        this.auctionRepository.deleteById(id);
    }

    //this method let the admin set the date and time for the auction to start
    public AuctionEntity setStartDateTime(int auctionId, LocalDate date, LocalTime time) {
        AuctionEntity auction = auctionRepository.findById(auctionId)
                .orElseThrow(() -> new IllegalArgumentException("Auction not found"));

        LocalDateTime startDateTime = LocalDateTime.of(date, time);
        auction.setStartDate(startDateTime);
        return auctionRepository.save(auction);
    }
}


