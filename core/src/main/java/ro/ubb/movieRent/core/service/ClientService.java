package ro.ubb.movieRent.core.service;

import ro.ubb.movieRent.core.domain.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    Client saveClient(Client client);

    Client updateClient(Long id,String name,Integer cnp);

    void deleteById(Long clientId);
}

