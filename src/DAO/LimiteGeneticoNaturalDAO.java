package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import DTO.LimiteGeneticoNaturalDTO;


public class LimiteGeneticoNaturalDAO {
	
	 
	
	Connection DBconnection;
	PreparedStatement preparedStatment;
	ResultSet rs;
	ArrayList<LimiteGeneticoNaturalDTO> lista = new ArrayList<>();
	private Double[] limiteMassaMagra;
	private Double[] indiceDeMassaMagraNormalizado;
	private Double[] hgMedidas;
	private Double[] egMedidas;
	
	
	
	public double calcularPorcentagemDeGorduraIdealJacksonAndPollard(double idade) {	
		
		double porcentagemDeGorduraIdealJacksonAndPollard=0;
		
		
		
		if ((idade>=20)&&(idade<25)) {
			
				porcentagemDeGorduraIdealJacksonAndPollard=8.5;
			} else if ((idade>=25)&&(idade<30)) {
			
					porcentagemDeGorduraIdealJacksonAndPollard=10.5;
				} else if ((idade>=30)&&(idade<55)) { 
			
						porcentagemDeGorduraIdealJacksonAndPollard=12.7;
					} else if ((idade)>=35&&(idade<40)) {
			
							porcentagemDeGorduraIdealJacksonAndPollard=13.7;
						} else if ((idade)>=40&&(idade<45)) {
			
								porcentagemDeGorduraIdealJacksonAndPollard=15.3;
							} else if ((idade>=45)&&(idade<50)) { 
			
									porcentagemDeGorduraIdealJacksonAndPollard=16.4;
			
								} else if ((idade>=50)&&(idade<55)) {
			
										porcentagemDeGorduraIdealJacksonAndPollard=18.9;
									} else if (idade>=55) { 
			
											porcentagemDeGorduraIdealJacksonAndPollard=20.9;
		}
		      
			
		

		
		
		     return porcentagemDeGorduraIdealJacksonAndPollard;
		    
		      
	}
	
	public Double[] calcularLimitDeMassaMagra(double tornozelo, double punho, double altura, double porcentagemDeGorduraIdealJacksonAndPollard){
		
		altura= altura/2.54;
		punho= punho/2.54;
		tornozelo=tornozelo/2.54;
		
		
		limiteMassaMagra=null;
		
		double egLimiteDeMassaMagra, hgLimiteDeMassaMagra;
		
		hgLimiteDeMassaMagra = (altura*((punho/7.6364)+(tornozelo/6.2918))*((porcentagemDeGorduraIdealJacksonAndPollard/450)+1))/2.205;  
		egLimiteDeMassaMagra = (altura*((punho/7.2546)+(tornozelo/5.9772))*((porcentagemDeGorduraIdealJacksonAndPollard/450)+1))/2.205;  
		 
		
		limiteMassaMagra = new Double[] {hgLimiteDeMassaMagra, egLimiteDeMassaMagra};
		
		 
		 
		
		
		return limiteMassaMagra;
		
	}
	
	public Double[] calcularFfmiLimite(Double[] limitDeMassaMagra, double altura) {
		
		double alturaEmMetros;
		
		indiceDeMassaMagraNormalizado = null;
		
		
		
		alturaEmMetros = altura/100; 
		
		indiceDeMassaMagraNormalizado= new Double[] {((limiteMassaMagra[0]/Math.pow(alturaEmMetros,2))+(6.1*(1.8-alturaEmMetros))),
															((limiteMassaMagra[1]/Math.pow(alturaEmMetros,2))+(6.1*(1.8-alturaEmMetros)))};
	  

	  	
	  	return indiceDeMassaMagraNormalizado;
		
	}
	
	public Double[] calcularMedidasMaximasHardGainer(double punho, double tornozelo, double porcentagemDeGorduraIdealJacksonAndPollard) {
		
		hgMedidas = null;
		
		punho= punho/2.54;
		tornozelo=tornozelo/2.54;
		
		
		
		hgMedidas = new Double[] {((punho*2.2574)*((porcentagemDeGorduraIdealJacksonAndPollard/340)+1)*2.54),((punho*6.3138)*((porcentagemDeGorduraIdealJacksonAndPollard/340)+1)*2.54),
				((punho*2.3008)*((porcentagemDeGorduraIdealJacksonAndPollard/265)+1)*2.54),((punho*1.8514)*((porcentagemDeGorduraIdealJacksonAndPollard/340)+1)*2.54),
				((tornozelo*2.6785)*((porcentagemDeGorduraIdealJacksonAndPollard/190)+1)*2.54), ((tornozelo*1.7780)*((porcentagemDeGorduraIdealJacksonAndPollard/210)+1)*2.54)}; 
		
		
		
		
		
		
		return hgMedidas;
	}
	
