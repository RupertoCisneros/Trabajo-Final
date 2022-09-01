import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup} from '@angular/forms';
import { AnimalService } from '@global/services/animal.service';
@Component({
  selector: 'app-animal-form',
  templateUrl: './animal-form.component.html',
  styleUrls: ['./animal-form.component.css']
})
export class AnimalFormComponent implements OnInit{
  @Output() formulario = new EventEmitter();
  @Input() data!: any;

  datosGenerales!: UntypedFormGroup;
  caracteristicas!: UntypedFormGroup;
  permanenciaAnimal!: UntypedFormGroup;
  salud!: UntypedFormGroup;
  certificados!: UntypedFormGroup;
  form!:UntypedFormGroup;
  tutoresComunitarios:any


  constructor(
    private _formBuilder: UntypedFormBuilder,
    public animalService: AnimalService) {
    this.datosGenerales = this._formBuilder.group({
      datosGenerales: []
    });
    this.caracteristicas = this._formBuilder.group({
      caracteristicas: []
    });
    this.permanenciaAnimal = this._formBuilder.group({
      permanenciaAnimal: []
    });
    this.certificados = this._formBuilder.group({
      certificados: []
    });
    this.salud = this._formBuilder.group({
      salud: []
    });

    this.form = this._formBuilder.group({
      datosGenerales: this.datosGenerales,
      caracteristicas: this.caracteristicas,
      permanenciaAnimal: this.permanenciaAnimal,
      certificados: this.certificados,
      salud: this.salud
    });
  }
  ngOnInit(): void {
    console.log(this.data);
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
