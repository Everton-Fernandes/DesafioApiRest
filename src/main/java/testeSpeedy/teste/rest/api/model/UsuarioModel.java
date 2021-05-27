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
	private Double valbase;
	
	@Column
	private Integer idade;



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
			Double valbase,
			Integer idade){
		id = id;
		nome = nome;
		cpf = cpf;
		sexo = sexo;
		nascimento = nascimento;
		veiculo = veiculo;
		valor = valor;
		valbase = valbase;
		idade = idade;
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
		
	public Double getValbase() {
		return valbase;
	}

	public void setValbase(Double valbase) {
		valbase = valor * 0.03;
		this.valbase = valbase;
	}

	public Integer getIdade() {

		return idade;
	}

	public void setIdade(Integer idade) {
		Calendar hoje = Calendar.getInstance();
		int age = hoje.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);
		idade = age;
		this.idade = idade;
	}

	public void calculo (Double valBase) {
		valBase = this.valor * 0.03;
	}

}
