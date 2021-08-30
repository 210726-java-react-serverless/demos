import {Principal} from "../dtos/principal";
import {bookstoreClient} from "./bookstore-client";

export const authenticate = async (credentials: {username: string, password: string}) => {

    let resp = await bookstoreClient.post('/auth', credentials);

    if (resp.status === 401) {
        throw resp.data;
    }

    let token: string | null = resp.headers['authorization'];

    let principal: Principal = resp.data;

    if (token && principal) {
        principal.token = token;
        localStorage.setItem('api-token', token);
    }

    return principal;

}