package ro.ubb.movieRent.core.domain;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Movie extends BaseEntity<Long> {
    private String name;
    private int year, price;
}
