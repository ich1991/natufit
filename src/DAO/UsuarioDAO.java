package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JOptionPane;


import DTO.UsuarioDTO;

public class UsuarioDAO {
	
	Connection DBconnection;
	PreparedStatement preparedStatment;
	ResultSet resultSet;
	
	

	
public void cadastrarUsuario(UsuarioDTO objetousuariodto) {
		
	String sql= "insert into usuario (idade, altura, punho, tornozelo) values (?,?,?,?)";
		
		DBconnection = new ConexaoDAO().connectDB();
		
		try {
			
			preparedStatment = DBconnection.prepareStatement(sql);
			preparedStatment.setInt(1, objetousuariodto.getIdade());
			preparedStatment.setDouble(2, objetousuariodto.getAltura());
			preparedStatment.setDouble(3, objetousuariodto.getPunho());
			preparedStatment.setDouble(4, objetousuariodto.getTornozelo());
			
			
			preparedStatment.execute();
			preparedStatment.close();
			DBconnection.close();
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "usuarioDAO Cadastrar: " + e);
		} finally {
			try {
				
				DBconnection.close();
				preparedStatment.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		

}

public ResultSet pesquisarUsuarioId( ) {
	

	String sql="select * from usuario";
	
	
	DBconnection = new ConexaoDAO().connectDB();
	try {
		preparedStatment=DBconnection.prepareStatement(sql);
		return preparedStatment.executeQuery();
	
	
		
	
	} catch (SQLException error) {
		JOptionPane.showMessageDialog(null,"UsuarioDAO Pesquisar: " + error);
	}
	
	
	return null;
	
} 

 public void resetarSistema() {
	 
	 String sql;
	 
	 DBconnection = new ConexaoDAO().connectDB();
	 
	 try {
		 	
			
			sql=" delete from estrategias";
			preparedStatment=DBconnection.prepareStatement(sql);
			preparedStatment.executeUpdate();
			sql=" delete from avaliacoes";
			preparedStatment=DBconnection.prepareStatement(sql);
			preparedStatment.executeUpdate();
			sql=" delete from refeicoes";
			preparedStatment=DBconnection.prepareStatement(sql); 
			preparedStatment.executeUpdate();
			sql=" delete from limite_genetico_natural";
			preparedStatment=DBconnection.prepareStatement(sql);
			preparedStatment.executeUpdate();
			sql=" delete from medidas_fisico_ideal";
			preparedStatment=DBconnection.prepareStatement(sql);
			preparedStatment.executeUpdate();
			sql=" delete from medidas";
			preparedStatment=DBconnection.prepareStatement(sql);
			preparedStatment.executeUpdate();
			sql=" delete from alimentos";
			preparedStatment=DBconnection.prepareStatement(sql);
			preparedStatment.executeUpdate();
			sql=" delete from usuario"; 
			preparedStatment=DBconnection.prepareStatement(sql);
			preparedStatment.executeUpdate();
			DBconnection.close();
			preparedStatment.close();
		
			
		
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null,"UsuarioDAO resetar: " + error);
		} finally {
			
			try {
				DBconnection.close();
				preparedStatment.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
}


}