	public Double[] calcularMedidasMaximasEasyGainer(double punho, double tornozelo, double porcentagemDeGorduraIdealJacksonAndPollard) {
		
		
		egMedidas = null;
		
		punho= punho/2.54;
		tornozelo=tornozelo/2.54;
		
		egMedidas = new Double[] {((punho*2.1858)*((porcentagemDeGorduraIdealJacksonAndPollard/340)+1)*2.54),((punho*5.9981)*((porcentagemDeGorduraIdealJacksonAndPollard/340)+1)*2.54),
				((punho*2.1858)*((porcentagemDeGorduraIdealJacksonAndPollard/265)+1)*2.54), ((punho*1.7588)*((porcentagemDeGorduraIdealJacksonAndPollard/340)+1)*2.54),
				((tornozelo*2.5446)*((porcentagemDeGorduraIdealJacksonAndPollard/190)+1)*2.54), ((tornozelo*1.6891)*((porcentagemDeGorduraIdealJacksonAndPollard/210)+1)*2.54)};
		
		
		
		
		 return egMedidas;
		
	}
	
	public void calcularLimiteGenetico(double porcentagemDeGorduraIdealJacksonAndPollard, Double[] limiteDeMassaMagra,Double[] indiceDeMassaMagraNormalizado, Double[] egMedidas, Double[] hgMedidas, int usuarioId ) {
		
		LimiteGeneticoNaturalDTO objetolimitedemassamagradto = new LimiteGeneticoNaturalDTO();
		
		
		
		objetolimitedemassamagradto.setEgLimite_pescoco(egMedidas[0]);
		objetolimitedemassamagradto.setEgLimite_peitoral(egMedidas[1]);
		objetolimitedemassamagradto.setEgLimite_bracos(egMedidas[2]);
		objetolimitedemassamagradto.setEgLimite_antebracos(egMedidas[3]);
		objetolimitedemassamagradto.setEgLimite_coxas(egMedidas[4]);
		objetolimitedemassamagradto.setEgLimite_panturrilhas(egMedidas[5]);
		objetolimitedemassamagradto.setEgLimite_de_massa_magra(limiteMassaMagra[1]);
		objetolimitedemassamagradto.setEg_ffmi(indiceDeMassaMagraNormalizado[1]);
		
		
		objetolimitedemassamagradto.setHgLimite_pescoco(hgMedidas[0]);
		objetolimitedemassamagradto.setHgLimite_peitoral(hgMedidas[1]);
		objetolimitedemassamagradto.setHgLimite_bracos(hgMedidas[2]);
		objetolimitedemassamagradto.setHgLimite_antebracos(hgMedidas[3]);
		objetolimitedemassamagradto.setHgLimite_coxas(hgMedidas[4]);
		objetolimitedemassamagradto.setHgLimite_panturrilhas(hgMedidas[5]);
		objetolimitedemassamagradto.setHgLimite_de_massa_magra(limiteMassaMagra[0]);
		objetolimitedemassamagradto.setHg_ffmi(indiceDeMassaMagraNormalizado[0]);
		
		 
		
		
		objetolimitedemassamagradto.setPorcentagem_de_gordura_ideal_Jackson_e_pollard(porcentagemDeGorduraIdealJacksonAndPollard);
		
		objetolimitedemassamagradto.setFk_usuario_id(usuarioId);
		
		LimiteGeneticoNaturalDAO objetolimitedemassamagradao = new LimiteGeneticoNaturalDAO();  
		objetolimitedemassamagradao.salvarLimiteGeneticoNatural(objetolimitedemassamagradto);
		
	}
	
	
	
