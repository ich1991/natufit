package DTO;

public class AlimentoDTO {
	
	int pk_alimento_id, indidce_glicemico, valor_biologico, fk_usuario_id;
	private String nome, grupo_alimentar;
	
	
	public int getPk_alimento_id() {
		return pk_alimento_id;
	}
	public void setPk_alimento_id(int pk_alimento_id) {
		this.pk_alimento_id = pk_alimento_id;
	}
	public int getIndidce_glicemico() {
		return indidce_glicemico;
	}
	public void setIndidce_glicemico(int indidce_glicemico) {
		this.indidce_glicemico = indidce_glicemico;
	}
	public int getValor_biologico() {
		return valor_biologico;
	}
	public void setValor_biologico(int valor_biologico) {
		this.valor_biologico = valor_biologico;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGrupo_alimentar() {
		return grupo_alimentar;
	}
	public void setGrupo_alimentar(String grupo_alimentar) {
		this.grupo_alimentar = grupo_alimentar;
	}

	public double getPorcao_amostral() {
		return porcao_amostral;
	}
	public void setPorcao_amostral(double porcao_amostral) {
		this.porcao_amostral = porcao_amostral;
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

	public double getFibra_alimentar() {
		return fibra_alimentar;
	}
	public void setFibra_alimentar(double fibra_alimentar) {
		this.fibra_alimentar = fibra_alimentar;
	}
	public double getSodio() {
		return sodio;
	}
	public void setSodio(double sodio) {
		this.sodio = sodio;
	}
	public int getFk_usuario_id() {
		return fk_usuario_id;
	}
	public void setFk_usuario_id(int fk_usuario_id) {
		this.fk_usuario_id = fk_usuario_id;
	}
	double porcao_amostral, carbohidratos, proteinas, gorduras_totais, fibra_alimentar, sodio;

}


