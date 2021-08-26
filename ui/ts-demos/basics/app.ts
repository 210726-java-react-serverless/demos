// Explicit type declaration for a variable
let x: number = 42;
x = false;

// Inferred type declaration for a variable
let y = 'hello';
y =  true;

// Function parameters can have types
function takesOnlyString(msg: string) {
    console.log(msg);
}

takesOnlyString({x: 1, y: 2}); // errors DO NOT prevent the transpilation from TS -> JS

interface User {
    id: string,
    firstName: string,
    lastName: string,
    username: string,
    password: string,
    getFullName: () => string
}

function register(newUser: User) {
    console.log(newUser);
}

let someNewUser = {
    id: '611cokiashj890u23904',
    firstName: 'Wezley',
    lastName: 'Singleton',
    username: 'wsingleton',
    password: 'revature',
    getFullName: function (){
        return `${this.firstName} ${this.lastName}`
    }
}

register(someNewUser);

let result: User | undefined;

// Functions can have return types, those return types could even be UNION TYPES (either returns A | B)
function login(): User | undefined {
    return undefined;
}

result = someNewUser;
result = undefined;

function getInfo() {
    fetch(`https://swapi.dev/api/1/1`)
        .then(resp => resp.json())
        .then(data => console.log(data))
        .catch(err => console.error(err));
}

getInfo();


async function asyncFetchInfo() {

    try {
        let response = await fetch(`https://swapi.dev/api/1/2`);
        let data = await response.json();
        console.log(data);
    } catch (e) {
        console.log(e);
    }

}

asyncFetchInfo();

function identity<T>(arg: T): T {
    return arg;
}

let input = document.getElementById('some-input-field');
(input as HTMLInputElement).value; // casting using the 'as' keyword
(<HTMLInputElement> input).value; // casting using <> syntax

// Class syntax is not specific to TS, but access modifiers are!
class SomeClass {

    static staticVal = 1; // not specific to TS, exists in JS as well

    // the lack of an access modifier implies: public
    id; // without the private keyword, this variable needs to be explicitly declared outside of the constructor

    constructor(id, private someValue = 'defaultValue') {
        this.id = id;
        this.someValue = someValue;
    }

}

