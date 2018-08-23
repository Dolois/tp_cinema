import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class cinemaClass
{
	// bonne pratique
	// creation d'une m�thode pour ouvrir la connection
	// cette m�thode retourne une variable de type Connection
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
		System.out.println("");
		
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
		System.out.println("");
		System.out.println("...D�connection Ok");
	}
	
	// creation d'une m�thode pour ex�cuter une requ�te sql
	public static Statement selectAll(Connection cn)
	{
		Statement st = null;
		
		// cr�ation du statement
		try
		{
			// creation d'un statement
			st = (Statement) cn.createStatement();
			
			// liste de toutes les occurences de la table personne
			String sql = "SELECT * FROM personne";
			
			// la classe ResultSet permet d'ex�cuter une requ�te
			// creation d'une instance result de la classe ResultSet
			// pour stocker le resultat de la requ�te
			ResultSet result = (ResultSet) st.executeQuery(sql);
			
			String prenom;
			
			while(result.next())
			{
				prenom = result.getString("prenom");
				System.out.println("La personne est : " + prenom);
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
		
		st = selectAll(cn);
		
		// appelle de la m�thode de fermeture
		closeConnection(cn, st);
	}
}