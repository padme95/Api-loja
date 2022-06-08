package br.com.alura.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import br.com.alura.entities.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDto {

	@NotEmpty(message = "Preenchimento Obrigatório")
	@NotNull(message = "Preenchimento Obrigatório")
	@Length(min = 3, max = 80, message = "O número de caracteres deve ser entre 3 e 80")
	@Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]*$", message = "É valido apenas caracteres")
	private String nome;
	private String descricao;
	private double preco;

	public ProdutoEntity toEntity() {

		ModelMapper mapper = new ModelMapper();

		return mapper.map(this, ProdutoEntity.class);
	}

}