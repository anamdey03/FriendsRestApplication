package com.pluralsight.friends.service;

import org.springframework.data.repository.CrudRepository;

import com.pluralsight.friends.model.Address;

public interface AddressService extends CrudRepository<Address, Integer>{

}
