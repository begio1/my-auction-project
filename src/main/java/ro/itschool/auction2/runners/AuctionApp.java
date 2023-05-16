package ro.itschool.auction2.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import ro.itschool.auction2.entities.BidderEntity;
import ro.itschool.auction2.repositories.BidderRepository;
import ro.itschool.auction2.service.AuctionService;
import ro.itschool.auction2.service.BidService;
import ro.itschool.auction2.service.BidderService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Component
public class AuctionApp implements CommandLineRunner {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private BidService bidService;

    @Autowired
    private BidderService bidderService;
    @Autowired
    private BidderRepository bidderRepository;

    @Override
    public void run(String... args) throws Exception {

        bidderService.delete(1);
    }
}
