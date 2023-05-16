package ro.itschool.auction2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.itschool.auction2.entities.BidderEntity;
import ro.itschool.auction2.exceptions.NonexistentResourceException;
import ro.itschool.auction2.repositories.BidderRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BidderService  {

    @Autowired
    private BidderRepository bidderRepository;

    //meth to add new bidder in db
    @Transactional
    public void add(String name, LocalDate birthDate, int age, String email) {
        BidderEntity bidder = new BidderEntity();

        bidder.setName(name);
        bidder.setBirthDate(birthDate);
        bidder.setAge(age);
        bidder.setEmail(email);

        bidderRepository.save(bidder);
    }
    //find by id
    public BidderEntity getBidderById(int id) throws NonexistentResourceException {
        return this.bidderRepository.findById(id).orElseThrow(() -> new NonexistentResourceException("Auction does not exist", id));
    }
    //update
    public BidderEntity updateBidderDetails(int id, String name, LocalDate birthDate, int age, String email) throws NonexistentResourceException {
        Optional<BidderEntity> optionalBidder = this.bidderRepository.findById(id);

        if (!optionalBidder.isPresent()) {
            throw new NonexistentResourceException("Bidder does not exist!", id);
        }
        BidderEntity bidder = optionalBidder.get();
        bidder.setName(name);
        bidder.setBirthDate(birthDate);
        bidder.setAge(age);
        bidder.setEmail(email);
        return bidder;
    }
    //delete
    public void delete(int id) {
        this.bidderRepository.deleteById(id);
    }
}
