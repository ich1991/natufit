package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.AlimentoDTO;



public class AlimentoDAO {

	Connection DBconnection;
	PreparedStatement preparedStatment;
	ResultSet resultSet;
	ArrayList<AlimentoDTO> listaAlimentos = new ArrayList<>();

	
public void cadastrarAlimento(AlimentoDTO objetoalimentodto) {

  
		
	
String sql= "insert into alimentos (nome, grupo_alimentar, indice_glicemico, valor_biologico, porcao_amostral, carbohidratos,"
		+ " proteinas,gorduras_totais, fibra_alimentar, sodio, usuario_pk_usuario_id) values (?,?,?,?,?,?,?,?,?,?,?)";
		
		
		DBconnection = new ConexaoDAO().connectDB();
		
		try {
			
			preparedStatment = DBconnection.prepareStatement(sql);
			preparedStatment.setString(1, objetoalimentodto.getNome());
			preparedStatment.setString(2, objetoalimentodto.getGrupo_alimentar());
			preparedStatment.setInt(3, objetoalimentodto.getIndidce_glicemico());
			preparedStatment.setInt(4, objetoalimentodto.getValor_biologico());
			preparedStatment.setDouble(5, objetoalimentodto.getPorcao_amostral());
			preparedStatment.setDouble(6, objetoalimentodto.getCarbohidratos());
			preparedStatment.setDouble(7, objetoalimentodto.getProteinas());
			preparedStatment.setDouble(8, objetoalimentodto.getGorduras_totais()); 
			preparedStatment.setDouble(9, objetoalimentodto.getFibra_alimentar());
			preparedStatment.setDouble(10, objetoalimentodto.getSodio()); 
			preparedStatment.setInt(11, objetoalimentodto.getFk_usuario_id());
			
			
			preparedStatment.execute();
			preparedStatment.close();
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "AlimentoDAO Cadastrar: " + e);
		}
}

		public ArrayList <AlimentoDTO> listarAlimentos( ) {
			
			String sql="select * from alimentos";
			
			DBconnection = new ConexaoDAO().connectDB();
			try { 
				preparedStatment=DBconnection.prepareStatement(sql);  
				resultSet= preparedStatment.executeQuery();
			
			while(resultSet.next()) { 
				AlimentoDTO objetoalimentodto= new AlimentoDTO();
				objetoalimentodto.setNome(resultSet.getString("nome"));
				objetoalimentodto.setGrupo_alimentar(resultSet.getString("grupo_alimentar"));                       
				objetoalimentodto.setIndidce_glicemico(resultSet.getInt("indice_glicemico"));
				objetoalimentodto.setValor_biologico(resultSet.getInt("valor_biologico"));
				objetoalimentodto.setPorcao_amostral(resultSet.getDouble("porcao_amostral"));
				objetoalimentodto.setCarbohidratos(resultSet.getDouble("carbohidratos"));
				objetoalimentodto.setProteinas(resultSet.getDouble("proteinas"));
				objetoalimentodto.setGorduras_totais(resultSet.getDouble("gorduras_totais"));
				objetoalimentodto.setFibra_alimentar(resultSet.getDouble("fibra_alimentar"));
				objetoalimentodto.setSodio(resultSet.getDouble("sodio"));
				
				listaAlimentos.add(objetoalimentodto);
				
				
			}
			} catch (SQLException error) {
				JOptionPane.showMessageDialog(null,"AlimentoDAO5 Listar: " + error);
			} 
					
				
			 
			
			return listaAlimentos; 
			
		}
		
		public ArrayList<AlimentoDTO> pesquisarGrupoAlimentar(String grupoAlimentar ) {
			

			String sql=null;
			
			if(grupoAlimentar=="Aves, Peixes e Ovos") {
				sql ="select * from alimentos where grupo_alimentar='Aves, Peixes e Ovos' ";
				
			} else if(grupoAlimentar=="Nozes, Sementes, Feijões e Tufu") {
				sql ="select * from alimentos where grupo_alimentar='Nozes, Sementes, Feijões e Tufu'";
				
				} else if(grupoAlimentar=="Laticinios") {
					sql ="select * from alimentos where grupo_alimentar='Laticinios'";
				
					} else if(grupoAlimentar=="Frutas e Vegetais") { 
						sql ="select * from alimentos where grupo_alimentar='Frutas e Vegetais'";
				
						} else if(grupoAlimentar=="Grãos Inteiros") {
							sql ="select * from alimentos where grupo_alimentar='Grãos Inteiros'";
				
							} else if(grupoAlimentar=="Óleos e Goduras Saudáveis") {
								sql ="select * from alimentos where grupo_alimentar='Óleos e Goduras Saudáveis'";
				
								} else if(grupoAlimentar=="Grãos Refinados, Doces, Açucar e Sal") {
									sql ="select * from alimentos where grupo_alimentar='Grãos Refinados, Doces, Açucar e Sal'";
				
									} 
			
									
									
										
			DBconnection = new ConexaoDAO().connectDB();
			try {
				preparedStatment=DBconnection.prepareStatement(sql);
			 resultSet=preparedStatment.executeQuery(); 
			
			 while(resultSet.next()) {
					AlimentoDTO objetoalimentodto= new AlimentoDTO();
					objetoalimentodto.setNome(resultSet.getString("nome"));
					objetoalimentodto.setGrupo_alimentar(resultSet.getString("grupo_alimentar"));                       
					objetoalimentodto.setIndidce_glicemico(resultSet.getInt("indice_glicemico"));
					objetoalimentodto.setValor_biologico(resultSet.getInt("valor_biologico"));
					objetoalimentodto.setPorcao_amostral(resultSet.getDouble("porcao_amostral"));
					objetoalimentodto.setCarbohidratos(resultSet.getDouble("carbohidratos"));
					objetoalimentodto.setProteinas(resultSet.getDouble("proteinas"));
					objetoalimentodto.setGorduras_totais(resultSet.getDouble("gorduras_totais"));
					objetoalimentodto.setFibra_alimentar(resultSet.getDouble("fibra_alimentar"));
					objetoalimentodto.setSodio(resultSet.getDouble("sodio"));
					objetoalimentodto.setPk_alimento_id(resultSet.getInt("pk_alimento_id"));
					
					listaAlimentos.add(objetoalimentodto);
					
					
					
					
			
			 }
			
			} catch (SQLException error) {
				JOptionPane.showMessageDialog(null,"AlimentoDAO PesquisarGrupoAlimnetar: " + error);
			} 
			
			return listaAlimentos;
			
			}
		
		

