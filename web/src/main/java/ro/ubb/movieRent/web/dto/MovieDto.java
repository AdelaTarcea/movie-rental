package ro.ubb.movieRent.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class MovieDto extends BaseDto {
    private String name;
    private int year, price;
}