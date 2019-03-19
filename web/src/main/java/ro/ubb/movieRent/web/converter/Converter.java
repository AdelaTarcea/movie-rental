package ro.ubb.movieRent.web.converter;

import ro.ubb.movieRent.core.domain.BaseEntity;
import ro.ubb.movieRent.web.dto.BaseDto;

public interface Converter<Model extends BaseEntity<Long>, Dto extends BaseDto> {

    Model convertDtoToModel(Dto dto);

    Dto convertModelToDto(Model model);

}
