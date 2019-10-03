package com.issats.SpringBoot.metier;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.issats.SpringBoot.dao.CompteRepository;
import com.issats.SpringBoot.dao.OperationRepository;
import com.issats.SpringBoot.entities.Compte;
import com.issats.SpringBoot.entities.CompteCourant;
import com.issats.SpringBoot.entities.Operation;
import com.issats.SpringBoot.entities.Retrait;
import com.issats.SpringBoot.entities.Versement;

//pour specifier que c'est un service
@Service
// gestion des transaction
@Transactional
public class BanqueMetierImpl implements IBanqueMetier {
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private OperationRepository operationRepository;

	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte cp = compteRepository.getOne(codeCpte);
		if (cp == null)
			throw new RuntimeException("compte introuvable");

		return cp;
	}

	@Override
	public void verser(String codecpte, double montant) {
		Compte cp = consulterCompte(codecpte);
		Versement v = new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde() + montant);
		compteRepository.save(cp);

	}

	@Override
	public void retirer(String codecpte, double montant) {
		Compte cp = consulterCompte(codecpte);
		double facilitesCaisse = 0;
		if (cp instanceof CompteCourant)
			facilitesCaisse = ((CompteCourant) cp).getDecouvert();
		if (cp.getSolde() + facilitesCaisse < montant)
			throw new RuntimeException("solde insuffisant");
		Retrait r = new Retrait(new Date(), montant, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde() - montant);
		compteRepository.save(cp);
	}

	@Override
	public void virement(String codecpte1, String codecpte2, double montant) {
		if (codecpte1.equals(codecpte2))
			throw new RuntimeException("Virement sur le meme compte impossible ");
		retirer(codecpte1, montant);
		verser(codecpte2, montant);

	}

	@Override
	public Page<Operation> listeOperation(String codecpte, int page, int size) {
		return /* null;// */operationRepository.listeOperation(codecpte, new PageRequest(page, size));
	}

}
