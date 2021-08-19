/*

    AJAX - Asynchronous JavaScript And XML (also JSON)

        - Not a programming language
        - A technique, a library that is available in all modern web browser
        - Allows our web page to communicate with external APIs

 */

const idField = document.getElementById('id');
const categoryField = document.getElementById('category');
const submitButton = document.getElementById('submitBtn');
const alertMessage = document.getElementById('alertMessage');
window.onload = () => {

    // Add event listeners onto various page elements
    idField.addEventListener('blur', fieldsValid);
    categoryField.addEventListener('blur', fieldsValid);
    submitButton.addEventListener('click', getInfo); // switch this to "fetchInfo" to use Fetch API instead of AJAX

    // Disable the submit button
    submitButton.setAttribute('disabled', 'true'); // use JS to add/remove attributes (id, class, etc.)

    // Hide the alert message
    // alertMessage.setAttribute('hidden', 'true');
    alertMessage.style.display = 'none'; // we can use JS to manipulate the CSS of an element

};

function fieldsValid() {

    let id = idField.value;
    let category = categoryField.value;

    if (id && category) {
        submitButton.removeAttribute('disabled');
        alertMessage.style.display = 'none';
    } else {
        submitButton.setAttribute('disabled', 'true');
        alertMessage.style.display = 'block';
    }

}

function getInfo() {

    let id = idField.value;
    let category = categoryField.value;

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {

        console.log(`XHR client is in the ${xhr.readyState} state.`);

        if (xhr.readyState === 4) {

            // XHR is in the DONE state (ready state: 4)

            if (xhr.status === 200) {

                renderResults(JSON.parse(xhr.responseText));

            }

        }
    }

    // XHR is in the UNSENT state (ready state: 0)

    xhr.open('GET', `https://swapi.dev/api/${category}/${id}`, true);

    // XHR is in the OPENED state (ready state: 1)
    xhr.send();

    // XHR could be in a HEADERS_RECEIVED state (ready state: 2)
    // XHR could be in a LOADING state (ready state: 3)
    // https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState

}

// Fetch API docs: https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API
function fetchInfo() {

    let id = idField.value;
    let category = categoryField.value;

    /*

        Promises

            The Promise object represents the eventual completion (or failure) of an
            asynchronous operation, and its resulting value. Using the .then() method
            we can process a successful response, otherwise we can use the .catch()
            method to handle a failed request. Promises return either zero or one
            value per request.

            https://github.com/domenic/promises-unwrapping/blob/master/docs/states-and-fates.md

     */
    fetch(`https://swapi.dev/api/${category}/${id}`)
        .then(resp => {
            console.log(resp.status);
            console.log(resp.headers);
            return resp.json()
        }).then(data => {
            renderResults(data);
        }).catch(err => {
            console.error(err);
        });

    // STAY OUT OF PROMISE HELL! DO NOT NEST YOUR .then CALLBACKS!
    // fetch(`https://swapi.dev/api/${category}/${id}`)
    //     .then(resp => {
    //         console.log(resp.status);
    //         console.log(resp.headers);
    //         resp.json().then(data => {
    //             renderResults(data);
    //         });
    //
    //     }).catch(err => {
    //     console.error(err);
    // })
}

// TODO: Dynamically render some elemnts on the page to display the response payload data.
function renderResults(responsePayload) {
    console.log(responsePayload);
}
