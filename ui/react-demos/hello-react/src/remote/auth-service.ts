import {Principal} from "../dtos/principal";

export const authenticate = async (credentials: {username: string, password: string}) => {

    let resp = await fetch('http://bookstoreapi-env.eba-ysp2j7xq.us-east-1.elasticbeanstalk.com/auth', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(credentials)
    });

    if (resp.status === 401) {
        throw await resp.json();
    }

    let token: string | null = resp.headers.get('Authorization');

    let principal: Principal = await resp.json();
    console.log(principal)
    if (token && principal) principal.token = token;

    return principal;

}