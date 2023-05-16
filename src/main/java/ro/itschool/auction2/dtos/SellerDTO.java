package ro.itschool.auction2.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ro.itschool.auction2.entities.SellerEntity;

//import javax.validation.constraints.Email;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class SellerDTO {

    private Integer id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotNull
    private LocalDate birthDate;

    private int age;

    @Email
    @NotEmpty
    private String email;

    public static SellerDTO from(SellerEntity sellerEntity) {
        return SellerDTO.builder()
                .id(sellerEntity.getId())
                .firstName(sellerEntity.getFirstName())
                .lastName(sellerEntity.getLastName())
                .birthDate(sellerEntity.getBirthDate())
                .age(sellerEntity.getAge())
                .email(sellerEntity.getEmail())
                .build();
    }

    public static List<SellerDTO> from(List<SellerEntity> sellerEntities) {
        List<SellerDTO> result = new ArrayList<>();

        for (SellerEntity sellerEntity : sellerEntities) {
            result.add(SellerDTO.from(sellerEntity));
        }

        return result;
    }

    public static SellerDTOBuilder builder() {
        return new SellerDTOBuilder();
    }

    public static class SellerDTOBuilder {
        private Integer id;
        private @NotEmpty String firstName;
        private @NotEmpty String lastName;
        private @NotNull LocalDate birthDate;
        private int age;
        private @Email @NotEmpty String email;

        SellerDTOBuilder() {
        }

        public SellerDTOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public SellerDTOBuilder firstName(@NotEmpty String firstName) {
            this.firstName = firstName;
            return this;
        }

        public SellerDTOBuilder lastName(@NotEmpty String lastName) {
            this.lastName = lastName;
            return this;
        }

        public SellerDTOBuilder birthDate(@NotNull LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public SellerDTOBuilder age( int age) {
            this.age = age;
            return this;
        }

        public SellerDTOBuilder email(@Email @NotEmpty String email) {
            this.email = email;
            return this;
        }

        public SellerDTO build() {
            return new SellerDTO(this.id, this.firstName, this.lastName, this.birthDate, this.age, this.email);
        }

        public String toString() {
            return "SellerDTO.SellerDTOBuilder(id=" + this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", birthDate=" + this.birthDate + ", age=" + this.age + ", email=" + this.email + ")";
        }

        public SellerDTOBuilder id(Long id) {
            return id(id);
        }
    }
}
