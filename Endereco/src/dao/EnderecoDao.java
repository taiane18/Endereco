/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Endereco;
/**
 *
 * @author Administrador
 */
public class EnderecoDao {
    
    public static boolean inserir(Endereco objeto) {
        String sql = "INSERT INTO endereco (logradouro, complemento, bairro) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getLogradouro());
            ps.setString(2, objeto.getComplemento());
            ps.setString(3, objeto.getBairro());
            ps.setInt(3, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    

    public static void main(String[] args) {
        Endereco objeto = new Endereco();
        objeto.setLogradouro("Rua Osvaldo Cruz");
        objeto.setComplemento("A123");
        objeto.setBairro("Madalena");
        objeto.getCodigo("123");
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
    public static boolean alterar(Endereco objeto) {
        String sql = "UPDATE endereco SET logradouro = ?, complemento = ?, bairro = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getLogradouro()); 
            ps.setString(2, objeto.getComplemento());
            ps.setString(3, objeto.getBairro());
            ps.setInt(4, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    
    public static boolean excluir(Endereco objeto) {
        String sql = "DELETE FROM endereco WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

}
