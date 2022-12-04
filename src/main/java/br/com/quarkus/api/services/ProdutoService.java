package br.com.quarkus.api.services;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.quarkus.api.models.Produto;
import br.com.quarkus.api.repositories.ProdutoRepository;

@Transactional
@ApplicationScoped
public class ProdutoService {

	@Inject
	private ProdutoRepository produtoRepository;
	
	public Produto cadastrar(Produto produto) {
		return produtoRepository.cadastrar(produto);
	}
	
	public Produto atualizar(Produto produto) {
		Produto produtoDB = Produto.findById(produto.id);
		produtoDB.setDescricao(produto.getDescricao());
		produtoDB.setValor(produto.getValor());
		return produtoRepository.cadastrar(produtoDB);
	}
	
	public Optional<Produto> consultarPorId(Long idProduto) {
		return produtoRepository.consultarPorId(idProduto);
	}

	public List<Produto> consultarTodosProdutos(){
		return produtoRepository.consultarTodosProdutos();
	}
	
	public void deletar(Long idProduto) {
		produtoRepository.deletar(idProduto);
	}
}

