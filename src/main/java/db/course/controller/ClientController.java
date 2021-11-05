package db.course.controller;

import db.course.domain.Client;
import db.course.domain.ClientForm;
import db.course.repos.ClientRepo;
import db.course.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    private final ClientRepo clientRepo;
    @Autowired
    private HumanService humanService;

    public ClientController(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @GetMapping
    public List<Client> list() {
        return clientRepo.findAll();
    }

    @GetMapping("{client_id}")
    public Client getOne(@PathVariable("client_id") Client client) {
        return client;
    }

    @PostMapping
    public Client create(@RequestBody ClientForm form) {
        Client client = new Client();
        client.setCash(form.getCash());
        client.setPolice(form.isPolice());
        client.setHuman(humanService.findByHuman_id(form.getHuman_id()));
        return clientRepo.save(client);
    }

    @PutMapping("{client_id}")
    public Client update(@PathVariable("client_id") Long id,
                         @RequestBody ClientForm form) {
        Client c = clientRepo.findClientById(id);
        c.setPolice(form.isPolice());
        c.setCash(form.getCash());
        c.setHuman(humanService.findByHuman_id(form.getHuman_id()));
        return clientRepo.save(c);
    }

    @DeleteMapping("{address_id}")
    public void delete(@PathVariable("address_id") Client address) {
        clientRepo.delete(address);
    }
}
