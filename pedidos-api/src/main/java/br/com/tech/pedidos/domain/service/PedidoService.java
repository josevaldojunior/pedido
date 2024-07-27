package br.com.tech.pedidos.domain.service;

import br.com.tech.pedidos.domain.model.ItemPedido;
import br.com.tech.pedidos.domain.model.Pedido;
import br.com.tech.pedidos.domain.repository.ItemPedidoRepositorio;
import br.com.tech.pedidos.domain.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepositorio itemPedidoRepositorio;

    public List<Pedido> listarTodosPedidos(){
        return pedidoRepository.findAll();
    }

    public List<ItemPedido> listarItensPedido(Long id){
        return itemPedidoRepositorio.findByPedidoId(id);
    }

}
