import { Mercadoria } from './model';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import * as moment from 'moment';
import { DatePipe } from '@angular/common';

export class MercadoriaFiltro {
  descricao?: string;
}

@Injectable({
  providedIn: 'root'
})
export class MercadoriaService {

    mercadoriasUrl = 'http://localhost:8080/mercadoria';

    constructor(
        private http: HttpClient) { }

    pesquisar(filtro: MercadoriaFiltro): Promise<any> {
        const headers = new HttpHeaders()
        //.append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==')
        //.append('Authorization', `Bearer ${localStorage.getItem('token')}`);

        let params = new HttpParams()

        if (filtro != null && filtro.descricao) {
            params = params.set('?descricao', filtro.descricao);
        }

        return this.http.get(`${this.mercadoriasUrl}`, { headers, params })
        .toPromise()
        .then((response: any) => {
            const mercadorias = response['content'];

            const resultado = {
            mercadorias,
            total: response['totalElements']
            };

            return resultado;
        });
    }

    adicionar(mercadoria: any): Promise<Mercadoria> {
        const headers = new HttpHeaders()
        .append('Content-Type', 'application/json')
        .append('Authorization', `Bearer ${localStorage.getItem('token')}`);

        return this.http.post<any>(this.mercadoriasUrl,
        Mercadoria.toJson(mercadoria), { headers })
        .toPromise();
    }

    excluir(codigo: number): Promise<any> {
        return this.http.delete(`${this.mercadoriasUrl}/${codigo}`)
        .toPromise()
        .then(() => null);
    }

    atualizar(mercadoria: Mercadoria): Promise<Mercadoria> {
        const headers = new HttpHeaders()
        .append('Content-Type', 'application/json');

        return this.http.put<Mercadoria>(`${this.mercadoriasUrl}/${mercadoria.codigo}`, Mercadoria.toJson(mercadoria), { headers })
        .toPromise()
        .then((response: any) => {
            const mercadoriaAlterada = response;

            this.converterStringsParaDatas([mercadoriaAlterada]);

            return mercadoriaAlterada;
        });
    }

    buscarPorCodigo(codigo: number): Promise<Mercadoria> {
        return this.http.get<Mercadoria>(`${this.mercadoriasUrl}/${codigo}`)
        .toPromise()
        .then((response: any) => {
            const mercadoria = response;

            this.converterStringsParaDatas([mercadoria]);

            return mercadoria;
        });
    }

    private converterStringsParaDatas(mercadorias: Mercadoria[]): void {
        for (const mercadoria of mercadorias) {
            mercadoria.dataProducao = moment(mercadoria.dataProducao,
                'DD/MM/YYYY').toDate();

        }
    }
}
