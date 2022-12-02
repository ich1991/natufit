package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.AlimentoDAO;
import DAO.AvaliacaoDAO;
import DAO.ConexaoDAO;
import DAO.EstrategiaDAO;
import DAO.LimiteGeneticoNaturalDAO;
import DAO.MedidasDAO;
import DAO.MedidasIdeaisDAO;
import DAO.RefeicaoDAO;
import DAO.UsuarioDAO;
import DTO.AlimentoDTO;
import DTO.AvaliacaoDTO;
import DTO.EstrategiaDTO;
import DTO.LimiteGeneticoNaturalDTO;
import DTO.MedidasDTO;
import DTO.MedidasIdeaisDTO;
import DTO.RefeicaoDTO;
import DTO.UsuarioDTO;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.CaretEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;

public class UserInterface extends JFrame {

	
	private JPanel contentPane;
	JPanel panelTelas;
	
	JLayeredPane lpTelasPrincipais;
	private JTextField textNomeAlimento;
	private JComboBox <String>textGrupoAlimentar;
	private JTextField textIndiceGlicemico;
	private JTextField textValorBiologico;
	private JTextField textPorcaoAmostral;
	private JTextField textCarbohidratos;
	private JTextField textProteinas;
	private JTextField textGordurasTotais;
	private JTable tabelaAlimento;
	private JTextField textFibraAlimentar;
	private JTextField textSodio;
	private JTable tabelaGruposAlimentares;
	JComboBox <String>selecionarGrupoAlimentar;
	JComboBox <String>selecionarRefeicao;
	private JTable tabelaRefeicao;
	JLabel txtnomeAlimento;
	private JTextField txtPorcao;
	JLabel txtCarbohidratos;
	JLabel txtProteinas;
	JLabel txtGordurasTotais;
	JLabel txtFibras;
	JLabel txtSodio;
	JLabel txtCalorias;
	JLabel idAlimento;
	JLabel prCarbs;
	JLabel prProt;
	JLabel prGor;
	JLabel prFibras;
	JLabel prSod;
	JLabel prKcal;
	JLabel txtIG;
	JLabel txtCarboDieta;
	JLabel txtProtDieta;
	JLabel txtGordDieta;
	JLabel txtSodioDieta;
	JLabel txtKcalsDieta;
	JPanel panelCadastroAlimentos;
	private JPanel panelMenu;
	private JLabel lblCadastrarAvaliacao;
	private JLabel lblCadastrarDieta;
	private JLabel lblCadastrarAlimento;
	private JLabel lblPainel;
	private JLabel lblInicio;
	private JLabel lblNewLabel_7;
	JPanel panelCadastroRefeicoes;
	JLabel txtCargaGlicemica;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_8_1;
	private JLabel txtRefeicaoId;
	private JLabel txtNomeAl;
	private JPanel panelCadastroDemaisAvaliacoes;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_6_7;
	private JLabel lblNewLabel_6_8;
	private JLabel lblNewLabel_6_9;
	private JLabel lblNewLabel_6_10;
	private JLabel lblNewLabel_6_11;
	private JLabel lblNewLabel_6_12;
	private JTextField txtOmbros;
	private JTextField txtPeitoral;
	private JTextField txtBracos;
	private JTextField txtAntebracos;
	private JTextField txtQuadril;
	private JTextField txtCoxa;
	private JTextField txtPanturrilhas;
	private JLabel lblNewLabel_5_2;
	private JTextField txtCintura;
	private JTextField txtPeso;
	private JTextField txtPescoco;
	private JLabel lblNewLabel_6_3_2;
	private JLabel lblNewLabel_6_6_2;
	private JTextField txtLarguraOmbros;
	private JLabel lblNewLabel_6_2_3;
	private JLabel lblNewLabel_6_2_4;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_22;
	private JLabel lblNewLabel_23;
	private JLabel lblNewLabel_24;
	private JLabel lblNewLabel_25;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_27;
	private JLabel lblNewLabel_28;
	private JLabel lblNewLabel_29;
	private JLabel lblNewLabel_30;
	private JLabel lblNewLabel_31;
	private JLabel lblNewLabel_32;
	private JLabel lblNewLabel_33;
	private JLabel lblNewLabel_34;
	private JLabel lblNewLabel_35;
	private JLabel lblNewLabel_36;
	private JLabel lblNewLabel_37;
	private JPanel panelEasyGainer;
	private JLabel egPescoco;
	private JLabel egPeitoral;
	private JLabel egBraco;
	private JLabel egAntebraco;
	private JLabel egCoxa;
	private JLabel egPanturrilha;
	private JLabel egMassaMagra;
	private JLabel egFfmi;
	private JLabel egBfIdeal;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_2_1_8_4_1;
	private JLabel lblNewLabel_3_2_1_8_5_1;
	private JLabel lblNewLabel_3_2_1_8_6_1;
	private JLabel lblNewLabel_3_2_1_8_7_1;
	private JLabel lblNewLabel_3_2_1_8_8_1;
	private JLabel lblNewLabel_3_2_1_8_9_1;
	private JLabel lblNewLabel_3_2_1_8_10_1;
	private JLabel lblNewLabel_3_2_1_8_11_1;
	private JLabel lblNewLabel_3_2_1_8_12_1;
	private JPanel panelHardGainer;
	private JLabel hgPeitoral;
	private JLabel hgBraco;
	private JLabel hgPescoco;
	private JLabel hgAntebraco;
	private JLabel hgCoxa;
	private JLabel hgPanturrilha;
	private JLabel hgMassaMagra;
	private JLabel hgFfmi;
	private JLabel hgBfIdeal;
	private JLabel lblNewLabel_3_2_1_8_3;
	private JLabel lblNewLabel_3_2_1_8_4;
	private JLabel lblNewLabel_3_2_1_8_5;
	private JLabel lblNewLabel_3_2_1_8_6;
	private JLabel lblNewLabel_3_2_1_8_7;
	private JLabel lblNewLabel_3_2_1_8_8;
	private JLabel lblNewLabel_3_2_1_8_9;
	private JLabel lblNewLabel_3_2_1_8_10;
	private JLabel lblNewLabel_3_2_1_8_11;
	private JPanel panelFisicoIdeal;
	private JProgressBar pbpescoco;
	private JProgressBar pbombros;
	private JProgressBar pbLarguraOmbros;
	private JProgressBar pbPeitoral;
	private JProgressBar pbBracos;
	private JProgressBar pbAntebracos;
	private JProgressBar pbCintura;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblNewLabel_3_2_1_1;
	private JLabel lblNewLabel_3_2_1_2;
	private JLabel lblNewLabel_3_2_1_3;
	private JLabel lblNewLabel_3_2_1_4;
	private JLabel lblNewLabel_3_2_1_5;
	private JLabel lblNewLabel_3_2_1_6;
	private JLabel lblNewLabel_3_2_1_7;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_3_2_1_7_1;
	private JLabel lblNewLabel_3_2_1_7_2;
	private JProgressBar pbQuadril;
	private JProgressBar pbCoxas;
	private JProgressBar pbPanturrilhas;
	private JLabel lblNewLabel_3_2_1_7_2_1;
	private JLabel lblNewLabel_3_2_1_7_2_2;
	private JProgressBar pbMassaMagra;
	private JProgressBar pbffmi;
	private JLabel idpescoco;
	private JLabel idOmbros;
	private JLabel idLarguraOmbros;
	private JLabel idPeitoral;
	private JLabel idBracos;
	private JLabel idAntebracos;
	private JLabel idCintura;
	private JLabel idQuadril;
	private JLabel idCoxas;
	private JLabel idPanturrilhas;
	private JLabel idMassaMagra;
	private JLabel idFFMI;
	private JProgressBar pbBf;
	private JLabel lblNewLabel_3_2_1_7_2_2_1;
	private JLabel idBf;
	private JPanel panelComposicaoCorporal;
	private JLabel lblNewLabel_2_1_1_1;
	private JLabel bfAtual;
	private JLabel gorduraKG;
	private JLabel ffmiAtual;
	private JLabel massaMagraKG;
	private JLabel classificacaoFFMI;
	private JLabel lblNewLabel_3_2_1_12;
	private JLabel lblNewLabel_3_2_1_8;
	private JLabel lblNewLabel_3_2_1_8_1;
	private JLabel classificacaobf;
	private JLabel lblNewLabel_3_2_1_12_1;
	private JLabel lblNewLabel_3_2_1;
	private JLabel lblNewLabel_3_2;
	private JLabel txtNomeRefeicaoEx;
	private JPanel panelCadastroPrimeiraAvaliacao;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_6_1;
	private JLabel lblNewLabel_6_2;
	private JLabel lblNewLabel_6_3;
	private JLabel lblNewLabel_6_4;
	private JLabel lblNewLabel_6_5;
	private JTextField textCircunferenciaOmbros;
	private JTextField textPeitoral;
	private JTextField textBraco;
	private JTextField textAntebraco;
	private JTextField textQuadril;
	private JTextField textCoxa;
	private JTextField textPanturrilha;
	private JLabel lblNewLabel_5_1;
	private JTextField textCintura;
	private JTextField textPeso;
	private JTextField textPescoco;
	private JLabel lblNewLabel_6_3_1;
	private JLabel lblNewLabel_6_6;
	private JTextField textLarguraOmbros;
	private JLabel lblNewLabel_6_2_1;
	private JLabel lblNewLabel_6_2_2;
	private JLabel lblNewLabel_26;
	private JLabel lblNewLabel_38;
	private JLabel lblNewLabel_39;
	private JLabel lblNewLabel_40;
	private JLabel lblNewLabel_41;
	private JLabel lblNewLabel_42;
	private JLabel lblNewLabel_43;
	private JLabel lblNewLabel_44;
	private JLabel lblNewLabel_45;
	private JLabel lblNewLabel_46;
	private JLabel lblNewLabel_47;
	private JLabel lblNewLabel_48;
	private JLabel lbl;
	private JTextField textIdade;
	private JLabel lblNewLabel_49;
	private JLabel lbl_1;
	private JTextField textAltura;
	private JLabel lblNewLabel_50;
	private JLabel lbl_2;
	private JTextField textPunho;
	private JLabel lblNewLabel_51;
	private JLabel lbl_3;
	private JTextField textTornozelo;
	private JLabel lblNewLabel_52;
	private JLabel lbl_4;
	private JComboBox<String> textFatorDeAtividadeFisica;
	private JPanel panel_1;
	JPanel panelInicio;
	JLabel txtNecessidadeCalorica;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblNewLabel_2_1_1_1_1;
	private JEditorPane Anotacoes;
	private JLabel lblNewLabel_53;

public int verificarUsuario() {
	int usuarioId=0;
	
	
		UsuarioDAO objetousuariodao = new UsuarioDAO();
	ResultSet rs= objetousuariodao.pesquisarUsuarioId(); 
	try {
		
		while(rs.next()) {
		usuarioId=(rs.getInt("pk_usuario_id")); 
		}
	} catch (SQLException e) {
		
		JOptionPane.showMessageDialog(null, "verificasUsuario" + e);
	}
	
	return usuarioId;
}

public double verificarNecessideEnergetica() {
	double kCals=0;
	
	
		EstrategiaDAO objetoestrategiadao = new EstrategiaDAO();
	ResultSet rs= objetoestrategiadao.pesquisarEstrategia(); 
	try {
		
		while(rs.next()) {
		kCals=(rs.getInt("necessidade_calorica")); 
		}
	} catch (SQLException e) {
		
		JOptionPane.showMessageDialog(null, "verificarNecessidadeCalorica " + e);
	}
	
	return kCals;
}

public void verificarAnotacoes() {
	String anotacoes=null;
	
	
		EstrategiaDAO objetoestrategiadao = new EstrategiaDAO();
	ResultSet rs= objetoestrategiadao.pesquisarEstrategia(); 
	try {
		
		while(rs.next()) {
		anotacoes=(rs.getString("anotacoes")); 
		}
	} catch (SQLException e) {
		
		JOptionPane.showMessageDialog(null, "verificarAnotacoes " + e);
	}
	
	Anotacoes.setText(anotacoes);
}

public int verificarEstrategiaId() {
	int estrategiaId = 0;
	
	
		EstrategiaDAO objetoestrategiadao = new EstrategiaDAO();
	ResultSet rs= objetoestrategiadao.pesquisarEstrategia(); 
	try {
		
		while(rs.next()) {
		estrategiaId=(rs.getInt("pk_estrategia_id")); 
		}
	} catch (SQLException e) {
		
		JOptionPane.showMessageDialog(null, "verificarEstrategiaId " + e);
	}
	
	return estrategiaId;
}

public double verifivarFatorDeAtividadeFisica( ) {
	
  double fatorDeAtividadeFisica = 0;
	
	AvaliacaoDAO objetoavaliacaodao = new AvaliacaoDAO();
	ResultSet rs = objetoavaliacaodao.pesquisarFatorDeAtividadeFisica();
	
	try {
	
	while(rs.next()) {
		fatorDeAtividadeFisica=(rs.getDouble("fator_de_atividade_fisica")); 
		}
	} catch (SQLException e) {
		
		JOptionPane.showMessageDialog(null, "verificarFdAF " + e);
	}

	
	return fatorDeAtividadeFisica;

}


public int verificarAltura() {
	int altura=0;
	
	
		UsuarioDAO objetousuariodao = new UsuarioDAO();
	ResultSet rs= objetousuariodao.pesquisarUsuarioId(); 
	try {
		
		while(rs.next()) {
		altura=(rs.getInt("altura")); 
		}
	} catch (SQLException e) {
		
		JOptionPane.showMessageDialog(null, "VerificarAltura " + e);
	}
	
	return altura;
}


public int verificarMedidas() {
	int medidasId=0;
	
	
		MedidasDAO objetomedidasdao = new MedidasDAO();
	ResultSet rs= objetomedidasdao.pesquisarMedidasId(); 
	try {
		
		while(rs.next()) {
			medidasId=(rs.getInt("pk_medidas_id")); 
		}
	} catch (SQLException e) {
		
		JOptionPane.showMessageDialog(null, "VerificarMedidas " + e);
	}
	
	return medidasId;
}

public int verificarAvaliacao() {
	int medidasId=0;
	
	
		AvaliacaoDAO objetoavaliacodao = new AvaliacaoDAO();
	ResultSet rs= objetoavaliacodao.pesquisarAvaliacaoId(); 
	try {
		
		while(rs.next()) {
			medidasId=(rs.getInt("pk_avaliacao_id")); 
		}
	} catch (SQLException e) {
		
		JOptionPane.showMessageDialog(null, "VerificarAvaliaçãoId " + e);
	}
	
	return medidasId;
}

public void inicializador(int usuarioId){
	
	
        panelCadastroAlimentos.setVisible(false);
		panelCadastroRefeicoes.setVisible(false);
		
	if(usuarioId!=0) {
		
		panelInicio.setVisible(false);
		imprimirAvaliacaoAtual();
		imprimirLimiteGeneticoNatural();
		imprimirMedidasIdeais();
		imprimirMedidasAtuais();
		listarAlimento();
		listarRefeicao();
		listarAlimentosPorGrupo();
		imprimirMacrosDaRefeicao(verificarNecessideEnergetica());
		calcularCargaGlicemicaRefeicao();
		verificarAnotacoes();
		
		
		
	}
}

public void cadastrarUsuario() {
		
	
		
		int idade;
		Double  altura, punho, tornozelo;
		
		
		

		idade = Integer.parseInt(textIdade.getText());
		altura = Double.parseDouble(textAltura.getText());
		punho = Double.parseDouble(textPunho.getText());
		tornozelo = Double.parseDouble(textTornozelo.getText());
		
		
		
		
		
	
		UsuarioDTO objetousuariodto = new UsuarioDTO(); 
		objetousuariodto.setAltura(altura);
		objetousuariodto.setPunho(punho);
		objetousuariodto.setTornozelo(tornozelo);
		objetousuariodto.setIdade(idade);
		
		UsuarioDAO objetousuariodtotodao = new UsuarioDAO();
		objetousuariodtotodao.cadastrarUsuario(objetousuariodto);
		
		
		
	}
public void cadastrarMedidasIdeais() {
	
	Double  altura, punho, idade;
	
	altura = Double.parseDouble(textAltura.getText());
	punho = Double.parseDouble(textPunho.getText()); 
	idade = Double.parseDouble(textIdade.getText());
	
	
	MedidasIdeaisDAO objetomedidasideais = new MedidasIdeaisDAO();
	LimiteGeneticoNaturalDAO objetolimitegenetico = new LimiteGeneticoNaturalDAO();
	objetomedidasideais.calcularMedidasIdeais(punho, altura, objetolimitegenetico.calcularPorcentagemDeGorduraIdealJacksonAndPollard(idade), verificarUsuario());
	
}
void cadstrarlimiteGeneticoNatural(){

	
	int idade;
	Double  altura, punho, tornozelo;
	
	
	idade = Integer.parseInt(textIdade.getText());
	altura = Double.parseDouble(textAltura.getText());
	punho = Double.parseDouble(textPunho.getText()); 
	tornozelo = Double.parseDouble(textTornozelo.getText());
	
		
		LimiteGeneticoNaturalDAO objetolimitegeneticonaturaldao = new LimiteGeneticoNaturalDAO();
		  
		 
	
		 		 objetolimitegeneticonaturaldao.calcularLimiteGenetico(objetolimitegeneticonaturaldao.calcularPorcentagemDeGorduraIdealJacksonAndPollard(idade),
				 objetolimitegeneticonaturaldao.calcularLimitDeMassaMagra(tornozelo, punho, altura, objetolimitegeneticonaturaldao.calcularPorcentagemDeGorduraIdealJacksonAndPollard(idade)), 
				 objetolimitegeneticonaturaldao.calcularFfmiLimite(objetolimitegeneticonaturaldao.calcularLimitDeMassaMagra(tornozelo,punho, altura, objetolimitegeneticonaturaldao.calcularPorcentagemDeGorduraIdealJacksonAndPollard(idade)), altura),
				 objetolimitegeneticonaturaldao.calcularMedidasMaximasHardGainer(punho, tornozelo, objetolimitegeneticonaturaldao.calcularPorcentagemDeGorduraIdealJacksonAndPollard(idade)),
				 objetolimitegeneticonaturaldao.calcularMedidasMaximasEasyGainer(punho, tornozelo, objetolimitegeneticonaturaldao.calcularPorcentagemDeGorduraIdealJacksonAndPollard(idade)),
				 verificarUsuario()); 
		 
		 
		
} 
 
