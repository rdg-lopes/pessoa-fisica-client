package client.pessoa;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("pessoaFisica")
@JsonPropertyOrder(value = {"codigo", "cpf", "nome"})
public class PessoaFisicaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String cpf;
	private String nome;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "PessoaFisicaDTO [codigo=" + codigo + ", cpf=" + cpf + ", nome=" + nome + "]";
	}

}
