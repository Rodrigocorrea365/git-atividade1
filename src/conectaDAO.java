
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {
Connection conn;
    public Connection connectDB() {

        try {

             conn = DriverManager.getConnection("jdbc:mysql://localhost/leiloes", // linha de conexao
                    "root", // usuario do mysql
                    "Realmadrid45,");// senha do mysql
            System.out.println("conexao bem sucedida");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return conn;
    }

}
