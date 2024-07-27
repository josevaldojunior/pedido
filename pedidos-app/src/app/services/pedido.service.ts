import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ItemPedido, Pedido } from './pedido.model';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  private apiUrl = 'http://localhost:8080/api/pedido';

  constructor(private http: HttpClient) { }

  getPedidos(): Observable<Pedido[]> {
    return this.http.get<Pedido[]>(this.apiUrl);
  }

  getItensPedido(pedidoId: number): Observable<ItemPedido[]> {
    return this.http.get<ItemPedido[]>(`${this.apiUrl}/itens/${pedidoId}`);
  }

}
