package ro.itschool.auction2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

    @Entity
    @Table(name="roles")
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class RoleEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Enumerated(EnumType.STRING)
        private RoleEnum name;
}
