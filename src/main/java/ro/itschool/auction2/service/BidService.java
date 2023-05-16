package ro.itschool.auction2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.itschool.auction2.entities.BidderEntity;
import ro.itschool.auction2.repositories.BidderRepository;

import java.util.List;

@Service
public class BidService {

        @Autowired
        private BidderRepository bidderRepository;

        //meth to place bid
        @Transactional
        public BidderEntity placeBid(String bidderName, Double bidAmount) {
            BidderEntity bidder = (BidderEntity) bidderRepository.findByName(bidderName);
            if (bidder == null) {
                bidder = new BidderEntity();
                bidder.setName(bidderName);
            }
            bidder.setBidAmount(bidAmount);
            return bidderRepository.save(bidder);
        }

        //meth to find the winner
        @Transactional
        public BidderEntity getWinner() {
            List<BidderEntity> bidders = bidderRepository.findAllByOrderByBidAmountDesc();
            if (bidders.isEmpty()) {
                return null;
            }
            return bidders.get(0);
        }
}
