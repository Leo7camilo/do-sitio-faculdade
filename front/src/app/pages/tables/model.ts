import * as moment from 'moment';

export class Categoria {
  codigo: number;
}

export class Produtor {
  codigo: number;
}

export class Mercadoria {
  codigo: number;
  tipo = 'RECEITA';
  descricao: string;
  dataProducao: Date;
  valor: number;
  observacao: string;
  categoria = new Categoria();
  produtor = new Produtor();

  static toJson(mercadoria: Mercadoria): any {
    return {
      codigo: mercadoria.codigo,
      tipo: mercadoria.tipo,
      descricao: mercadoria.descricao,
      dataProducao: moment(mercadoria.dataProducao).format('DD/MM/YYYY'),
      valor: mercadoria.valor,
      observacao: mercadoria.observacao,
      produtor: mercadoria.produtor,
      categoria: mercadoria.categoria
    };
  }
}
