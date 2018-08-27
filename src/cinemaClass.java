import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class cinemaClass
{
	// creation d'une m�thode pour ouvrir la connection
	// cette m�thode retourne une variable de type Connection
	// de la classe Connection
	public static Connection openConnection(Statement st) 
	{
		// d�clarations de variables de connection
		Connection cn = null;
		
		String url  = "jdbc:mysql://localhost/cinema?autoReconnect=true&useSSL=false";
		String user = "root";
		String pwd  = "Dauphyn1";

		// r�cup�ration du driver (chemin du driver de jdbc)
		try
		{
			// lancement du driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(".Driver Ok");
			
			// r�cup�ration de la connection
			// type cast = convertion d'un type vers autre type 
			cn = (Connection) DriverManager.getConnection(url, user, pwd);
		}
		
		// la classe m�re des exceptions est Exception
		//
		// pour g�rer tous les types Exceptions
		// catch (Exception e)
		//
		// ici nous g�rons les exceptions Class 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		// ici nous g�rons les exceptions SQL
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("..Connection Ok");
		
		// retourne la connection
		return cn;
	}
	
	// creation d'une m�thode pour fermer la Connection et le Statement
	public static void closeConnection(Connection cn, Statement st)
	{
		// �v�nement al�atoire
		// donc utilisation d'un try
		// pour la gestion d'erreurs
		try {
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("...D�connection Ok");
	}
	
	// creation d'une m�thode pour ex�cuter la 1�re requ�te SQL
	public static Statement requeteSQL_1(Connection cn)
	{
		Statement st = null;
		
		// cr�ation du statement
		try
		{
			// creation d'un statement
			st = (Statement) cn.createStatement();
			
			// liste de toutes les occurences de la table personne
			String sql = "SELECT titre FROM film";
			
			// la classe ResultSet permet d'ex�cuter une requ�te
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requ�te
			ResultSet result = (ResultSet) st.executeQuery(sql);
			
			String titre;
			
			while(result.next())
			{
				titre = result.getString("titre");
				System.out.println("Le titre du film est : " + titre);
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return st;
	}

	// creation d'une m�thode pour ex�cuter la 2�me requ�te SQL
	public static Statement requeteSQL_2(Connection cn)
	{
		Statement st = null;
		
		// cr�ation du statement
		try
		{
			// creation d'un statement
			st = (Statement) cn.createStatement();
			
			String sql = 	"SELECT * FROM film " +
							"WHERE longueur > 180";
			
			// la classe ResultSet permet d'ex�cuter une requ�te
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requ�te
			ResultSet result = (ResultSet) st.executeQuery(sql);
			
			String titre;
			String genre;
			int longueur;
			
			while(result.next())
			{
				titre = result.getString("titre");
				genre = result.getString("genre");
				longueur = result.getInt("longueur");
				System.out.println("Le film " + titre + " de " + genre + 
									" � une dur�e de " + longueur + " minutes");
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return st;
	}

	// creation d'une m�thode pour ex�cuter la 3�me requ�te SQL
	public static Statement requeteSQL_3(Connection cn)
	{
		Statement st = null;
		
		// cr�ation du statement
		try
		{
			// creation d'un statement
			st = (Statement) cn.createStatement();
			
			// String sql =	"SELECT DISTINCT genre FROM film";
			// ou 
			String sql =	"SELECT genre FROM film " +
							"GROUP BY genre";
			
			// la classe ResultSet permet d'ex�cuter une requ�te
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requ�te
			ResultSet result = (ResultSet) st.executeQuery(sql);
			
			String genre;
			
			while(result.next())
			{
				genre = result.getString("genre");
				System.out.println("Le genre est : " + genre);
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return st;
	}

	// creation d'une m�thode pour ex�cuter la 4�me requ�te SQL
	public static Statement requeteSQL_4(Connection cn)
	{
		Statement st = null;
		
		// cr�ation du statement
		try
		{
			// creation d'un statement
			st = (Statement) cn.createStatement();

			String sql =	"SELECT titre, annee, budget FROM film " +
							"WHERE genre = 'Science-fiction' " +
							"AND budget > 5";
			
			// la classe ResultSet permet d'ex�cuter une requ�te
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requ�te
			ResultSet result = (ResultSet) st.executeQuery(sql);
			
			String titre;
			int annee;
			double budget;
			
			while(result.next())
			{
				titre = result.getString("titre");
				annee = result.getInt("annee");
				budget = result.getDouble("budget");
				System.out.println("Le film " + titre + " de " + annee +
									" au budget de " + budget + " $");
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return st;
	}

	// creation d'une m�thode pour ex�cuter la 5�me requ�te SQL
	public static Statement requeteSQL_5(Connection cn)
	{
		Statement st = null;
		
		// cr�ation du statement
		try
		{
			// creation d'un statement
			st = (Statement) cn.createStatement();
			
			String sql =	"SELECT genre, COUNT(genre) AS count FROM film " +
							"GROUP BY genre";
			
			// la classe ResultSet permet d'ex�cuter une requ�te
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requ�te
			ResultSet result = (ResultSet) st.executeQuery(sql);
			
			String genre;
			int count;
			
			while(result.next())
			{
				genre = result.getString("genre");
				count =	result.getInt("count");
				System.out.println(count + " genre(s) de film " + genre);
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return st;
	}

	// creation d'une m�thode pour ex�cuter la 6�me requ�te SQL
	public static Statement requeteSQL_6(Connection cn)
	{
		Statement st = null;
		
		// cr�ation du statement
		try
		{
			// creation d'un statement
			st = (Statement) cn.createStatement();
			
			String sql =	"SELECT annee, genre, count(genre) as nb FROM film " +
							"WHERE annee = 1960 " +
							"GROUP BY genre";
			
			// la classe ResultSet permet d'ex�cuter une requ�te
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requ�te
			ResultSet result = (ResultSet) st.executeQuery(sql);
			
			int annee;
			String genre;
			int nb;
			
			while(result.next())
			{
				annee = result.getInt("annee");
				genre = result.getString("genre");
				nb =	result.getInt("nb");
				System.out.println(nb + " genre(s) de film " + genre + " de l'ann�e " + annee);
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return st;
	}

	// creation d'une m�thode pour ex�cuter la 7�me requ�te SQL
	public static Statement requeteSQL_7(Connection cn)
	{
		Statement st = null;
		
		// cr�ation du statement
		try
		{
			// creation d'un statement
			st = (Statement) cn.createStatement();
			
			String sql =	"SELECT titre, genre " +
							"FROM film " +
							"WHERE realisateur = 'Roman Polanski'";

			// la classe ResultSet permet d'ex�cuter une requ�te
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requ�te
			ResultSet result = (ResultSet) st.executeQuery(sql);
			
			String titre;
			String genre;
			
			while(result.next())
			{
				titre = result.getString("titre");
				genre = result.getString("genre");
				System.out.println("film de Roman Polanski " + titre + ", " + genre);
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return st;
	}
	
	// creation d'une m�thode pour ex�cuter la 8�me requ�te SQL
	public static Statement requeteSQL_8(Connection cn)
	{
		Statement st = null;
		
		// cr�ation du statement
		try
		{
			// creation d'un statement
			st = (Statement) cn.createStatement();
			
			String sql =	"SELECT f.realisateur, f.titre, f.genre, p.nom, p.prenom " +
							"FROM film f " +
							"INNER JOIN distribution d ON d.numf = f.numf " +
							"INNER JOIN acteur a ON a.numa =d.numa " +
							"INNER JOIN personne p ON p.nump = a.nump " +
							"WHERE f.realisateur = 'Steven Spielberg'";
			
			// la classe ResultSet permet d'ex�cuter une requ�te
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requ�te
			ResultSet result = (ResultSet) st.executeQuery(sql);
			
			String realisateur;
			String titre;
			String genre;
			String nom;
			String prenom;
			
			while(result.next())
			{
				realisateur = result.getString("realisateur");
				titre = result.getString("titre");
				genre = result.getString("genre");
				nom = result.getString("nom");
				prenom = result.getString("prenom");
				System.out.println(prenom + "-" + nom + 
									" � jou� dans le film " + genre + ", " + titre + 
									" du r�alisateur " + realisateur);
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return st;
	}

	public static void main(String[] args)
	{
		Connection cn = null;
		Statement st = null;
		
		// appelle de la m�thode de connection
		cn = openConnection(st);
		System.out.println("");
		
		// cr�ation et ex�cution de la 1�re requete SQL
		st = requeteSQL_1(cn);
		System.out.println();
		
		// cr�ation et ex�cution de la 2�me requete SQL
		st = requeteSQL_2(cn);
		System.out.println("");
		
		// cr�ation et ex�cution de la 3�me requete SQL
		st = requeteSQL_3(cn);
		System.out.println("");
		
		// cr�ation et ex�cution de la 4�me requete SQL
		st = requeteSQL_4(cn);
		System.out.println("");
		
		// cr�ation et ex�cution de la 5�me requete SQL
		st = requeteSQL_5(cn);
		System.out.println("");
		
		// cr�ation et ex�cution de la 6�me requete SQL
		st = requeteSQL_6(cn);
		System.out.println("");

		// cr�ation et ex�cution de la 7�me requete SQL
		st = requeteSQL_7(cn);
		System.out.println("");
		
		// cr�ation et ex�cution de la 8�me requete SQL
		st = requeteSQL_8(cn);
		System.out.println("");
		
		// appelle de la m�thode de fermeture
		closeConnection(cn, st);
	}
}