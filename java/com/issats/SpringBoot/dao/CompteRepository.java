package com.issats.SpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issats.SpringBoot.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>{

}
