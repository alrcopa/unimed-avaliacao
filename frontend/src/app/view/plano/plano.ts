import { Beneficiario } from "../beneficiario/beneficiario";

export class Plano {

  public id!: number;
  public nome!: string;
  public valor!: number;
  public beneficiario!: Beneficiario;

}