 public void imprimirLimiteGeneticoNatural() {
	 
	 
	 
		LimiteGeneticoNaturalDAO objetolimitegeneticonaturaldao = new LimiteGeneticoNaturalDAO();
		
		
	ArrayList <LimiteGeneticoNaturalDTO> lista = objetolimitegeneticonaturaldao.listarLimiteGeneticoNatural();
		
	
	 DecimalFormat formatarDecimal = new DecimalFormat("0.0", DecimalFormatSymbols.getInstance(Locale.US));

		
		egPescoco.setText(formatarDecimal.format(lista.get(0).getEgLimite_pescoco())+" cm");
		egPeitoral.setText(formatarDecimal.format(lista.get(0).getEgLimite_peitoral())+" cm");
		egBraco.setText(formatarDecimal.format(lista.get(0).getEgLimite_bracos())+" cm");
		egAntebraco.setText(formatarDecimal.format(lista.get(0).getEgLimite_antebracos())+" cm"); 
		egCoxa.setText(formatarDecimal.format(lista.get(0).getEgLimite_coxas())+" cm");
		egPanturrilha.setText(formatarDecimal.format(lista.get(0).getEgLimite_panturrilhas())+" cm");
		egMassaMagra.setText(formatarDecimal.format(lista.get(0).getEgLimite_de_massa_magra())+" Kg");
		egFfmi.setText(formatarDecimal.format(lista.get(0).getEg_ffmi())); 
		egBfIdeal.setText(formatarDecimal.format(lista.get(0).getPorcentagem_de_gordura_ideal_Jackson_e_pollard())+" %");
		
		hgPescoco.setText(formatarDecimal.format(lista.get(0).getHgLimite_pescoco())+" cm");
		hgPeitoral.setText(formatarDecimal.format(lista.get(0).getHgLimite_peitoral())+" cm");
		hgBraco.setText(formatarDecimal.format(lista.get(0).getHgLimite_bracos())+" cm");
		hgAntebraco.setText(formatarDecimal.format(lista.get(0).getHgLimite_antebracos())+" cm");  
		hgCoxa.setText(formatarDecimal.format(lista.get(0).getHgLimite_coxas())+" cm");
		hgPanturrilha.setText(formatarDecimal.format(lista.get(0).getHgLimite_panturrilhas())+" cm");
		hgMassaMagra.setText(formatarDecimal.format(lista.get(0).getHgLimite_de_massa_magra())+" Kg");
		hgFfmi.setText(formatarDecimal.format(lista.get(0).getHg_ffmi()));
		hgBfIdeal.setText(formatarDecimal.format(lista.get(0).getPorcentagem_de_gordura_ideal_Jackson_e_pollard())+" %");
		
	 
 }
 

 public void imprimirMedidasIdeais() {
	 
	 MedidasIdeaisDAO objetomedidasideaisdao = new MedidasIdeaisDAO();
	 
	 ArrayList <MedidasIdeaisDTO> listaMedidasIdeias = objetomedidasideaisdao.listarMedidasIdeais();
	 
	 DecimalFormat formatarDecimal = new DecimalFormat("0.0", DecimalFormatSymbols.getInstance(Locale.US));
	 
	 idAntebracos.setText(formatarDecimal.format(listaMedidasIdeias.get(0).getAntebracos_ideal())+" cm");
	 idBracos.setText(formatarDecimal.format(listaMedidasIdeias.get(0).getBracos_ideal())+" cm");
	 idCintura.setText(formatarDecimal.format(listaMedidasIdeias.get(0).getCintura_ideal())+" cm");
	 idCoxas.setText(formatarDecimal.format(listaMedidasIdeias.get(0).getCoxas_ideal())+" cm");
	 idFFMI.setText(formatarDecimal.format(listaMedidasIdeias.get(0).getIndice_de_massa_magra_ideal()));
	 idLarguraOmbros.setText(formatarDecimal.format(listaMedidasIdeias.get(0).getLargura_ideal_dos_ombros())+" cm");
	 idMassaMagra.setText(formatarDecimal.format(listaMedidasIdeias.get(0).getMassa_magra_ideal())+" Kg");
	 idOmbros.setText(formatarDecimal.format(listaMedidasIdeias.get(0).getCircunferencia_ideal_dos_ombros())+" cm");
	 idPanturrilhas.setText(formatarDecimal.format(listaMedidasIdeias.get(0).getPanturrilha_ideal())+" cm");
	 idPeitoral.setText(formatarDecimal.format(listaMedidasIdeias.get(0).getPeitoral_ideal())+" cm");
	 idpescoco.setText(formatarDecimal.format(listaMedidasIdeias.get(0).getPescoco_ideal())+" cm"); 
	 idQuadril.setText(formatarDecimal.format(listaMedidasIdeias.get(0).getQuadril_ideal())+" cm");
	 idBf.setText(egBfIdeal.getText());
	 
	 
	 pbAntebracos.setMaximum((int)listaMedidasIdeias.get(0).getAntebracos_ideal());
	 pbBracos.setMaximum((int)listaMedidasIdeias.get(0).getBracos_ideal());
	 pbLarguraOmbros.setMaximum((int)listaMedidasIdeias.get(0).getLargura_ideal_dos_ombros());
	 pbombros.setMaximum((int)listaMedidasIdeias.get(0).getCircunferencia_ideal_dos_ombros());
	 pbPeitoral.setMaximum((int)(listaMedidasIdeias.get(0).getPeitoral_ideal()));
	 pbpescoco.setMaximum((int)listaMedidasIdeias.get(0).getPescoco_ideal());
	 pbQuadril.setMaximum((int)listaMedidasIdeias.get(0).getQuadril_ideal());
	 pbCoxas.setMaximum((int)listaMedidasIdeias.get(0).getCoxas_ideal()); 
	 pbffmi.setMaximum((int)listaMedidasIdeias.get(0).getIndice_de_massa_magra_ideal());
	 pbCintura.setMaximum((int)listaMedidasIdeias.get(0).getCintura_ideal());
	 pbMassaMagra.setMaximum((int)listaMedidasIdeias.get(0).getMassa_magra_ideal()); 
	 pbffmi.setMaximum((int)listaMedidasIdeias.get(0).getIndice_de_massa_magra_ideal());
	 pbBf.setMaximum((int)Double.parseDouble(hgBfIdeal.getText().replace(" %","")));
	 pbPanturrilhas.setMaximum((int)listaMedidasIdeias.get(0).getPanturrilha_ideal());
	 
	 
	 	 
 }
 
 public void limparcampos() {
	 
	 textAltura.setText((""));
	 textAntebraco.setText((""));
	 textBraco.setText((""));
	 textCintura.setText((""));
	 textCircunferenciaOmbros.setText((""));
	 textCoxa.setText((""));
	 textLarguraOmbros.setText((""));
	 textPanturrilha.setText((""));
	 textPeitoral.setText((""));
	 textPescoco.setText((""));
	 textPeso.setText((""));
	 textPunho.setText((""));
	 textQuadril.setText((""));
	 textTornozelo.setText((""));
	 textIdade.setText((""));
 }
            
public void imprimirMedidasAtuais() {
	

 MedidasDAO objetomedidasdao = new MedidasDAO();
 
 ArrayList <MedidasDTO> listaMedidas = objetomedidasdao.listarMedidasAtuais();
	
 MedidasIdeaisDAO objetomedidasideaisdao = new MedidasIdeaisDAO();
 
 ArrayList <MedidasIdeaisDTO> listaMedidasIdeias = objetomedidasideaisdao.listarMedidasIdeais();
 
 DecimalFormat formatarDecimal = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.US));
	
	for(int n = 0; n < listaMedidas.size(); n ++) {
		
		
	pbAntebracos.setValue((int)listaMedidas.get(n).getAntebraco());
	pbAntebracos.setString((formatarDecimal.format((int)((listaMedidas.get(n).getAntebraco()/listaMedidasIdeias.get(0).getAntebracos_ideal())*100)))+" %");
	pbBracos.setValue((int)listaMedidas.get(n).getBraco());
	pbBracos.setString((formatarDecimal.format((int)((listaMedidas.get(n).getBraco()/listaMedidasIdeias.get(0).getBracos_ideal())*100)))+" %");
	pbCintura.setValue((int)listaMedidas.get(n).getCintura());
	pbCintura.setString((formatarDecimal.format((int)((listaMedidas.get(n).getCintura()/listaMedidasIdeias.get(0).getCintura_ideal())*100)))+" %");
	pbLarguraOmbros.setValue((int)listaMedidas.get(n).getLargura_ombros());
	pbLarguraOmbros.setString((formatarDecimal.format((int)((listaMedidas.get(n).getLargura_ombros()/listaMedidasIdeias.get(0).getLargura_ideal_dos_ombros())*100)))+" %");
	pbombros.setValue((int)listaMedidas.get(n).getCircunferencia_ombros());
	pbombros.setString((formatarDecimal.format((int)((listaMedidas.get(n).getCircunferencia_ombros()/listaMedidasIdeias.get(0).getCircunferencia_ideal_dos_ombros())*100)))+" %");
	pbPeitoral.setValue((int)listaMedidas.get(n).getPeitoral());
	pbPeitoral.setString((formatarDecimal.format((int)((listaMedidas.get(n).getPeitoral()/listaMedidasIdeias.get(0).getPeitoral_ideal())*100)))+" %");
	pbpescoco.setValue((int)listaMedidas.get(n).getPescoco());
	pbpescoco.setString((formatarDecimal.format((int)((listaMedidas.get(n).getPescoco()/listaMedidasIdeias.get(0).getPescoco_ideal())*100)))+" %");
	pbQuadril.setValue((int)listaMedidas.get(n).getQuadril());
	pbQuadril.setString((formatarDecimal.format((int)((listaMedidas.get(n).getQuadril()/listaMedidasIdeias.get(0).getQuadril_ideal())*100)))+" %");
	pbCoxas.setValue((int)listaMedidas.get(n).getCoxa());
	pbCoxas.setString((formatarDecimal.format((int)((listaMedidas.get(n).getCoxa()/listaMedidasIdeias.get(0).getCoxas_ideal())*100)))+" %");
	pbPanturrilhas.setValue((int)listaMedidas.get(n).getPanturrilha()); 
	pbPanturrilhas.setString((formatarDecimal.format((int)((listaMedidas.get(n).getPanturrilha()/listaMedidasIdeias.get(0).getPanturrilha_ideal())*100)))+" %");
	pbMassaMagra.setValue((int)Double.parseDouble(massaMagraKG.getText().replace(" Kg","")));
	pbMassaMagra.setString((formatarDecimal.format((int)((Double.parseDouble(massaMagraKG.getText().replace(" Kg",""))/(Double.parseDouble(idMassaMagra.getText().replace(" Kg",""))))*100)))+" %");
	pbffmi.setValue((int)Double.parseDouble(ffmiAtual.getText()));	 
	pbffmi.setString((formatarDecimal.format((int)((Double.parseDouble(ffmiAtual.getText())/(Double.parseDouble(idFFMI.getText())))*100)))+" %"); 
	pbBf.setValue((int)Double.parseDouble(bfAtual.getText().replace(" %","")));
	pbBf.setString((formatarDecimal.format((int)((Double.parseDouble(bfAtual.getText().replace(" %",""))/(Double.parseDouble(idBf.getText().replace(" %",""))))*100)))+" %");
	
	
		
	}

	}
 
public void imprimirAvaliacaoAtual() {
	 
	 AvaliacaoDAO objetoavaliacaodao = new AvaliacaoDAO();
	 
	 ArrayList <AvaliacaoDTO> listaAvaliacao = objetoavaliacaodao.listarAvaliacao();
	 
	 DecimalFormat formatarDecimal = new DecimalFormat("0.0", DecimalFormatSymbols.getInstance(Locale.US));
		
	
		for(int n = 0; n < listaAvaliacao.size(); n ++) {
			 
		bfAtual.setText(formatarDecimal.format(listaAvaliacao.get(n).getPorcentagem_de_gordura_corporal())+" %");
		ffmiAtual.setText(formatarDecimal.format(listaAvaliacao.get(n).getIndice_de_de_massa_magra()));
		gorduraKG.setText(formatarDecimal.format(listaAvaliacao.get(n).getMassa_gorda())+" Kg");
		massaMagraKG.setText(formatarDecimal.format(listaAvaliacao.get(n).getMassa_magra())+" Kg");
		classificacaobf.setText((listaAvaliacao.get(n).getIndice_de_massa_gorda()));
		classificacaoFFMI.setText((listaAvaliacao.get(n).getCategoria_indice_de_massa_magra()));
		
			}
			
	
	
}

public void cadastrarMedidas(int usuarioId) {
	
	
	
	double pescoco, cintura, quadril, larguraOmbros, circunferenciaOmbros, peitoral, braco, antebraco, coxa, panturrilha, peso;
	

	
	pescoco = Double.parseDouble(textPescoco.getText());
	cintura = Double.parseDouble(textCintura.getText());
	quadril = Double.parseDouble(textQuadril.getText());
	larguraOmbros = Double.parseDouble(textLarguraOmbros.getText());
	circunferenciaOmbros = Double.parseDouble(textCircunferenciaOmbros.getText());
	peitoral = Double.parseDouble(textPeitoral.getText());
	braco = Double.parseDouble(textBraco.getText());
	antebraco = Double.parseDouble(textAntebraco.getText());
	coxa = Double.parseDouble(textCoxa.getText());
	panturrilha = Double.parseDouble(textPanturrilha.getText());
	peso = Double.parseDouble(textPeso.getText());
	
	
   
	MedidasDTO objetomedidasdto = new MedidasDTO();
	
	
	objetomedidasdto.setPescoco(pescoco);
	objetomedidasdto.setCintura(cintura);;
	objetomedidasdto.setQuadril(quadril); 
	objetomedidasdto.setPeitoral(peitoral);
	objetomedidasdto.setBraco(braco);
	objetomedidasdto.setAntebraco(antebraco);
	objetomedidasdto.setLargura_ombros(larguraOmbros);
	objetomedidasdto.setCircunferencia_ombros(circunferenciaOmbros);
	objetomedidasdto.setCoxa(coxa);
	objetomedidasdto.setPanturrilha(panturrilha);
	objetomedidasdto.setPeso(peso);
	objetomedidasdto.setFk_usuario_id(usuarioId); 
	
	 
	MedidasDAO objetomedidasdao = new MedidasDAO();
	objetomedidasdao.cadastrarMedidas(objetomedidasdto);
	
}

public void atualizarAnotacoes() {
	
	String anotacoes;
	
	anotacoes =  Anotacoes.getText();
	
	EstrategiaDAO objetoestrategiadao = new EstrategiaDAO();
	objetoestrategiadao.atualizarAnotacoes(verificarEstrategiaId(), anotacoes);
}

public void cadastrarNovasMedidas(int usuarioId) {
	
	
	
	double pescoco, cintura, quadril, larguraOmbros, circunferenciaOmbros, peitoral, braco, antebraco, coxa, panturrilha, peso;
	

	
	pescoco = Double.parseDouble(txtPescoco.getText());
	cintura = Double.parseDouble(txtCintura.getText());
	quadril = Double.parseDouble(txtQuadril.getText());
	larguraOmbros = Double.parseDouble(txtLarguraOmbros.getText());
	circunferenciaOmbros = Double.parseDouble(textCircunferenciaOmbros.getText());
	peitoral = Double.parseDouble(txtPeitoral.getText());
	braco = Double.parseDouble(txtBracos.getText());
	antebraco = Double.parseDouble(txtAntebracos.getText());
	coxa = Double.parseDouble(txtCoxa.getText());
	panturrilha = Double.parseDouble(txtPanturrilhas.getText());
	peso = Double.parseDouble(txtPeso.getText());
	
	
   
	MedidasDTO objetomedidasdto = new MedidasDTO();
	
	
	objetomedidasdto.setPescoco(pescoco);
	objetomedidasdto.setCintura(cintura);;
	objetomedidasdto.setQuadril(quadril); 
	objetomedidasdto.setPeitoral(peitoral);
	objetomedidasdto.setBraco(braco);
	objetomedidasdto.setAntebraco(antebraco);
	objetomedidasdto.setLargura_ombros(larguraOmbros);
	objetomedidasdto.setCircunferencia_ombros(circunferenciaOmbros);
	objetomedidasdto.setCoxa(coxa);
	objetomedidasdto.setPanturrilha(panturrilha);
	objetomedidasdto.setPeso(peso);
	objetomedidasdto.setFk_usuario_id(usuarioId); 
	
	 
	MedidasDAO objetomedidasdao = new MedidasDAO();
	objetomedidasdao.cadastrarMedidas(objetomedidasdto);
	
}
	
