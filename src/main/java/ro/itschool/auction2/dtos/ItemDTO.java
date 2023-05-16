package ro.itschool.auction2.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.itschool.auction2.entities.ItemEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    private Long id;
    private String name;
    private String category;

    public static ItemDTO from(ItemEntity item) {
        return new ItemDTO(item.getId(), item.getName(), item.getCategory());

    }

    public Integer getAuctionId() {
        return getAuctionId();
    }
}
