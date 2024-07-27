package br.com.tech.pedidos.api.model;

import br.com.tech.pedidos.domain.model.Comprador;
import br.com.tech.pedidos.domain.model.Fornecedor;
import br.com.tech.pedidos.domain.model.ItemPedido;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PedidoModel {
    private Long id;
    private Comprador comprador;
    private Fornecedor fornecedor;
    private ItemPedido itemPedido;
    private Integer totalProdutos;
    private BigDecimal valorTotal;
}
