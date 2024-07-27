package br.com.tech.pedidos.api.assembler;

import br.com.tech.pedidos.api.model.ItemPedidoModel;
import br.com.tech.pedidos.domain.model.ItemPedido;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ItemPedidoAssembler {

    private final ModelMapper modelMapper;

    public ItemPedidoModel toModel(ItemPedido itemPedido){
        return modelMapper.map(itemPedido, ItemPedidoModel.class);
    }

    public List<ItemPedidoModel> toListModel(List<ItemPedido> itensPedido){
        return itensPedido.stream()
                .map(this::toModel)
                .toList();
    }

}
