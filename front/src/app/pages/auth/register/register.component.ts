import { HttpClient, HttpXhrBackend } from '@angular/common/http';
import { ChangeDetectorRef, Component, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { NbAuthService, NbLoginComponent, NbRegisterComponent, NB_AUTH_OPTIONS } from '@nebular/auth';
import { NbComponentStatus, NbGlobalPhysicalPosition, NbGlobalPosition, NbToastrConfig, NbToastrService } from '@nebular/theme';
import { AuthService } from '../auth.service';


@Component({
  selector: 'ngx-register',
  templateUrl: './register.component.html',
})
export class NgxRegisterComponent extends NbRegisterComponent {

  private http: HttpClient = new HttpClient(
    new HttpXhrBackend({ build: () => new XMLHttpRequest() })
  );
  jwtHelper: JwtHelperService = new JwtHelperService;
  private auth: AuthService = new AuthService(this.http, this.jwtHelper);

  status: NbComponentStatus = 'primary';
  config: NbToastrConfig;
  index = 1;
  destroyByClick = true;
  duration = 5000;
  hasIcon = true;
  position: NbGlobalPosition = NbGlobalPhysicalPosition.TOP_RIGHT;
  preventDuplicates = false;

  constructor(
    service: NbAuthService,
    @Inject(NB_AUTH_OPTIONS) options: {},
    cd: ChangeDetectorRef,
    router: Router,
    private toastrService: NbToastrService) {
    super(service, options, cd, router);
  }

  registerCustom(fullName: string, email: string, password: string, rePass: string) : void {
    this.auth.criar(fullName, email, password, rePass)
      .then(() => {
        let status: NbComponentStatus = 'success';
        let title = "Sucesso";
        this.showToast(status, title, "Usuário Criado com sucesso!");
        this.router.navigate(['/auth/login']);
      })
      .catch((response) => {
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
