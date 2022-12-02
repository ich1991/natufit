package DTO;

public class AvaliacaoDTO {
	
	int fk_medidas_id, fk_usuario_id;
	
    public int getFk_usuario_id() {
		return fk_usuario_id;
	}

	public void setFk_usuario_id(int fk_usuario_id) {
		this.fk_usuario_id = fk_usuario_id;
	}

	public int getFk_medidas_id() {
		return fk_medidas_id;
	}

	public void setFk_medidas_id(int fk_medidas_id) {
		this.fk_medidas_id = fk_medidas_id;
	}

	public double getPorcentagem_de_gordura_corporal() {
		return porcentagem_de_gordura_corporal;
	}

	public void setPorcentagem_de_gordura_corporal(double porcentagem_de_gordura_corporal) {
		this.porcentagem_de_gordura_corporal = porcentagem_de_gordura_corporal;
	}

	public double getMassa_gorda() {
		return massa_gorda;
	}

	public void setMassa_gorda(double massa_gorda) {
		this.massa_gorda = massa_gorda;
	}

	public double getMassa_magra() {
		return massa_magra;
	}

	public void setMassa_magra(double massa_magra) {
		this.massa_magra = massa_magra;
	}

	public double getIndice_de_de_massa_magra() {
		return indice_de_de_massa_magra;
	}

	public void setIndice_de_de_massa_magra(double indice_de_de_massa_magra) {
		this.indice_de_de_massa_magra = indice_de_de_massa_magra;
	}

	public double getTaxa_metablica_basal() {
		return taxa_metablica_basal;
	}

	public void setTaxa_metablica_basal(double taxa_metablica_basal) {
		this.taxa_metablica_basal = taxa_metablica_basal;
	}

	public String getStatus() {
		return resultadoEstrategia;
	}

	public void setResultadoEstrategia(String resultadoEstrategia) {
		this.resultadoEstrategia = resultadoEstrategia;
	}

	public double getFator_de_atividae_fisica() {
		return fator_de_atividae_fisica;
	}

	public void setFator_de_atividae_fisica(double fator_de_atividae_fisica) {
		this.fator_de_atividae_fisica = fator_de_atividae_fisica;
	}
 
	public String getCategoria_indice_de_massa_magra() { 
		return categoria_indice_de_massa_magra;
	}

	public void setCategoria_indice_de_massa_magra(String categoria_indice_de_massa_magra) {
		this.categoria_indice_de_massa_magra = categoria_indice_de_massa_magra;
	}

	public String getIndice_de_massa_gorda() {
		return indice_de_massa_gorda;
	}

	public void setIndice_de_massa_gorda(String indice_de_massa_gorda) {
		this.indice_de_massa_gorda = indice_de_massa_gorda;
	}

	double porcentagem_de_gordura_corporal, massa_gorda, massa_magra, indice_de_de_massa_magra,  taxa_metablica_basal, fator_de_atividae_fisica, historico_de_medidas_magras;
    
    public double getHistorico_de_medidas_magras() {
		return historico_de_medidas_magras;
	}

	public void setHistorico_de_medidas_magras(double historico_de_medidas_magras) {
		this.historico_de_medidas_magras = historico_de_medidas_magras;
	}

	String categoria_indice_de_massa_magra, indice_de_massa_gorda, resultadoEstrategia;
}
