package db.course.service;

import db.course.domain.Client;
import db.course.dto.ClientDTO;
import db.course.form.ClientForm;
import db.course.repos.ClientRepo;
import db.course.repos.HumanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepo clientRepo;
    @Autowired
    HumanRepo humanRepo;

    public ResponseEntity<?> findAll() {
        return getJSON();
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
    private ResponseEntity<?> getJSON(){
        ArrayList<ClientDTO> clients = new ArrayList<>();
        clientRepo.findAll().forEach(c -> {
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setId(c.getId());
            clientDTO.setMoney(c.getCash());
            clientDTO.setPolice(c.isPolice());
            clientDTO.setName(c);
            clients.add(clientDTO);
        });
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}
