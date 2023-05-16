package ro.itschool.auction2.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.itschool.auction2.entities.BidderEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BidderDTO {

    private Integer id;

    @NotEmpty
    private String name;

    @NotNull
    private LocalDate birthDate;

    private int age;

    @Email
    @NotEmpty
    private String email;

    public static BidderDTO from(BidderEntity bidderEntity) {
        return BidderDTO.builder()
                .id(bidderEntity.getId())
                .name(bidderEntity.getName())
                .birthDate(bidderEntity.getBirthDate())
                .age(bidderEntity.getAge())
                .email(bidderEntity.getEmail())
                .build();
    }

    public static List<BidderDTO> from(List<BidderEntity> bidderEntities) {
        List<BidderDTO> result = new ArrayList<>();

        for (BidderEntity bidderEntity : bidderEntities) {
            result.add(BidderDTO.from(bidderEntity));
        }

        return result;
    }

    public static BidderDTOBuilder builder() {
        return new BidderDTOBuilder();
    }

    public static class BidderDTOBuilder {
        private Integer id;
        private @NotEmpty String name;
        private @NotNull LocalDate birthDate;
        private int age;
        private @Email @NotEmpty String email;

        BidderDTOBuilder() {
        }

        public BidderDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public BidderDTOBuilder name(@NotEmpty String name) {
            this.name = name;
            return this;
        }

        public BidderDTOBuilder birthDate(@NotNull LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public BidderDTOBuilder age(int age) {
            this.age = age;
            return this;
        }

        public BidderDTOBuilder email(@Email @NotEmpty String email) {
            this.email = email;
            return this;
        }

        public BidderDTO build() {
            return new BidderDTO(this.id, this.name, this.birthDate, this.age, this.email);
        }

        public String toString() {
            return "BidderDTO.BidderDTOBuilder(id=" + this.id + ", name=" + this.name + ", birthDate=" + this.birthDate + ", age=" + this.age + ", email=" + this.email + ")";
        }

        public BidderDTOBuilder id(Long id) {
            return null;
        }
    }
}

