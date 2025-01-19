package com.swetha.springboot_cicd.repositories;

import com.swetha.springboot_cicd.modals.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepository extends MongoRepository<Inventory,String> {

}
