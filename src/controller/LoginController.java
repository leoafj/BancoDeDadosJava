/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import View.LoginView;
import View.MenuView;
import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author leonardoa
 */
public class LoginController {
    
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        
        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        
        Usuario usuarioAutenticar = new Usuario (usuario, senha);
        
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            
        boolean existe = usuarioDao.existeNoBancoPorUsuarioESenha(usuarioAutenticar);
            
        if(existe) {
        MenuView telaDeMenu = new MenuView();
        telaDeMenu.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(view, "Usuario ou senha invalidos");
        }
        
        
    }
    
    
}
