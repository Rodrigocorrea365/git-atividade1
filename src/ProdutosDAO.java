
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    conectaDAO cone = new conectaDAO();
    //private conexao conexao;
    private Connection conn;
    ResultSet resultado;

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
            System.out.println("erro");
        }
    }

    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/leiloes", "root", "Realmadrid45,");
            return true;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("erro de conexao" + e.getMessage());
            return false;
        }
    }

    public List<ProdutosDTO> getpro() {
         ProdutosDTO DTt = new ProdutosDTO();
        List<ProdutosDTO> listapro = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        if (conn != null) {
            try {

                PreparedStatement entrada = this.conn.prepareStatement(sql);
                resultado = entrada.executeQuery();

                // Itera sobre os resultados e adiciona à lista de filmes
                while (resultado.next()) {
                    ProdutosDTO DT = new ProdutosDTO();
                    DT.setNome(resultado.getString("nome"));
                    DT.setValor(resultado.getInt("valor"));
                    DT.setStatus(resultado.getString("status"));
                    listapro.add(DT);

                }
                return listapro;

            } catch (SQLException e) {
                System.out.println("Erro na lista: " + e.getMessage());
            }

        } else {
            System.out.println("A conexão com o banco de dados não foi inicializada.");
        }

        return listapro;
    }

    public ArrayList<ProdutosDTO> listarProdutos() {

        return listagem;

    }

}
