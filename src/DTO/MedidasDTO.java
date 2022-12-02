package DTO;

public class MedidasDTO {
	
	
	
	int fk_usuario_id;
	
 String data;
	
	public int getFk_usuario_id() {
		return fk_usuario_id;
	}
	public void setFk_usuario_id(int fk_usuario_id) {
		this.fk_usuario_id = fk_usuario_id;
	}
	public double getFator_de_atividade_fisica() {
		return fator_de_atividade_fisica;
	}
	public void setFator_de_atividade_fisica(Double fator_de_atividade_fisica) {
		this.fator_de_atividade_fisica = fator_de_atividade_fisica;
	}
	
	public double getPescoco() {
		return pescoco;
	}
	public void setPescoco(double pescoco) {
		this.pescoco = pescoco;
	}
	public double getCintura() {
		return cintura;
	}
	public void setCintura(double cintura) {
		this.cintura = cintura;
	}
	public double getQuadril() {
		return quadril;
	}
	public void setQuadril(double quadril) {
		this.quadril = quadril;
	}
	public double getLargura_ombros() {
		return largura_ombros;
	}
	public void setLargura_ombros(double largura_ombros) {
		this.largura_ombros = largura_ombros;
	}
	public double getCircunferencia_ombros() {
		return circunferencia_ombros;
	}
	public void setCircunferencia_ombros(double circunferencia_ombros) {
		this.circunferencia_ombros = circunferencia_ombros;
	}
	public double getPeitoral() {
		return peitoral;
	}
	public void setPeitoral(double peitoral) {
		this.peitoral = peitoral;
	}
	public double getBraco() {
		return braco;
	}
	public void setBraco(double braco) {
		this.braco = braco;
	}
	public double getAntebraco() {
		return antebraco;
	}
	public void setAntebraco(double antebraco) {
		this.antebraco = antebraco;
	}
	public double getCoxa() {
		return coxa;
	}
	public void setCoxa(double coxa) {
		this.coxa = coxa;
	}
	public double getPanturrilha() {
		return panturrilha;
	}
	public void setPanturrilha(double panturrilha) {
		this.panturrilha = panturrilha;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	double pescoco, cintura, quadril, largura_ombros, circunferencia_ombros, peitoral, braco, antebraco, coxa, panturrilha, peso, fator_de_atividade_fisica;

	public void setData(String data) {
		this.data= data;
		
	}
	
	public String getData() {
		return data; 
	}
	
}