public ArrayList <AlimentoDTO> pesquisarAlimentoPorNome(String nome) {
	
	String sql= "select * from alimentos where nome='"+ nome + "'";
	
	DBconnection = new ConexaoDAO().connectDB();
	try {
		preparedStatment=DBconnection.prepareStatement(sql);
	 resultSet=preparedStatment.executeQuery(); 
	
	 while(resultSet.next()) {
			AlimentoDTO objetoalimentodto= new AlimentoDTO();
			objetoalimentodto.setNome(resultSet.getString("nome"));                       
			objetoalimentodto.setIndidce_glicemico(resultSet.getInt("indice_glicemico"));
			objetoalimentodto.setValor_biologico(resultSet.getInt("valor_biologico"));
			objetoalimentodto.setPorcao_amostral(resultSet.getDouble("porcao_amostral"));
			objetoalimentodto.setCarbohidratos(resultSet.getDouble("carbohidratos"));
			objetoalimentodto.setProteinas(resultSet.getDouble("proteinas"));
			objetoalimentodto.setGorduras_totais(resultSet.getDouble("gorduras_totais"));
			objetoalimentodto.setFibra_alimentar(resultSet.getDouble("fibra_alimentar"));
			objetoalimentodto.setSodio(resultSet.getDouble("sodio"));
			objetoalimentodto.setPk_alimento_id(resultSet.getInt("pk_alimento_id"));
			
			listaAlimentos.add(objetoalimentodto);
	 } 
	
	} catch (SQLException error) {
		JOptionPane.showMessageDialog(null,"AlimentoDAO PesquisarPorNome: " + error);
	} 
	
	return listaAlimentos;
	
	}



public double calcularKcalorias(String nome) {
	
	double kCals=0;
	
	String sql= "select * from alimentos where nome='"+ nome + "'";
	
	DBconnection = new ConexaoDAO().connectDB();
	try {
		preparedStatment=DBconnection.prepareStatement(sql);
	 resultSet=preparedStatment.executeQuery(); 
	
	 while(resultSet.next()) {
			
			
			 kCals = (((resultSet.getDouble("carbohidratos"))-(resultSet.getDouble("fibra_alimentar")))*4) + (resultSet.getDouble("proteinas")*4)+(resultSet.getDouble("gorduras_totais")*9);
			
			 } 
	
	} catch (SQLException error) {
		JOptionPane.showMessageDialog(null,"AlimentoDAO Pesquisar: " + error);
	} 
	
	return kCals;
		
	}

public void excluirAlimento(String nome) {
	
	String sql = "delete from alimentos where nome='"+ nome +"'";
		
	DBconnection = new ConexaoDAO().connectDB();
	
		try {
			
			preparedStatment= DBconnection.prepareStatement(sql);
			preparedStatment.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	
	
}

}


