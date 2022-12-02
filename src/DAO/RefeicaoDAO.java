package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.RefeicaoDTO;

public class RefeicaoDAO {
	
	Connection DBconnection;
	PreparedStatement preparedStatment;
	ResultSet resultSet;
	ArrayList<RefeicaoDTO> listaAlimentos = new ArrayList<>();

	
public void cadastrarRefeicao(RefeicaoDTO objetorefeicaodto) {

		
	
	String	sql= "insert into refeicoes (nome_alimento, porcao, carbohidratos, proteinas, gorduras_totais, fibras, sodio, "
		+ "valor_energetico, indice_glicemico, nome_refeicao,alimentos_pk_alimento_id, alimentos_usuario_pk_usuario_id) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		 
		DBconnection = new ConexaoDAO().connectDB();
		
		try {
			
			preparedStatment = DBconnection.prepareStatement(sql);
			preparedStatment.setString(1, objetorefeicaodto.getNome_alimento()); 
			preparedStatment.setDouble(2, objetorefeicaodto.getPorcao());
			preparedStatment.setDouble(3, objetorefeicaodto.getCarbohidratos());
			preparedStatment.setDouble(4, objetorefeicaodto.getProteinas());
			preparedStatment.setDouble(5, objetorefeicaodto.getGorduras_totais());
			preparedStatment.setDouble(6, objetorefeicaodto.getFibras());
			preparedStatment.setDouble(7, objetorefeicaodto.getSodio());
			preparedStatment.setDouble(8, objetorefeicaodto.getKcals());
			preparedStatment.setInt(9, objetorefeicaodto.getIndice_glicemico());
			preparedStatment.setString(10, objetorefeicaodto.getNomeRefeicao());
			preparedStatment.setInt(11, objetorefeicaodto.getFk_alimento_id());
			preparedStatment.setInt(12, objetorefeicaodto.getFk_usuario_id());
			
			
			preparedStatment.execute();
			preparedStatment.close();
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "RefeicaoDAO Cadastrar: " + e);
		}
}

public ArrayList <RefeicaoDTO> listarRefeicaoPorNome( String nomeTabela) {
	
	String sql = null;
	 
	   
	if (nomeTabela=="Café da Manhã") {
		
		sql="select * from refeicoes where nome_refeicao='Café da Manhã' ";
		
	} else if (nomeTabela=="Lanche") {
		
		sql="select * from refeicoes where nome_refeicao='Lanche' ";
		
	} else if (nomeTabela=="Almoço") {
		
		sql="select * from refeicoes where nome_refeicao='Almoço' ";
		
	} else if (nomeTabela=="Pré Treino") {
		
		sql="select * from refeicoes where nome_refeicao='Pré Treino' ";
		
	} else if (nomeTabela=="Pós Treino") {
		
		sql="select * from refeicoes where nome_refeicao='Pós Treino' ";
		
	}
		
	
	
	
	
	DBconnection = new ConexaoDAO().connectDB();
	try { 
		preparedStatment=DBconnection.prepareStatement(sql);  
		resultSet= preparedStatment.executeQuery();
	 
	while(resultSet.next()) { 
		RefeicaoDTO objetorefeicaodto= new RefeicaoDTO();
		objetorefeicaodto.setNome_alimento(resultSet.getString("nome_alimento"));
		objetorefeicaodto.setPorcao(resultSet.getDouble("porcao"));
		objetorefeicaodto.setCarbohidratos(resultSet.getDouble("carbohidratos"));
		objetorefeicaodto.setProteinas(resultSet.getDouble("proteinas"));
		objetorefeicaodto.setGorduras_totais(resultSet.getDouble("gorduras_totais"));
		objetorefeicaodto.setFibras(resultSet.getDouble("fibras"));
		objetorefeicaodto.setSodio(resultSet.getDouble("sodio"));
		objetorefeicaodto.setKcals(resultSet.getDouble("valor_energetico"));
		objetorefeicaodto.setIndice_glicemico(resultSet.getInt("indice_glicemico"));
		
		
		
		
		
		
		listaAlimentos.add(objetorefeicaodto);
		
		
	}
	} catch (SQLException error) {
		JOptionPane.showMessageDialog(null,"refeicaoDAO listarPorNome: " + error);
	} 
			
		
	 
	
	return listaAlimentos; 
	
}

public ArrayList <RefeicaoDTO> pesquisarAtributosDaRefeicao() {
	
	String sql = null;
	    
	
		 
		sql="select * from refeicoes";
	
	
	
	DBconnection = new ConexaoDAO().connectDB();
	try { 
		preparedStatment=DBconnection.prepareStatement(sql);  
		resultSet= preparedStatment.executeQuery();
	 
	while(resultSet.next()) { 
		RefeicaoDTO objetorefeicaodto= new RefeicaoDTO();
		objetorefeicaodto.setPk_refeicao_id(resultSet.getInt("pk_refeicao_id"));                 
		objetorefeicaodto.setKcals(resultSet.getDouble("valor_energetico"));
		objetorefeicaodto.setCarbohidratos(resultSet.getDouble("carbohidratos"));
		objetorefeicaodto.setProteinas(resultSet.getDouble("proteinas"));
		objetorefeicaodto.setGorduras_totais(resultSet.getDouble("gorduras_totais"));
		objetorefeicaodto.setFibras(resultSet.getDouble("fibras"));
		objetorefeicaodto.setSodio(resultSet.getDouble("sodio"));
		
		listaAlimentos.add(objetorefeicaodto);
		
		
	}
	} catch (SQLException error) {
		JOptionPane.showMessageDialog(null,"refeicaoDAO5 PesquisarAtributos: " + error);
	} 
			
		
	 
	
	return listaAlimentos; 
	
}

public void excluirAlimentoDaRefeicao(String id, String nome) {
	
	String sql = "delete from refeicoes where valor_energetico ='"+id+"' and nome_alimento='"+nome+"'";
		
	DBconnection = new ConexaoDAO().connectDB();
	
		try {
			
			preparedStatment= DBconnection.prepareStatement(sql);
			preparedStatment.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	
	
}



}
