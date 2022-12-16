import { Produtor } from './../../../tables/model';
import { Component, Input, OnInit } from '@angular/core';
import { NbComponentStatus, NbDialogRef, NbDialogService, NbGlobalPhysicalPosition, NbGlobalPosition, NbToastrConfig, NbToastrService } from '@nebular/theme';
import { Mercadoria } from '../../../tables/model';
import { CategoriaService } from '../../categoria.service';
import { ProdutorService } from '../../produtor.service';
import { MercadoriaService } from '../../../tables/mercadoria.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'ngx-form-mercadoria-dialog',
  templateUrl: 'form-mercadoria-dialog.component.html',
  styleUrls: ['form-mercadoria-dialog.component.scss'],
})
export class FormMercadoriaDialogComponent implements OnInit {


  mercadoria: Mercadoria = new Mercadoria();
  produtores = [];

  categorias = [];

  //produtor: string;

  starRate = 2;
  heartRate = 4;
  radioGroupValue = 'This is value 2';

  date = new Date();

  status: NbComponentStatus = 'primary';
  config: NbToastrConfig;
  index = 1;
  destroyByClick = true;
  duration = 5000;
  hasIcon = true;
  position: NbGlobalPosition = NbGlobalPhysicalPosition.TOP_RIGHT;
  preventDuplicates = false;

  constructor(protected ref: NbDialogRef<FormMercadoriaDialogComponent>,
              private categoriaService: CategoriaService,
              private produtorService: ProdutorService,
              private toastrService: NbToastrService,
              private mercadoriaService: MercadoriaService,
              private router: Router,
              private dialogService: NbDialogService) {}
  ngOnInit(): void {

    this.carregarCategorias();
    this.carregarProdutores();
  }

  dismiss() {
    this.ref.close();
  }

  salvar(mercadoriaForm: NgForm){

    console.log(mercadoriaForm);
    console.log('Valido: '+mercadoriaForm.valid);
    console.log('Invalido: '+mercadoriaForm.invalid);

    if(!mercadoriaForm.invalid){
      this.mercadoriaService.adicionar(mercadoriaForm.form.value).
        then(() => {
          let status: NbComponentStatus = 'success';
          let title = "Sucesso";
          this.showToast(status, title, "Produto adicionado com sucesso!");
          this.ref.close();
          this.router.navigate(['/pages/tables']);
          this.router.navigate(['/pages/tables/produto']);
      })
      .catch(response => {
        let status: NbComponentStatus = 'warning';
        let title = "Erro";

        if(response.status === 401){
          let msg = 'Sua sessão expirou!';
          this.showToast(status, title, msg);
          this.router.navigate(['/auth/login']);
        }else {
          this.showToast(status, title, response[0]['mensagemUsuario']);
        }
      });
    }
  }


  carregarProdutores(): any {
    return this.produtorService.listarTodas()
      .then(produtores => {
        this.produtores = produtores;
        console.log(produtores);
      })
      .catch(response => {
        let status: NbComponentStatus = 'warning';
        let title = "Erro";
        this.showToast(status, title, response);
      });
  }

  carregarCategorias(): any {
    return this.categoriaService.listarTodas()
      .then(categorias => {
        this.categorias = categorias;
        console.log(categorias);

      })
      .catch(response => {
        let status: NbComponentStatus = 'warning';
        let title = "Erro";
        this.showToast(status, title, response);
      });
  }

  private showToast(type: NbComponentStatus, title: string, response: string) {
    const config = {
    status: type,
    destroyByClick: this.destroyByClick,
    duration: this.duration,
    hasIcon: this.hasIcon,
    position: this.position,
    preventDuplicates: this.preventDuplicates,
  };

  this.toastrService.show(
    response,
    `${title}`,
    config);
  }

}
