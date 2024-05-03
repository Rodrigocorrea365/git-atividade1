
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {

    conectaDAO cone = new conectaDAO();
    //private conexao conexao;
    private Connection conn;

    public ProdutosDAO() {
        this.cone = new conectaDAO();
        this.conn = this.cone.connectDB();
    }
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto(ProdutosDTO produto) {
        String sql = "INSERT INTO produtos(nome,valor) VALUES " + "(?, ?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getValor());
            stmt.execute();
            

        } catch (Exception e) {
            System.out.println("Erro ao inserir empresa: " + e.getMessage());
        }
    }


    /*Connection conn;
    //PreparedStatement prep;
    ResultSet resultset;
    PreparedStatement entrada;
    

    public int cadastrarProduto(ProdutosDTO produto) {

        conn = new conectaDAO().connectDB();
        int status;
        try {
            entrada = conn.prepareStatement("INSERT INTO produtos(nome,valor) VALUES (?,?)");
            entrada.setString(1, produto.getNome());
            entrada.setInt(2, produto.getValor());
           // entrada.setString(3, produto.getStatus());

            status = entrada.executeUpdate();
            return status;
        } catch (SQLException e) {
            System.out.println("erro" + e.getMessage());
            return e.getErrorCode();
        }
    }
     */
    public ArrayList<ProdutosDTO> listarProdutos() {

        return listagem;
    }

}
