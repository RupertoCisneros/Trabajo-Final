import { Component, EventEmitter, Output } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup} from '@angular/forms';
@Component({
  selector: 'app-tutor-form',
  templateUrl: './tutor-form.component.html',
  styleUrls: ['./tutor-form.component.css']
})
export class TutorFormComponent {
  form!: UntypedFormGroup;
  @Output() formulario = new EventEmitter();

  constructor(
    private _formBuilder: UntypedFormBuilder) {
    this.form = this._formBuilder.group({
      telefono: [],
      direccion: [],
      nacimiento: [],
      nacionalidad: [],
    });
  }
  submitForm() {
    if (this.form.invalid) {
      console.log(this.form.value);
    } else {
      this.formulario.emit(this.form.value)
    }
  }
}
