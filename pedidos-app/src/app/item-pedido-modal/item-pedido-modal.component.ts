import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { PedidoService } from '../services/pedido.service';
import { ItemPedido } from '../services/pedido.model';

@Component({
  selector: 'app-item-pedido-modal',
  templateUrl: './item-pedido-modal.component.html',
  styleUrls: ['./item-pedido-modal.component.css']
})
export class ItemPedidoModalComponent implements OnInit {

  itensPedido: ItemPedido[] = [];
  pedidoId: number;

  constructor(
    private pedidoService: PedidoService,
    public dialogRef: MatDialogRef<ItemPedidoModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    this.pedidoId = data.pedidoId;
  }

  ngOnInit(): void {
    this.getItensPedido();
  }

  getItensPedido() {
    this.pedidoService.getItensPedido(this.pedidoId).subscribe(
      res => {
        this.itensPedido = res;
      },
      error => {
        console.error('Erro ao listar Itens do Pedido: ', error);
      }
    );
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
