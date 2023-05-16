package ro.itschool.auction2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.itschool.auction2.entities.AuctionEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuctionRepository extends JpaRepository<AuctionEntity, Integer> {
    List<AuctionEntity> findById(Long auctionId);
    List<AuctionEntity> findByName(String name);

}
