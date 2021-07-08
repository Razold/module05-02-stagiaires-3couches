package fr.eni.dal;

import java.util.List;

import fr.eni.bo.Stagiaire;

public interface StagiaireDao {

	List<Stagiaire> findAll();

	Stagiaire findById(int id);

	void insert(Stagiaire s);

	void update(Stagiaire s);

	void delete(int id);

}