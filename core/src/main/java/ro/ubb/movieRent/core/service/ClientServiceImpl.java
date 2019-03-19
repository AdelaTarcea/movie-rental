package ro.ubb.movieRent.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.movieRent.core.domain.Client;
import ro.ubb.movieRent.core.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private static final Logger log =
            LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public List<Client> getAllClients() {
        log.trace("getAllClients --- method entered");

        List<Client> result = clientRepository.findAll();

        log.trace("getAllClients: result={}", result);

        return result;
    }

    @Override

    public Client saveClient(Client client) {
        log.trace("saveClient: client={}", client);
        Client result = clientRepository.save(client);
        log.trace("saveClient: result={}", result);
        return result;
    }

    @Override
    @Transactional
    public Client updateClient(Long id,String name,Integer cnp) {
        log.trace("updateClient: name={}, cnp={}",
                name,cnp);

        Optional<Client> client = clientRepository.findById(id);

        client.ifPresent(c -> {
            c.setName(name);
            c.setCnp(cnp);
        });

        log.trace("updateClient: client={}", client.get());

        return client.orElse(null);
    }

    @Override
    public void deleteById(Long clientId) {
        log.trace("deleteById: clientId={}", clientId);

        clientRepository.deleteById(clientId);

        log.trace("deleteById --- method finished");
    }
}

