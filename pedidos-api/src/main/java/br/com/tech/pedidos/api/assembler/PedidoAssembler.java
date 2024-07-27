package br.com.tech.pedidos.api.assembler;

import br.com.tech.pedidos.api.model.PedidoModel;
import br.com.tech.pedidos.domain.model.Pedido;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class PedidoAssembler {

    private final ModelMapper modelMapper;

    public PedidoModel toModel(Pedido pedido) {
        return modelMapper.map(pedido, PedidoModel.class);
    }

    public List<PedidoModel> toListModel(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(this::toModel)
                .toList();
    }

}
