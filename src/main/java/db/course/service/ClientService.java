package db.course.service;

import db.course.domain.Client;
import db.course.form.ClientForm;
import db.course.repos.ClientRepo;
import db.course.repos.HumanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    HumanRepo humanRepo;

    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    public ResponseEntity<?> add(ClientForm form) {
        Client client = new Client();
        return setClientParameters(client, form);
    }

    public ResponseEntity<?> update(Long id, ClientForm form) {
        Client c = clientRepo.findClientById(id);
        return setClientParameters(c, form);
    }

    public void delete(Client client) {
        clientRepo.delete(client);
    }

    public ResponseEntity<?> setClientParameters(Client client, ClientForm form) {
            client.setCash(form.getCash());
            client.setPolice(form.isPolice());
            client.setHuman(humanRepo.findHumanById(form.getHuman_id()));
            return new ResponseEntity<>(clientRepo.save(client), HttpStatus.OK);
    }
}
