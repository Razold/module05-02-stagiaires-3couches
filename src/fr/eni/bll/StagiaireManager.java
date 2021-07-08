package fr.eni.bll;

import java.util.List;

import fr.eni.bo.Stagiaire;
import fr.eni.dal.DaoFactory;
import fr.eni.dal.StagiaireDao;

public class StagiaireManager {

	private StagiaireDao sDao;
	
	public StagiaireManager() {
		sDao = DaoFactory.getStagiaireDao();
	}
	
	
	public List<Stagiaire> trouverTous(){
		return sDao.findAll();
	}

	
	public Stagiaire rechercheParCle(int cle){
		Stagiaire s = sDao.findById(cle);
		return s;
	}
	
	public void ajouter(Stagiaire s) throws BllException {
		if(s == null)
			throw new BllException("Attention le stagiaire doit exister pour enreg");
		if (s.getNom() == null || s.getNom().trim().length() == 0)
			throw new BllException("Attention le nom du stagiaire doit exister pour enreg");
		
		
		sDao.insert(s);
		
		
	}	
	public void modifier(Stagiaire s) throws BllException {
		if(s == null)
			throw new BllException("Attention le stagiaire doit exister pour modif");
		if (s.getNom() == null || s.getNom().trim().length() == 0)
			throw new BllException("Attention le nom du stagiaire doit exister pour modif");
		
		
		sDao.update(s);
	
	}
	
	public void supprimer(int cle) throws BllException {
		if (cle <= 0 )
			throw new BllException("Attention la clé doit etre un entier positif pour suppression");
		
		sDao.delete(cle);
	}
}
