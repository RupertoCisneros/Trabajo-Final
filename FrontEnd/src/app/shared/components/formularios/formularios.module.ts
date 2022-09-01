import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TelefonoFormComponent } from './formularios-reusables/telefono-form/telefono-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '@modules/material/material.module';
import { DireccionFormComponent } from './formularios-reusables/direccion-form/direccion-form.component';
import { FechaNacimientoFormComponent } from './formularios-reusables/fecha-nacimiento-form/fecha-nacimiento-form.component';
import { NacionalidadFormComponent } from './formularios-reusables/nacionalidad-form/nacionalidad-form.component';
import { DatosPersonalesFormComponent } from './formularios-reusables/datos-personales-form/datos-personales-form.component';
import { TutorFormComponent } from './formulario/tutor-form/tutor-form.component';
import { VeterinarioFormComponent } from './formulario/veterinario-form/veterinario-form.component';
import { FormularioComponent } from './formulario/formulario.component';
import { EspecialistaFormComponent } from './formulario/especialista-form/especialista-form.component';
import { FormularioDirective } from './formulario/formulario.directive';
import { FormacionDocumentoFormComponent } from './formularios-reusables/formacion-documento-form/formacion-documento-form.component';
import { MicrochipFormComponent } from './formulario/microchip-form/microchip-form.component';
import { DireccionBasicFormComponent } from './formularios-reusables/direccion-basic-form/direccion-basic-form.component';
import { CodigoMicrochipFormComponent } from './formularios-reusables/codigo-microchip-form/codigo-microchip-form.component';
import { InformacionConsideradaFormComponent } from './formularios-reusables/informacion-considerada-form/informacion-considerada-form.component';
import { EstablecimientoFormComponent } from './formularios-reusables/establecimiento-form/establecimiento-form.component';
import { ObservacionFormComponent } from './formularios-reusables/observacion-form/observacion-form.component';
import { AnimalFormComponent } from './formulario/animal-form/animal-form.component';
import { DatosGeneralesFormComponent } from './formularios-reusables/animal-form/datos-generales-form/datos-generales-form.component';
import { CaracteristicasFormComponent } from './formularios-reusables/animal-form/caracteristicas-form/caracteristicas-form.component';
import { MultiplosArchivosFormComponent } from './formularios-reusables/multiplos-archivos-form/multiplos-archivos-form.component';
import { PermanenciaAnimalFormComponent } from './formularios-reusables/animal-form/permanencia-animal-form/permanencia-animal-form.component';
import { SaludFormComponent } from './formularios-reusables/animal-form/salud-form/salud-form.component';
import { CertificadosFormComponent } from './formularios-reusables/animal-form/certificados-form/certificados-form.component';
import { MultipleSelectFormComponent } from './formularios-reusables/multiple-select-form/multiple-select-form.component';
import { SelectSimpleFormComponent } from './formularios-reusables/select-simple-form/select-simple-form.component';
import { InputSimpleFormComponent } from './formularios-reusables/input-simple-form/input-simple-form.component';
import { RetiroAnimalFormComponent } from './formulario/retiro-animal-form/retiro-animal-form.component';
import { TextareaSimpleFormComponent } from './formularios-reusables/textarea-simple-form/textarea-simple-form.component';
import { RecepcionAnimalFormComponent } from './formulario/recepcion-animal-form/recepcion-animal-form.component';
import { DatosTecnicosAnimalFormComponent } from './formulario/datos-tecnicos-animal-form/datos-tecnicos-animal-form.component';
import { DatepickerSimpleFormComponent } from './formularios-reusables/datepicker-simple-form/datepicker-simple-form.component';
import { AgremiadoFormComponent } from './formularios-reusables/agremiado-form/agremiado-form.component';

@NgModule({
  declarations: [
    TelefonoFormComponent,
    DireccionFormComponent,
    FechaNacimientoFormComponent,
    NacionalidadFormComponent,
    DatosPersonalesFormComponent,
    TutorFormComponent,
    VeterinarioFormComponent,
    FormularioComponent,
    EspecialistaFormComponent,
    FormacionDocumentoFormComponent,
    FormularioDirective,
    MicrochipFormComponent,
    DireccionBasicFormComponent,
    CodigoMicrochipFormComponent,
    InformacionConsideradaFormComponent,
    EstablecimientoFormComponent,
    ObservacionFormComponent,
    AnimalFormComponent,
    DatosGeneralesFormComponent,
    CaracteristicasFormComponent,
    MultiplosArchivosFormComponent,
    PermanenciaAnimalFormComponent,
    SaludFormComponent,
    CertificadosFormComponent,
    MultipleSelectFormComponent,
    SelectSimpleFormComponent,
    InputSimpleFormComponent,
    RetiroAnimalFormComponent,
    TextareaSimpleFormComponent,
    RecepcionAnimalFormComponent,
    DatosTecnicosAnimalFormComponent,
    DatepickerSimpleFormComponent,
    AgremiadoFormComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule.withConfig({warnOnNgModelWithFormControl: 'never'}),
    MaterialModule
  ],
  exports:[
    DatosPersonalesFormComponent,
    FormularioComponent,
    RecepcionAnimalFormComponent,
    RetiroAnimalFormComponent,
    AnimalFormComponent,
    InputSimpleFormComponent,
    SelectSimpleFormComponent
  ]
})
export class FormulariosModule { }
