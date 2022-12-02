package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.AvaliacaoDTO;
import DTO.EstrategiaDTO;


public class AvaliacaoDAO {
	
	
Connection DBconnection;
PreparedStatement preparedStatment;
ResultSet resultSet;
ArrayList<AvaliacaoDTO> listaAvaliacao = new ArrayList<>();

	public void cadastrarAvaliacao (AvaliacaoDTO objetoavaliacaodto) {


		
		
		String sql= "insert into avaliacoes (porcentagem_de_gordura_corporal, massa_gorda, indice_de_massa_gorda, massa_magra, indice_de_massa_magra, "
				+ " categoria_indice_de_massa_magra, taxa_metabolica_basal, historico_medidas_magras, resultado_estrategia,  "
				+ "fator_de_atividade_fisica, medidas_pk_medidas_id, medidas_usuario_pk_usuario_id) values (?,?,?,?,?,?,?,?,?,?,?,?)";
				
				
				DBconnection = new ConexaoDAO().connectDB();
				
				try { 
					
					preparedStatment = DBconnection.prepareStatement(sql); 
					preparedStatment.setDouble(1, objetoavaliacaodto.getPorcentagem_de_gordura_corporal());
					preparedStatment.setDouble(2, objetoavaliacaodto.getMassa_gorda());
					preparedStatment.setString(3, objetoavaliacaodto.getIndice_de_massa_gorda()); 
					preparedStatment.setDouble(4,objetoavaliacaodto.getMassa_magra());
					preparedStatment.setDouble(5, objetoavaliacaodto.getIndice_de_de_massa_magra());
					preparedStatment.setString(6, objetoavaliacaodto.getCategoria_indice_de_massa_magra());
					preparedStatment.setDouble(7, objetoavaliacaodto.getTaxa_metablica_basal());
					preparedStatment.setDouble(8, objetoavaliacaodto.getHistorico_de_medidas_magras());
					preparedStatment.setString(9, objetoavaliacaodto.getStatus());
					preparedStatment.setDouble(10, objetoavaliacaodto.getFator_de_atividae_fisica());
					preparedStatment.setInt(11, objetoavaliacaodto.getFk_medidas_id());
					preparedStatment.setInt(12, objetoavaliacaodto.getFk_usuario_id());
					
					
					preparedStatment.execute();
					preparedStatment.close();
					
					
				} catch (Exception e) { 
					JOptionPane.showMessageDialog(null, "AvaliacaoDAO Cadastrar: " + e);
				}finally {
					try {
						preparedStatment.close();
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
		}
	}
	
	public double calcularPorcentagemDeGorduraCorporal(double pecoco, double cintura, double altura){
		
		double porcentagemDeGorduraCorporal;
		
		porcentagemDeGorduraCorporal = (495/((1.0324 - (0.19077*(Math.log10(cintura-pecoco))))+(0.15456*(Math.log10(altura)))))-450;
		
		return porcentagemDeGorduraCorporal;
	}
	
public	double calcularMassaGorda(double peso, double porcentagemDeGorduraCorporal){
		
		double massaGorda;
		
		massaGorda = (porcentagemDeGorduraCorporal/100) * peso;
		
		return massaGorda;
		
	}
	
public	String classificarPorIndiceDeMassaGorda(double porcentagemDeGorduraCorporal){
		 
		String categoriaIndiceDeMassaGorda= null;
		
		if(porcentagemDeGorduraCorporal<2)
		{
			categoriaIndiceDeMassaGorda = "Menos que o Excencial";
		} else if ((porcentagemDeGorduraCorporal>=2)&&(porcentagemDeGorduraCorporal<6))
		  {
			categoriaIndiceDeMassaGorda= "Gordura Excencial";
	      } else if ((porcentagemDeGorduraCorporal>=6)&&(porcentagemDeGorduraCorporal<14))
	         {
	    	  categoriaIndiceDeMassaGorda = "Atleta";
	         } else if ((porcentagemDeGorduraCorporal>=14)&&(porcentagemDeGorduraCorporal<18))
	           {
	        	 categoriaIndiceDeMassaGorda = "Fitness";
			   } else if ((porcentagemDeGorduraCorporal>=18)&&(porcentagemDeGorduraCorporal<25))
			     {
				   categoriaIndiceDeMassaGorda = "Média";
				 } else if (porcentagemDeGorduraCorporal>=25){
					 
					 categoriaIndiceDeMassaGorda = "Obeso";
				 }
				     
				     	return categoriaIndiceDeMassaGorda;
		
	}
	
	 public double calcularMassaMagra(double peso, double massaGorda) {
		
		double massaMagra;
		
		massaMagra = peso - massaGorda;
		
		return massaMagra;
		
	}
	
public	double calcularIndiceDeMassaMagra(double altura, double massaMagra){
		
		double alturaEmMetros, indiceDeMassaMagraNormalizado, indiceDeMassaMagra;
		 
		 alturaEmMetros = altura/100;
		
		indiceDeMassaMagra= massaMagra/Math.pow(alturaEmMetros,2);
	  	indiceDeMassaMagraNormalizado=indiceDeMassaMagra+(6.1*(1.8-alturaEmMetros));
	  	
	  	return indiceDeMassaMagraNormalizado;
		
	}
	
public	double calcularTaxaMetabolicaBasal(double massaMagra){
		
		double taxaMetablicaBasal;
		
		taxaMetablicaBasal = 370 + (21.6* massaMagra);
		
		return taxaMetablicaBasal;
		
	}
	
public	double verificarMassaMagra(double pescoco, double circunferenciaOmbros, double peitoral, double braco, double antebraco, double coxa, double panturrilha) {
		
		double medidasMagras;
		
		medidasMagras = (pescoco+circunferenciaOmbros+peitoral+braco+antebraco+coxa+panturrilha)/7;
		
		return medidasMagras;
	}
	
public	String verificarResultdoDaEstrategia(double medidasMagras, double cintura){
		
		double medidadMagrasAvaliacaoAnterior=0, cinturaAvaliacaoAnterior=0;
		String resultadoDaEstrategia=null;
		
		if((medidasMagras<medidadMagrasAvaliacaoAnterior)&&(cintura<cinturaAvaliacaoAnterior))
		{ 
			resultadoDaEstrategia = "perdendoGordura&&MassaMagra";
		}else if((medidasMagras>medidadMagrasAvaliacaoAnterior)&&(cintura>cinturaAvaliacaoAnterior))
			{
		  		resultadoDaEstrategia="ganhandoGordura&&MassaMagra"; 
			}else if((medidasMagras<medidadMagrasAvaliacaoAnterior)&&(cintura>cinturaAvaliacaoAnterior))
				{
		  			resultadoDaEstrategia="ganhandoGordura&&PerdendoMassaMagra";
				}else if((medidasMagras>medidadMagrasAvaliacaoAnterior)&&(cintura<cinturaAvaliacaoAnterior))
					{
		  				resultadoDaEstrategia="prdendoGordura&&GanhandoMassaMagra";
					}else if((medidasMagras<medidadMagrasAvaliacaoAnterior)&&(cintura==cinturaAvaliacaoAnterior))
						{
							resultadoDaEstrategia="perdendoMassaMagra";
						}else if((medidasMagras==medidadMagrasAvaliacaoAnterior)&&(cintura<cinturaAvaliacaoAnterior))
							{
								resultadoDaEstrategia="perdendoGordura";
							}else if((medidasMagras>medidadMagrasAvaliacaoAnterior)&&(cintura==cinturaAvaliacaoAnterior))
								{
									resultadoDaEstrategia="ganhandoMassaMagra";
								}else if((medidasMagras==medidadMagrasAvaliacaoAnterior)&&(cintura>cinturaAvaliacaoAnterior))
									{
										resultadoDaEstrategia="ganhandoGordura";
									}else if((medidasMagras==medidadMagrasAvaliacaoAnterior)&&(cintura==cinturaAvaliacaoAnterior))
										{
		 									 resultadoDaEstrategia="manutenção";
										}
		return resultadoDaEstrategia;
		
	}
	
public	String classificarPorIndiceDeMassaMagra(double indiceDeMassaMagraNormalizado) {
		
	String categoriaIndiceDeMassaMagra=null;
	
	if(indiceDeMassaMagraNormalizado<18)
	{
		categoriaIndiceDeMassaMagra = "Abaixo da Média";
	} else if ((indiceDeMassaMagraNormalizado>=18)&&(indiceDeMassaMagraNormalizado<20))
	  {
		categoriaIndiceDeMassaMagra=  "Mediano";
      }else if ((indiceDeMassaMagraNormalizado>=20)&&(indiceDeMassaMagraNormalizado<22))
         {
    	  categoriaIndiceDeMassaMagra =  "Acima da Média"; 
         } else if (indiceDeMassaMagraNormalizado>=22.0) 
           {
        	 categoriaIndiceDeMassaMagra = "Excelente";
		   } else if ((indiceDeMassaMagraNormalizado>=23)&&(indiceDeMassaMagraNormalizado<26))
		     {
			   categoriaIndiceDeMassaMagra = "Superior";
			 } else if ((indiceDeMassaMagraNormalizado>=26)&&(indiceDeMassaMagraNormalizado<28))
			     {
				 categoriaIndiceDeMassaMagra = "Improvável que Seja Natural";
				 } else if (indiceDeMassaMagraNormalizado>=28)
			     {
					 categoriaIndiceDeMassaMagra = "Inacreditável que Seja Natural";
			     }
	
					return categoriaIndiceDeMassaMagra;

	}

public double recalcularFatorDeAtividadeFisica(String categoriaIndindiceDeMassaGorda, String resultadoDaEstrategia, double percentualDeGorduraIdealParaAIdade, double percentualDeGodura, double fatorDeAtividadeFisica) { 
	
	int fatorDeAtividadeFisicaOp=0;
	
	if(fatorDeAtividadeFisica==1.2) {
		fatorDeAtividadeFisicaOp=1;
	} else if(fatorDeAtividadeFisica==1.375) {
		fatorDeAtividadeFisicaOp=2; 
	} else if(fatorDeAtividadeFisica==1.55) {
		fatorDeAtividadeFisicaOp=3;
	} else if(fatorDeAtividadeFisica==1.725) {
		fatorDeAtividadeFisicaOp=4;
	} else if(fatorDeAtividadeFisica==1.9) {
		fatorDeAtividadeFisicaOp=5;
	}
	
	if(((categoriaIndindiceDeMassaGorda=="Média")||(categoriaIndindiceDeMassaGorda=="Obeso"))&&
			((resultadoDaEstrategia=="ganhandoGordura&&MassaMagra")||(resultadoDaEstrategia=="ganhandoGordura")||(resultadoDaEstrategia=="manutenção"))) 
			{
		fatorDeAtividadeFisicaOp= fatorDeAtividadeFisicaOp-1;
			}else if((categoriaIndindiceDeMassaGorda=="Menos que o Excencial")&&
					((resultadoDaEstrategia=="perdendoGordura&&MassaMagra")||(resultadoDaEstrategia=="perdendoMassaMagra")||(resultadoDaEstrategia=="perdendoGordura")||(resultadoDaEstrategia=="manutenção")))
					{
					fatorDeAtividadeFisicaOp= fatorDeAtividadeFisicaOp+1;
					} else if ((categoriaIndindiceDeMassaGorda=="Gordura Escencial")||(categoriaIndindiceDeMassaGorda=="Atleta")||(categoriaIndindiceDeMassaGorda=="Fitness")&&
							(resultadoDaEstrategia=="perdendoMassaMagra"))
					{
						fatorDeAtividadeFisicaOp= fatorDeAtividadeFisicaOp+1;
					}else if ((categoriaIndindiceDeMassaGorda=="Gordura Excencial")||(categoriaIndindiceDeMassaGorda=="Atleta")||(categoriaIndindiceDeMassaGorda=="Fitness")&&
							(resultadoDaEstrategia=="ganhandoGordura"))
						{
							fatorDeAtividadeFisicaOp= fatorDeAtividadeFisicaOp-1;
						}else if (((categoriaIndindiceDeMassaGorda=="Gordura Excencial")||(categoriaIndindiceDeMassaGorda=="Atleta")||(categoriaIndindiceDeMassaGorda=="Fitness"))&& 
								(resultadoDaEstrategia=="manutenção")&&(percentualDeGodura>percentualDeGorduraIdealParaAIdade))
							{
							fatorDeAtividadeFisicaOp= fatorDeAtividadeFisicaOp+1;
							}else if (((categoriaIndindiceDeMassaGorda=="Gordura Excencial")||(categoriaIndindiceDeMassaGorda=="Atleta")||(categoriaIndindiceDeMassaGorda=="Fitness"))&& 
									(resultadoDaEstrategia=="manutenção")&&(percentualDeGodura<percentualDeGorduraIdealParaAIdade))
								{
								fatorDeAtividadeFisicaOp= fatorDeAtividadeFisicaOp-1;
								
								}
	
	switch(fatorDeAtividadeFisicaOp)
	{
	case 1: fatorDeAtividadeFisica=1.2;
		break;
	case 2: fatorDeAtividadeFisica=1.287;
		break;
	case 3: fatorDeAtividadeFisica=1.375;
		break;
	case 4: fatorDeAtividadeFisica=1.462;
		break;
	case 5: fatorDeAtividadeFisica=1.55;
		break;
	case 6: fatorDeAtividadeFisica=1.637;
		break;
	case 7: fatorDeAtividadeFisica=1.725;
		break;
	case 8: fatorDeAtividadeFisica=1.812;
		break;
	case 9: fatorDeAtividadeFisica=1.9;
		break;
	
		
	} 
	
	return fatorDeAtividadeFisica;
}

public double calcularNecessidadeCalorica(double fatorDeAtividadeFísica, double taxaMetabolicaBasal, int avaliacaoId) {
	
	double necessidadeCalorica;
	
	necessidadeCalorica = fatorDeAtividadeFísica * taxaMetabolicaBasal;
	
	EstrategiaDTO objetoestrategiadto = new EstrategiaDTO();
	objetoestrategiadto.setNecessidade_calorica(necessidadeCalorica);
	objetoestrategiadto.setAvaliacoes_pk_avaliacao_id(avaliacaoId);
	
	EstrategiaDAO objetoestrategiadao = new EstrategiaDAO();
	objetoestrategiadao.cadastrarEstrategia(objetoestrategiadto);
	
	return 0;
	
}


	public ArrayList <AvaliacaoDTO> listarAvaliacao() {
		

	String sql="select * from avaliacoes";
	
	
	DBconnection = new ConexaoDAO().connectDB(); 
	try { 
		preparedStatment=DBconnection.prepareStatement(sql); 
		resultSet=preparedStatment.executeQuery();
		
		AvaliacaoDTO objetoavaliacaodto = new AvaliacaoDTO();
		
		while (resultSet.next()) {
		objetoavaliacaodto.setCategoria_indice_de_massa_magra(resultSet.getString("categoria_indice_de_massa_magra"));
		objetoavaliacaodto.setIndice_de_de_massa_magra(resultSet.getDouble("indice_de_massa_magra"));
		objetoavaliacaodto.setIndice_de_massa_gorda(resultSet.getString("indice_de_massa_gorda")); 
		objetoavaliacaodto.setMassa_gorda(resultSet.getDouble("massa_gorda"));
		objetoavaliacaodto.setMassa_magra(resultSet.getDouble("massa_magra"));
		objetoavaliacaodto.setPorcentagem_de_gordura_corporal(resultSet.getDouble("porcentagem_de_gordura_corporal"));  
		
		
		listaAvaliacao.add(objetoavaliacaodto);
		 
		}
		
		
	
	} catch (SQLException error) {
		JOptionPane.showMessageDialog(null,"limiteDAO Listar: " + error);
	}
	
	
	return listaAvaliacao;
	
}

public ResultSet pesquisarAvaliacaoId( ) {
	

	String sql="select * from avaliacoes";
	
	
	DBconnection = new ConexaoDAO().connectDB();
	try {
		preparedStatment=DBconnection.prepareStatement(sql);
		return preparedStatment.executeQuery();
	
	
		
	
	} catch (SQLException error) {
		JOptionPane.showMessageDialog(null,"avaliacoesDAO PesquisarID: " + error);
	}
	
	
	return null;
	
}

public ResultSet pesquisarFatorDeAtividadeFisica( ) {
	

	String sql="select * from avaliacoes";
	
	
	DBconnection = new ConexaoDAO().connectDB();
	try {
		preparedStatment=DBconnection.prepareStatement(sql);
		return preparedStatment.executeQuery();
	
	
		
	
	} catch (SQLException error) {
		JOptionPane.showMessageDialog(null,"UsuarioDAO PesquisarFDAF: " + error);
	}
	
	
	return null;
	
} 

public void realizarAvaliacao(double porcentagemDeGorduraCorporal, double massaGorda, String categoriaIndiceDeMassaGorda, double massaMagra, double indiceDeMassaMagraNormalizado,
		double taxaMetabolicabasal, double medidasMagras, String  resultadoDaEstrategia, String categoriaIndiceDeMassaMagra, double fatorDeAtividadeFisica, int medidasId, int usuarioId) {
	
	AvaliacaoDAO objetoavaliacaodao = new AvaliacaoDAO();
	AvaliacaoDTO objetoavaliacaodto = new AvaliacaoDTO();
	
	objetoavaliacaodto.setCategoria_indice_de_massa_magra(categoriaIndiceDeMassaMagra);
	objetoavaliacaodto.setFator_de_atividae_fisica(fatorDeAtividadeFisica);
	objetoavaliacaodto.setHistorico_de_medidas_magras(medidasMagras);
	objetoavaliacaodto.setIndice_de_de_massa_magra(indiceDeMassaMagraNormalizado);
	objetoavaliacaodto.setIndice_de_massa_gorda(categoriaIndiceDeMassaGorda);
	objetoavaliacaodto.setMassa_gorda(massaGorda);
	objetoavaliacaodto.setMassa_magra(massaMagra);
	objetoavaliacaodto.setPorcentagem_de_gordura_corporal(porcentagemDeGorduraCorporal);
	objetoavaliacaodto.setResultadoEstrategia(resultadoDaEstrategia);
	objetoavaliacaodto.setTaxa_metablica_basal(taxaMetabolicabasal);
	objetoavaliacaodto.setFk_medidas_id(medidasId);
	objetoavaliacaodto.setFk_usuario_id(usuarioId);
	
	objetoavaliacaodao.cadastrarAvaliacao(objetoavaliacaodto);
	
	
}

	
}
