package db.course.controller;

import db.course.domain.Client;
import db.course.form.ClientForm;
import db.course.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return clientService.findAll();
    }

    @GetMapping("{client_id}")
    public Client getOne(@PathVariable("client_id") Client client) {
        return client;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClientForm form) {
        return clientService.add(form);
    }

    @PutMapping("{client_id}")
    public ResponseEntity<?> update(@PathVariable("client_id") Long id,
                         @RequestBody ClientForm form) {
        return clientService.update(id, form);
    }

    @DeleteMapping("{client_id}")
    public void delete(@PathVariable("client_id") Client client) {
        clientService.delete(client);
    }
}
