export interface IRango {
  id?: number;
  value?:string;
}

export class Rango implements IRango {
  constructor(public id?: number , public value?: string) {}
}
 