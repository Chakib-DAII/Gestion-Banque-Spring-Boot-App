package com.issats.SpringBoot.metier;

import org.springframework.data.domain.Page;

import com.issats.SpringBoot.entities.Compte;
import com.issats.SpringBoot.entities.Operation;

public interface IBanqueMetier {
	public Compte consulterCompte(String codeCpte);
	public void verser(String codecpte,double montant);
	public void retirer(String codecpte,double montant);
	public void virement(String codecpte1, String codecpte2,double montant);
	public Page<Operation> listeOperation(String codecpte,int page,int size);
}
