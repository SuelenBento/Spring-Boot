package com.generation.farmacia.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.Model.ModelCategoria;

@Repository
public interface RepositoryCategoria extends JpaRepository<ModelCategoria, Long> {
	public List<ModelCategoria> findAllByTituloContainingIgnoreCase(String titulo);

}
