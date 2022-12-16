import { HttpClient, HttpXhrBackend } from '@angular/common/http';
import { Component } from '@angular/core';
import { NbDialogService } from '@nebular/theme';
import { LocalDataSource } from 'ng2-smart-table';

import { SmartTableData } from '../../../@core/data/smart-table';
import { FormMercadoriaDialogComponent } from '../../modal-overlays/dialog/form-mercadoria-dialog/form-mercadoria-dialog.component';
import { ShowcaseDialogComponent } from '../../modal-overlays/dialog/showcase-dialog/showcase-dialog.component';
import { MercadoriaService } from '../mercadoria.service';

@Component({
  selector: 'ngx-smart-table',
  templateUrl: './smart-table.component.html',
  styleUrls: ['./smart-table.component.scss'],
})
export class SmartTableComponent {

  private http : HttpClient = new HttpClient(
    new HttpXhrBackend({ build: () => new XMLHttpRequest() })
  );

  private mercadoriaService: MercadoriaService = new MercadoriaService(this.http);

  mercadorias = [];

  settings = {
    add: {
      addButtonContent: '<i class="nb-plus"></i>',
      createButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
    },
    edit: {
      editButtonContent: '<i class="nb-edit"></i>',
      saveButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
    },
    delete: {
      deleteButtonContent: '<i class="nb-trash"></i>',
      confirmDelete: true,
    },
    columns: {
      codigo: {
        title: 'Codigo',
        type: 'number',
      },
      descricao: {
        title: 'Descrição',
        type: 'string',
      },
      dataProducao: {
        title: 'Data de Produção',
        type: 'string',
      },
      observacao: {
        title: 'Observação',
        type: 'string',
      },
      valor: {
        title: 'Valor por kilo',
        type: 'number',
      },
    },
  };


  source: LocalDataSource = new LocalDataSource();

  constructor(private service: SmartTableData,
              private dialogService: NbDialogService) {
    this.pesquisar(0);
  }

  pesquisar(pagina: number = 0): void {
    this.mercadoriaService.pesquisar(null)
    .then((resultado: any) => {
        this.mercadorias = resultado.mercadorias;
        this.source.load(this.mercadorias);
      });
  }

  onDeleteConfirm(event): void {
    if (window.confirm('Are you sure you want to delete?')) {
      event.confirm.resolve();
    } else {
      event.confirm.reject();
    }
  }


  onUserRowSelect(event): void {
    console.log(event);
    this.dialogService.open(ShowcaseDialogComponent, {
      context: {
        mercadoria: event,
      },
    });
  }


  onCadastrarMercadoria(): void {
      this.dialogService.open(FormMercadoriaDialogComponent);
  }
}
