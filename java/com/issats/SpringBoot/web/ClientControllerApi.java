package com.issats.SpringBoot.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.issats.SpringBoot.dao.ClientRepository;
import com.issats.SpringBoot.entities.Client;

@RestController
@RequestMapping(path = "/api")
public class ClientControllerApi {

	@Autowired
	ClientRepository clientRepository;

	@GetMapping("/clients")
	public List<Client> getAllClient() {
		return clientRepository.findAll();
	}

	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getClient(@PathVariable(name = "id") Long idClient) {
		Optional<Client> optionalClient = clientRepository.findById(idClient);

		if (optionalClient.isPresent()) {
			Client client = optionalClient.get();
			return new ResponseEntity<Client>(client, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/clients")
	public Client addClient(@RequestBody Client client) {
		clientRepository.save(client);
		return client;
	}

	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable(name = "id") Long id, @RequestBody Client clientData) {
		Optional<Client> optionalClient = clientRepository.findById(id);

		if (!optionalClient.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Client client = optionalClient.get();

		client.setEmail(clientData.getEmail());
		client.setNom(clientData.getNom());

		clientRepository.save(client);

		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	@DeleteMapping("/clients/{id}")
	public ResponseEntity<Object> deleteClient(@PathVariable(name = "id") Long id) {

		Optional<Client> optionalClient = clientRepository.findById(id);

		if (!optionalClient.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Client client = optionalClient.get();

		clientRepository.delete(client);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
