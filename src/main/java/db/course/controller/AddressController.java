package db.course.controller;

import db.course.domain.Address;
import db.course.repos.AddressRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("address")
public class AddressController {
    private final AddressRepo addressRepo;

    @Autowired
    public AddressController(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @GetMapping
    public List<Address> list() {
        return addressRepo.findAll();
    }

    @GetMapping("{address_id}")
    public Address getOne(@PathVariable("address_id") Address address) {
        return address;
    }

    @PostMapping
    public Address create(@RequestBody Address address){
        return addressRepo.save(address);
    }


    @PutMapping("{address_id}")
    public Address update(@PathVariable("address_id") Address addressFromDb,
                        @RequestBody Address address) {
        BeanUtils.copyProperties(address, addressFromDb, "address_id");
        return addressRepo.save(addressFromDb);
    }

    @DeleteMapping("{address_id}")
    public void delete(@PathVariable("address_id") Address address) {
        addressRepo.delete(address);
    }
}
