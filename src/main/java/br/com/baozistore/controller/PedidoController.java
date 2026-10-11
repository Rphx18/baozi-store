package br.com.baozistore.controller;

import br.com.baozistore.model.Cliente;
import br.com.baozistore.model.Pedido;
import br.com.baozistore.model.PedidoRequest;
import br.com.baozistore.model.Produto;
import br.com.baozistore.repository.ClienteRepository;
import br.com.baozistore.repository.PedidoRepository;
import br.com.baozistore.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoController(PedidoRepository pedidoRepository,
                            ClienteRepository clienteRepository,
                            ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public ResponseEntity<Pedido> criar(@RequestBody PedidoRequest request) {
        Optional<Cliente> cliente = clienteRepository.findById(request.clienteId());
        Optional<Produto> produto = produtoRepository.findById(request.produtoId());

        if (cliente.isEmpty() || produto.isEmpty()
                || request.quantidade() == null || request.quantidade() <= 0) {
            return ResponseEntity.badRequest().build();
        }

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente.get());
        pedido.setProduto(produto.get());
        pedido.setQuantidade(request.quantidade());
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoRepository.save(pedido));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @RequestBody PedidoRequest request) {
        Optional<Pedido> existente = pedidoRepository.findById(id);
        Optional<Cliente> cliente = clienteRepository.findById(request.clienteId());
        Optional<Produto> produto = produtoRepository.findById(request.produtoId());

        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (cliente.isEmpty() || produto.isEmpty()
                || request.quantidade() == null || request.quantidade() <= 0) {
            return ResponseEntity.badRequest().build();
        }

        Pedido pedido = existente.get();
        pedido.setCliente(cliente.get());
        pedido.setProduto(produto.get());
        pedido.setQuantidade(request.quantidade());
        return ResponseEntity.ok(pedidoRepository.save(pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id) {
        if (!pedidoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pedidoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
