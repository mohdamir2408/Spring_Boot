package com.java.mappingonetone.controller;

import com.java.mappingonetone.dao.AddressRepository;
import com.java.mappingonetone.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/getAddress")
    public List<Address> getEmployees(){
        return addressRepository.findAll();
    }
}
