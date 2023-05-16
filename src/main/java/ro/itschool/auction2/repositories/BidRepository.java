package ro.itschool.auction2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.itschool.auction2.entities.BidEntity;

@Repository
public interface BidRepository extends JpaRepository<BidEntity, Integer> {
}
