package com.generation.farmacia.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.farmacia.Model.ModelProduto;

public interface RepositoryProduto extends JpaRepository<ModelProduto, Long> {
	public List<ModelProduto> findAllByDescricaoProdutoContainingIgnoreCase(String descricaoProduto);

}
