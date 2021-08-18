// single line comments

/*
    multi
    line
    comments
 */

/**
 * Documentation comments
 */

/*
    JavaScript is a loosely-typed language, not untyped!

        Primitive types:
            - string
            - number
            - boolean
            - null (represents the lack of an object value; primitive root value)
            - undefined (an uninitialized value)
            - bigint
            - Symbol (always unique, even if they contain the same value; excellent for UUIDs)

        Structural types:
            - object
                + Array
                + Set
                + Date
                + Map
                + Function
                + user-defined types
 */

let id_1 = Symbol('test'); // single quotes are preferred
let id_2 = Symbol("test"); // double quotes are acceptable (just be consistent!)
console.log(id_1 === id_2); // false, Symbols are NEVER equal to one another

let a_1; // value = undefined
let b_1 = null;
let c_1 = undefined;

// standard/named function declarations
function a() {
    console.log('This is a named function declaration!');
}

a(); // invokes the function named "a"

// anonymous function declarations
let b = function() {
    console.log('This is an anonymous function declaration assigned to a variable named "b"');
}

b();

// anonymous arrow function declarations
// NOTE: there is a difference between this and the above function syntax
let c = () => {
    console.log('This an anonymous function declaration expressed using arrow notations assigned to a variable named "c"');
}

c();

// Exploring the "this" keyword
function d() {
    console.log(this); // in a browser environment, refers to the global Window object
}

d();

let e = {
    greeting: 'hello!',
    printGreeting: function() {
        console.log(this); // refers to the containing object "e"
        console.log(this.greeting);
    }
}

e.printGreeting();

/*
    Why is "this" different in a globally declared function vs. an object?

        - Globally declared values (functions and variables) are "hoisted" to the global object
          of the environment we are running in.
                + in the browser, this is the Window object
                + in Node.JS, this is the Object object
 */

// location = 'https://www.google.com'; // DO NOT DECLARE GLOBAL VARIABLES WITHOUT A DECLARATIVE KEYWORD (e.g. var, let, const)

let f = {
    greeting: 'bonjour!',
    printGreeting: () => {
        console.log(this); // refers to the global Window object
    }
}

f.printGreeting();

let g = {
    greeting: 'hola!',
    greeter: {
        greet: () => {
            console.log(this); // still refers to the global Window object
        }
    }
}

g.greeter.greet();

// This is a example of a "higher-order function"
let h = function() {
    let a = 5;
    return () => {
        console.log(this); // when in an arrow function, "this" always refers to the global object
    }
}

h()(); // invoke the function named "h", then invoke the function returned by "h".

// IIFEs (immediately invoked function expressions)
(function () {
    console.log("This is an immediately invoked function expression!");
})();

(function (x) {
    console.log("This is an immediately invoked function expression! Value: " + x);
})(4);

i(4); // this works because of the way that the JS Engine is interpreting our script (i.e. declarations first, then execute expressions);
function i(x) {
    console.log('do the thing.');
    if (x % 2 === 0) {
        let msg = 'x is even!';
        console.log(msg);
    }
}

/*
    Variable declarative keywords
        - var: been around forever, used to simply declare variables/functions/objects
        - let: introduced in ES6 (ECMAScript 2015), block-scoped
        - const: introduced in ES6 (ECMAScript 2015), block-scoped, represents a constant/final value
        - (lack of declarative keyword): bad practice! results in the binding of the declaration to the global object

    Variable scopes
        - global
        - function/method/local
        - block
        - lexical (closure)
 */

// Exploring variable scopes and hoisting
function varScopeExample(x) {
    console.log('Line 156: ' + greeting); // prints: undefined
    if (x % 2 === 0) { // if "x" is not even, this block never runs - therefore, greeting never gets a value;
        var greeting = 'hello!';
        console.log('Line 159: ' + greeting); // prints: 'hello!'
    }
    console.log('Line 161: ' + greeting); // prints: 'hello!'
}

function varScopeExample_whatsActuallyHappening(x) {
    var greeting; // the declaration for "greeting" is hoisted to the top of the local scope
    console.log('Line 156: ' + greeting); // prints: undefined
    if (x % 2 === 0) {
        greeting = 'hello!';
        console.log('Line 159: ' + greeting); // prints: 'hello!'
    }
    console.log('Line 161: ' + greeting); // prints: 'hello!'
}

