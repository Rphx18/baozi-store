package br.com.baozistore.model;

/**
 * Corpo JSON recebido no POST/PUT de pedidos (igual ao DER: clienteId, produtoId, quantidade).
 */
public record PedidoRequest(Long clienteId, Long produtoId, Integer quantidade) {
}
