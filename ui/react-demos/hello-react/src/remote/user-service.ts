import {bookstoreClient} from "./bookstore-client";

export const getAllUsers = async () => {
    let resp = await bookstoreClient.get('/users', {
        headers: {
            'Authorization': localStorage.getItem('api-token')
        }
    });
    return resp.data;
}