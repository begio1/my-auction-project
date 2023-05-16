package ro.itschool.auction2.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auction_bidder")
public class AuctionBidderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "auction_bidder_auction",
            joinColumns = @JoinColumn(name = "auction_bidder_id"),
            inverseJoinColumns = @JoinColumn(name = "auction_id"))
    private Set<AuctionEntity> auctions = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "auction_bidder_bidder",
            joinColumns = @JoinColumn(name = "auction_bidder_id"),
            inverseJoinColumns = @JoinColumn(name = "bidder_id"))
    private Set<BidderEntity> bidders = new HashSet<>();


}

