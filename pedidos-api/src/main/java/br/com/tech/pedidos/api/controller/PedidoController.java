package br.com.tech.pedidos.api.controller;

import br.com.tech.pedidos.api.assembler.ItemPedidoAssembler;
import br.com.tech.pedidos.api.assembler.PedidoAssembler;
import br.com.tech.pedidos.api.model.ItemPedidoModel;
import br.com.tech.pedidos.api.model.PedidoModel;
import br.com.tech.pedidos.domain.service.PedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@Tag(name = "Pedidos")
@RequestMapping("/api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;
    private final PedidoAssembler pedidoAssembler;
    private final ItemPedidoAssembler itemPedidoAssembler;

    @GetMapping
    public ResponseEntity<List<PedidoModel>> findAll() {
        return ResponseEntity.ok(pedidoAssembler.toListModel(pedidoService.listarTodosPedidos()));
    }

    @GetMapping("/itens/{id}")
    public ResponseEntity<List<ItemPedidoModel>> findItensPedido(@PathVariable Long id) {
        return ResponseEntity.ok(itemPedidoAssembler.toListModel(pedidoService.listarItensPedido(id)));
    }

}
