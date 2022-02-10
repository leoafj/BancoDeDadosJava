/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import View.FormCadastroView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
/**
 *
 * @author leonardoa
 */
public class UsuarioDAO {
    
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert (Usuario usuario) throws SQLException{
        
        String sql = "insert into usuario (usuario, senha) values (?, ?); ";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getUsuario());
            statement.setString(2, usuario.getSenha());
            statement.execute();
         
        }

    public boolean existeNoBancoPorUsuarioESenha(Usuario usuario) throws SQLException {
        
        String sql = "select * from usuario where usuario = ? and senha = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        
        statement.execute();
            
        ResultSet resultSet = statement.getResultSet();
        
        return resultSet.next();
    }

}
    