public void cadastrarPrimeiraAvaliacao(){
	
	
	String txtfatorDeAtividadeFisica;
	double pescoco, cintura, quadril, larguraOmbros, circunferenciaOmbros, peitoral, braco, antebraco, coxa, panturrilha, peso, fatorDeAtividadeFisica, altura;
	
	
	fatorDeAtividadeFisica=0;
	
	pescoco = Double.parseDouble(textPescoco.getText());
	cintura = Double.parseDouble(textCintura.getText());
	quadril = Double.parseDouble(textQuadril.getText());
	larguraOmbros = Double.parseDouble(textLarguraOmbros.getText());
	circunferenciaOmbros = Double.parseDouble(textCircunferenciaOmbros.getText());
	peitoral = Double.parseDouble(textPeitoral.getText());
	braco = Double.parseDouble(textBraco.getText());
	antebraco = Double.parseDouble(textAntebraco.getText());
	coxa = Double.parseDouble(textCoxa.getText());
	panturrilha = Double.parseDouble(textPanturrilha.getText());
	peso = Double.parseDouble(textPeso.getText());
	txtfatorDeAtividadeFisica = textFatorDeAtividadeFisica.getSelectedItem().toString();
	altura = Double.parseDouble(textAltura.getText());
	
	 
	
	 
	if(txtfatorDeAtividadeFisica=="Sedentário") {
		fatorDeAtividadeFisica=1.2;
	} else if(txtfatorDeAtividadeFisica=="Levemente Ativo") {
		fatorDeAtividadeFisica=1.375; 
	} else if(txtfatorDeAtividadeFisica=="Moderadamente Ativo") {
		fatorDeAtividadeFisica=1.55;
	} else if(txtfatorDeAtividadeFisica=="Muito Ativo") {
		fatorDeAtividadeFisica=1.725;
	} else if(txtfatorDeAtividadeFisica=="Extremamente ativo") {
		fatorDeAtividadeFisica=1.9;
	}
		
	
	AvaliacaoDAO objetoavaliacaodao = new AvaliacaoDAO();
	
	objetoavaliacaodao.realizarAvaliacao(objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, altura),
											objetoavaliacaodao.calcularMassaGorda(peso, objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, altura)), 											
											objetoavaliacaodao.classificarPorIndiceDeMassaGorda(objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, altura)),											
											objetoavaliacaodao.calcularMassaMagra(peso, objetoavaliacaodao.calcularMassaGorda(peso, 
													objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, altura))),											
											objetoavaliacaodao.calcularIndiceDeMassaMagra(altura, objetoavaliacaodao.calcularMassaMagra(peso, objetoavaliacaodao.calcularMassaGorda(peso, objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, altura)))),											
								 			objetoavaliacaodao.calcularTaxaMetabolicaBasal(objetoavaliacaodao.calcularMassaMagra(peso, objetoavaliacaodao.calcularMassaGorda(peso, objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, altura)))), 											
											objetoavaliacaodao.verificarMassaMagra(pescoco, circunferenciaOmbros, peitoral, braco, antebraco, coxa, panturrilha),											
											objetoavaliacaodao.verificarResultdoDaEstrategia(objetoavaliacaodao.verificarMassaMagra(pescoco, circunferenciaOmbros, peitoral, braco, antebraco, coxa, panturrilha), cintura), 											
									 		objetoavaliacaodao.classificarPorIndiceDeMassaMagra(objetoavaliacaodao.calcularIndiceDeMassaMagra
													(altura, objetoavaliacaodao.calcularMassaMagra(peso, objetoavaliacaodao.calcularMassaGorda(peso, objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, altura))))),											
											fatorDeAtividadeFisica, verificarMedidas(),verificarUsuario());
	
	objetoavaliacaodao.calcularNecessidadeCalorica(fatorDeAtividadeFisica, 
			objetoavaliacaodao.calcularTaxaMetabolicaBasal(objetoavaliacaodao.calcularMassaMagra
					(peso, objetoavaliacaodao.calcularMassaGorda(peso, objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, altura)))), 
			verificarAvaliacao());
	
}

public void cadastrarNovasAvaliacoes(){
	
	
	
	double pescoco, cintura, quadril, larguraOmbros, circunferenciaOmbros, peitoral, braco, antebraco, coxa, panturrilha, peso;
	
	
	
	double bfIdealParaAIdade=Double.parseDouble(egBfIdeal.getText());
	pescoco = Double.parseDouble(txtPescoco.getText());
	cintura = Double.parseDouble(txtCintura.getText());
	quadril = Double.parseDouble(txtQuadril.getText());
	larguraOmbros = Double.parseDouble(txtLarguraOmbros.getText());
	circunferenciaOmbros = Double.parseDouble(txtOmbros.getText());
	peitoral = Double.parseDouble(txtPeitoral.getText());
	braco = Double.parseDouble(txtBracos.getText());
	antebraco = Double.parseDouble(txtAntebracos.getText());
	coxa = Double.parseDouble(txtCoxa.getText());
	panturrilha = Double.parseDouble(txtPanturrilhas.getText());
	peso = Double.parseDouble(txtPeso.getText());
	
	 
	
	 
		
	
	AvaliacaoDAO objetoavaliacaodao = new AvaliacaoDAO();
	
	objetoavaliacaodao.realizarAvaliacao(objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, verificarAltura()),
											objetoavaliacaodao.calcularMassaGorda(peso, objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, verificarAltura())), 											
											objetoavaliacaodao.classificarPorIndiceDeMassaGorda(objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, verificarAltura())),											
											objetoavaliacaodao.calcularMassaMagra(peso, objetoavaliacaodao.calcularMassaGorda(peso, 
													objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, verificarAltura()))),											
											objetoavaliacaodao.calcularIndiceDeMassaMagra(verificarAltura(), objetoavaliacaodao.calcularMassaMagra(peso, objetoavaliacaodao.calcularMassaGorda(peso, objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, verificarAltura())))),											
								 			objetoavaliacaodao.calcularTaxaMetabolicaBasal(objetoavaliacaodao.calcularMassaMagra(peso, objetoavaliacaodao.calcularMassaGorda(peso, objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, verificarAltura())))), 											
											objetoavaliacaodao.verificarMassaMagra(pescoco, circunferenciaOmbros, peitoral, braco, antebraco, coxa, panturrilha),											
											objetoavaliacaodao.verificarResultdoDaEstrategia(objetoavaliacaodao.verificarMassaMagra(pescoco, circunferenciaOmbros, peitoral, braco, antebraco, coxa, panturrilha), cintura), 											
									 		objetoavaliacaodao.classificarPorIndiceDeMassaMagra(objetoavaliacaodao.calcularIndiceDeMassaMagra
													(verificarAltura(), objetoavaliacaodao.calcularMassaMagra(peso, objetoavaliacaodao.calcularMassaGorda(peso, objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, verificarAltura()))))),											
											objetoavaliacaodao.recalcularFatorDeAtividadeFisica(objetoavaliacaodao.classificarPorIndiceDeMassaGorda(objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, verificarAltura())), objetoavaliacaodao.verificarResultdoDaEstrategia(objetoavaliacaodao.verificarMassaMagra(pescoco, circunferenciaOmbros, peitoral, braco, antebraco, coxa, panturrilha), cintura), bfIdealParaAIdade, objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, verificarAltura()), verifivarFatorDeAtividadeFisica()), 
											verificarMedidas(),verificarUsuario());
	
	objetoavaliacaodao.calcularNecessidadeCalorica(objetoavaliacaodao.recalcularFatorDeAtividadeFisica(objetoavaliacaodao.classificarPorIndiceDeMassaGorda(objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, verificarAltura())), objetoavaliacaodao.verificarResultdoDaEstrategia(objetoavaliacaodao.verificarMassaMagra(pescoco, circunferenciaOmbros, peitoral, braco, antebraco, coxa, panturrilha), cintura), bfIdealParaAIdade, objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, verificarAltura()), verifivarFatorDeAtividadeFisica()), 
			objetoavaliacaodao.calcularTaxaMetabolicaBasal(objetoavaliacaodao.calcularMassaMagra
					(peso, objetoavaliacaodao.calcularMassaGorda(peso, objetoavaliacaodao.calcularPorcentagemDeGorduraCorporal(pescoco, cintura, verificarAltura())))), 
			verificarAvaliacao());
	
}

//===============================================================Alimentos=============================================================================================

public void cadastrarAlimento(int fkUsuarioId) {
		
		String nomeAlimento, grupoAlimentar;
		int indiceGlicemico, valorBiologico;
		Double porcaoAmostral, carbohidratos, proteinas, gordurasTotais, fibraAlimentar, sodio;
		
		
		
		
		nomeAlimento = textNomeAlimento.getText();
		grupoAlimentar = textGrupoAlimentar.getSelectedItem().toString();
		indiceGlicemico = Integer.parseInt(textIndiceGlicemico.getText()); 
		valorBiologico = Integer.parseInt(textValorBiologico.getText());
		porcaoAmostral = Double.parseDouble(textPorcaoAmostral.getText()); 
		carbohidratos = Double.parseDouble(textCarbohidratos.getText());
		proteinas = Double.parseDouble(textProteinas.getText());
		gordurasTotais = Double.parseDouble(textGordurasTotais.getText());
		fibraAlimentar = Double.parseDouble(textFibraAlimentar.getText());
		sodio = Double.parseDouble(textSodio.getText());
	
		
		
		
		
	
		AlimentoDTO objetoalimentodto = new AlimentoDTO();
		objetoalimentodto.setNome(nomeAlimento);
		objetoalimentodto.setGrupo_alimentar(grupoAlimentar);
		objetoalimentodto.setIndidce_glicemico(indiceGlicemico);
		objetoalimentodto.setValor_biologico(valorBiologico);
		objetoalimentodto.setPorcao_amostral(porcaoAmostral);
		objetoalimentodto.setCarbohidratos(carbohidratos);
		objetoalimentodto.setProteinas(proteinas);
		objetoalimentodto.setGorduras_totais(gordurasTotais);
		objetoalimentodto.setFibra_alimentar(fibraAlimentar);
		objetoalimentodto.setSodio(sodio);
		objetoalimentodto.setFk_usuario_id(fkUsuarioId); 
		 
		AlimentoDAO objetoalimentodao = new AlimentoDAO();
		objetoalimentodao.cadastrarAlimento(objetoalimentodto);
	}
	
	private void limparCamposAlimento() {
		textNomeAlimento.setText("");
		textIndiceGlicemico.setText("");
		textValorBiologico.setText("");
		textPorcaoAmostral.setText("");
		textCarbohidratos.setText("");
		textProteinas.setText("");
		textGordurasTotais.setText("");
		textFibraAlimentar.setText("");
		textSodio.setText("");
	}
	
	private void listarAlimento() {
		try {
			AlimentoDAO objetoalimentodao = new AlimentoDAO();
			DefaultTableModel model = (DefaultTableModel) tabelaAlimento.getModel();
			model.setRowCount(0);
			
			model.addColumn("Nome");
			model.addColumn("Grupo Alimetar");
			model.addColumn("Carbohidratos (g)"); 
			model.addColumn("Proteínas (g)"); 
			model.addColumn("Gorduras Totais (g)"); 
			model.addColumn("Sódio (mg)"); 
			model.setColumnCount(6);
			
			ArrayList <AlimentoDTO> listaAlimentos = objetoalimentodao.listarAlimentos();
			
			
		
			
			for(int num = 0; num < listaAlimentos.size(); num ++) {
					model.addRow(new Object[]{
					listaAlimentos.get(num).getNome(),	
					listaAlimentos.get(num).getGrupo_alimentar(),
					listaAlimentos.get(num).getCarbohidratos(),
					listaAlimentos.get(num).getProteinas(),
					listaAlimentos.get(num).getGorduras_totais(), 
					listaAlimentos.get(num).getSodio()
					
				 
				});
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"listarValores" + e);
	}
	}
	
public void carregarNomeAlimento() {
		
		int setar = tabelaAlimento.getSelectedRow();
		String nome = tabelaAlimento.getModel().getValueAt(setar, 0).toString();
		
		txtNomeAl.setText(nome);
		
		
		}
	 
	public void excuirAlimento() {
		
		String nome;
		
		nome = txtNomeAl.getText();
		
       AlimentoDAO objetorefeicaodao = new AlimentoDAO();
		
		objetorefeicaodao.excluirAlimento(nome);
	}
	
	private void listarAlimentosPorGrupo() {
		
		String grupoAlimentar = selecionarGrupoAlimentar.getSelectedItem().toString();
		
		try {
			AlimentoDAO objetoalimentodao = new AlimentoDAO();
			DefaultTableModel model = (DefaultTableModel) tabelaGruposAlimentares.getModel();
			model.setRowCount(0);
			
			model.addColumn("Nome");
			 model.setColumnCount(1); 
			ArrayList <AlimentoDTO> listaAlimentos = objetoalimentodao.pesquisarGrupoAlimentar(grupoAlimentar);
		
			
			for(int num = 0; num < listaAlimentos.size(); num ++) {
							model.addRow(new Object[]{
							listaAlimentos.get(num).getNome(),		

				});
			}
			
		}catch(Exception e) { 
			JOptionPane.showMessageDialog(null,"listarValores2" + e);
	}
	}
	
	public void carregarAlimentos() {
		
		
		int setar= tabelaGruposAlimentares.getSelectedRow();
		String nome;
		 
		DecimalFormat formatarDecimal = new DecimalFormat("0.0", DecimalFormatSymbols.getInstance(Locale.US));
		
		
		AlimentoDAO objetoalimentodao = new AlimentoDAO();
		
		
		nome = (tabelaGruposAlimentares.getModel().getValueAt(setar, 0).toString()); 
		
		 
		
		ArrayList <AlimentoDTO> lista = objetoalimentodao.pesquisarAlimentoPorNome(nome);
		 
		 
		
		txtnomeAlimento.setText((lista.get(0).getNome())); 
		txtPorcao.setText(formatarDecimal.format(lista.get(0).getPorcao_amostral())); 
		txtCarbohidratos.setText(formatarDecimal.format(lista.get(0).getCarbohidratos())+" g"); 
		txtProteinas.setText(formatarDecimal.format(lista.get(0).getProteinas())+" g"); 
		txtGordurasTotais.setText(formatarDecimal.format(lista.get(0).getGorduras_totais())+" g"); 
		txtFibras.setText(formatarDecimal.format(lista.get(0).getFibra_alimentar())+" g"); 
		txtSodio.setText(formatarDecimal.format(lista.get(0).getSodio())+" mg"); 
		txtCalorias.setText(formatarDecimal.format(objetoalimentodao.calcularKcalorias(nome))+" Kcal"); 
		txtIG.setText(Integer.toString(lista.get(0).getIndidce_glicemico()));
		idAlimento.setText(Integer.toString(lista.get(0).getPk_alimento_id()));
		 
		
		
	}
	
	private void limparCamposRefeicao() {
		txtnomeAlimento.setText("");
		txtIG.setText("");
		txtPorcao.setText("");
		txtCarbohidratos.setText("g 0");
		txtProteinas.setText("g 0");
		txtGordurasTotais.setText("g 0");
		txtFibras.setText("g 0");
		txtSodio.setText("g 0");
		idAlimento.setText("g 0");
		txtCalorias.setText("0 Kcal");
		prCarbs.setText("0%"); 
		prProt.setText("0%");  
		prGor.setText("0%"); 
		prFibras.setText("0%"); 
		prSod.setText("0%");  
		prKcal.setText("0%"); 
	}
	
	
	public void calcularPorcentagemMacrosDosAlimentosParaRefeicao() {
		
		double porcaoAmostral, carbohidrato, proteina, gordurasTotal, fibraAlimentar, sodiO, calorias; 
		 
		
		
		DecimalFormat formatarDecimal = new DecimalFormat("0.0", DecimalFormatSymbols.getInstance(Locale.US));
       
        
		porcaoAmostral = Double.parseDouble(txtPorcao.getText().replace(" g","")); 
		carbohidrato = Double.parseDouble(txtCarbohidratos.getText().replace(" g",""));
		proteina = Double.parseDouble(txtProteinas.getText().replace(" g","")); 
		gordurasTotal = Double.parseDouble(txtGordurasTotais.getText().replace(" g",""));
		fibraAlimentar = Double.parseDouble(txtFibras.getText().replace(" g",""));
		sodiO = Double.parseDouble(txtSodio.getText().replace(" mg",""));
	    calorias = Double.parseDouble(txtCalorias.getText().replace(" Kcal",""));
	    
	    
	    
		carbohidrato = (carbohidrato/porcaoAmostral)*100;
		proteina = (proteina/porcaoAmostral)*100; 
		gordurasTotal = (gordurasTotal /porcaoAmostral)*100;
		fibraAlimentar = (fibraAlimentar/porcaoAmostral)*100;
		sodiO = (sodiO/porcaoAmostral)*100;
	    calorias = (calorias/porcaoAmostral)*100; 
	    
		 
		
		prCarbs.setText(formatarDecimal.format(carbohidrato)+"%"); 
		prProt.setText(formatarDecimal.format(proteina)+"%");  
		prGor.setText(formatarDecimal.format(gordurasTotal)+"%"); 
		prFibras.setText(formatarDecimal.format(fibraAlimentar)+"%"); 
		prSod.setText(formatarDecimal.format(sodiO)+"%");  
		prKcal.setText(formatarDecimal.format(calorias)); 
		
		
		
	}
	
	public void calcularMacrosDaRefeicao() {
		
		double porcaoRefeicao, prCarbohidratos, prProteinas, prGordurasTotais, prFibrasAlimentatares, porSodio, prCalorias;
		
		DecimalFormat formatarDecimal = new DecimalFormat("0.0", DecimalFormatSymbols.getInstance(Locale.US));
		
		porcaoRefeicao = Double.parseDouble(txtPorcao.getText());
		prCarbohidratos = Double.parseDouble(prCarbs.getText().replace("%",""));
		prProteinas = Double.parseDouble(prProt.getText().replace("%",""));
		prGordurasTotais = Double.parseDouble(prGor.getText().replace("%","")); 
		prFibrasAlimentatares = Double.parseDouble(prFibras.getText().replace("%",""));
		porSodio = Double.parseDouble(prSod.getText().replace("%",""));
		prCalorias = Double.parseDouble(prKcal.getText());
		
		
		prCarbohidratos = (prCarbohidratos/100)*porcaoRefeicao ;
		prProteinas = (prProteinas/100)*porcaoRefeicao;
		prGordurasTotais = (prGordurasTotais/100)*porcaoRefeicao;
		prFibrasAlimentatares = (prFibrasAlimentatares/100)*porcaoRefeicao;
		porSodio = (porSodio/100)*porcaoRefeicao;
		prCalorias = (prCalorias/100)*porcaoRefeicao;	
		
		
		 
		txtCarbohidratos.setText(formatarDecimal.format(prCarbohidratos)+" g");  
		txtProteinas.setText(formatarDecimal.format(prProteinas)+" g"); 
		txtGordurasTotais.setText(formatarDecimal.format(prGordurasTotais)+" g"); 
		txtFibras.setText(formatarDecimal.format(prFibrasAlimentatares)+" g"); 
		txtSodio.setText(formatarDecimal.format(porSodio)+" mg"); 
		txtCalorias.setText(formatarDecimal.format(prCalorias)+" Kcal"); 
		
		 
		
	}
	
