package fr.eni.ihm;

import java.util.List;

import fr.eni.bll.BllException;
import fr.eni.bll.StagiaireManager;
import fr.eni.bo.Stagiaire;
import fr.eni.dal.DaoFactory;
import fr.eni.dal.StagiaireDao;

public class ProgPrinc {

	public static void main(String[] args) {
		System.out.println("Bienvenue");
//		StagiaireDao sDao = DaoFactory.getStagiaireDao();
		
		StagiaireManager sm = new StagiaireManager();
		
		System.out.println("Liste initiale : ");
		
		List<Stagiaire> listeS = sm.trouverTous();
		for (Stagiaire s : listeS) {
			System.out.println("   - " + s);
		}
		
		Stagiaire s1 = new Stagiaire("Lebleu", "Joe", null, "joelebleu");
		try {
			sm.ajouter(s1);
		} catch (BllException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Liste apres ajout : ");
		
		listeS = sm.trouverTous();
		for (Stagiaire s : listeS) {
			System.out.println("   - " + s);
		}

	}
}
