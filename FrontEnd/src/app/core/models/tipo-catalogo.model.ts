export interface TipoCatalogo {
    isSelected: boolean;
    tipoCatalogoId: number;
    nombre: string;
    estado: string;
    Acciones: boolean;
}
export const TipoCatalogoSchema: any = {
    isSelected: "isSelected",
    nombre: "text",
    estado: "select",
    Acciones: "Acciones"
}
export interface Catalogo {
    nombreTipoCatalogo: any;
    isSelected: boolean;
    catalogoId: number;
    nombre: string;
    tipoCatalogoId: number,
    estado: string;
    Acciones: boolean;
}
export const CatalogoSchema: any = {
    isSelected: "isSelected",
    nombre: "text",
    nombreTipoCatalogo: "select2",
    tipoCatalogoId: '',
    estado: "select",
    Acciones: "Acciones"
}