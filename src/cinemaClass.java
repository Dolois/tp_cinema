import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class cinemaClass
{
	// creation d'une méthode pour ouvrir la connection
	// cette méthode retourne une variable de type Connection
	// de la classe Connection
	public static Connection openConnection(Statement st) 
	{
		// déclarations de variables de connection
		Connection cn = null;
		
		String url  = "jdbc:mysql://localhost/cinema?autoReconnect=true&useSSL=false";
		String user = "root";
		String pwd  = "Dauphyn1";

		// récupération du driver (chemin du driver de jdbc)
		try
		{
			// lancement du driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(".Driver Ok");
			
			// récupération de la connection
			// type cast = convertion d'un type vers autre type 
			cn = (Connection) DriverManager.getConnection(url, user, pwd);
		}
		
		// la classe mère des exceptions est Exception
		//
		// pour gérer tous les types Exceptions
		// catch (Exception e)
		//
		// ici nous gérons les exceptions Class 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		// ici nous gérons les exceptions SQL
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("..Connection Ok");
		
		// retourne la connection
		return cn;
	}
	
	// creation d'une méthode pour fermer la Connection et le Statement
	public static void closeConnection(Connection cn, Statement st)
	{
		// évènement aléatoire
		// donc utilisation d'un try
		// pour la gestion d'erreurs
		try {
			cn.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("...Déconnection Ok");
	}
	
	// creation d'une méthode pour exécuter la 1ère requête SQL
	public static Statement requeteSQL_1(Connection cn)
	{
		Statement st = null;
		
		// création du statement
		try
		{
			// creation d'un statement
			st = (Statement) cn.createStatement();
			
			// liste de toutes les occurences de la table personne
			String sql = "SELECT titre FROM film";
			
			// la classe ResultSet permet d'exécuter une requête
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requête
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

	// creation d'une méthode pour exécuter la 2ème requête SQL
	public static Statement requeteSQL_2(Connection cn)
	{
		Statement st = null;
		
		// création du statement
		try
		{
			// creation d'un statement
			st = (Statement) cn.createStatement();
			
			String sql = 	"SELECT * FROM film " +
							"WHERE longueur > 180";
			
			// la classe ResultSet permet d'exécuter une requête
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requête
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
									" à une durée de " + longueur + " minutes");
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return st;
	}

	// creation d'une méthode pour exécuter la 3ème requête SQL
	public static Statement requeteSQL_3(Connection cn)
	{
		Statement st = null;
		
		// création du statement
		try
		{
			// creation d'un statement
			st = (Statement) cn.createStatement();
			
			// String sql =	"SELECT DISTINCT genre FROM film";
			// ou 
			String sql =	"SELECT genre FROM film " +
							"GROUP BY genre";
			
			// la classe ResultSet permet d'exécuter une requête
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requête
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

	// creation d'une méthode pour exécuter la 4ème requête SQL
	public static Statement requeteSQL_4(Connection cn)
	{
		Statement st = null;
		
		// création du statement
		try
		{
			// creation d'un statement
			st = (Statement) cn.createStatement();

			String sql =	"SELECT titre, annee, budget FROM film " +
							"WHERE genre = 'Science-fiction' " +
							"AND budget > 5";
			
			// la classe ResultSet permet d'exécuter une requête
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requête
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

	// creation d'une méthode pour exécuter la 5ème requête SQL
	public static Statement requeteSQL_5(Connection cn)
	{
		Statement st = null;
		
		// création du statement
		try
		{
			// creation d'un statement
			st = (Statement) cn.createStatement();
			
			String sql =	"SELECT genre, COUNT(genre) AS count FROM film " +
							"GROUP BY genre";
			
			// la classe ResultSet permet d'exécuter une requête
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requête
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

	// creation d'une méthode pour exécuter la 6ème requête SQL
	public static Statement requeteSQL_6(Connection cn)
	{
		Statement st = null;
		
		// création du statement
		try
		{
			// creation d'un statement
			st = (Statement) cn.createStatement();
			
			String sql =	"SELECT annee, genre, count(genre) as nb FROM film " +
							"WHERE annee = 1960 " +
							"GROUP BY genre";
			
			// la classe ResultSet permet d'exécuter une requête
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requête
			ResultSet result = (ResultSet) st.executeQuery(sql);
			
			int annee;
			String genre;
			int nb;
			
			while(result.next())
			{
				annee = result.getInt("annee");
				genre = result.getString("genre");
				nb =	result.getInt("nb");
				System.out.println(nb + " genre(s) de film " + genre + " de l'année " + annee);
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return st;
	}

	// creation d'une méthode pour exécuter la 7ème requête SQL
	public static Statement requeteSQL_7(Connection cn)
	{
		Statement st = null;
		
		// création du statement
		try
		{
			// creation d'un statement
			st = (Statement) cn.createStatement();
			
			String sql =	"SELECT titre, genre " +
							"FROM film " +
							"WHERE realisateur = 'Roman Polanski'";

			// la classe ResultSet permet d'exécuter une requête
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requête
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
	
	// creation d'une méthode pour exécuter la 8ème requête SQL
	public static Statement requeteSQL_8(Connection cn)
	{
		Statement st = null;
		
		// création du statement
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
			
			// la classe ResultSet permet d'exécuter une requête
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requête
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
									" à joué dans le film " + genre + ", " + titre + 
									" du réalisateur " + realisateur);
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
		
		// appelle de la méthode de connection
		cn = openConnection(st);
		System.out.println("");
		
		// création et exécution de la 1ère requete SQL
		st = requeteSQL_1(cn);
		System.out.println();
		
		// création et exécution de la 2ème requete SQL
		st = requeteSQL_2(cn);
		System.out.println("");
		
		// création et exécution de la 3ème requete SQL
		st = requeteSQL_3(cn);
		System.out.println("");
		
		// création et exécution de la 4ème requete SQL
		st = requeteSQL_4(cn);
		System.out.println("");
		
		// création et exécution de la 5ème requete SQL
		st = requeteSQL_5(cn);
		System.out.println("");
		
		// création et exécution de la 6ème requete SQL
		st = requeteSQL_6(cn);
		System.out.println("");

		// création et exécution de la 7ème requete SQL
		st = requeteSQL_7(cn);
		System.out.println("");
		
		// création et exécution de la 8ème requete SQL
		st = requeteSQL_8(cn);
		System.out.println("");
		
		// appelle de la méthode de fermeture
		closeConnection(cn, st);
	}
}