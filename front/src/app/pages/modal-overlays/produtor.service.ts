import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProdutorService {

  produtoresUrl = 'http://localhost:8080/produtor';

  constructor(
    private http: HttpClient
  ) { }

  listarTodas(): Promise<any> {
    return this.http.get(this.produtoresUrl)
      .toPromise();
  }
}
