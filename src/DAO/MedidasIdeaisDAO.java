package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import DTO.MedidasIdeaisDTO;



public class MedidasIdeaisDAO {
	
	Connection DBconnection;
	PreparedStatement preparedStatment;
	ResultSet resultSet;
	ArrayList<MedidasIdeaisDTO> listaMedidasIdeias = new ArrayList<>();
	
	
	public void cadastrarMedidasIdeas(MedidasIdeaisDTO objetomedidasideaisdto) {

		  
		
		
		String sql= "insert into medidas_fisico_ideal (cintura_ideal, quadril_ideal, peitoral_ideal, circunferencia_ideal_dos_ombros, largura_ideal_dos_ombros, massa_magra_ideal,"
				+ " indice_de_massa_magra_ideal, pescoco_ideal, bracos_ideal, antebracos_ideal, coxas_ideal, panturrilhas_ideal,usuario_pk_usuario_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				
				DBconnection = new ConexaoDAO().connectDB();
				
				try {
					
					preparedStatment = DBconnection.prepareStatement(sql);
					preparedStatment.setDouble(1, objetomedidasideaisdto.getCintura_ideal());
					preparedStatment.setDouble(2, objetomedidasideaisdto.getQuadril_ideal());
					preparedStatment.setDouble(3, objetomedidasideaisdto.getPeitoral_ideal());
					preparedStatment.setDouble(4, objetomedidasideaisdto.getCircunferencia_ideal_dos_ombros());
					preparedStatment.setDouble(5, objetomedidasideaisdto.getLargura_ideal_dos_ombros());
					preparedStatment.setDouble(6, objetomedidasideaisdto.getMassa_magra_ideal());
					preparedStatment.setDouble(7, objetomedidasideaisdto.getIndice_de_massa_magra_ideal());
					preparedStatment.setDouble(8, objetomedidasideaisdto.getPescoco_ideal());
					preparedStatment.setDouble(9, objetomedidasideaisdto.getBracos_ideal());
					preparedStatment.setDouble(10, objetomedidasideaisdto.getAntebracos_ideal());
					preparedStatment.setDouble(11, objetomedidasideaisdto.getCoxas_ideal());
					preparedStatment.setDouble(12, objetomedidasideaisdto.getPanturrilha_ideal());
					preparedStatment.setDouble(13, objetomedidasideaisdto.getUsuario_fk_usuario_id());

					
					
					
					preparedStatment.execute();
					preparedStatment.close();
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "medidasIdeaisDAO Cadastrar: " + e);
				}
		}
	
	public void calcularMedidasIdeais( double punho, double altura,double percentualDeGorduraIdealParaAIdade, int fkUsuarioId) {
		
		double cinturaIdeal, quadrilIdeal, peitoralIdeal, circunferenciaIdealDosOmbros, larguraIdealDosOmbros, pescocoIdeal, bracosIdeal,
		antebracosIdeal, coxasIdeal , panturrilhasIdeal, massaMagraIdeal, indiceDemassaMagraIdeal;
				
				punho= punho /2.54;
				altura = altura/2.54;
				
				cinturaIdeal = ((0.6412 * percentualDeGorduraIdealParaAIdade) + (2.3111 *  punho) + 7.6829)*2.54;
				quadrilIdeal = ((0.8015 * percentualDeGorduraIdealParaAIdade) + (2.8888 * punho) + 9.6037)*2.54;
				peitoralIdeal = ((0.9078 * percentualDeGorduraIdealParaAIdade) + (3.2719 * punho) + 10.8771);
				circunferenciaIdealDosOmbros = ((1.0375 * percentualDeGorduraIdealParaAIdade) + (3.7393 * punho) + 12.4310)*2.54;
				larguraIdealDosOmbros = ((0.4200 * percentualDeGorduraIdealParaAIdade) + (1.5137 * punho) + 5.0323)*2.54;
				
				pescocoIdeal = (0.360 * peitoralIdeal)*2.54;
				bracosIdeal = (0.360 * peitoralIdeal); 
				antebracosIdeal = (0.806 * bracosIdeal)*2.54;
				coxasIdeal = (0.530 * peitoralIdeal);
				panturrilhasIdeal= (0.679 * coxasIdeal)*2.54;
				
				massaMagraIdeal = ((0.2709 * Math.pow(bracosIdeal, 2)) + (3.0458 * altura - 115.88))/2.205;
				
				peitoralIdeal = peitoralIdeal*2.54;
				coxasIdeal = coxasIdeal * 2.54;
				bracosIdeal = bracosIdeal * 2.54;
			    altura = altura * 2.54;
				 
					
					indiceDemassaMagraIdeal= massaMagraIdeal/Math.pow((altura/100),2);
				  	indiceDemassaMagraIdeal=indiceDemassaMagraIdeal+(6.1*(1.8-(altura/100)));
				
				
				
				MedidasIdeaisDTO objetomedidasideaisdto = new MedidasIdeaisDTO();
				MedidasIdeaisDAO objetomedidasideaisdao = new MedidasIdeaisDAO();
				
				objetomedidasideaisdto.setCintura_ideal(cinturaIdeal);
				objetomedidasideaisdto.setBracos_ideal(bracosIdeal);
				objetomedidasideaisdto.setAntebracos_ideal(antebracosIdeal);
				objetomedidasideaisdto.setCircunferencia_ideal_dos_ombros(circunferenciaIdealDosOmbros);
				objetomedidasideaisdto.setCoxas_ideal(coxasIdeal);
				objetomedidasideaisdto.setIndice_de_massa_magra_ideal(indiceDemassaMagraIdeal);
				objetomedidasideaisdto.setLargura_ideal_dos_ombros(larguraIdealDosOmbros);
				objetomedidasideaisdto.setMassa_magra_ideal(massaMagraIdeal);
				objetomedidasideaisdto.setPanturrilha_ideal(panturrilhasIdeal);
				objetomedidasideaisdto.setPeitoral_ideal(peitoralIdeal);
				objetomedidasideaisdto.setPescoco_ideal(pescocoIdeal);
				objetomedidasideaisdto.setQuadril_ideal(quadrilIdeal);
				objetomedidasideaisdto.setUsuario_fk_usuario_id(fkUsuarioId);
				
				objetomedidasideaisdao.cadastrarMedidasIdeas(objetomedidasideaisdto);
		
		
		
	}
	
   	public ArrayList <MedidasIdeaisDTO> listarMedidasIdeais( ) {
		

		String sql="select * from medidas_fisico_ideal";
		
		
		DBconnection = new ConexaoDAO().connectDB(); 
		try {
			preparedStatment=DBconnection.prepareStatement(sql); 
			resultSet=preparedStatment.executeQuery();
			
			MedidasIdeaisDTO objetomedidasideaisdto = new MedidasIdeaisDTO();
			
			while (resultSet.next()) {
			objetomedidasideaisdto.setAntebracos_ideal(resultSet.getDouble("antebracos_ideal"));
			objetomedidasideaisdto.setBracos_ideal(resultSet.getDouble("bracos_ideal"));
			objetomedidasideaisdto.setCintura_ideal(resultSet.getDouble("cintura_ideal")); 
			objetomedidasideaisdto.setCircunferencia_ideal_dos_ombros(resultSet.getDouble("circunferencia_ideal_dos_ombros"));
			objetomedidasideaisdto.setCoxas_ideal(resultSet.getDouble("coxas_ideal"));
			objetomedidasideaisdto.setIndice_de_massa_magra_ideal(resultSet.getDouble("indice_de_massa_magra_ideal")); 
			objetomedidasideaisdto.setLargura_ideal_dos_ombros(resultSet.getDouble("largura_ideal_dos_ombros"));
			objetomedidasideaisdto.setMassa_magra_ideal(resultSet.getDouble("massa_magra_ideal"));
			objetomedidasideaisdto.setPanturrilha_ideal(resultSet.getDouble("panturrilhas_ideal"));  
			objetomedidasideaisdto.setPeitoral_ideal(resultSet.getDouble("peitoral_ideal")); 
			objetomedidasideaisdto.setPescoco_ideal(resultSet.getDouble("pescoco_ideal"));
			objetomedidasideaisdto.setQuadril_ideal(resultSet.getDouble("quadril_ideal"));
		
			
			
			listaMedidasIdeias.add(objetomedidasideaisdto);
			 
			}
			
			
		
		} catch (SQLException error) {
			JOptionPane.showMessageDialog(null,"MedidasIdeaisDAO Listar: " + error);
		}
		
		
		return listaMedidasIdeias;
		
	}

}
