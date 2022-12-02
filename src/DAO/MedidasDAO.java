package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import DTO.MedidasDTO;


public class MedidasDAO {
	
	Connection DBconnection;
		PreparedStatement preparedStatment=null;
		ResultSet resultSet;
		ArrayList<MedidasDTO> listaMedidas = new ArrayList<>();
	
	public void cadastrarMedidas(MedidasDTO objetomedidasdto) {
 
		

		
		 
		String sql= "insert into medidas ( pescoco, cintura, quadril, largura_ombros, circunferencia_ombros, peitoral, "
				+ "braco, antebraco, coxa, panturrilha, peso,  usuario_pk_usuario_id) values (?,?,?,?,?,?,?,?,?,?,?,?)";
				
				
				DBconnection = new ConexaoDAO().connectDB();
				
				try {
					
					preparedStatment = DBconnection.prepareStatement(sql);
					preparedStatment.setDouble(1, objetomedidasdto.getPescoco());
					preparedStatment.setDouble(2, objetomedidasdto.getCintura()); 
					preparedStatment.setDouble(3, objetomedidasdto.getQuadril());
					preparedStatment.setDouble(4, objetomedidasdto.getLargura_ombros());
					preparedStatment.setDouble(5, objetomedidasdto.getCircunferencia_ombros());
					preparedStatment.setDouble(6, objetomedidasdto.getPeitoral());
					preparedStatment.setDouble(7, objetomedidasdto.getBraco());
					preparedStatment.setDouble(8, objetomedidasdto.getAntebraco());
					preparedStatment.setDouble(9, objetomedidasdto.getCoxa());
					preparedStatment.setDouble(10, objetomedidasdto.getPanturrilha());
					preparedStatment.setDouble(11, objetomedidasdto.getPeso());
					preparedStatment.setInt(12, objetomedidasdto.getFk_usuario_id());
					
					
					preparedStatment.execute();
					preparedStatment.close();
					DBconnection.close();
					
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "MedidasDAO Cadastrar: " + e);
				}finally {
					try {
						DBconnection.close();
						preparedStatment.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
		}

}
	
  	public ArrayList <MedidasDTO> listarMedidasAtuais( ) {
		

		String sql="select * from medidas";
		
		
		DBconnection = new ConexaoDAO().connectDB(); 
		try {
			preparedStatment=DBconnection.prepareStatement(sql); 
			resultSet=preparedStatment.executeQuery();
			
			MedidasDTO objetomedidasdto = new MedidasDTO();
			
			while (resultSet.next()) {
			objetomedidasdto.setAntebraco(resultSet.getDouble("antebraco"));
			objetomedidasdto.setBraco(resultSet.getDouble("braco"));
			objetomedidasdto.setCintura(resultSet.getDouble("cintura")); 
			objetomedidasdto.setCircunferencia_ombros(resultSet.getDouble("circunferencia_ombros"));
			objetomedidasdto.setCoxa(resultSet.getDouble("coxa"));
			objetomedidasdto.setLargura_ombros(resultSet.getDouble("largura_ombros"));
			objetomedidasdto.setPanturrilha(resultSet.getDouble("panturrilha"));  
			objetomedidasdto.setPeitoral(resultSet.getDouble("peitoral")); 
			objetomedidasdto.setPescoco(resultSet.getDouble("pescoco"));
			objetomedidasdto.setQuadril(resultSet.getDouble("quadril"));
		
			
			
			listaMedidas.add(objetomedidasdto);
			 
			}
			
			
		
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null,"medidasDAO Pesquisar: " + error);
		}
		
		
		return listaMedidas;
		
	}
	
	public ResultSet pesquisarMedidasId( ) {
		

		String sql="select * from medidas";
		
		
		DBconnection = new ConexaoDAO().connectDB();
		try {
			preparedStatment=DBconnection.prepareStatement(sql);
			return preparedStatment.executeQuery();
		
		
			
		
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null,"medidasDAO PesquisarID: " + error);
		}
		
		
		return null;
		
	}

}
