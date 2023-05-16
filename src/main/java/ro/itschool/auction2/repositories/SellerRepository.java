package ro.itschool.auction2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.itschool.auction2.entities.AuctionEntity;
import ro.itschool.auction2.entities.SellerEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Integer> {

    Optional<AuctionEntity> findById(int id);
    List<SellerEntity> findByFirstName(String firstName);
    List<SellerEntity> findByLastName(String lastName);

}
