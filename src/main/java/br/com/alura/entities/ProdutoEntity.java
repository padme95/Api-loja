package br.com.alura.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.alura.dtos.ProdutoDto;
import lombok.Data;

@Data
@Entity
@Table(name = "produto")
public class ProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nome;
	private String descricao;
	private double preco;

	public ProdutoDto toDTO() {
		ModelMapper mapper = new ModelMapper();

		ProdutoDto dto = mapper.map(this, ProdutoDto.class);

		return dto;
	}

}
