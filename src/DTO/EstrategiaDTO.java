package DTO;

public class EstrategiaDTO {
	
	double necessidade_calorica;
	int avaliacoes_pk_avaliacao_id;
	String anotacoes;
	
	
	public String getAnotacoes() {
		return anotacoes;
	}
	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}
	public double getNecessidade_calorica() {
		return necessidade_calorica;
	}
	public void setNecessidade_calorica(double necessidade_calorica) {
		this.necessidade_calorica = necessidade_calorica;
	}
	public int getAvaliacoes_pk_avaliacao_id() {
		return avaliacoes_pk_avaliacao_id;
	}
	public void setAvaliacoes_pk_avaliacao_id(int avaliacoes_pk_avaliacao_id) {
		this.avaliacoes_pk_avaliacao_id = avaliacoes_pk_avaliacao_id;
	}

}
