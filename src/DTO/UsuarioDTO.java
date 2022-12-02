package DTO;

public class UsuarioDTO {
	
	
	int pk_usuario_id, idade;
	
	private double altura,  punho, tornozelo;
	
	public int getPk_usuario_id() {
		return pk_usuario_id;
	}
	public void setPk_usuario_id(int usuarioID) {
		this.pk_usuario_id = usuarioID;
	}
	

	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getPunho() {
		return punho;
	}
	public void setPunho(double punho) {
		this.punho = punho;
	}
	public double getTornozelo() {
		return tornozelo;
	}
	public void setTornozelo(double tornozelo) {
		this.tornozelo = tornozelo;
	}
	
	
	
}
