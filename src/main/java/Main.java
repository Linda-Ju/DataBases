import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Connection to database");
        Connection connection = dbConn();

        System.out.println("Database is connected successfully");
    }

    public static Connection dbConn(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Wsxcftfcxsw!2233");
        }catch(SQLException e){
//            System.out.println("Unable to connect to database");
            e.printStackTrace();
        }
        return connection;
    }
}
