package ro.ubb.movieRent.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.movieRent.core.domain.Client;
import ro.ubb.movieRent.core.service.ClientService;
import ro.ubb.movieRent.web.converter.ClientConverter;
import ro.ubb.movieRent.web.dto.ClientDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    private static final Logger log =
            LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientConverter clientConverter;


    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    List<ClientDto> getClients() {
        log.trace("getClients --- method entered");

        List<Client> clients = clientService.getAllClients();
        log.trace("getClients: clients={}", clients);

        return new ArrayList<>(clientConverter.convertModelsToDtos(clients));

    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    ClientDto saveClient(@RequestBody final ClientDto dto) {
        log.trace("saveClient: dto={}", dto);

        Client client = clientService.saveClient(clientConverter.convertDtoToModel(dto));
        ClientDto result = clientConverter.convertModelToDto(client);

        log.trace("saveClient: result={}", result);

        return result;
    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.PUT)
    ClientDto updateClient(@PathVariable Long clientId,
                         @RequestBody ClientDto dto) {
        log.trace("updateClient: clientId={}, clientDtoMap={}", clientId,
                dto);

        Client client = clientService.updateClient(clientId,
                dto.getName(),
                dto.getCnp());

        ClientDto result = clientConverter.convertModelToDto(client);

        log.trace("updateClient: result={}", result);

        return result;
    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteClient(@PathVariable Long clientId) {
        log.trace("deleteClient: clientId={}", clientId);

        clientService.deleteById(clientId);

        log.trace("deleteClient --- method finished");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

