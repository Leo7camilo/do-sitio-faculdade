import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {
  NbActionsModule,
  NbButtonModule,
  NbCalendarModule,
  NbCardModule,
  NbCheckboxModule,
  NbDatepickerModule,
  NbDialogModule,
  NbIconModule,
  NbInputModule,
  NbPopoverModule,
  NbRadioModule,
  NbSelectModule,
  NbStepperModule,
  NbTabsetModule,
  NbTooltipModule,
  NbUserModule,
  NbWindowModule,
} from '@nebular/theme';

// modules
import { ThemeModule } from '../../@theme/theme.module';
import { ModalOverlaysRoutingModule } from './modal-overlays-routing.module';

// components
import { ModalOverlaysComponent } from './modal-overlays.component';
import { DialogComponent } from './dialog/dialog.component';
import { ShowcaseDialogComponent } from './dialog/showcase-dialog/showcase-dialog.component';
import { DialogNamePromptComponent } from './dialog/dialog-name-prompt/dialog-name-prompt.component';
import { WindowComponent } from './window/window.component';
import { WindowFormComponent } from './window/window-form/window-form.component';
import { ToastrComponent } from './toastr/toastr.component';
import { PopoversComponent } from './popovers/popovers.component';
import {
  NgxPopoverCardComponent, NgxPopoverFormComponent,
  NgxPopoverTabsComponent,
} from './popovers/popover-examples.component';
import { TooltipComponent } from './tooltip/tooltip.component';
import { FormMercadoriaDialogComponent } from './dialog/form-mercadoria-dialog/form-mercadoria-dialog.component';
import { FormsRoutingModule } from '../forms/forms-routing.module';
import { CalendarComponent } from '../extra-components/calendar/calendar.component';


const COMPONENTS = [
  ModalOverlaysComponent,
  ToastrComponent,
  DialogComponent,
  ShowcaseDialogComponent,
  FormMercadoriaDialogComponent,
  DialogNamePromptComponent,
  WindowComponent,
  WindowFormComponent,
  PopoversComponent,
  NgxPopoverCardComponent,
  NgxPopoverFormComponent,
  NgxPopoverTabsComponent,
  TooltipComponent,
];

const ENTRY_COMPONENTS = [
  ShowcaseDialogComponent,
  DialogNamePromptComponent,
  WindowFormComponent,
  NgxPopoverCardComponent,
  NgxPopoverFormComponent,
  NgxPopoverTabsComponent,
];

const MODULES = [
  FormsModule,
  ThemeModule,
  ModalOverlaysRoutingModule,
  NbDialogModule.forChild(),
  NbWindowModule.forChild(),
  NbCardModule,
  NbCheckboxModule,
  NbTabsetModule,
  NbPopoverModule,
  NbButtonModule,
  NbInputModule,
  NbSelectModule,
  NbTooltipModule,
  NbStepperModule,

  NbActionsModule,
  NbUserModule,
  NbRadioModule,
  NbDatepickerModule,
  NbIconModule,
  NbCalendarModule,

];

const SERVICES = [
];

@NgModule({
  imports: [
    ...MODULES,
  ],
  declarations: [
    ...COMPONENTS,
  ],
  providers: [
    ...SERVICES,
  ],
  entryComponents: [
    ...ENTRY_COMPONENTS,
  ],
})
export class ModalOverlaysModule {
}
