package DTO;

public class RefeicaoDTO {
	
	private String nome_alimento, nomeRefeicao;  
	
	public String getNomeRefeicao() {
		return nomeRefeicao;
	}
	public void setNomeRefeicao(String nomeRefeicao) {
		this.nomeRefeicao = nomeRefeicao;
	}
	double porcao, carbohidratos, proteinas, gorduras_totais, fibras, sodio, kcals;
	
	public String getNome_alimento() {
		return nome_alimento;
	}
	public void setNome_alimento(String nome_alimento) {
		this.nome_alimento = nome_alimento;
	}
	public double getPorcao() {
		return porcao;
	}
	public void setPorcao(double porcao) {
		this.porcao = porcao;
	}
	public double getCarbohidratos() {
		return carbohidratos;
	}
	public void setCarbohidratos(double carbohidratos) {
		this.carbohidratos = carbohidratos;
	}
	public double getProteinas() {
		return proteinas;
	}
	public void setProteinas(double proteinas) {
		this.proteinas = proteinas;
	}
	public double getGorduras_totais() {
		return gorduras_totais;
	}
	public void setGorduras_totais(double gorduras_totais) {
		this.gorduras_totais = gorduras_totais;
	}
	public double getFibras() {
		return fibras;
	}
	public void setFibras(double fibras) {
		this.fibras = fibras;
	}
	public double getSodio() {
		return sodio;
	}
	public void setSodio(double sodio) {
		this.sodio = sodio;
	}
	public double getKcals() {
		return kcals;
	}
	public void setKcals(double kcals) {
		this.kcals = kcals;
	}
	
	public int getIndice_glicemico() {
		return indice_glicemico;
	}
	public void setIndice_glicemico(int indice_glicemico) {
		this.indice_glicemico = indice_glicemico;
	}
	public int getFk_usuario_id() {
		return fk_usuaio_id;
	}
	public void setFk_usuario_id(int fk_usuaio_id) {
		this.fk_usuaio_id = fk_usuaio_id;
	}
	public int getFk_alimento_id() {
		return fk_alimento_id;
	}
	public void setFk_alimento_id(int fk_alimento_id) {
		this.fk_alimento_id = fk_alimento_id;
	}
	int indice_glicemico, fk_usuaio_id, fk_alimento_id, pk_refeicao_id;

	public int getPk_refeicao_id() {
		return pk_refeicao_id;
	}
	public void setPk_refeicao_id(int pk_refeicao_id) {
		this.pk_refeicao_id = pk_refeicao_id;
	}

	
}
