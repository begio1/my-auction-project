package ro.itschool.auction2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ro.itschool.auction2.entities.BidderEntity;

import java.util.List;

@Repository
public interface BidderRepository extends JpaRepository<BidderEntity, Integer> {

   List<BidderEntity> findByName(String name);

    List<BidderEntity> findAllByOrderByBidAmountDesc();
}
