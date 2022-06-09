package br.com.alura.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.entities.ProdutoEntity;
import br.com.alura.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<ProdutoEntity> getAll(){
		return produtoRepository.findAll();
	}
	
	public ProdutoEntity getOne(int id) {
		return produtoRepository.findById(id).orElse(new ProdutoEntity());
	}
	
	public ProdutoEntity save(ProdutoEntity produto) {
		return produtoRepository.save(produto);
	}
	
	public void excluir(int id) {
		produtoRepository.deleteById(id);
	}
	
	public ProdutoEntity update(int id, ProdutoEntity novoProduto) {
		
		Optional<ProdutoEntity> optional = produtoRepository.findById(id);
		
		if(optional.isPresent()) {
			ProdutoEntity produto = optional.get();
			produto.setDescricao(novoProduto.getDescricao());
			produto.setNome(novoProduto.getNome());
			produto.setPreco(novoProduto.getPreco());
			return produtoRepository.save(produto);
		}else {
			return new ProdutoEntity();
		}		
	}
	
	
	
//	ProdutoEntity produtoAtual = produtoRepository.findById(id).get();
//	produtoAtual.setNome(produto.getNome());
//	return produtoRepository.save(produtoAtual);
}
