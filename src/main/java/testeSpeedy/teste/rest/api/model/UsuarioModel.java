package testeSpeedy.teste.rest.api.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 50)
	private String nome;

	@Column(nullable = false, length = 11)
	private Long cpf;

	@Pattern(regexp="^M|F$")
	@Column(name = "sexo", nullable = false)
	private String sexo;

	@Column(nullable = false)
	@Past
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Calendar nascimento;

	@Column(nullable = false, length = 50)
	private String veiculo;

	@Column(nullable = false)
	@DecimalMin("1.00")
	private Double valor;
	
	@Column
	private Double calculo;
	
	@Column
	private Integer idade;
	
	@Column
	private Integer qtdparcelas;

	@Column
	private Double parcela;


	public UsuarioModel() {
	}

	public UsuarioModel(
			Integer id, 
			String nome, 
			Long cpf, 
			String sexo, 
			Calendar nascimento,
			String veiculo,
			Double valor,
			Double calculo,
			Integer idade,
			Integer qtdparcelas,
			Double parcela){
		id = id;
		nome = nome;
		cpf = cpf;
		sexo = sexo;
		nascimento = nascimento;
		veiculo = veiculo;
		valor = valor;
		calculo = calculo;
		qtdparcelas = qtdparcelas;
		idade = idade;
		
		parcela = parcela;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	
	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
		

	public Double getCalculo() {
		
		if(sexo=="F") {
			if(idade>=18 && idade<26) {
				calculo = (valor * 0.03) * 1.10;
			} else if (idade>25 && idade<31) {
				calculo = (valor * 0.03) * 1.05;
				
			} else if (idade>30 && idade<36) {
				calculo = (valor * 0.03) * 1.02;
				
			} else if (idade>35) {
				calculo = (valor * 0.03) * 1.00;
				
			}

		} else { // para genero masculino  acrescer 10% do valor base
			if(idade>=18 && idade<26) {
				calculo = ((valor * 0.03) * 1.10) + ((valor * 0.03) * 1.10);
			} else if (idade>25 && idade<31) {
				calculo = ((valor * 0.03) * 1.05) + ((valor * 0.03) * 1.10);
				
			} else if (idade>30 && idade<36) {
				calculo = ((valor * 0.03) * 1.02) + ((valor * 0.03) * 1.10);
				
			} else if (idade>35) {
				calculo = ((valor * 0.03) * 1.00) + ((valor * 0.03) * 1.10);
				
			}

		}

		return calculo;
	}

	public void setCalculo(Double calculo) {		
		this.calculo = calculo;
	}

	public Integer getIdade() {
		Calendar hoje = Calendar.getInstance();
		int age = hoje.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);
		idade = age;

		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	

	public Integer getQtdparcelas() {
		return qtdparcelas;
	}

	public void setQtdparcelas(Integer qtdparcelas) {
		this.qtdparcelas = qtdparcelas;
	}

	public Double getParcela() {
		switch(qtdparcelas) {
		case 1: 
			parcela = calculo; 
			break;
		case 2: 
			parcela = calculo/2; 
			break;
		case 3: 
			parcela = calculo/3; 
			break;
		case 4: 
			parcela = calculo/4; 
			break;
		case 5: 
			parcela = calculo/5; 
			break;
		case 6: 
			parcela = (calculo * 1.03)/6; 
			break;
		case 7: 
			parcela = (calculo * 1.03)/7; 
			break;
		case 8: 
			parcela = (calculo * 1.03)/8; 
			break;
		case 9: 
			parcela = (calculo * 1.03)/9; 
			break;
		case 10: 
			parcela = (calculo * 1.05)/10; 
			break;
		case 11: 
			parcela = (calculo * 1.05)/11; 
			break;
		case 12: 
			parcela = (calculo * 1.05)/12; 
			break;
		default: 
			parcela = null;
		}
		
		return parcela;
	}

	public void setParcela(Double parcela) {
		this.parcela = parcela;
	}

}
