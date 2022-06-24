package janela;

import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import conexao.conexaoo;

public class janelalogin extends javax.swing.JFrame{
JButton entrar=new JButton("Entrar");
JTextField nome=new JTextField();
JPasswordField senha=new JPasswordField();
JLabel nomel=new JLabel("Nome");
JLabel senhal=new JLabel("Senha");
JLabel imagem=new JLabel();

	public void janelaa() {
	
	setSize(800,450);
	setVisible(true);
	setLayout(null);
	JLabel logo = new JLabel();
	setLocationRelativeTo(null);
	}
	public void Menu() {
		ImageIcon imagem = new ImageIcon(getClass().getResource("/biblioteca/m.jpg"));
		JLabel logo = new JLabel();
		logo.setIcon(imagem);
	//	logo.setSize(1200,400);
		//
		add(logo);
	}
public void componentes(){
	entrar.setBounds(50, 300, 150, 40);
	add(entrar);
	entrar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 try{        
			        Connection con = conexaoo.fazconexao();
			      String sql= "select * from usuarios where nome=? and senha=?";
			        PreparedStatement stmt=con.prepareStatement(sql);
			            stmt.setString(1,nome.getText());
			            stmt.setString(2,new String(senha.getPassword()));
			       ResultSet rs=stmt.executeQuery();
			       if(rs.next()){
			           JOptionPane.showMessageDialog(null,"Entrando...");
			           corpo exibir=new corpo();
			           exibir.setVisible(true);
			           setVisible(false);
			       }else{
			           JOptionPane.showMessageDialog(null,"Usuario inesistente ");
			       }
			       stmt.close();
			       con.close();
			       
			       }catch(SQLException erro){
			    	   
			       }
		}
	});
	nome.setBounds(300, 40, 300, 30);
	add(nome);
	senha.setBounds(300, 160, 300, 30);
	add(senha);
	nomel.setBounds(200,40,200,30);
	add(nomel);
	senhal.setBounds(200,160,200,30);
	add(senhal);
	nomel.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,25));
	nomel.setForeground(Color.BLUE);;
	senhal.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,25));
	senhal.setForeground(Color.BLUE);;
	entrar.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,30));
}
	public static void main(String[] args) {
		janelalogin a=new janelalogin();
		a.componentes();
			a.Menu();
			
		a.janelaa();
		
		
	
	}
}
