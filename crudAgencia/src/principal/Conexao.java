package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String URL = "jdbc:mysql://localhost:3307/agenciaTuristicaNoturna";

	private static final String USUARIO = "root";

	private static final String SENHA = "root";

	public static Connection conectar() throws SQLException {
		return DriverManager.getConnection(URL, USUARIO, SENHA);
	}

}