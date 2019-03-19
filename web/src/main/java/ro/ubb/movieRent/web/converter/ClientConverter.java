package ro.ubb.movieRent.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.movieRent.core.domain.Client;
import ro.ubb.movieRent.web.dto.ClientDto;

@Component
public class ClientConverter extends BaseConverter<Client, ClientDto> {

    @Override
    public Client convertDtoToModel(ClientDto dto) {
        Client client = new Client(dto.getName(),dto.getCnp());
        client.setId(dto.getId());
        return client;
    }

    @Override
    public ClientDto convertModelToDto(Client client) {
        ClientDto dto = new ClientDto(client.getName(), client.getCnp());
        dto.setId(client.getId());
        return dto;
    }
}