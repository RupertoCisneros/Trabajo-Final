import { Directive, ViewContainerRef } from '@angular/core';
@Directive({
  selector: '[appFormulario]'
})
export class FormularioDirective {
  constructor(public viewContainerRef: ViewContainerRef) {}
}
