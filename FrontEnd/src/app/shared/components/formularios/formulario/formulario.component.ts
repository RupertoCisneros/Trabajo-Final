import { AfterViewInit, Component, ComponentRef, EventEmitter, Input, OnChanges, Output, ViewChild } from '@angular/core';
import { ConsultasService } from '@global/services/consultas.service';
import { FormularioDirective } from './formulario.directive';
import { FormularioService } from './formulario.service';

export interface FormComponent {
  data: any;
}

@Component({
  selector: 'app-formulario',
  template: `
  <h2>{{tipoRegistro.descripcion}}</h2>
  <ng-template appFormulario></ng-template>
  `,
})

export class FormularioComponent implements OnChanges, AfterViewInit {

  @ViewChild(FormularioDirective)
  formularioHost!: FormularioDirective;
  componentRef!: ComponentRef<any>;
  cargado = false
  @Input() tipoRegistro!: any;
  @Input() datos!: any;
  @Output() formularioSend = new EventEmitter<any>();

  constructor(
    private formularioService: FormularioService,
    private consultasService: ConsultasService) { }

  ngOnChanges(): void {
    if (this.cargado) {
      this.loadComponent();
    }
  }
  ngAfterViewInit(): void {
    this.loadComponent();
    this.cargado = true
  }

  loadComponent() {
    let descripcion = this.tipoRegistro.descripcion;
    let componente:any = this.formularioService.getForms().find(componente => componente.data.name === descripcion)
    const viewContainerRef = this.formularioHost.viewContainerRef;
    viewContainerRef.clear()
    if (componente) {
      if (this.datos.editable) {
        this.consultasService.obtenerRegistroProfesionalporID(this.datos.registro).subscribe({
          next: data=>{
            this.datos.registroProfesional = data
            this.componentRef = viewContainerRef.createComponent<any>(componente.component);
            this.componentRef.instance.data = this.datos
            this.componentRef.changeDetectorRef.detectChanges();
            if (this.componentRef.instance.formulario) {
              this.componentRef.instance.formulario.subscribe((form: any) => {
                this.formularioSend.emit(form)
              })
            }
          }
        })
      }else{
        this.componentRef = viewContainerRef.createComponent<any>(componente.component);
        this.componentRef.instance.data = this.datos
        this.componentRef.changeDetectorRef.detectChanges();
        if (this.componentRef.instance.formulario) {
          this.componentRef.instance.formulario.subscribe((form: any) => {
            this.formularioSend.emit(form)
          })
        }
      }
    }
  }
}