varScopeExample(3);

function letScopeExample(x) {
    // console.log('Line 177: ' + greeting); // if uncommented, throws Reference error
    if (x % 2 === 0) {
        let greeting = 'hello!';
        console.log('Line 180: ' + greeting); // if we make it here, it prints: 'hello!'
    }
    // console.log('Line 182: ' + greeting); // if uncommented, throws Reference error
}

letScopeExample(2);

// Const variables
const meaningOfLife = 42;
// meaningOfLife = 43; // TypeError

const immutableMaybe = {
    someValue: 10,
    anotherValue: 'test',
    nestedObject: {
        nestedValue: 100
    }
}

console.log(immutableMaybe);

try {
    immutableMaybe = {} // obviously, wrong.
} catch (e) {
    console.log(e);
    console.log('why you do that?!')
} finally {
    console.log('the day is almost over...finally!')
}

immutableMaybe.someValue = 20; // shows that while we cannot reassign the "immutableMaybe" variable, we can manipulate it
console.log(immutableMaybe);

let numbers = [1, 2, 3, 4];
let randomVals = [1, 'test', false, function() {}, new Date(), undefined, Symbol('test')] // JS Arrays are NOT homogenous

console.log(numbers)
numbers.push(5); // JS Arrays are dynamically sized!
console.log(numbers)
console.log(numbers[2]); // prints: 3
console.log(numbers[10000]); // prints: undefined

let myMap = new Map();
myMap.set('wsingleton', {
    firstName: 'Wezley',
    lastName: 'Singleton'
})

console.log(myMap.get('wsingleton'));

let me = {
    firstName: 'Wezley',
    lastName: 'Singleton',
    email: 'wezley.singleton@revature.com',
    username: 'wsingleton',
    password: 'revature',
    'test value': 'test'
};

// standard for loop
for (let i = 0; i < 10; i++) {
    console.log(i);
}

// for..of loop - creates a loop iterating over iterable objects (strings, Arrays, Maps, etc.)
for (let val of numbers) {
    console.log("--" + val) // indexing starts at 1
}

for (let entry of myMap) {
    console.log(entry);
}

// for..in loop - used to iterate across the keys of an object (e.g. objects, Arrays, Maps, etc.)
for (let value in numbers) {
    console.log(value);
}

for (let val in numbers) {
    console.log("--" + val) // indexing starts at 0
}

for (let property in me) {
    console.log(property + ": " + me[property]); // bracket notation, used to access members of an object
}

/*
    Type Coercion and Truthy/Falsy Values

    Falsy Values:
        - ''/"" (empty string)
        - 0
        - null
        - undefined
        - false
        - NaN
 */

console.log(7 + 7 + '7'); // prints: '147'
console.log(7 + '7' + 7); // prints: '777'

let username = '';
let password = '';

if (username && password) {
    console.log(username);
    console.log(password);
} else {
    console.log('Provided values were falsy!')
}

console.log('hello' - 3); // NaN
console.log(typeof ('hello' - 3)); // NaN (not a number) is a number

console.log(10 / 0); // Positive infinity
console.log(10 / -0); // Negative infinity
console.log(0 === -0); // phew...still true
console.log(7 == '7'); // the == operator is subject to type coercion
console.log(7 === '7'); // the === operator is NOT subject to type coercion
console.log('hello' + 3); // prints: 'hello3'
console.log('hello' - 3); // prints: NaN
let x = ('hello' - 3); // NaN
let y = ('hello' - 3); // NaN
console.log(x === y); // NaN is never equal to itself! Not because of JS, but because of the governing IEEE standard for NaN
console.log(x + 3);

// Default operator
let name = getName() || 'Tester McTesterson';
console.log(name); // prints: 'Tester McTesterson'

function getName() {
    return null;
}

// Guard operator
(username && password) && login(username, password);

function login(un, pw) {
    console.log('Provided credentials: ', un, pw);
}

console.log([] + {} + !{}); // prints: [object Object]

let token = 'sjkdgfjkaergjk';

function isTokenValid() {
    return !!token;
}

console.log(isTokenValid());
