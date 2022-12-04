package br.com.quarkus.api.resources;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import br.com.quarkus.api.models.Produto;
import br.com.quarkus.api.services.ProdutoService;

@Path("produto")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class ProdutoResource {

	@Inject
	private ProdutoService produtoService;

	@Transactional
	@POST
	public Response cadastrar(Produto produto) {
		produtoService.cadastrar(produto);
		return Response.status(Status.CREATED).build();
	}
	
	@PUT
	@Path("{idProduto}")
	public Response atualizar(@PathParam(value = "idProduto") Long id, Produto produto) {
		produto.id = id;
		produtoService.atualizar(produto);
		return Response.ok().build();
	}

	@GET
	public List<Produto> consultarTodosProdutos() {
		return produtoService.consultarTodosProdutos();
	}
	
	@GET
	public Response consultar(@QueryParam(value = "idProduto") Long idProduto) {
		Optional<Produto> optProduto = produtoService.consultar(idProduto);
		if(optProduto.isEmpty()) {
			return Response.noContent().build();
		}
		return Response.ok().entity(optProduto.get()).build();
	}
	
	@DELETE
	@Path("{idProduto}")
	public Response deletar(@PathParam(value = "idProduto") Long idProduto) {
		produtoService.deletar(idProduto);
		return Response.ok().build();
	}

}


