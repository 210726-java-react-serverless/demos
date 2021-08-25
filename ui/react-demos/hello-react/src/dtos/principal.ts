export class Principal {

    id: string;
    username: string;
    token: string;

    constructor(id: string, un: string, token: string) {
        this.id = id;
        this.username = un;
        this.token = token;
    }

}