public void imprimirMacrosDaRefeicao(double necessidadeCalorica) {
	
	double carbohidratos = 0, proteinas = 0, gordurasTotais = 0, sodio = 0, kcals = 0;
	
	DecimalFormat formatarDecimal = new DecimalFormat("0.0", DecimalFormatSymbols.getInstance(Locale.US));
	
	 RefeicaoDAO objetorefeicaodao = new RefeicaoDAO();
	 
	 ArrayList <RefeicaoDTO> listaAlimentos = objetorefeicaodao.pesquisarAtributosDaRefeicao();
	
	for(int num = 0; num < listaAlimentos.size(); num ++) {
		
	kcals = kcals + listaAlimentos.get(num).getKcals();
	carbohidratos = carbohidratos + listaAlimentos.get(num).getCarbohidratos();
	proteinas = proteinas + listaAlimentos.get(num).getProteinas();
	gordurasTotais = gordurasTotais + listaAlimentos.get(num).getGorduras_totais(); 
	sodio = sodio + listaAlimentos.get(num).getSodio();
		
	}
	
	
		
	 txtCarboDieta.setText(formatarDecimal.format(((carbohidratos*4)/necessidadeCalorica)*100)+" %");
	 txtGordDieta.setText(formatarDecimal.format(((gordurasTotais*9)/necessidadeCalorica)*100)+" %");
	 txtKcalsDieta.setText(formatarDecimal.format(kcals)+" Kcal");
	 txtSodioDieta.setText(formatarDecimal.format(sodio)+" mg");
	 txtProtDieta.setText(formatarDecimal.format(((proteinas*4)/necessidadeCalorica)*100)+" %");
	 txtNecessidadeCalorica.setText(formatarDecimal.format(necessidadeCalorica));
}
	
	
	public void adiconarAlimentoARefeicao(int usuarioId) {
		
		String nomeAlimento, nomeRefeicao;
		int indiceGlicemico, alimentoId=0;
		double porcaoAmostral, carbohidratos, proteinas, gordurasTotais, fibraAlimentar, sodio, calorias;
		
		nomeAlimento = txtnomeAlimento.getText();
		porcaoAmostral = Double.parseDouble(txtPorcao.getText()); 
		carbohidratos = Double.parseDouble(txtCarbohidratos.getText().replace(" g",""));
		proteinas = Double.parseDouble(txtProteinas.getText().replace(" g",""));
		gordurasTotais = Double.parseDouble(txtGordurasTotais.getText().replace(" g",""));
		fibraAlimentar = Double.parseDouble(txtFibras.getText().replace(" g",""));
		sodio = Double.parseDouble(txtSodio.getText().replace(" mg",""));
	    calorias = Double.parseDouble(txtCalorias.getText().replace(" Kcal",""));
	    alimentoId = Integer.parseInt(idAlimento.getText());
	    nomeRefeicao = selecionarRefeicao.getSelectedItem().toString();
	    indiceGlicemico = Integer.parseInt(txtIG.getText()); 
	    
	    RefeicaoDTO objetorefeicaodto = new RefeicaoDTO();
	    RefeicaoDAO objetorefeicaodao = new RefeicaoDAO();
	    
	     
	    objetorefeicaodto.setNome_alimento(nomeAlimento);
	    objetorefeicaodto.setPorcao(porcaoAmostral);
	    objetorefeicaodto.setCarbohidratos(carbohidratos);
	    objetorefeicaodto.setProteinas(proteinas);
	    objetorefeicaodto.setGorduras_totais(gordurasTotais);
	    objetorefeicaodto.setSodio(sodio);
	    objetorefeicaodto.setIndice_glicemico(indiceGlicemico);
	    objetorefeicaodto.setKcals(calorias);
	    objetorefeicaodto.setFibras(fibraAlimentar);
	    objetorefeicaodto.setNomeRefeicao(nomeRefeicao);
	    objetorefeicaodto.setFk_usuario_id(usuarioId);
	    objetorefeicaodto.setFk_alimento_id(alimentoId);
	    
	    
	 
	    objetorefeicaodao.cadastrarRefeicao(objetorefeicaodto);
		
		
		}
	
	public void listarRefeicao() {
		
		String nomeRefeicao = selecionarRefeicao.getSelectedItem().toString();
		
		try {
			RefeicaoDAO objetorefeicaodao = new RefeicaoDAO();
			DefaultTableModel model = (DefaultTableModel) tabelaRefeicao.getModel();
			model.setRowCount(0);
			
			model.addColumn("Nome");
			model.addColumn("Porção (g)");
			model.addColumn("Índice Glicêmico"); 
			model.addColumn("Carbohidratos (g)"); 
			model.addColumn("Proteínas (g)"); 
			model.addColumn("Gorduras Totais (g)");  
			model.addColumn("Sódio (mg)"); 
			model.addColumn("kcal");
			model.setColumnCount(8); 
			
			
			
			ArrayList <RefeicaoDTO> listaAlimentos = objetorefeicaodao.listarRefeicaoPorNome(nomeRefeicao);
			
			
		
			
			for(int num = 0; num < listaAlimentos.size(); num ++) {
					model.addRow(new Object[]{
					listaAlimentos.get(num).getNome_alimento(),	
					listaAlimentos.get(num).getPorcao(),
					listaAlimentos.get(num).getIndice_glicemico(),
					listaAlimentos.get(num).getCarbohidratos(),
					listaAlimentos.get(num).getProteinas(),
					listaAlimentos.get(num).getGorduras_totais(), 
					listaAlimentos.get(num).getSodio(),
					listaAlimentos.get(num).getKcals(),
					
					});
					}
			
				
		}catch(Exception e) { 
			
	}
	}
	
	public void calcularCargaGlicemicaRefeicao() {
		
		double cargaGlicemica = 0, indiceGlicemico, carbs, fibras;
		
		DecimalFormat formatarDecimal = new DecimalFormat("0.0", DecimalFormatSymbols.getInstance(Locale.US));
		
	String nomeRefeicao = selecionarRefeicao.getSelectedItem().toString();
		
		try {
			
		 
			RefeicaoDAO objetorefeicaodao = new RefeicaoDAO();
			
			ArrayList <RefeicaoDTO> listaAlimentos = objetorefeicaodao.listarRefeicaoPorNome(nomeRefeicao);
			
			
		
			
			for(int num = 0; num < listaAlimentos.size(); num ++) 
				{
				
				indiceGlicemico = listaAlimentos.get(num).getIndice_glicemico();  
				fibras = listaAlimentos.get(num).getFibras(); 
			    carbs = listaAlimentos.get(num).getCarbohidratos();
				cargaGlicemica = cargaGlicemica + (indiceGlicemico/100) * (carbs - fibras);
				
                
		}
			
		txtCargaGlicemica.setText(formatarDecimal.format(cargaGlicemica));
		
		} finally {
			 
		}
		
		
	
	}
	
	public void carregarIdRefeicao() {
		
		int setar = tabelaRefeicao.getSelectedRow();
		String id = tabelaRefeicao.getModel().getValueAt(setar, 7).toString();
		String nome = tabelaRefeicao.getModel().getValueAt(setar, 0).toString();
		
		txtRefeicaoId.setText(id);
		txtNomeRefeicaoEx.setText(nome);
		
		
		}
	 
	public void excuirAlimentoRefeicao() { 
		
		String id, nome;
		
		id = txtRefeicaoId.getText();
		nome = txtNomeRefeicaoEx.getText();
		
       RefeicaoDAO objetorefeicaodao = new RefeicaoDAO();
		
		objetorefeicaodao.excluirAlimentoDaRefeicao(id,nome);
	}
		
			
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
					frame.setTitle("Natufit");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param usuarioId 
	 */
	public UserInterface() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1728, 782);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelInicio = new JPanel();
		panelInicio.setBackground(new Color(255,255,255,210));
		panelInicio.setBounds(0, 0, 1725, 743);
		contentPane.add(panelInicio);
		panelInicio.setLayout(null);
		
		
		panel_1 = new JPanel();
		panel_1.setBounds(693, 56, 542, 632);
		panelInicio.add(panel_1);
		panel_1.setBackground(Color.BLACK);
		panel_1.setLayout(null);
		
		
		panelCadastroPrimeiraAvaliacao = new JPanel();
		panelCadastroPrimeiraAvaliacao.setBounds(10, 11, 519, 610);
		panel_1.add(panelCadastroPrimeiraAvaliacao);
		panelCadastroPrimeiraAvaliacao.setBorder(new EmptyBorder(1, 1, 1, 1));
		panelCadastroPrimeiraAvaliacao.setLayout(null);
		panelCadastroPrimeiraAvaliacao.setForeground(Color.DARK_GRAY);
		panelCadastroPrimeiraAvaliacao.setBackground(Color.WHITE);
		
		lblNewLabel_5 = new JLabel("Braço:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_5.setForeground(Color.GRAY);
		lblNewLabel_5.setBounds(171, 182, 38, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Antebraço:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6.setForeground(Color.GRAY);
		lblNewLabel_6.setBounds(147, 216, 63, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_6);
		
		lblNewLabel_6_1 = new JLabel("Circunferência dos Ombros:");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_1.setForeground(Color.GRAY);
		lblNewLabel_6_1.setBounds(71, 89, 138, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_6_1);
		
		lblNewLabel_6_2 = new JLabel("Panturrilha:");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_2.setForeground(Color.GRAY);
		lblNewLabel_6_2.setBounds(147, 338, 63, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_6_2);
		
		lblNewLabel_6_3 = new JLabel("Coxa:");
		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_3.setForeground(Color.GRAY);
		lblNewLabel_6_3.setBackground(Color.WHITE);
		lblNewLabel_6_3.setBounds(171, 310, 38, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_6_3);
		
		lblNewLabel_6_4 = new JLabel("Quadril:");
		lblNewLabel_6_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_4.setForeground(Color.GRAY);
		lblNewLabel_6_4.setBounds(163, 272, 46, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_6_4);
		
		lblNewLabel_6_5 = new JLabel("Peitoral:");
		lblNewLabel_6_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_5.setForeground(Color.GRAY);
		lblNewLabel_6_5.setBackground(Color.WHITE);
		lblNewLabel_6_5.setBounds(163, 151, 46, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_6_5);
		
		textCircunferenciaOmbros = new JTextField();
		textCircunferenciaOmbros.setToolTipText("Medir a circunferência dos ombros com os braços relachado posisionados ao lado do corpo");
		textCircunferenciaOmbros.setForeground(Color.GRAY);
		textCircunferenciaOmbros.setColumns(10);
		textCircunferenciaOmbros.setBorder(null);
		textCircunferenciaOmbros.setBackground(Color.WHITE);
		textCircunferenciaOmbros.setBounds(209, 89, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(textCircunferenciaOmbros);
		
		textPeitoral = new JTextField();
		textPeitoral.setToolTipText("Faça a medição com a fita métrica abaixo das axilas e os braços relaxados ao lado do corpo");
		textPeitoral.setForeground(Color.GRAY);
		textPeitoral.setColumns(10);
		textPeitoral.setBorder(null);
		textPeitoral.setBackground(Color.WHITE);
		textPeitoral.setBounds(209, 151, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(textPeitoral);
		
		textBraco = new JTextField();
		textBraco.setToolTipText("Faça a medição com o cotovelo posicionado em 90° e o biceps contraído");
		textBraco.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textBraco.setForeground(Color.GRAY);
		textBraco.setColumns(10);
		textBraco.setBorder(null);
		textBraco.setBackground(Color.WHITE);
		textBraco.setBounds(209, 182, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(textBraco);
		
		textAntebraco = new JTextField();
		textAntebraco.setToolTipText("Faça a medição no maior ponto do antrabreaço com o punho fechado porém sem flexioná-lo");
		textAntebraco.setForeground(Color.GRAY);
		textAntebraco.setColumns(10);
		textAntebraco.setBorder(null);
		textAntebraco.setBackground(Color.WHITE);
		textAntebraco.setBounds(209, 210, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(textAntebraco);
		
		textQuadril = new JTextField();
		textQuadril.setToolTipText("Faça a medição com a fita posicionada sobre o maior ponto do quadril");
		textQuadril.setForeground(Color.GRAY);
		textQuadril.setColumns(10);
		textQuadril.setBorder(null);
		textQuadril.setBackground(Color.WHITE);
		textQuadril.setBounds(209, 272, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(textQuadril);
		
		textCoxa = new JTextField();
		textCoxa.setToolTipText("Faça a medição em pé com com a fita métrica posicionada no ponto médio da coxa");
		textCoxa.setForeground(Color.GRAY);
		textCoxa.setColumns(10);
		textCoxa.setBorder(null);
		textCoxa.setBackground(Color.WHITE);
		textCoxa.setBounds(209, 304, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(textCoxa);
		
		textPanturrilha = new JTextField();
		textPanturrilha.setToolTipText("Faça a medição em pé com a fita metrica sobre o maior ponto");
		textPanturrilha.setForeground(Color.GRAY);
		textPanturrilha.setColumns(10);
		textPanturrilha.setBorder(null);
		textPanturrilha.setBackground(Color.WHITE);
		textPanturrilha.setBounds(209, 335, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(textPanturrilha);
		
		lblNewLabel_5_1 = new JLabel("Salvar");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				cadastrarUsuario();
				cadastrarMedidas(verificarUsuario());
				cadastrarMedidasIdeais();
				cadstrarlimiteGeneticoNatural();
				cadastrarPrimeiraAvaliacao();
				imprimirLimiteGeneticoNatural();
				imprimirAvaliacaoAtual();
				imprimirMedidasIdeais();
				imprimirMedidasAtuais();
				limparcampos();
				panelInicio.setVisible(false);
				
				
				}
		});
		lblNewLabel_5_1.setForeground(Color.GRAY);
		lblNewLabel_5_1.setBounds(253, 585, 83, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_5_1);
		
		textCintura = new JTextField();
		textCintura.setToolTipText("Faça a medição com a fita métrica posisionada sobre o umbigo, expire todo o ar porém sem contrair o abdômen");
		textCintura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textCintura.setForeground(Color.GRAY);
		textCintura.setColumns(10);
		textCintura.setBorder(null);
		textCintura.setBackground(Color.WHITE);
		textCintura.setBounds(209, 241, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(textCintura);
		
		textPeso = new JTextField();
		textPeso.setForeground(Color.GRAY);
		textPeso.setColumns(10);
		textPeso.setBorder(null);
		textPeso.setBackground(Color.WHITE);
		textPeso.setBounds(209, 366, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(textPeso);
		
		textPescoco = new JTextField();
		textPescoco.setToolTipText("A medida é feita no menor ponto logo abaixo do pomo de Adão");
		textPescoco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPescoco.setForeground(Color.GRAY);
		textPescoco.setColumns(10);
		textPescoco.setBorder(null);
		textPescoco.setBackground(Color.WHITE);
		textPescoco.setBounds(209, 58, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(textPescoco);
		
		lblNewLabel_6_3_1 = new JLabel("Pescoco:");
		lblNewLabel_6_3_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_3_1.setForeground(Color.GRAY);
		lblNewLabel_6_3_1.setBounds(158, 61, 51, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_6_3_1);
		
		lblNewLabel_6_6 = new JLabel("Cintura:");
		lblNewLabel_6_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_6.setForeground(Color.GRAY);
		lblNewLabel_6_6.setBounds(163, 244, 46, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_6_6);
		
		textLarguraOmbros = new JTextField();
		textLarguraOmbros.setToolTipText("Faça a medição com as costas contra a parede meça a distância de um ombro ao outro");
		textLarguraOmbros.setForeground(Color.GRAY);
		textLarguraOmbros.setColumns(10);
		textLarguraOmbros.setBorder(null);
		textLarguraOmbros.setBackground(Color.WHITE);
		textLarguraOmbros.setBounds(209, 120, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(textLarguraOmbros);
		
		lblNewLabel_6_2_1 = new JLabel("Largura dos Ombros:");
		lblNewLabel_6_2_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_2_1.setForeground(Color.GRAY);
		lblNewLabel_6_2_1.setBounds(100, 126, 109, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_6_2_1);
		
		lblNewLabel_6_2_2 = new JLabel("Peso:");
		lblNewLabel_6_2_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_2_2.setForeground(Color.GRAY);
		lblNewLabel_6_2_2.setBounds(171, 372, 38, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_6_2_2);
		
		lblNewLabel_26 = new JLabel("__________________________________");
		lblNewLabel_26.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_26.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_26.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_26.setBounds(209, 372, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_26);
		
		lblNewLabel_38 = new JLabel("__________________________________");
		lblNewLabel_38.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_38.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_38.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_38.setBounds(209, 338, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_38);
		
		lblNewLabel_39 = new JLabel("__________________________________");
		lblNewLabel_39.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_39.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_39.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_39.setBounds(209, 310, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_39);
		
		lblNewLabel_40 = new JLabel("__________________________________");
		lblNewLabel_40.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_40.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_40.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_40.setBounds(209, 275, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_40);
		
		lblNewLabel_41 = new JLabel("_____________________________");
		lblNewLabel_41.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_41.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_41.setBounds(209, 244, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_41);
		
		lblNewLabel_42 = new JLabel("__________________________________");
		lblNewLabel_42.setToolTipText("Faça a medição  no maior ponto com o punho fechado mas sem flexiona-lo");
		lblNewLabel_42.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_42.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_42.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_42.setBounds(209, 216, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_42);
		
		lblNewLabel_43 = new JLabel("_____________________________");
		lblNewLabel_43.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_43.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_43.setBounds(209, 185, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_43);
		
		lblNewLabel_44 = new JLabel("__________________________________");
		lblNewLabel_44.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_44.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_44.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_44.setBounds(209, 154, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_44);
		
		lblNewLabel_45 = new JLabel("__________________________________");
		lblNewLabel_45.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_45.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_45.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_45.setBounds(209, 92, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_45);
		
		lblNewLabel_46 = new JLabel("__________________________________");
		lblNewLabel_46.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_46.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_46.setBounds(209, 58, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_46);
		
		lblNewLabel_47 = new JLabel("__________________________________");
		lblNewLabel_47.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_47.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_47.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_47.setBounds(209, 126, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_47);
		
		lblNewLabel_48 = new JLabel("_____________________________");
		lblNewLabel_48.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_48.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_48.setBounds(209, 61, 207, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_48);
		
		lbl = new JLabel("Idade:");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl.setForeground(Color.GRAY);
		lbl.setBounds(171, 404, 43, 25);
		panelCadastroPrimeiraAvaliacao.add(lbl);
		
		textIdade = new JTextField();
		textIdade.setForeground(Color.GRAY);
		textIdade.setColumns(10);
		textIdade.setBorder(null);
		textIdade.setBackground(Color.WHITE);
		textIdade.setBounds(209, 397, 224, 19);
		panelCadastroPrimeiraAvaliacao.add(textIdade);
		
		lblNewLabel_49 = new JLabel("__________________________________");
		lblNewLabel_49.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_49.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_49.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_49.setBounds(209, 409, 224, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_49);
		
		lbl_1 = new JLabel("Altura:");
		lbl_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_1.setForeground(Color.GRAY);
		lbl_1.setBounds(171, 440, 38, 14);
		panelCadastroPrimeiraAvaliacao.add(lbl_1);
		
		textAltura = new JTextField();
		textAltura.setForeground(Color.GRAY);
		textAltura.setColumns(10);
		textAltura.setBorder(null);
		textAltura.setBackground(Color.WHITE);
		textAltura.setBounds(209, 429, 224, 19);
		panelCadastroPrimeiraAvaliacao.add(textAltura);
		
		lblNewLabel_50 = new JLabel("_____________________________");
		lblNewLabel_50.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_50.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_50.setBounds(209, 440, 224, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_50);
		
		lbl_2 = new JLabel("Punho:");
		lbl_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_2.setForeground(Color.GRAY);
		lbl_2.setBounds(171, 469, 38, 25);
		panelCadastroPrimeiraAvaliacao.add(lbl_2);
		
		textPunho = new JTextField();
		textPunho.setToolTipText("Faça a medição com a fita métrica posicionada sobre a articulação do punho");
		textPunho.setForeground(Color.GRAY);
		textPunho.setColumns(10);
		textPunho.setBorder(null);
		textPunho.setBackground(Color.WHITE);
		textPunho.setBounds(209, 459, 224, 25);
		panelCadastroPrimeiraAvaliacao.add(textPunho);
		
		lblNewLabel_51 = new JLabel("__________________________________");
		lblNewLabel_51.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_51.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_51.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_51.setBounds(209, 474, 224, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_51);
		
		lbl_3 = new JLabel("Tornozelo:");
		lbl_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_3.setForeground(Color.GRAY);
		lbl_3.setBounds(151, 505, 58, 25);
		panelCadastroPrimeiraAvaliacao.add(lbl_3);
		
		textTornozelo = new JTextField();
		textTornozelo.setToolTipText("Faça a medição com a fita métrica posicionada sobre o menor ponto de tornozelo");
		textTornozelo.setForeground(Color.GRAY);
		textTornozelo.setColumns(10);
		textTornozelo.setBorder(null);
		textTornozelo.setBackground(Color.WHITE);
		textTornozelo.setBounds(209, 499, 224, 20);
		panelCadastroPrimeiraAvaliacao.add(textTornozelo);
		
		lblNewLabel_52 = new JLabel("__________________________________");
		lblNewLabel_52.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_52.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_52.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_52.setBounds(209, 508, 224, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_52);
		
		lbl_4 = new JLabel("Fator de Atividade Física:");
		lbl_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl_4.setForeground(Color.GRAY);
		lbl_4.setBounds(80, 541, 129, 20); 
		panelCadastroPrimeiraAvaliacao.add(lbl_4);
		
		textFatorDeAtividadeFisica = new JComboBox<String>();
		textFatorDeAtividadeFisica.setToolTipText("Descreve a quantidade de atividades físicas você desemprenha diariamente, incluindo trabalho e etc");
		textFatorDeAtividadeFisica.setForeground(Color.BLACK);
		textFatorDeAtividadeFisica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFatorDeAtividadeFisica.setBorder(new EmptyBorder(0, 0, 0, 0));
		textFatorDeAtividadeFisica.setBackground(Color.WHITE);
		textFatorDeAtividadeFisica.setBounds(209, 541, 208, 20);
		panelCadastroPrimeiraAvaliacao.add(textFatorDeAtividadeFisica);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(743, 0, 329, 610);
		panelCadastroPrimeiraAvaliacao.add(panel_2);
		
		JLabel lblNewLabel_6_3_1_1 = new JLabel("Cadastre a sua primeira avaliação:");
		lblNewLabel_6_3_1_1.setForeground(Color.GRAY);
		lblNewLabel_6_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6_3_1_1.setBounds(171, 21, 231, 14);
		panelCadastroPrimeiraAvaliacao.add(lblNewLabel_6_3_1_1);
		textFatorDeAtividadeFisica.addItem("Sedentário");
		textFatorDeAtividadeFisica.addItem("Levemente Ativo");
		textFatorDeAtividadeFisica.addItem("Moderadamente Ativo");
		textFatorDeAtividadeFisica.addItem("Muito Ativo");
		textFatorDeAtividadeFisica.addItem("Extremamente ativo");
		
		
		panelCadastroDemaisAvaliacoes = new JPanel();
		panelCadastroDemaisAvaliacoes.setLayout(null);
		panelCadastroDemaisAvaliacoes.setForeground(Color.DARK_GRAY);
		panelCadastroDemaisAvaliacoes.setBackground(Color.WHITE);
		panelCadastroDemaisAvaliacoes.setBounds(246, 11, 1456, 721);
		contentPane.add(panelCadastroDemaisAvaliacoes);
		
		lblNewLabel_12 = new JLabel("Braço:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_12.setForeground(Color.GRAY);
		lblNewLabel_12.setBounds(98, 216, 78, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_12);
		
		lblNewLabel_6_7 = new JLabel("Antebraço:");
		lblNewLabel_6_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_7.setForeground(Color.GRAY);
		lblNewLabel_6_7.setBounds(74, 255, 61, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_6_7);
		
		lblNewLabel_6_8 = new JLabel("Ombros:");
		lblNewLabel_6_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_8.setForeground(Color.GRAY);
		lblNewLabel_6_8.setBounds(87, 99, 78, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_6_8);
		
		lblNewLabel_6_9 = new JLabel("Panturrilha:");
		lblNewLabel_6_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_9.setForeground(Color.GRAY);
		lblNewLabel_6_9.setBounds(74, 416, 78, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_6_9);
		
		lblNewLabel_6_10 = new JLabel("Coxa:");
		lblNewLabel_6_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_10.setForeground(Color.GRAY);
		lblNewLabel_6_10.setBackground(Color.WHITE);
		lblNewLabel_6_10.setBounds(98, 374, 78, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_6_10);
		
		lblNewLabel_6_11 = new JLabel("Quadril:");
		lblNewLabel_6_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_11.setForeground(Color.GRAY);
		lblNewLabel_6_11.setBounds(87, 337, 78, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_6_11);
		
		lblNewLabel_6_12 = new JLabel("Peitoral:");
		lblNewLabel_6_12.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_12.setForeground(Color.GRAY);
		lblNewLabel_6_12.setBounds(87, 178, 78, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_6_12);
		
		txtOmbros = new JTextField();
		txtOmbros.setForeground(Color.BLACK);
		txtOmbros.setColumns(10);
		txtOmbros.setBorder(null); 
		txtOmbros.setBackground(Color.WHITE);
		txtOmbros.setBounds(131, 96, 207, 14);
		panelCadastroDemaisAvaliacoes.add(txtOmbros);
		
		txtPeitoral = new JTextField();
		txtPeitoral.setForeground(Color.BLACK);
		txtPeitoral.setColumns(10);
		txtPeitoral.setBorder(null);
		txtPeitoral.setBackground(Color.WHITE);
		txtPeitoral.setBounds(131, 175, 207, 14);
		panelCadastroDemaisAvaliacoes.add(txtPeitoral);
		
		txtBracos = new JTextField();
		txtBracos.setForeground(Color.BLACK);
		txtBracos.setColumns(10);
		txtBracos.setBorder(null);
		txtBracos.setBackground(Color.WHITE);
		txtBracos.setBounds(131, 213, 207, 14);
		panelCadastroDemaisAvaliacoes.add(txtBracos);
		
		txtAntebracos = new JTextField();
		txtAntebracos.setForeground(Color.BLACK);
		txtAntebracos.setColumns(10);
		txtAntebracos.setBorder(null);
		txtAntebracos.setBackground(Color.WHITE);
		txtAntebracos.setBounds(131, 252, 207, 14);
		panelCadastroDemaisAvaliacoes.add(txtAntebracos);
		
		txtQuadril = new JTextField();
		txtQuadril.setForeground(Color.BLACK);
		txtQuadril.setColumns(10);
		txtQuadril.setBorder(null);
		txtQuadril.setBackground(Color.WHITE);
		txtQuadril.setBounds(131, 334, 207, 14);
		panelCadastroDemaisAvaliacoes.add(txtQuadril);
		
		txtCoxa = new JTextField();
		txtCoxa.setForeground(Color.BLACK);
		txtCoxa.setColumns(10);
		txtCoxa.setBorder(null);
		txtCoxa.setBackground(Color.WHITE);
		txtCoxa.setBounds(131, 371, 207, 14);
		panelCadastroDemaisAvaliacoes.add(txtCoxa);
		
		txtPanturrilhas = new JTextField();
		txtPanturrilhas.setForeground(Color.BLACK);
		txtPanturrilhas.setColumns(10);
		txtPanturrilhas.setBorder(null);
		txtPanturrilhas.setBackground(Color.WHITE);
		txtPanturrilhas.setBounds(131, 413, 207, 14);
		panelCadastroDemaisAvaliacoes.add(txtPanturrilhas);
		
		lblNewLabel_5_2 = new JLabel("Cadastrar");
		lblNewLabel_5_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cadastrarNovasMedidas(verificarUsuario());
				cadastrarNovasAvaliacoes();
				imprimirMedidasAtuais();
				imprimirAvaliacaoAtual();
				
			}
		});
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5_2.setForeground(Color.GRAY);
		lblNewLabel_5_2.setBounds(157, 585, 108, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_5_2);
		
		txtCintura = new JTextField();
		txtCintura.setForeground(Color.BLACK); 
		txtCintura.setColumns(10);
		txtCintura.setBorder(null);
		txtCintura.setBackground(Color.WHITE);
		txtCintura.setBounds(131, 292, 207, 14);
		panelCadastroDemaisAvaliacoes.add(txtCintura);
		
		txtPeso = new JTextField();
		txtPeso.setForeground(Color.BLACK);
		txtPeso.setColumns(10);
		txtPeso.setBorder(null);
		txtPeso.setBackground(Color.WHITE);
		txtPeso.setBounds(131, 455, 207, 14);
		panelCadastroDemaisAvaliacoes.add(txtPeso);
		
		txtPescoco = new JTextField();
		txtPescoco.setForeground(Color.BLACK);
		txtPescoco.setColumns(10);
		txtPescoco.setBorder(null);
		txtPescoco.setBackground(Color.WHITE);
		txtPescoco.setBounds(131, 56, 207, 14);
		panelCadastroDemaisAvaliacoes.add(txtPescoco);
		
		lblNewLabel_6_3_2 = new JLabel("Pescoco:");
		lblNewLabel_6_3_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_3_2.setForeground(Color.GRAY);
		lblNewLabel_6_3_2.setBounds(87, 59, 78, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_6_3_2);
		
		lblNewLabel_6_6_2 = new JLabel("Cintura:");
		lblNewLabel_6_6_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_6_2.setForeground(Color.GRAY);
		lblNewLabel_6_6_2.setBounds(87, 295, 78, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_6_6_2);
		
		txtLarguraOmbros = new JTextField();
		txtLarguraOmbros.setForeground(Color.BLACK);
		txtLarguraOmbros.setColumns(10);
		txtLarguraOmbros.setBorder(null);
		txtLarguraOmbros.setBackground(Color.WHITE);
		txtLarguraOmbros.setBounds(131, 134, 207, 14);
		panelCadastroDemaisAvaliacoes.add(txtLarguraOmbros);
		
		lblNewLabel_6_2_3 = new JLabel("Largura dos Ombros:");
		lblNewLabel_6_2_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_2_3.setForeground(Color.GRAY);
		lblNewLabel_6_2_3.setBounds(29, 137, 116, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_6_2_3);
		
		lblNewLabel_6_2_4 = new JLabel("Peso:");
		lblNewLabel_6_2_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6_2_4.setForeground(Color.GRAY);
		lblNewLabel_6_2_4.setBounds(101, 458, 34, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_6_2_4);
		
		lblNewLabel_27 = new JLabel("__________________________________");
		lblNewLabel_27.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_27.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_27.setBounds(130, 458, 208, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_27);
		
		lblNewLabel_28 = new JLabel("__________________________________");
		lblNewLabel_28.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_28.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_28.setBounds(131, 416, 208, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_28);
		
		lblNewLabel_29 = new JLabel("__________________________________");
		lblNewLabel_29.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_29.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_29.setBounds(130, 374, 208, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_29);
		
		lblNewLabel_30 = new JLabel("__________________________________");
		lblNewLabel_30.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_30.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_30.setBounds(131, 337, 208, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_30);
		
		lblNewLabel_31 = new JLabel("__________________________________");
		lblNewLabel_31.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_31.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_31.setBounds(130, 295, 208, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_31);
		
		lblNewLabel_32 = new JLabel("__________________________________");
		lblNewLabel_32.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_32.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_32.setBounds(130, 255, 208, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_32);
		
		lblNewLabel_33 = new JLabel("__________________________________");
		lblNewLabel_33.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_33.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_33.setBounds(131, 216, 208, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_33);
		
		lblNewLabel_34 = new JLabel("__________________________________");
		lblNewLabel_34.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_34.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_34.setBounds(131, 178, 208, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_34);
		
		lblNewLabel_35 = new JLabel("__________________________________");
		lblNewLabel_35.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_35.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_35.setBounds(131, 137, 208, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_35);
		
		lblNewLabel_36 = new JLabel("__________________________________");
		lblNewLabel_36.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_36.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_36.setBounds(130, 99, 208, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_36);
		
		lblNewLabel_37 = new JLabel("__________________________________");
		lblNewLabel_37.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_37.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_37.setBounds(130, 59, 208, 14);
		panelCadastroDemaisAvaliacoes.add(lblNewLabel_37);
		
		panel_3 = new JPanel();
		panel_3.setBounds(361, 21, 1085, 689);
		panelCadastroDemaisAvaliacoes.add(panel_3);
		panel_3.setLayout(null);
		
		panelFisicoIdeal = new JPanel();
		panelFisicoIdeal.setBounds(10, 11, 369, 380);
		panel_3.add(panelFisicoIdeal);
		panelFisicoIdeal.setLayout(null);
		panelFisicoIdeal.setBackground(Color.WHITE);
		
		pbpescoco = new JProgressBar();
		pbpescoco.setName("");
		pbpescoco.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pbpescoco.setStringPainted(true);
		pbpescoco.setForeground(Color.GRAY);
		pbpescoco.setBorderPainted(false);
		pbpescoco.setBackground(Color.WHITE);
		pbpescoco.setBounds(150, 47, 146, 14);
		panelFisicoIdeal.add(pbpescoco);
		
		pbombros = new JProgressBar();
		pbombros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pbombros.setStringPainted(true);
		pbombros.setForeground(Color.GRAY);
		pbombros.setBorderPainted(false);
		pbombros.setBackground(Color.WHITE);
		pbombros.setBounds(150, 72, 146, 14);
		panelFisicoIdeal.add(pbombros);
		
		pbLarguraOmbros = new JProgressBar();
		pbLarguraOmbros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pbLarguraOmbros.setBackground(Color.WHITE);
		pbLarguraOmbros.setForeground(Color.GRAY);
		pbLarguraOmbros.setStringPainted(true);
		pbLarguraOmbros.setBorderPainted(false);
		pbLarguraOmbros.setBounds(150, 97, 146, 14);
		panelFisicoIdeal.add(pbLarguraOmbros);
		
		pbPeitoral = new JProgressBar();
		pbPeitoral.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pbPeitoral.setBackground(Color.WHITE);
		pbPeitoral.setForeground(Color.GRAY);
		pbPeitoral.setStringPainted(true);
		pbPeitoral.setBorderPainted(false);
		pbPeitoral.setBounds(150, 122, 146, 14);
		panelFisicoIdeal.add(pbPeitoral);
		
		pbBracos = new JProgressBar();
		pbBracos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pbBracos.setBackground(Color.WHITE);
		pbBracos.setForeground(Color.GRAY);
		pbBracos.setStringPainted(true);
		pbBracos.setBorderPainted(false);
		pbBracos.setBounds(150, 147, 146, 14);
		panelFisicoIdeal.add(pbBracos);
		
		pbAntebracos = new JProgressBar();
		pbAntebracos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pbAntebracos.setBackground(Color.WHITE);
		pbAntebracos.setForeground(Color.GRAY);
		pbAntebracos.setStringPainted(true);
		pbAntebracos.setBorderPainted(false);
		pbAntebracos.setBounds(150, 172, 146, 14);
		panelFisicoIdeal.add(pbAntebracos);
		
		pbCintura = new JProgressBar();
		pbCintura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pbCintura.setBackground(Color.WHITE);
		pbCintura.setForeground(Color.GRAY);
		pbCintura.setStringPainted(true);
		pbCintura.setBorderPainted(false);
		pbCintura.setBounds(150, 197, 146, 14);
		panelFisicoIdeal.add(pbCintura);
		
		lblNewLabel_2_1_1 = new JLabel("Medidas pra um fisico ideal:");
		lblNewLabel_2_1_1.setForeground(Color.GRAY);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1.setBounds(10, 11, 317, 25);
		panelFisicoIdeal.add(lblNewLabel_2_1_1);
		
		lblNewLabel_3_2_1_1 = new JLabel("Pescoco:");
		lblNewLabel_3_2_1_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_2_1_1.setBounds(20, 47, 46, 14);
		panelFisicoIdeal.add(lblNewLabel_3_2_1_1);
		
		lblNewLabel_3_2_1_2 = new JLabel("Ombros:");
		lblNewLabel_3_2_1_2.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_2_1_2.setBounds(20, 72, 46, 14);
		panelFisicoIdeal.add(lblNewLabel_3_2_1_2);
		
		lblNewLabel_3_2_1_3 = new JLabel("Largura dos Ombros:");
		lblNewLabel_3_2_1_3.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_2_1_3.setBounds(20, 97, 120, 14);
		panelFisicoIdeal.add(lblNewLabel_3_2_1_3);
		
		lblNewLabel_3_2_1_4 = new JLabel("Peitoral:");
		lblNewLabel_3_2_1_4.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_2_1_4.setBounds(20, 122, 46, 14);
		panelFisicoIdeal.add(lblNewLabel_3_2_1_4);
		
		lblNewLabel_3_2_1_5 = new JLabel("Braços:");
		lblNewLabel_3_2_1_5.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_2_1_5.setBounds(20, 147, 46, 14);
		panelFisicoIdeal.add(lblNewLabel_3_2_1_5);
		
		lblNewLabel_3_2_1_6 = new JLabel("Antebraços:");
		lblNewLabel_3_2_1_6.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_2_1_6.setBounds(20, 172, 76, 14);
		panelFisicoIdeal.add(lblNewLabel_3_2_1_6);
		
		lblNewLabel_3_2_1_7 = new JLabel("Cintura:");
		lblNewLabel_3_2_1_7.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_2_1_7.setBounds(20, 197, 46, 14);
		panelFisicoIdeal.add(lblNewLabel_3_2_1_7);
		
		lblNewLabel_9 = new JLabel("Quadril:");
		lblNewLabel_9.setForeground(Color.GRAY);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9.setBounds(20, 222, 46, 14);
		panelFisicoIdeal.add(lblNewLabel_9);
		
		lblNewLabel_3_2_1_7_1 = new JLabel("Coxas:");
		lblNewLabel_3_2_1_7_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_7_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_2_1_7_1.setBounds(20, 247, 46, 14);
		panelFisicoIdeal.add(lblNewLabel_3_2_1_7_1);
		
		lblNewLabel_3_2_1_7_2 = new JLabel("Panturrilhas:");
		lblNewLabel_3_2_1_7_2.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_7_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_2_1_7_2.setBounds(20, 272, 89, 14);
		panelFisicoIdeal.add(lblNewLabel_3_2_1_7_2);
		
		pbQuadril = new JProgressBar();
		pbQuadril.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pbQuadril.setBackground(Color.WHITE);
		pbQuadril.setForeground(Color.GRAY);
		pbQuadril.setStringPainted(true);
		pbQuadril.setBorderPainted(false);
		pbQuadril.setBounds(150, 222, 146, 14);
		panelFisicoIdeal.add(pbQuadril);
		
		pbCoxas = new JProgressBar();
		pbCoxas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pbCoxas.setBackground(Color.WHITE);
		pbCoxas.setForeground(Color.GRAY);
		pbCoxas.setStringPainted(true);
		pbCoxas.setBorderPainted(false);
		pbCoxas.setBounds(150, 247, 146, 14);
		panelFisicoIdeal.add(pbCoxas);
		
		pbPanturrilhas = new JProgressBar();
		pbPanturrilhas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pbPanturrilhas.setBackground(Color.WHITE);
		pbPanturrilhas.setForeground(Color.GRAY);
		pbPanturrilhas.setStringPainted(true);
		pbPanturrilhas.setBorderPainted(false);
		pbPanturrilhas.setBounds(150, 272, 146, 14);
		panelFisicoIdeal.add(pbPanturrilhas);
		
		lblNewLabel_3_2_1_7_2_1 = new JLabel("Massa Magra:");
		lblNewLabel_3_2_1_7_2_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_7_2_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_2_1_7_2_1.setBounds(20, 296, 89, 14);
		panelFisicoIdeal.add(lblNewLabel_3_2_1_7_2_1);
		
		lblNewLabel_3_2_1_7_2_2 = new JLabel("Indice de Massa Magra:");
		lblNewLabel_3_2_1_7_2_2.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_7_2_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_2_1_7_2_2.setBounds(20, 319, 120, 14);
		panelFisicoIdeal.add(lblNewLabel_3_2_1_7_2_2);
		
		pbMassaMagra = new JProgressBar();
		pbMassaMagra.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pbMassaMagra.setBackground(Color.WHITE);
		pbMassaMagra.setForeground(Color.GRAY);
		pbMassaMagra.setStringPainted(true);
		pbMassaMagra.setBorderPainted(false);
		pbMassaMagra.setBounds(150, 296, 146, 14);
		panelFisicoIdeal.add(pbMassaMagra);
		
		pbffmi = new JProgressBar();
		pbffmi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pbffmi.setBackground(Color.WHITE);
		pbffmi.setForeground(Color.GRAY);
		pbffmi.setStringPainted(true);
		pbffmi.setBorderPainted(false);
		pbffmi.setBounds(150, 319, 146, 14);
		panelFisicoIdeal.add(pbffmi);
		
		idpescoco = new JLabel("");
		idpescoco.setForeground(Color.GRAY);
		idpescoco.setFont(new Font("Tahoma", Font.PLAIN, 11));
		idpescoco.setBounds(317, 45, 46, 14);
		panelFisicoIdeal.add(idpescoco);
		
		idOmbros = new JLabel("");
		idOmbros.setForeground(Color.GRAY);
		idOmbros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		idOmbros.setBounds(317, 72, 46, 14);
		panelFisicoIdeal.add(idOmbros);
		
		idLarguraOmbros = new JLabel("");
		idLarguraOmbros.setForeground(Color.GRAY);
		idLarguraOmbros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		idLarguraOmbros.setBounds(317, 97, 46, 14);
		panelFisicoIdeal.add(idLarguraOmbros);
		
		idPeitoral = new JLabel("");
		idPeitoral.setForeground(Color.GRAY);
		idPeitoral.setFont(new Font("Tahoma", Font.PLAIN, 11));
		idPeitoral.setBounds(317, 122, 46, 14);
		panelFisicoIdeal.add(idPeitoral);
		
		idBracos = new JLabel("");
		idBracos.setForeground(Color.GRAY);
		idBracos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		idBracos.setBounds(317, 147, 46, 14);
		panelFisicoIdeal.add(idBracos);
		
		idAntebracos = new JLabel("");
		idAntebracos.setForeground(Color.GRAY);
		idAntebracos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		idAntebracos.setBounds(317, 172, 46, 14);
		panelFisicoIdeal.add(idAntebracos);
		
		idCintura = new JLabel("");
		idCintura.setForeground(Color.GRAY);
		idCintura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		idCintura.setBounds(317, 197, 46, 14);
		panelFisicoIdeal.add(idCintura);
		
		idQuadril = new JLabel("");
		idQuadril.setForeground(Color.GRAY);
		idQuadril.setFont(new Font("Tahoma", Font.PLAIN, 11));
		idQuadril.setBounds(317, 222, 46, 14);
		panelFisicoIdeal.add(idQuadril);
		
		idCoxas = new JLabel("");
		idCoxas.setForeground(Color.GRAY);
		idCoxas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		idCoxas.setBounds(317, 247, 46, 14);
		panelFisicoIdeal.add(idCoxas);
		
		idPanturrilhas = new JLabel("");
		idPanturrilhas.setForeground(Color.GRAY);
		idPanturrilhas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		idPanturrilhas.setBounds(317, 272, 46, 14);
		panelFisicoIdeal.add(idPanturrilhas);
		
		idMassaMagra = new JLabel("");
		idMassaMagra.setForeground(Color.GRAY);
		idMassaMagra.setFont(new Font("Tahoma", Font.PLAIN, 11));
		idMassaMagra.setBounds(317, 296, 46, 14);
		panelFisicoIdeal.add(idMassaMagra);
		
		idFFMI = new JLabel("");
		idFFMI.setForeground(Color.GRAY);
		idFFMI.setFont(new Font("Tahoma", Font.PLAIN, 11));
		idFFMI.setBounds(317, 319, 46, 14);
		panelFisicoIdeal.add(idFFMI);
		
		pbBf = new JProgressBar();
		pbBf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pbBf.setBackground(Color.WHITE);
		pbBf.setForeground(Color.GRAY);
		pbBf.setStringPainted(true);
		pbBf.setBorderPainted(false);
		pbBf.setBounds(150, 344, 146, 14);
		panelFisicoIdeal.add(pbBf);
		
		lblNewLabel_3_2_1_7_2_2_1 = new JLabel("Gordura Corporal:");
		lblNewLabel_3_2_1_7_2_2_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_7_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3_2_1_7_2_2_1.setBounds(20, 344, 120, 14);
		panelFisicoIdeal.add(lblNewLabel_3_2_1_7_2_2_1);
		
		idBf = new JLabel("");
		idBf.setForeground(Color.GRAY);
		idBf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		idBf.setBounds(317, 344, 59, 14);
		panelFisicoIdeal.add(idBf);
		
		panelComposicaoCorporal = new JPanel();
		panelComposicaoCorporal.setBounds(387, 11, 351, 380);
		panel_3.add(panelComposicaoCorporal);
		panelComposicaoCorporal.setLayout(null);
		panelComposicaoCorporal.setBackground(Color.WHITE);
		
		lblNewLabel_2_1_1_1 = new JLabel("Composição Corporal:");
		lblNewLabel_2_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1.setBounds(20, 11, 199, 25);
		panelComposicaoCorporal.add(lblNewLabel_2_1_1_1);
		
		bfAtual = new JLabel("");
		bfAtual.setForeground(Color.GRAY);
		bfAtual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bfAtual.setBounds(293, 70, 46, 14);
		panelComposicaoCorporal.add(bfAtual);
		
		gorduraKG = new JLabel("");
		gorduraKG.setForeground(Color.GRAY);
		gorduraKG.setFont(new Font("Tahoma", Font.PLAIN, 13));
		gorduraKG.setBounds(293, 47, 46, 14);
		panelComposicaoCorporal.add(gorduraKG);
		
		ffmiAtual = new JLabel("");
		ffmiAtual.setForeground(Color.GRAY);
		ffmiAtual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ffmiAtual.setBounds(293, 158, 46, 14);
		panelComposicaoCorporal.add(ffmiAtual);
		
		massaMagraKG = new JLabel("");
		massaMagraKG.setForeground(Color.GRAY);
		massaMagraKG.setFont(new Font("Tahoma", Font.PLAIN, 13));
		massaMagraKG.setBounds(293, 133, 46, 14);
		panelComposicaoCorporal.add(massaMagraKG);
		
		classificacaoFFMI = new JLabel("");
		classificacaoFFMI.setForeground(Color.GRAY);
		classificacaoFFMI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		classificacaoFFMI.setBounds(273, 183, 78, 14);
		panelComposicaoCorporal.add(classificacaoFFMI);
		
		lblNewLabel_3_2_1_12 = new JLabel("Classificação do Indice de Massa Magra:");
		lblNewLabel_3_2_1_12.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_12.setBounds(20, 183, 243, 14);
		panelComposicaoCorporal.add(lblNewLabel_3_2_1_12);
		
		lblNewLabel_3_2_1_8 = new JLabel("Gordura Corporal:");
		lblNewLabel_3_2_1_8.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8.setBounds(20, 47, 143, 14);
		panelComposicaoCorporal.add(lblNewLabel_3_2_1_8);
		
		lblNewLabel_3_2_1_8_1 = new JLabel("Massa Magra:");
		lblNewLabel_3_2_1_8_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_1.setBounds(20, 133, 108, 14);
		panelComposicaoCorporal.add(lblNewLabel_3_2_1_8_1);
		
		classificacaobf = new JLabel("");
		classificacaobf.setForeground(Color.GRAY);
		classificacaobf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		classificacaobf.setBounds(293, 95, 46, 14);
		panelComposicaoCorporal.add(classificacaobf);
		
		lblNewLabel_3_2_1_12_1 = new JLabel("Indice de Massa Magra:");
		lblNewLabel_3_2_1_12_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_12_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_12_1.setBounds(20, 158, 143, 14);
		panelComposicaoCorporal.add(lblNewLabel_3_2_1_12_1);
		
		lblNewLabel_3_2_1 = new JLabel("Porcentagem de Gordura Corporal:");
		lblNewLabel_3_2_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1.setBounds(20, 72, 243, 14);
		panelComposicaoCorporal.add(lblNewLabel_3_2_1);
		
		lblNewLabel_3_2 = new JLabel("Classificação no Indice de Gordura Corporal:");
		lblNewLabel_3_2.setForeground(Color.GRAY);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2.setBounds(20, 95, 276, 14);
		panelComposicaoCorporal.add(lblNewLabel_3_2);
		
		panelHardGainer = new JPanel();
		panelHardGainer.setBounds(10, 402, 369, 276);
		panel_3.add(panelHardGainer);
		panelHardGainer.setLayout(null);
		panelHardGainer.setBackground(Color.WHITE);
		
		hgPeitoral = new JLabel("");
		hgPeitoral.setForeground(Color.GRAY);
		hgPeitoral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		hgPeitoral.setBounds(297, 71, 58, 14);
		panelHardGainer.add(hgPeitoral);
		
		hgBraco = new JLabel("");
		hgBraco.setForeground(Color.GRAY);
		hgBraco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		hgBraco.setBounds(297, 96, 58, 14);
		panelHardGainer.add(hgBraco);
		
		hgPescoco = new JLabel("");
		hgPescoco.setForeground(Color.GRAY);
		hgPescoco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		hgPescoco.setBounds(297, 46, 58, 14);
		panelHardGainer.add(hgPescoco);
		
		hgAntebraco = new JLabel("");
		hgAntebraco.setForeground(Color.GRAY);
		hgAntebraco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		hgAntebraco.setBounds(297, 121, 58, 14);
		panelHardGainer.add(hgAntebraco);
		
		hgCoxa = new JLabel("");
		hgCoxa.setForeground(Color.GRAY);
		hgCoxa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		hgCoxa.setBounds(297, 146, 58, 14);
		panelHardGainer.add(hgCoxa);
		
		hgPanturrilha = new JLabel("");
		hgPanturrilha.setForeground(Color.GRAY);
		hgPanturrilha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		hgPanturrilha.setBounds(297, 171, 58, 14);
		panelHardGainer.add(hgPanturrilha);
		
		hgMassaMagra = new JLabel("");
		hgMassaMagra.setForeground(Color.GRAY);
		hgMassaMagra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		hgMassaMagra.setBounds(297, 196, 58, 14);
		panelHardGainer.add(hgMassaMagra);
		
		hgFfmi = new JLabel("");
		hgFfmi.setForeground(Color.GRAY);
		hgFfmi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		hgFfmi.setBounds(297, 221, 58, 14);
		panelHardGainer.add(hgFfmi);
		
		hgBfIdeal = new JLabel("");
		hgBfIdeal.setForeground(Color.GRAY);
		hgBfIdeal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		hgBfIdeal.setBounds(297, 246, 58, 14);
		panelHardGainer.add(hgBfIdeal);
		
		lblNewLabel_3_2_1_8_3 = new JLabel("Pescoco:");
		lblNewLabel_3_2_1_8_3.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_3.setBounds(10, 46, 71, 14);
		panelHardGainer.add(lblNewLabel_3_2_1_8_3);
		
		lblNewLabel_3_2_1_8_4 = new JLabel("Peitoral:");
		lblNewLabel_3_2_1_8_4.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_4.setBounds(10, 71, 71, 14);
		panelHardGainer.add(lblNewLabel_3_2_1_8_4);
		
		lblNewLabel_3_2_1_8_5 = new JLabel("Bracos:");
		lblNewLabel_3_2_1_8_5.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_5.setBounds(10, 96, 71, 14);
		panelHardGainer.add(lblNewLabel_3_2_1_8_5);
		
		lblNewLabel_3_2_1_8_6 = new JLabel("Antebracos:");
		lblNewLabel_3_2_1_8_6.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_6.setBounds(10, 121, 71, 14);
		panelHardGainer.add(lblNewLabel_3_2_1_8_6);
		
		lblNewLabel_3_2_1_8_7 = new JLabel("Coxas:");
		lblNewLabel_3_2_1_8_7.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_7.setBounds(10, 146, 71, 14);
		panelHardGainer.add(lblNewLabel_3_2_1_8_7);
		
		lblNewLabel_3_2_1_8_8 = new JLabel("Panturrilhas:");
		lblNewLabel_3_2_1_8_8.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_8.setBounds(10, 171, 100, 14);
		panelHardGainer.add(lblNewLabel_3_2_1_8_8);
		
		lblNewLabel_3_2_1_8_9 = new JLabel("Massa Magra:");
		lblNewLabel_3_2_1_8_9.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_9.setBounds(10, 196, 100, 14);
		panelHardGainer.add(lblNewLabel_3_2_1_8_9);
		
		lblNewLabel_3_2_1_8_10 = new JLabel("Indice de Massa Magra:");
		lblNewLabel_3_2_1_8_10.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_10.setBounds(10, 221, 161, 14);
		panelHardGainer.add(lblNewLabel_3_2_1_8_10);
		
		lblNewLabel_3_2_1_8_11 = new JLabel("Gordura Corporal Ideal Para A Idade:");
		lblNewLabel_3_2_1_8_11.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_11.setBounds(10, 246, 224, 14);
		panelHardGainer.add(lblNewLabel_3_2_1_8_11);
		
		JLabel lblNewLabel_54 = new JLabel("Medids máximas para  pessoas com dificuldade em ganhar massa magra");
		lblNewLabel_54.setBounds(10, 11, 359, 20);
		panelHardGainer.add(lblNewLabel_54);
		lblNewLabel_54.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_54.setForeground(Color.GRAY);
		
		panelEasyGainer = new JPanel();
		panelEasyGainer.setBounds(387, 402, 351, 276);
		panel_3.add(panelEasyGainer);
		panelEasyGainer.setLayout(null);
		panelEasyGainer.setBackground(Color.WHITE);
		
		egPescoco = new JLabel("");
		egPescoco.setForeground(Color.GRAY);
		egPescoco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		egPescoco.setBounds(284, 42, 57, 14);
		panelEasyGainer.add(egPescoco);
		
		egPeitoral = new JLabel("");
		egPeitoral.setForeground(Color.GRAY);
		egPeitoral.setFont(new Font("Tahoma", Font.PLAIN, 13));
		egPeitoral.setBounds(284, 67, 57, 14);
		panelEasyGainer.add(egPeitoral);
		
		egBraco = new JLabel("");
		egBraco.setForeground(Color.GRAY);
		egBraco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		egBraco.setBounds(284, 92, 57, 14);
		panelEasyGainer.add(egBraco);
		
		egAntebraco = new JLabel("");
		egAntebraco.setForeground(Color.GRAY);
		egAntebraco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		egAntebraco.setBounds(284, 117, 57, 14);
		panelEasyGainer.add(egAntebraco);
		
		egCoxa = new JLabel("");
		egCoxa.setForeground(Color.GRAY);
		egCoxa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		egCoxa.setBounds(284, 142, 57, 14);
		panelEasyGainer.add(egCoxa);
		
		egPanturrilha = new JLabel("");
		egPanturrilha.setForeground(Color.GRAY);
		egPanturrilha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		egPanturrilha.setBounds(284, 167, 57, 14);
		panelEasyGainer.add(egPanturrilha);
		
		egMassaMagra = new JLabel("");
		egMassaMagra.setForeground(Color.GRAY);
		egMassaMagra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		egMassaMagra.setBounds(284, 192, 57, 14);
		panelEasyGainer.add(egMassaMagra);
		
		egFfmi = new JLabel("");
		egFfmi.setForeground(Color.GRAY);
		egFfmi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		egFfmi.setBounds(284, 217, 57, 14);
		panelEasyGainer.add(egFfmi);
		
		egBfIdeal = new JLabel("");
		egBfIdeal.setForeground(Color.GRAY);
		egBfIdeal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		egBfIdeal.setBounds(284, 242, 57, 14);
		panelEasyGainer.add(egBfIdeal);
		
		
		lblNewLabel_3_2_1_8_4_1 = new JLabel("Pescoco:");
		lblNewLabel_3_2_1_8_4_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_4_1.setBounds(10, 42, 71, 14);
		panelEasyGainer.add(lblNewLabel_3_2_1_8_4_1);
		
		lblNewLabel_3_2_1_8_5_1 = new JLabel("Peitoral:");
		lblNewLabel_3_2_1_8_5_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_5_1.setBounds(10, 67, 71, 14);
		panelEasyGainer.add(lblNewLabel_3_2_1_8_5_1);
		
		lblNewLabel_3_2_1_8_6_1 = new JLabel("Bracos:");
		lblNewLabel_3_2_1_8_6_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_6_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_6_1.setBounds(10, 92, 71, 14);
		panelEasyGainer.add(lblNewLabel_3_2_1_8_6_1);
		
		lblNewLabel_3_2_1_8_7_1 = new JLabel("Antebracos:");
		lblNewLabel_3_2_1_8_7_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_7_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_7_1.setBounds(10, 117, 71, 14);
		panelEasyGainer.add(lblNewLabel_3_2_1_8_7_1);
		
		lblNewLabel_3_2_1_8_8_1 = new JLabel("Coxas:");
		lblNewLabel_3_2_1_8_8_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_8_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_8_1.setBounds(10, 142, 71, 14);
		panelEasyGainer.add(lblNewLabel_3_2_1_8_8_1);
		
		lblNewLabel_3_2_1_8_9_1 = new JLabel("Panturrilhas:");
		lblNewLabel_3_2_1_8_9_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_9_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_9_1.setBounds(10, 167, 116, 14);
		panelEasyGainer.add(lblNewLabel_3_2_1_8_9_1);
		
		lblNewLabel_3_2_1_8_10_1 = new JLabel("Massa Magra:");
		lblNewLabel_3_2_1_8_10_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_10_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_10_1.setBounds(10, 192, 116, 14);
		panelEasyGainer.add(lblNewLabel_3_2_1_8_10_1);
		
		lblNewLabel_3_2_1_8_11_1 = new JLabel("Indice de Massa Magra:");
		lblNewLabel_3_2_1_8_11_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_11_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_11_1.setBounds(10, 217, 168, 14);
		panelEasyGainer.add(lblNewLabel_3_2_1_8_11_1);
		
		lblNewLabel_3_2_1_8_12_1 = new JLabel("Gordura Corporal Ideal Para A Idade:");
		lblNewLabel_3_2_1_8_12_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1_8_12_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3_2_1_8_12_1.setBounds(10, 240, 245, 14);
		panelEasyGainer.add(lblNewLabel_3_2_1_8_12_1);
		
		JLabel lblNewLabel_54_1 = new JLabel("Medidas máximas para pessoas com facilidade em ganhar massa magra");
		lblNewLabel_54_1.setForeground(Color.GRAY);
		lblNewLabel_54_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_54_1.setBounds(10, 11, 352, 18);
		panelEasyGainer.add(lblNewLabel_54_1);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(748, 11, 327, 667);
		panel_3.add(panel_4);
		
		lblNewLabel_2_1_1_1_1 = new JLabel("Anotações:");
		lblNewLabel_2_1_1_1_1.setForeground(Color.GRAY);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1_1.setBounds(10, 11, 199, 25);
		panel_4.add(lblNewLabel_2_1_1_1_1);
		
		Anotacoes = new JEditorPane();
		Anotacoes.setToolTipText("Este espaço é destinado para fazer suas anotações ou mesmo para armazenar o seu plano de treinos.");
		Anotacoes.setForeground(Color.GRAY);
		Anotacoes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Anotacoes.setBounds(10, 47, 307, 581);
		panel_4.add(Anotacoes);
		
		lblNewLabel_53 = new JLabel("Salvar");
		lblNewLabel_53.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_53.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				atualizarAnotacoes();
				verificarAnotacoes();
			}
		});
		lblNewLabel_53.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_53.setBounds(157, 639, 46, 14);
		panel_4.add(lblNewLabel_53);
		
		
		panelCadastroAlimentos = new JPanel();
		panelCadastroAlimentos.setBackground(Color.WHITE);
		panelCadastroAlimentos.setBounds(246, 11, 1456, 721);
		contentPane.add(panelCadastroAlimentos);
		panelCadastroAlimentos.setLayout(null);
		
		textNomeAlimento = new JTextField();
		textNomeAlimento.setBorder(new EmptyBorder(0, 0, 0, 0));
		textNomeAlimento.setToolTipText("");
		textNomeAlimento.setBackground(Color.WHITE);
		textNomeAlimento.setBounds(101, 79, 194, 14);
		panelCadastroAlimentos.add(textNomeAlimento);
		textNomeAlimento.setColumns(10);
		
		textGrupoAlimentar = new JComboBox();
		textGrupoAlimentar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textGrupoAlimentar.setBorder(new EmptyBorder(1, 1, 1, 1));
		textGrupoAlimentar.setBackground(Color.WHITE);
		textGrupoAlimentar.setBounds(101, 39, 194, 20);
		panelCadastroAlimentos.add(textGrupoAlimentar);
		textGrupoAlimentar.addItem("Aves, Peixes e Ovos");
		textGrupoAlimentar.addItem("Nozes, Sementes, Feijões e Tufu");
		textGrupoAlimentar.addItem("Laticinios");
		textGrupoAlimentar.addItem("Frutas e Vegetais");
		textGrupoAlimentar.addItem("Grãos Inteiros");
		textGrupoAlimentar.addItem("Óleos e Goduras Saudáveis");
		textGrupoAlimentar.addItem("Grãos Refinados, Doces, Açucar e Sal");
		
		textIndiceGlicemico = new JTextField();
		textIndiceGlicemico.setBorder(new EmptyBorder(0, 0, 0, 0));
		textIndiceGlicemico.setBackground(Color.WHITE);
		textIndiceGlicemico.setColumns(10);
		textIndiceGlicemico.setBounds(101, 123, 194, 14);
		panelCadastroAlimentos.add(textIndiceGlicemico);
		
		textValorBiologico = new JTextField();
		textValorBiologico.setBorder(new EmptyBorder(0, 0, 0, 0));
		textValorBiologico.setBackground(Color.WHITE);
		textValorBiologico.setColumns(10);
		textValorBiologico.setBounds(101, 169, 194, 14);
		panelCadastroAlimentos.add(textValorBiologico);
		
		textPorcaoAmostral = new JTextField();
		textPorcaoAmostral.setBorder(new EmptyBorder(0, 0, 0, 0));
		textPorcaoAmostral.setBackground(Color.WHITE);
		textPorcaoAmostral.setColumns(10);
		textPorcaoAmostral.setBounds(101, 213, 194, 14);
		panelCadastroAlimentos.add(textPorcaoAmostral);
		
		textCarbohidratos = new JTextField();
		textCarbohidratos.setBorder(new EmptyBorder(0, 0, 0, 0));
		textCarbohidratos.setBackground(Color.WHITE);
		textCarbohidratos.setColumns(10);
		textCarbohidratos.setBounds(101, 256, 194, 14);
		panelCadastroAlimentos.add(textCarbohidratos);
		
		textProteinas = new JTextField();
		textProteinas.setBorder(new EmptyBorder(0, 0, 0, 0));
		textProteinas.setBackground(Color.WHITE);
		textProteinas.setColumns(10);
		textProteinas.setBounds(101, 300, 194, 14);
		panelCadastroAlimentos.add(textProteinas);
		
		textGordurasTotais = new JTextField();
		textGordurasTotais.setBorder(new EmptyBorder(0, 0, 0, 0));
		textGordurasTotais.setBackground(Color.WHITE);
		textGordurasTotais.setColumns(10);
		textGordurasTotais.setBounds(101, 340, 194, 14);
		panelCadastroAlimentos.add(textGordurasTotais);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(338, 27, 1029, 645);
		panelCadastroAlimentos.add(scrollPane);
		
		tabelaAlimento = new JTable();
		tabelaAlimento.setIntercellSpacing(new Dimension(0, 0));
		tabelaAlimento.setRowMargin(0);
		tabelaAlimento.setShowVerticalLines(false);
		tabelaAlimento.setSelectionForeground(Color.WHITE);
		tabelaAlimento.setSelectionBackground(Color.GRAY);
		tabelaAlimento.setForeground(Color.BLACK);
		tabelaAlimento.setBackground(Color.WHITE);
		tabelaAlimento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tabelaAlimento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				carregarNomeAlimento();
			}
		});
		tabelaAlimento.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setViewportView(tabelaAlimento);
		
		textFibraAlimentar = new JTextField();
		textFibraAlimentar.setBorder(new EmptyBorder(0, 0, 0, 0));
		textFibraAlimentar.setColumns(10);
		textFibraAlimentar.setBackground(Color.WHITE);
		textFibraAlimentar.setBounds(101, 385, 194, 14);
		panelCadastroAlimentos.add(textFibraAlimentar);
		
		textSodio = new JTextField();
		textSodio.setBorder(new EmptyBorder(0, 0, 0, 0));
		textSodio.setColumns(10);
		textSodio.setBackground(Color.WHITE);
		textSodio.setBounds(101, 429, 194, 14);
		panelCadastroAlimentos.add(textSodio);
		
		JLabel lblNomeAlimento = new JLabel("   Nome:");
		lblNomeAlimento.setBackground(Color.GRAY);
		lblNomeAlimento.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNomeAlimento.setForeground(Color.GRAY);
		lblNomeAlimento.setBounds(56, 85, 46, 14);
		panelCadastroAlimentos.add(lblNomeAlimento);
		
		JLabel lblGrupoAlimentar = new JLabel("Grupo Alimentar:");
		lblGrupoAlimentar.setBackground(Color.DARK_GRAY);
		lblGrupoAlimentar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblGrupoAlimentar.setForeground(Color.GRAY);
		lblGrupoAlimentar.setBounds(15, 42, 117, 14);
		panelCadastroAlimentos.add(lblGrupoAlimentar);
		
		JLabel lblIndiceGlicemico = new JLabel("Índice Glicêmico:");
		lblIndiceGlicemico.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblIndiceGlicemico.setForeground(Color.GRAY);
		lblIndiceGlicemico.setBounds(21, 129, 81, 14);
		panelCadastroAlimentos.add(lblIndiceGlicemico);
		
		JLabel lblValorBiolgico = new JLabel("  Valor Biológico:");
		lblValorBiolgico.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblValorBiolgico.setForeground(Color.GRAY);
		lblValorBiolgico.setBounds(21, 175, 81, 14);
		panelCadastroAlimentos.add(lblValorBiolgico);
		
		JLabel lblPoroAmostral = new JLabel("Porção Amostral (g):");
		lblPoroAmostral.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPoroAmostral.setForeground(Color.GRAY);
		lblPoroAmostral.setBounds(0, 219, 102, 14);
		panelCadastroAlimentos.add(lblPoroAmostral);
		
		JLabel lblCarboidratos = new JLabel(" Carbohidratos (g):");
		lblCarboidratos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCarboidratos.setForeground(Color.GRAY);
		lblCarboidratos.setBounds(10, 262, 92, 14);
		panelCadastroAlimentos.add(lblCarboidratos);
		
		JLabel lblProtenas = new JLabel("    Proteínas (g):");
		lblProtenas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblProtenas.setForeground(Color.GRAY);
		lblProtenas.setBounds(21, 306, 81, 14);
		panelCadastroAlimentos.add(lblProtenas);
		
		JLabel lblGordurasTotais = new JLabel("  Gorduras Totais (g):");
		lblGordurasTotais.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblGordurasTotais.setForeground(Color.GRAY);
		lblGordurasTotais.setBounds(0, 346, 102, 14);
		panelCadastroAlimentos.add(lblGordurasTotais);
		
		JLabel lblFibraAlimentar = new JLabel("Fibra Alimentar(g):");
		lblFibraAlimentar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFibraAlimentar.setForeground(Color.GRAY);
		lblFibraAlimentar.setBounds(15, 391, 87, 14);
		panelCadastroAlimentos.add(lblFibraAlimentar);
		
		JLabel lblSdio = new JLabel("Sódio (mg):");
		lblSdio.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSdio.setForeground(Color.GRAY);
		lblSdio.setBounds(47, 437, 55, 14);
		panelCadastroAlimentos.add(lblSdio);
		
		JLabel lblNewLabel = new JLabel("Cadastrar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cadastrarAlimento(verificarUsuario());
				listarAlimento();
				listarAlimentosPorGrupo();
				limparCamposAlimento();
			}
		});
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBounds(56, 524, 72, 14);
		panelCadastroAlimentos.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Excluir");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				excuirAlimento();
				listarAlimento();   
			}
		});
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(224, 524, 46, 14);
		panelCadastroAlimentos.add(lblNewLabel_1);
		
		
		txtNomeAl = new JLabel("");
		txtNomeAl.setVisible(false);
		txtNomeAl.setBounds(136, 608, 46, 14);
		panelCadastroAlimentos.add(txtNomeAl);
		
		JLabel lblNewLabel_16 = new JLabel("________________________________");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_16.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_16.setBounds(101, 391, 194, 14);
		panelCadastroAlimentos.add(lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel("________________________________");
		lblNewLabel_17.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_17.setBounds(101, 262, 194, 14);
		panelCadastroAlimentos.add(lblNewLabel_17);
		
		lblNewLabel_18 = new JLabel("________________________________");
		lblNewLabel_18.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_18.setBounds(101, 391, 194, 14);
		panelCadastroAlimentos.add(lblNewLabel_18);
		
		lblNewLabel_19 = new JLabel("________________________________");
		lblNewLabel_19.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_19.setBounds(101, 346, 194, 14);
		panelCadastroAlimentos.add(lblNewLabel_19);
		
		lblNewLabel_20 = new JLabel("________________________________");
		lblNewLabel_20.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_20.setBounds(101, 306, 194, 14);
		panelCadastroAlimentos.add(lblNewLabel_20);
		
		lblNewLabel_21 = new JLabel("________________________________");
		lblNewLabel_21.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_21.setBounds(101, 219, 194, 14);
		panelCadastroAlimentos.add(lblNewLabel_21);
		
		lblNewLabel_22 = new JLabel("________________________________");
		lblNewLabel_22.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_22.setBounds(101, 175, 194, 14);
		panelCadastroAlimentos.add(lblNewLabel_22);
		
		lblNewLabel_23 = new JLabel("________________________________");
		lblNewLabel_23.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_23.setBounds(101, 129, 194, 14);
		panelCadastroAlimentos.add(lblNewLabel_23);
		
		lblNewLabel_24 = new JLabel("________________________________");
		lblNewLabel_24.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_24.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_24.setBounds(101, 85, 194, 14);
		panelCadastroAlimentos.add(lblNewLabel_24);
		
		lblNewLabel_25 = new JLabel("________________________________");
		lblNewLabel_25.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_25.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_25.setBounds(101, 433, 194, 22);
		panelCadastroAlimentos.add(lblNewLabel_25);
		
		panelCadastroRefeicoes = new JPanel();
		panelCadastroRefeicoes.setBackground(Color.WHITE);
		panelCadastroRefeicoes.setBounds(246, 11, 1456, 721);
		contentPane.add(panelCadastroRefeicoes);
		panelCadastroRefeicoes.setLayout(null);
		
		JScrollPane ScrollPane1 = new JScrollPane();
		ScrollPane1.setBorder(new EmptyBorder(0, 0, 0, 0));
		ScrollPane1.setBounds(53, 85, 193, 379);
		panelCadastroRefeicoes.add(ScrollPane1);
		
		tabelaGruposAlimentares = new JTable();
		tabelaGruposAlimentares.setSelectionForeground(Color.WHITE);
		tabelaGruposAlimentares.setSelectionBackground(Color.GRAY);
		tabelaGruposAlimentares.setShowVerticalLines(false);
		tabelaGruposAlimentares.setRowMargin(0);
		tabelaGruposAlimentares.setIntercellSpacing(new Dimension(0, 0));
		tabelaGruposAlimentares.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tabelaGruposAlimentares.setForeground(Color.BLACK);
		tabelaGruposAlimentares.setBackground(Color.WHITE);
		tabelaGruposAlimentares.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				carregarAlimentos();
				calcularPorcentagemMacrosDosAlimentosParaRefeicao();
			}
		});
		ScrollPane1.setViewportView(tabelaGruposAlimentares);
		
		selecionarGrupoAlimentar = new JComboBox();
		selecionarGrupoAlimentar.setBorder(new EmptyBorder(0, 0, 0, 0));
		selecionarGrupoAlimentar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		selecionarGrupoAlimentar.setBackground(Color.WHITE);
		selecionarGrupoAlimentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarAlimentosPorGrupo();
			}
		});
		selecionarGrupoAlimentar.setBounds(53, 39, 193, 22);
		panelCadastroRefeicoes.add(selecionarGrupoAlimentar);
		selecionarGrupoAlimentar.addItem("Aves, Peixes e Ovos");
		selecionarGrupoAlimentar.addItem("Nozes, Sementes, Feijões e Tufu");
		selecionarGrupoAlimentar.addItem("Laticinios");
		selecionarGrupoAlimentar.addItem("Frutas e Vegetais");
		selecionarGrupoAlimentar.addItem("Grãos Inteiros");
		selecionarGrupoAlimentar.addItem("Óleos e Goduras Saudáveis");
		selecionarGrupoAlimentar.addItem("Grãos Refinados, Doces, Açucar e Sal");
		
		
		
		selecionarRefeicao = new JComboBox();
		selecionarRefeicao.setBorder(new EmptyBorder(0, 0, 0, 0));
		selecionarRefeicao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		selecionarRefeicao.setBackground(Color.WHITE);
		selecionarRefeicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarRefeicao();
				
			}
		});
		selecionarRefeicao.setBounds(485, 39, 149, 22);
		panelCadastroRefeicoes.add(selecionarRefeicao);
		selecionarRefeicao.addItem("Café da Manhã");
		selecionarRefeicao.addItem("Lanche"); 
		selecionarRefeicao.addItem("Almoço");
		selecionarRefeicao.addItem("Pré Treino");
		selecionarRefeicao.addItem("Pós Treino");
		selecionarRefeicao.addItem("Jantar");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane_1.setBounds(485, 76, 918, 388);
		panelCadastroRefeicoes.add(scrollPane_1);
		
		tabelaRefeicao = new JTable();
		tabelaRefeicao.setIntercellSpacing(new Dimension(0, 0));
		tabelaRefeicao.setSelectionForeground(Color.WHITE);
		tabelaRefeicao.setSelectionBackground(Color.GRAY);
		tabelaRefeicao.setShowVerticalLines(false);
		tabelaRefeicao.setRowMargin(0);
		tabelaRefeicao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				carregarIdRefeicao();
			}
		});
		tabelaRefeicao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane_1.setViewportView(tabelaRefeicao);
		
		txtSodioDieta = new JLabel("0 mg");
		txtSodioDieta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtSodioDieta.setForeground(Color.GRAY);
		txtSodioDieta.setBounds(695, 657, 46, 14);
		panelCadastroRefeicoes.add(txtSodioDieta);
		
		JLabel txtSodioMaximoRecomendado = new JLabel("2000 mg");
		txtSodioMaximoRecomendado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtSodioMaximoRecomendado.setForeground(Color.GRAY);
		txtSodioMaximoRecomendado.setBounds(603, 657, 46, 14);
		panelCadastroRefeicoes.add(txtSodioMaximoRecomendado);
		
		txtGordDieta = new JLabel("0%");
		txtGordDieta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtGordDieta.setForeground(Color.GRAY);
		txtGordDieta.setBounds(695, 607, 46, 14);
		panelCadastroRefeicoes.add(txtGordDieta);
		
		JLabel lblNewLabel_8_5 = new JLabel("Objetivo Diário");
		lblNewLabel_8_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_5.setForeground(Color.GRAY);
		lblNewLabel_8_5.setBounds(576, 532, 73, 14);
		panelCadastroRefeicoes.add(lblNewLabel_8_5);
		
		JLabel lblNewLabel_8_6 = new JLabel("40%");
		lblNewLabel_8_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_6.setForeground(Color.GRAY);
		lblNewLabel_8_6.setBounds(603, 557, 46, 14);
		panelCadastroRefeicoes.add(lblNewLabel_8_6);
		
		JLabel lblNewLabel_8_7 = new JLabel("35%");
		lblNewLabel_8_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_7.setForeground(Color.GRAY);
		lblNewLabel_8_7.setBounds(603, 582, 46, 14);
		panelCadastroRefeicoes.add(lblNewLabel_8_7);
		
		JLabel lblNewLabel_8_9 = new JLabel("Sódio:");
		lblNewLabel_8_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_9.setForeground(Color.GRAY);
		lblNewLabel_8_9.setBounds(485, 657, 46, 14);
		panelCadastroRefeicoes.add(lblNewLabel_8_9);
		
		JLabel lblNewLabel_8_10 = new JLabel("Proteinas: ");
		lblNewLabel_8_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_10.setForeground(Color.GRAY);
		lblNewLabel_8_10.setBounds(485, 582, 70, 14);
		panelCadastroRefeicoes.add(lblNewLabel_8_10);
		
		JLabel lblNewLabel_8_11 = new JLabel("Gorduras Totais:");
		lblNewLabel_8_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_11.setForeground(Color.GRAY);
		lblNewLabel_8_11.setBounds(485, 607, 97, 14);
		panelCadastroRefeicoes.add(lblNewLabel_8_11);
		
		JLabel lblNewLabel_8_12 = new JLabel("Kcals:");
		lblNewLabel_8_12.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_12.setForeground(Color.GRAY);
		lblNewLabel_8_12.setBounds(485, 632, 73, 14);
		panelCadastroRefeicoes.add(lblNewLabel_8_12);
		
		JLabel lblNewLabel_8_13 = new JLabel("Carbohidratos:");
		lblNewLabel_8_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_13.setForeground(Color.GRAY);
		lblNewLabel_8_13.setBounds(485, 557, 86, 14);
		panelCadastroRefeicoes.add(lblNewLabel_8_13);
		
		JLabel lblNewLabel_8_14 = new JLabel("Alcançado");
		lblNewLabel_8_14.setToolTipText("");
		lblNewLabel_8_14.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_14.setForeground(Color.GRAY);
		lblNewLabel_8_14.setBounds(695, 532, 57, 14);
		panelCadastroRefeicoes.add(lblNewLabel_8_14);
		
		txtCarboDieta = new JLabel("0%");
		txtCarboDieta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCarboDieta.setForeground(Color.GRAY);
		txtCarboDieta.setBounds(695, 557, 46, 14);
		panelCadastroRefeicoes.add(txtCarboDieta);
		
		txtProtDieta = new JLabel("0");
		txtProtDieta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtProtDieta.setForeground(Color.GRAY);
		txtProtDieta.setBounds(695, 582, 46, 14);
		panelCadastroRefeicoes.add(txtProtDieta);
		
		JLabel lblNewLabel_8_29 = new JLabel("25%");
		lblNewLabel_8_29.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_29.setForeground(Color.GRAY);
		lblNewLabel_8_29.setBounds(603, 607, 46, 14);
		panelCadastroRefeicoes.add(lblNewLabel_8_29);
		
		JLabel lblNewLabel_11 = new JLabel("Adicionar ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				adiconarAlimentoARefeicao(verificarUsuario());
				limparCamposRefeicao(); 
				listarRefeicao();
				calcularCargaGlicemicaRefeicao();
				imprimirMacrosDaRefeicao(verificarNecessideEnergetica());
			}
		});
		lblNewLabel_11.setForeground(Color.GRAY);
		lblNewLabel_11.setBounds(401, 334, 70, 22);
		panelCadastroRefeicoes.add(lblNewLabel_11);
		
		txtnomeAlimento = new JLabel("");
		txtnomeAlimento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtnomeAlimento.setForeground(Color.GRAY);
		txtnomeAlimento.setBounds(353, 85, 72, 14);
		panelCadastroRefeicoes.add(txtnomeAlimento);
		
		
		txtPorcao = new JTextField();
		txtPorcao.setForeground(Color.GRAY);
		txtPorcao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtPorcao.setBackground(Color.WHITE);
		txtPorcao.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPorcao.setBounds(353, 105, 46, 14);
		panelCadastroRefeicoes.add(txtPorcao);
		txtPorcao.setColumns(10);
		
		
		
		txtCarbohidratos = new JLabel("0 g");
		txtCarbohidratos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCarbohidratos.setForeground(Color.GRAY);
		txtCarbohidratos.setBounds(384, 136, 33, 14);
		panelCadastroRefeicoes.add(txtCarbohidratos);
		
		txtProteinas = new JLabel("0 g");
		txtProteinas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtProteinas.setForeground(Color.GRAY);
		txtProteinas.setBounds(384, 161, 33, 14);
		panelCadastroRefeicoes.add(txtProteinas);
		
		txtGordurasTotais = new JLabel("0 g");
		txtGordurasTotais.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtGordurasTotais.setForeground(Color.GRAY);
		txtGordurasTotais.setBounds(384, 186, 33, 14);
		panelCadastroRefeicoes.add(txtGordurasTotais);
		
		txtFibras = new JLabel("0 g");
		txtFibras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtFibras.setForeground(Color.GRAY);
		txtFibras.setBounds(384, 211, 33, 14);
		panelCadastroRefeicoes.add(txtFibras);
		
		txtSodio = new JLabel("0 g");
		txtSodio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtSodio.setForeground(Color.GRAY);
		txtSodio.setBounds(384, 236, 41, 14);
		panelCadastroRefeicoes.add(txtSodio);
		
		txtCalorias = new JLabel("0  Kcal");
		txtCalorias.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCalorias.setForeground(Color.GRAY);
		txtCalorias.setBounds(384, 261, 70, 14);
		panelCadastroRefeicoes.add(txtCalorias);
		
		JLabel lblNewLabel_13 = new JLabel("Nome:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_13.setForeground(Color.GRAY);
		lblNewLabel_13.setBounds(277, 86, 46, 14);
		panelCadastroRefeicoes.add(lblNewLabel_13);
		
		JLabel lblNewLabel_13_1 = new JLabel("Quantidade:");
		lblNewLabel_13_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_13_1.setForeground(Color.GRAY);
		lblNewLabel_13_1.setBounds(277, 111, 97, 14);
		panelCadastroRefeicoes.add(lblNewLabel_13_1);
		
		JLabel lblNewLabel_13_2 = new JLabel("Carbohidratos:");
		lblNewLabel_13_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_13_2.setForeground(Color.GRAY);
		lblNewLabel_13_2.setBounds(277, 136, 86, 14);
		panelCadastroRefeicoes.add(lblNewLabel_13_2);
		
		JLabel lblNewLabel_13_3 = new JLabel("Proteínas:");
		lblNewLabel_13_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_13_3.setForeground(Color.GRAY);
		lblNewLabel_13_3.setBounds(277, 161, 86, 14);
		panelCadastroRefeicoes.add(lblNewLabel_13_3);
		
		JLabel lblNewLabel_13_4 = new JLabel("Gorduras Totais:");
		lblNewLabel_13_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_13_4.setForeground(Color.GRAY);
		lblNewLabel_13_4.setBounds(277, 186, 86, 14);
		panelCadastroRefeicoes.add(lblNewLabel_13_4);
		
		JLabel lblNewLabel_13_5 = new JLabel("Fibras:");
		lblNewLabel_13_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_13_5.setForeground(Color.GRAY);
		lblNewLabel_13_5.setBounds(277, 211, 46, 14);
		panelCadastroRefeicoes.add(lblNewLabel_13_5);
		
		JLabel lblNewLabel_14 = new JLabel("Sódio:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_14.setForeground(Color.GRAY);
		lblNewLabel_14.setBounds(277, 236, 46, 14);
		panelCadastroRefeicoes.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Valor Energético:");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_15.setForeground(Color.GRAY);
		lblNewLabel_15.setBounds(277, 261, 97, 14);
		panelCadastroRefeicoes.add(lblNewLabel_15);
		
		idAlimento = new JLabel("");
		idAlimento.setVisible(false);
		idAlimento.setBounds(277, 295, 46, 14);
		panelCadastroRefeicoes.add(idAlimento);
		
		
		
		prCarbs = new JLabel("0%");
		prCarbs.setFont(new Font("Tahoma", Font.PLAIN, 11));
		prCarbs.setForeground(Color.GRAY);
		prCarbs.setBounds(427, 136, 48, 14);
		panelCadastroRefeicoes.add(prCarbs);
		
		prProt = new JLabel("0%");
		prProt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		prProt.setForeground(Color.GRAY); 
		prProt.setBounds(427, 161, 48, 14);
		panelCadastroRefeicoes.add(prProt);
		
		prGor = new JLabel("0%");
		prGor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		prGor.setForeground(Color.GRAY);
		prGor.setBounds(427, 186, 48, 14);
		panelCadastroRefeicoes.add(prGor);
		
		prFibras = new JLabel("0%");
		prFibras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		prFibras.setForeground(Color.GRAY);
		prFibras.setBounds(427, 211, 48, 14);
		panelCadastroRefeicoes.add(prFibras);
		
		prSod = new JLabel("0%");
		prSod.setFont(new Font("Tahoma", Font.PLAIN, 11));
		prSod.setForeground(Color.GRAY);
		prSod.setBounds(427, 236, 48, 14);
		panelCadastroRefeicoes.add(prSod);
		
		prKcal = new JLabel("");
		prKcal.setVisible(false);
		prKcal.setForeground(Color.WHITE);
		prKcal.setBounds(415, 261, 23, 14);
		panelCadastroRefeicoes.add(prKcal);
		
		
		txtIG = new JLabel("");
		txtIG.setVisible(false);
		txtIG.setBounds(380, 286, 46, 14);
		panelCadastroRefeicoes.add(txtIG);
		
		JLabel lblNewLabel_10 = new JLabel("Reajustar");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setForeground(Color.GRAY);
		lblNewLabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calcularMacrosDaRefeicao();
			}
		});
		lblNewLabel_10.setBounds(418, 108, 88, 14);
		panelCadastroRefeicoes.add(lblNewLabel_10);
		
		txtNecessidadeCalorica = new JLabel("0 kcal");
		txtNecessidadeCalorica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtNecessidadeCalorica.setForeground(Color.GRAY);
		txtNecessidadeCalorica.setBounds(603, 632, 46, 14);
		panelCadastroRefeicoes.add(txtNecessidadeCalorica);
		
		txtKcalsDieta = new JLabel("0 kcal");
		txtKcalsDieta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtKcalsDieta.setForeground(Color.GRAY);
		txtKcalsDieta.setBounds(695, 632, 80, 14);
		panelCadastroRefeicoes.add(txtKcalsDieta);
		
		JLabel lblNewLabel_8_5_1 = new JLabel("Carga Glicêmica da Refeição:");
		lblNewLabel_8_5_1.setForeground(Color.GRAY);
		lblNewLabel_8_5_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_5_1.setBounds(485, 478, 164, 14);
		panelCadastroRefeicoes.add(lblNewLabel_8_5_1);
		
		txtCargaGlicemica = new JLabel("");
		txtCargaGlicemica.setForeground(Color.GRAY);
		txtCargaGlicemica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCargaGlicemica.setBounds(637, 478, 46, 14);
		panelCadastroRefeicoes.add(txtCargaGlicemica);
		
		lblNewLabel_8_1 = new JLabel("Excluir");
		lblNewLabel_8_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				excuirAlimentoRefeicao();
				listarRefeicao();
				calcularCargaGlicemicaRefeicao();
				imprimirMacrosDaRefeicao(verificarNecessideEnergetica());
			}
		});
		lblNewLabel_8_1.setForeground(Color.GRAY);
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8_1.setBounds(289, 338, 203, 14);
		panelCadastroRefeicoes.add(lblNewLabel_8_1);
		
		txtRefeicaoId = new JLabel("");
		txtRefeicaoId.setVisible(false);
		txtRefeicaoId.setDoubleBuffered(true);
		txtRefeicaoId.setBounds(141, 632, 46, 14);
		panelCadastroRefeicoes.add(txtRefeicaoId);
		
		lblNewLabel_4 = new JLabel("_________");
		lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4.setBounds(341, 108, 70, 14);
		panelCadastroRefeicoes.add(lblNewLabel_4);
		
		txtNomeRefeicaoEx = new JLabel("");
		txtNomeRefeicaoEx.setVisible(false);
		txtNomeRefeicaoEx.setBounds(229, 592, 46, 14);
		panelCadastroRefeicoes.add(txtNomeRefeicaoEx);
		
		panelMenu = new JPanel();
		panelMenu.setLayout(null);
		panelMenu.setBackground(Color.BLACK);
		panelMenu.setBounds(0, 0, 236, 743);
		contentPane.add(panelMenu);
		
		lblCadastrarAvaliacao = new JLabel("Cadastrar Avaliação");
		lblCadastrarAvaliacao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarAvaliacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				panelCadastroAlimentos.setVisible(false);
				panelCadastroRefeicoes.setVisible(false);
				panelCadastroDemaisAvaliacoes.setVisible(true);
			}
		});
		lblCadastrarAvaliacao.setForeground(Color.WHITE);
		lblCadastrarAvaliacao.setBounds(61, 193, 132, 14);
		panelMenu.add(lblCadastrarAvaliacao);
		
		lblCadastrarDieta = new JLabel("Minha Dieta");
		lblCadastrarDieta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarDieta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				panelCadastroAlimentos.setVisible(false);
				panelCadastroRefeicoes.setVisible(true);
				panelCadastroDemaisAvaliacoes.setVisible(false);
			}
		});
		lblCadastrarDieta.setForeground(Color.WHITE);
		lblCadastrarDieta.setBounds(61, 339, 98, 14);
		panelMenu.add(lblCadastrarDieta);
		
		lblCadastrarAlimento = new JLabel("Cadastrar Alimento");
		lblCadastrarAlimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastrarAlimento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				panelCadastroAlimentos.setVisible(true);
				panelCadastroRefeicoes.setVisible(false);
				panelCadastroDemaisAvaliacoes.setVisible(false);
				
			}
		});
		lblCadastrarAlimento.setForeground(Color.WHITE);
		lblCadastrarAlimento.setBounds(61, 262, 132, 14);
		panelMenu.add(lblCadastrarAlimento);
		
			
			lblNewLabel_7 = new JLabel("Restaurar Sistema");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblNewLabel_7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					UsuarioDAO objetousuariodao = new UsuarioDAO();
					objetousuariodao.resetarSistema();
					panelInicio.setVisible(true);
					panelCadastroAlimentos.setVisible(false);
					panelCadastroRefeicoes.setVisible(false);
					panelCadastroDemaisAvaliacoes.setVisible(true);
				}
			});
			lblNewLabel_7.setForeground(Color.GRAY);
			lblNewLabel_7.setBounds(70, 695, 89, 14);
			panelMenu.add(lblNewLabel_7);
		inicializador(verificarUsuario());
		listarAlimento();
		listarRefeicao();
		listarAlimentosPorGrupo();
		
		
		
		
	}
}
