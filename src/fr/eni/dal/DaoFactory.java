package fr.eni.dal;

import fr.eni.dal.jdbc.StagiaireDaoJdbcImpl;

public class DaoFactory {

	public static StagiaireDao getStagiaireDao() {

		StagiaireDao sDao = new StagiaireDaoJdbcImpl();
		return sDao;
	}
}
