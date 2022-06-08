package br.com.alura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.entities.ProdutoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer>{

}
