package br.com.alura.services;

import java.util.List;

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
	
	public ProdutoEntity update(int id, ProdutoEntity produto) {
		ProdutoEntity produtoAtual = produtoRepository.findById(id).get();
		produtoAtual.setNome(produto.getNome());
		return produtoRepository.save(produtoAtual);
	}
}
