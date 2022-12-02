package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JOptionPane;


import DTO.EstrategiaDTO;

public class EstrategiaDAO {
	
	Connection DBconnection;
	PreparedStatement preparedStatment;
	ResultSet resultSet;
	

	
public void cadastrarEstrategia(EstrategiaDTO objetoestrategiadto) {

  
		
	
String sql= "insert into estrategias (necessidade_calorica, anotacoes, avaliacoes_pk_avaliacao_id) values (?,?,?)";
		
		
		DBconnection = new ConexaoDAO().connectDB();
		
		try {
			
			preparedStatment = DBconnection.prepareStatement(sql);
			preparedStatment.setDouble(1, objetoestrategiadto.getNecessidade_calorica());
			preparedStatment.setString(2, objetoestrategiadto.getAnotacoes());
			preparedStatment.setInt(3, objetoestrategiadto.getAvaliacoes_pk_avaliacao_id());
			
			preparedStatment.execute(); 
			preparedStatment.close();
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "EstrategiaDAO Cadastrar: " + e);
		}
		
}

public void atualizarAnotacoes(int idEstrategia, String anotacoes) {
	
	String sql="update estrategias set anotacoes='"+anotacoes+"'  where pk_estrategia_id='"+idEstrategia+"'";
	
	DBconnection = new ConexaoDAO().connectDB();
	try {
		preparedStatment=DBconnection.prepareStatement(sql);
		preparedStatment.execute();
		preparedStatment.close();
	
		
	
	} catch (SQLException error) {
		JOptionPane.showMessageDialog(null,"EstrategiaDAO AtualizarAnot: " + error);
	}
	
	
}
		
public ResultSet pesquisarEstrategia( ) {
	

	String sql="select * from estrategias";
	
	
	DBconnection = new ConexaoDAO().connectDB();
	try {
		preparedStatment=DBconnection.prepareStatement(sql);
		return preparedStatment.executeQuery();
	
	
		
	
	} catch (SQLException error) {
		JOptionPane.showMessageDialog(null,"EstrategiaDAO Pesquisar: " + error);
	}
	
	
	return null;
	
} 

	

}
