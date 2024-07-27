import { Component, OnInit } from '@angular/core';
import { ItemPedido, Pedido } from '../services/pedido.model';
import { PedidoService } from '../services/pedido.service';
import { MatDialog } from '@angular/material/dialog';
import { ItemPedidoModalComponent } from '../item-pedido-modal/item-pedido-modal.component';

@Component({
  selector: 'app-pedido',
  templateUrl: './pedido.component.html',
  styleUrls: ['./pedido.component.css']
})
export class PedidoComponent implements OnInit {

  pedido: Pedido[] = [];
  itensPedido: ItemPedido[] = [];
  columnsToDisplay: string[] = ['id', 'comprador', 'fornecedor', 'totalProdutos', 'valorTotal'];
  columnsToDisplayWithExpand = [...this.columnsToDisplay, 'expand'];

  constructor(private pedidoService: PedidoService, public dialog: MatDialog) { }

  ngOnInit() {
    this.getPedidos();
  }

  openItemPedidoModal(pedido: Pedido): void {
    const dialogRef = this.dialog.open(ItemPedidoModalComponent, {
      width: '600px',
      data: { pedidoId: pedido.id }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('O diálogo foi encerrado');
    });
  }

  getPedidos() {
    this.pedidoService.getPedidos().subscribe(
      res => {
        this.pedido = res.map((p, index) => ({
          ...p,
          position: index + 1,
          showProducts: false
        }));
      },
      error => {
        console.error('Erro ao listar Pedidos: ', error);
      }
    );
  }
}