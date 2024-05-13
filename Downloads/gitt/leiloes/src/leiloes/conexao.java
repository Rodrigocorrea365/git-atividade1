/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leiloes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class conexao {
    

    public Connection getConexao() {

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/leiloes", // linha de conexao
                    "root", // usuario do mysql
                    "Realmadrid45,"// senha do mysql
            );
            System.out.println("conexao concluida");
            return conn;

        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }

    }

}
/*
public void venderProduto(int id) {

        try {
            ProdutosDTO DTt = new ProdutosDTO();
            String sql = "update produtos set Status =? where id =?";
            PreparedStatement entrada = this.conn.prepareStatement(sql);
            entrada.setString(1, "VENDIDO");
            entrada.setInt(2, id);
            int itensvendidos = entrada.executeUpdate();
            if (itensvendidos == 0) {
                throw new SQLException("Não há produtos vendidos.");
            }

        } catch (Exception w) {
            System.out.println("erro" + w.getMessage());
        }

    }
// lista de produtos vendidos
    public void listaproduto(String categoria) {
        List<ProdutosDTO> listapro = new ArrayList<>();
        String sql = "SELECT r FROM produto r WHERE (r.status LIKE : vendido)";
        if (conn != null) {
            try {
                PreparedStatement entrada = this.conn.prepareStatement(sql);
                resultado = entrada.executeQuery();
                while (resultado.next()) {
                    ProdutosDTO produto = new ProdutosDTO();
                    produto.setId(resultado.getInt("id"));
                    produto.setNome(resultado.getString("nome"));
                    listapro.add(produto);
                }
                resultado.close();
                entrada.close();
                conn.close();

            } catch (Exception e) {
                System.out.println("erro" + e.getMessage());

            }

        }
*/