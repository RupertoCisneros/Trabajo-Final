import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup} from '@angular/forms';
@Component({
  selector: 'app-veterinario-form',
  templateUrl: './veterinario-form.component.html',
  styleUrls: ['./veterinario-form.component.css'],
})
export class VeterinarioFormComponent implements OnInit{
  form!: UntypedFormGroup;
  @Output() formulario = new EventEmitter();
  @Input() data!: any;

  constructor(
    private _formBuilder: UntypedFormBuilder) {
  }
  ngOnInit(): void {
    this.form = this._formBuilder.group({
      telefono: [],
      direccion: [],
      nacimiento: [],
      nacionalidad: [],
      agremiado: []
    });
  }
  submitForm() {
    if (this.form.invalid) {
      console.log(this.form.value);
    } else {
      console.log(this.form.value);
      this.formulario.emit(this.form.value)
    }
  }
}
