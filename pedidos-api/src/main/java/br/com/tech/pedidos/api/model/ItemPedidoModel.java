package br.com.tech.pedidos.api.model;

import br.com.tech.pedidos.domain.model.Produto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemPedidoModel {
    private Produto produto;
    private Integer quantidade;
    private BigDecimal valorTotalProduto;
}
