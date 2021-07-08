package fr.eni.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.bo.Stagiaire;
import fr.eni.dal.StagiaireDao;

public class StagiaireDaoJdbcImpl implements StagiaireDao {


	final String FINDALL = "SELECT noStagiaire, nom, prenom, dateDeNaissance, motDePasse FROM Stagiaires";
	final String INSERT = "INSERT INTO Stagiaires (nom, prenom, dateDeNaissance, motDePasse) VALUES (?,?,?,?)";

	
	@Override
	public List<Stagiaire> findAll() {
		List<Stagiaire> listeS = new ArrayList<Stagiaire>();

		try(
				Connection cnx = JdbcTools.getConnection();
				Statement stt = cnx.createStatement();
			){
			
			ResultSet rs = stt.executeQuery(FINDALL);
			while(rs.next()) {
				int id = rs.getInt("noStagiaire");
				String n = rs.getString(2);
				String p = rs.getString("prenom");
				Date ddn = rs.getDate(4);
				String pass = rs.getString(5);
				
				Stagiaire s = new Stagiaire(id, n, p, ddn, pass);
				listeS.add(s);
			}
			rs.close();
		}catch (SQLException e) {
			System.out.println("Attention, la connexion n'a pas eu lieu");
			e.printStackTrace();
		}
		
		return listeS;
	}
	
	@Override
	public Stagiaire findById(int id) {
		return null;
	}

	@Override
	public void insert(Stagiaire s) {
		try(
				Connection cnx = JdbcTools.getConnection();
				PreparedStatement pstt = cnx.prepareStatement(INSERT);
			){
				
				pstt.setString(1, s.getNom());
				pstt.setString(2, s.getPrenom());
				if (s.getDateDeNaissance() != null) {
					pstt.setDate(3, new java.sql.Date(s.getDateDeNaissance().getTime()));
				}
				else {
					pstt.setNull(3, Types.DATE);
					// ou bien
					// pstt.setDate(3, null);
				}
				pstt.setString(4, s.getMotDepasse());

				pstt.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("Attention, la connexion n'a pas eu lieu");
				e.printStackTrace();
			}

	}

	@Override
	public void update(Stagiaire s) {
		
	}
	
	@Override
	public void delete(int id) {
		
	}
}
