package com.generation.farmacia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmacia.Model.ModelProduto;
import com.generation.farmacia.Repository.RepositoryProduto;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/produto")

public class ControllerProduto {

	@Autowired
	private RepositoryProduto repository;

	@GetMapping
	public ResponseEntity<List<ModelProduto>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ModelProduto> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/descricaoProduto/{descricaoProduto}")
	public ResponseEntity<List<ModelProduto>> getByDescricaoProduto(@PathVariable String descricaoProduto) {
		return ResponseEntity.ok(repository.findAllByDescricaoProdutoContainingIgnoreCase(descricaoProduto));
	}

	@PostMapping
	public ResponseEntity<ModelProduto> post(@RequestBody ModelProduto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));

	}

	@PutMapping
	public ResponseEntity<ModelProduto> putBody(@RequestBody ModelProduto produto) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {

		repository.deleteById(id);
	}

}
