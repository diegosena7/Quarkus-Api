package br.com.quarkus.api.repositories;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import br.com.quarkus.api.models.Produto;

@ApplicationScoped
public class ProdutoRepository {

	public Produto cadastrar(Produto produto) {
		produto.persist();
		return produto;
	}
	
	public Optional<Produto> consultarPorId(Long idProduto) {
		return Produto.findByIdOptional(idProduto);
	}
	
	public void deletar(Long idProduto) {
		this.consultarPorId(idProduto).ifPresent(Produto::delete);
	}

	public List<Produto> consultarTodosProdutos() {
		return Produto.listAll();
	}

}

