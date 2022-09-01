import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup} from '@angular/forms';
@Component({
  selector: 'app-especialista-form',
  templateUrl: './especialista-form.component.html',
  styleUrls: ['./especialista-form.component.css']
})
export class EspecialistaFormComponent implements OnInit{
  form!: UntypedFormGroup;
  @Input() data!: any;
  @Output() formulario = new EventEmitter();
  formatos=['pdf']

  constructor(
    private _formBuilder: UntypedFormBuilder) {
  }
  ngOnInit(): void {
    this.form = this._formBuilder.group({
      telefono: [],
      direccion: [],
      nacimiento: [],
      nacionalidad: [],
      formacion:[],
      perfiles:[]
    });
  }

  submitForm() {
    if (this.form.invalid) {
      console.log('error')
      console.log(this.form.value);
      console.log(this.form.errors);
    } else {
      console.log(this.form.value);
      this.formulario.emit(this.form.value)
    }
  }
  recibirDocumento(array:any){
    if (array) {
      this.form.controls['formacion'].setValue({files: array})
    }
  }
}
