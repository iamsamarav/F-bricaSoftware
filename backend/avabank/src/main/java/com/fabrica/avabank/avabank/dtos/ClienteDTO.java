package com.fabrica.avabank.avabank.dtos;

import java.util.Date;

import com.fabrica.avabank.avabank.entities.Cliente;
import com.fabrica.avabank.avabank.entities.Endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;

public class ClienteDTO {
	private String cpf;
	private String nome;
	private Date dataNascimento;
	private String email;
	private String telefone;
	private Endereco endereco;
	private String senha;
	 
		public String getSenha() {
			return senha;
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
		public Date getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		
		
		public static ClienteDTO toDto(Cliente cliente) {
		    ClienteDTO dto = new ClienteDTO();
		    
		    dto.setCpf(cliente.getCpf());  
		    dto.setNome(cliente.getNome());  
		    dto.setDataNascimento(cliente.getDataNascimento());  
		    dto.setEmail(cliente.getEmail());  
		    dto.setTelefone(cliente.getTelefone());  
		    dto.setEndereco(cliente.getEndereco()); 
		    dto.setSenha(cliente.getSenha());  
		    
		    return dto;
		}

}