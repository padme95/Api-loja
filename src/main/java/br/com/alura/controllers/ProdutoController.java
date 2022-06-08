package br.com.alura.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.entities.ProdutoEntity;
import br.com.alura.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	@GetMapping
	public List<ProdutoEntity> buscar(){
		return produtoService.getAll();
	}
	
	@GetMapping("{id}")
	public ProdutoEntity getOne(@PathVariable int id) {
		return produtoService.getOne(id);
	}
	
	@PostMapping
	public ProdutoEntity salvar(@RequestBody ProdutoEntity produto) {
		return produtoService.save(produto);
	}
	
	@DeleteMapping("{id}")
	public void excluir(@PathVariable int id) {
		produtoService.excluir(id);
	}
	
	@PutMapping("{id}")
	public ProdutoEntity update(@PathVariable int id, @RequestBody ProdutoEntity produto) {

		return produtoService.update(id, produto);
	}
}
