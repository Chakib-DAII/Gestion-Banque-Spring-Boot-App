package com.issats.SpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issats.SpringBoot.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
