import axios from "axios";

export const bookstoreClient = axios.create({
    baseURL: 'http://bookstoreapi-env.eba-ysp2j7xq.us-east-1.elasticbeanstalk.com',
    headers: {
        'Content-Type': 'application/json'
    }
});
