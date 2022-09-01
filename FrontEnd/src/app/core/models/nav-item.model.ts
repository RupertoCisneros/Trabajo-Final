export interface NavItem {
  nombre: string;
  descripcion?: string;
  disabled?: boolean;
  icono?: string;
  ruta?: string;
  hijos?: NavItem[];
}