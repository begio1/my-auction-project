package ro.itschool.auction2.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
@Builder
@Table(name = "auctions")
public class AuctionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    private String description;

    @Column(name = "start_price")
    private Double startPrice;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "last_bidder")
    private String lastBidder;

    @Column(name = "highest_bid")
    private BigDecimal highestBid;

    @Column(name = "call_count")
    private Integer callCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private SellerEntity seller;

    @OneToOne(mappedBy = "auction", cascade = CascadeType.ALL)
    private ItemEntity item;

    public void setStartDate(LocalDateTime startDate) {
    }
}



