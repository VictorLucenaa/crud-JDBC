package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
    private static final String url = "jdbc:postgresql://localhost:5432/jdbc";
    private static final  String user = "postgres";
    private static final String password = "admin";

    public static Connection getConnection() throws Exception{
        Connection connect = null;

         try {
             connect = DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            System.out.println("Erro na conexão com o banco de dados: " + e.getMessage());
        }
    return connect;
    }
}


