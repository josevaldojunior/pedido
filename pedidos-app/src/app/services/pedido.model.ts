export interface Comprador {
  nome: string;
}

export interface Fornecedor {
  nome: string;
}

export interface Produto {
  nome: string;
}

export interface ItemPedido {
  pedidoId: number;
  produto: Produto;
  quantidade: number;
  valorTotalProduto: number;
}

export interface Pedido {
  id: number;
  comprador: Comprador;
  fornecedor: Fornecedor;
  totalProdutos: number;
  valorTotal: number;
}
