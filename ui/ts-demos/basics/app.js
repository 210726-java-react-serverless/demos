var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
// Explicit type declaration for a variable
var x = 42;
x = false;
// Inferred type declaration for a variable
var y = 'hello';
y = true;
// Function parameters can have types
function takesOnlyString(msg) {
    console.log(msg);
}
takesOnlyString({ x: 1, y: 2 }); // errors DO NOT prevent the transpilation from TS -> JS
function register(newUser) {
    console.log(newUser);
}
var someNewUser = {
    id: '611cokiashj890u23904',
    firstName: 'Wezley',
    lastName: 'Singleton',
    username: 'wsingleton',
    password: 'revature',
    getFullName: function () {
        return this.firstName + " " + this.lastName;
    }
};
register(someNewUser);
var result;
// Functions can have return types, those return types could even be UNION TYPES (either returns A | B)
function login() {
    return undefined;
}
result = someNewUser;
result = undefined;
function getInfo() {
    fetch("https://swapi.dev/api/1/1")
        .then(function (resp) { return resp.json(); })
        .then(function (data) { return console.log(data); })["catch"](function (err) { return console.error(err); });
}
getInfo();
function asyncFetchInfo() {
    return __awaiter(this, void 0, void 0, function () {
        var response, data, e_1;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    _a.trys.push([0, 3, , 4]);
                    return [4 /*yield*/, fetch("https://swapi.dev/api/1/2")];
                case 1:
                    response = _a.sent();
                    return [4 /*yield*/, response.json()];
                case 2:
                    data = _a.sent();
                    console.log(data);
                    return [3 /*break*/, 4];
                case 3:
                    e_1 = _a.sent();
                    console.log(e_1);
                    return [3 /*break*/, 4];
                case 4: return [2 /*return*/];
            }
        });
    });
}
asyncFetchInfo();
function identity(arg) {
    return arg;
}
var input = document.getElementById('some-input-field');
input.value; // casting using the 'as' keyword
input.value; // casting using <> syntax
// Class syntax is not specific to TS, but access modifiers are!
var SomeClass = /** @class */ (function () {
    function SomeClass(id, someValue) {
        if (someValue === void 0) { someValue = 'defaultValue'; }
        this.someValue = someValue;
        this.id = id;
        this.someValue = someValue;
    }
    SomeClass.staticVal = 1; // not specific to TS, exists in JS as well
    return SomeClass;
}());
