package com.issats.SpringBoot;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.issats.SpringBoot.dao.ClientRepository;
import com.issats.SpringBoot.dao.CompteRepository;
import com.issats.SpringBoot.dao.OperationRepository;
import com.issats.SpringBoot.entities.Client;
import com.issats.SpringBoot.entities.Compte;
import com.issats.SpringBoot.entities.CompteCourant;
import com.issats.SpringBoot.entities.CompteEpargne;
import com.issats.SpringBoot.entities.Retrait;
import com.issats.SpringBoot.entities.Versement;
import com.issats.SpringBoot.metier.IBanqueMetier;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CompteRepository compteRepository;

	@Autowired
	private OperationRepository operationRepository;

	@Autowired
	private IBanqueMetier banqueMetier;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		/*Client c1 = clientRepository.save(new Client("User 1","User1@gmail.com"));
		Client c2 = clientRepository.save(new Client("User 2","User2@gmail.com"));
		Compte cp1 = compteRepository.save(new CompteCourant("c1",new Date(),9000,c1,6000));
		Compte cp2 = compteRepository.save(new CompteEpargne("c2",new Date(),6000,c2,5.5));
		
		operationRepository.save(new Versement(new Date(),9000,cp1));
		operationRepository.save(new Versement(new Date(),6000,cp1));
		operationRepository.save(new Retrait(new Date(),2000,cp1));
		operationRepository.save(new Versement(new Date(),500,cp1));
		
		operationRepository.save(new Versement(new Date(),1900,cp2));
		operationRepository.save(new Versement(new Date(),2900,cp2));
		operationRepository.save(new Versement(new Date(),2000,cp2));
		operationRepository.save(new Retrait(new Date(),500,cp1));
		
		banqueMetier.verser("c1", 123456);*/
	}
}