    public void  salvarLimiteGeneticoNatural (LimiteGeneticoNaturalDTO objetolimitegeneticonaturaldto) {
    	
    	String sql = "insert into limite_genetico_natural (eg_limite_pescoco, eg_limite_peitoral, eg_limite_bracos, eg_limite_antebracos, eg_limite_coxas, eg_limite_panturrilhas,eg_limite_de_massa_magra,  eg_ffmi,"
    			+ "percentual_de_gordura_ideal_para_Idade,hg_limite_pescoco, hg_limite_peitoral, hg_limite_bracos, hg_limite_antebracos, hg_limite_coxas, hg_limite_panturrilhas, hg_limite_de_massa_magra,hg_ffmi, "
    			+ "usuario_pk_usuario_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	
    	DBconnection = new ConexaoDAO().connectDB();
    	
    	try {
			
    		preparedStatment = DBconnection.prepareStatement(sql);
    		preparedStatment.setDouble(1, objetolimitegeneticonaturaldto.getEgLimite_pescoco()); 
    		preparedStatment.setDouble(2,objetolimitegeneticonaturaldto.getEgLimite_peitoral());
    		preparedStatment.setDouble(3,objetolimitegeneticonaturaldto.getEgLimite_bracos());
    		preparedStatment.setDouble(4,objetolimitegeneticonaturaldto.getEgLimite_antebracos());
    		preparedStatment.setDouble(5,objetolimitegeneticonaturaldto.getEgLimite_coxas());
    		preparedStatment.setDouble(6,objetolimitegeneticonaturaldto.getEgLimite_panturrilhas()); 
    		preparedStatment.setDouble(7,objetolimitegeneticonaturaldto.getEgLimite_de_massa_magra());
    		preparedStatment.setDouble(8,objetolimitegeneticonaturaldto.getEg_ffmi());
    		
    		
    		preparedStatment.setDouble(10, objetolimitegeneticonaturaldto.getHgLimite_pescoco()); 
    		preparedStatment.setDouble(11,objetolimitegeneticonaturaldto.getHgLimite_peitoral());
    		preparedStatment.setDouble(12,objetolimitegeneticonaturaldto.getHgLimite_bracos());
    		preparedStatment.setDouble(13,objetolimitegeneticonaturaldto.getHgLimite_antebracos());
    		preparedStatment.setDouble(14,objetolimitegeneticonaturaldto.getHgLimite_coxas());
    		preparedStatment.setDouble(15,objetolimitegeneticonaturaldto.getHgLimite_panturrilhas());
    		preparedStatment.setDouble(16,objetolimitegeneticonaturaldto.getHgLimite_de_massa_magra());
    		preparedStatment.setDouble(17,objetolimitegeneticonaturaldto.getHg_ffmi());
    		 
    		preparedStatment.setDouble(9,objetolimitegeneticonaturaldto.getPorcentagem_de_gordura_ideal_Jackson_e_pollard());
    		
    		preparedStatment.setInt(18, objetolimitegeneticonaturaldto.getFk_usuario_id());
    		
    		
    		
    		preparedStatment.execute();
			preparedStatment.close();
			
    		 
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "LimiteGeneticoNsturalDAO Cadastrar: " + e);
		}  
		
    }
    	

    	
    	public ArrayList <LimiteGeneticoNaturalDTO> listarLimiteGeneticoNatural( ) {
    		

    		String sql="select * from limite_genetico_natural";
    		
    		
    		DBconnection = new ConexaoDAO().connectDB(); 
    		try {
    			preparedStatment=DBconnection.prepareStatement(sql); 
    			rs=preparedStatment.executeQuery();
    			
    			LimiteGeneticoNaturalDTO objetolimitegeneticonaturaldto = new LimiteGeneticoNaturalDTO();
    			
    			while (rs.next()) {
    			objetolimitegeneticonaturaldto.setHgLimite_pescoco(rs.getDouble("hg_limite_pescoco"));
				objetolimitegeneticonaturaldto.setHgLimite_peitoral(rs.getDouble("hg_limite_peitoral"));
				objetolimitegeneticonaturaldto.setHgLimite_bracos(rs.getDouble("hg_limite_bracos")); 
				objetolimitegeneticonaturaldto.setHgLimite_antebracos(rs.getDouble("hg_Limite_antebracos"));
				objetolimitegeneticonaturaldto.setHgLimite_coxas(rs.getDouble("hg_limite_coxas"));
				objetolimitegeneticonaturaldto.setHgLimite_panturrilhas(rs.getDouble("hg_limite_panturrilhas")); 
				objetolimitegeneticonaturaldto.setHgLimite_de_massa_magra(rs.getDouble("hg_limite_de_massa_magra"));
				objetolimitegeneticonaturaldto.setHg_ffmi(rs.getDouble("hg_ffmi"));
				
				objetolimitegeneticonaturaldto.setEgLimite_pescoco(rs.getDouble("eg_limite_pescoco"));  
				objetolimitegeneticonaturaldto.setEgLimite_peitoral(rs.getDouble("eg_limite_peitoral")); 
				objetolimitegeneticonaturaldto.setEgLimite_bracos(rs.getDouble("eg_limite_bracos"));
				objetolimitegeneticonaturaldto.setEgLimite_antebracos(rs.getDouble("eg_Limite_antebracos"));
				objetolimitegeneticonaturaldto.setEgLimite_coxas(rs.getDouble("eg_limite_coxas"));
				objetolimitegeneticonaturaldto.setEgLimite_panturrilhas(rs.getDouble("eg_limite_panturrilhas"));
				objetolimitegeneticonaturaldto.setEgLimite_de_massa_magra(rs.getDouble("eg_limite_de_massa_magra"));
				objetolimitegeneticonaturaldto.setEg_ffmi(rs.getDouble("eg_ffmi"));
				
				objetolimitegeneticonaturaldto.setPorcentagem_de_gordura_ideal_Jackson_e_pollard(rs.getDouble("percentual_de_gordura_ideal_para_Idade"));
				
				lista.add(objetolimitegeneticonaturaldto);
				 
    			}
				
    			
    		
    		} catch (SQLException error) {
    			JOptionPane.showMessageDialog(null,"limiteDAO Listar: " + error);
    		}
    		
    		
    		return lista;
    		
    	}
    	
 	
}

