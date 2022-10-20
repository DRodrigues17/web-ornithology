import { Passaro } from "./Passaro";

export interface CustomResponse {
    timeStamp: Date;
    statusCode: number;
    status: string;
    reason: string;
    message: string;
    developerMessage: string;
    data: { passaros?: Passaro[], passaro?: Passaro };
}