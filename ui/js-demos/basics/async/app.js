/*

    AJAX = Asynchronous JavaScript And XML (also JSON)
    a technique/library available in all modern browsers
    allows our web page to communicate with external APIs

*/
window.onload = () => {
    console.log('app.js loaded');
    const idField = document.getElementById('id');
    const categoryField = document.getElementById('category');
    const submitButton = document.getElementById('submitBtn');
    const alertMessage = document.getElementById('alertMessage');


    idField.addEventListener('blur',fieldIsValid);
    categoryField.addEventListener('blur',fieldIsValid);
    submitButton.addEventListener('click',getInfo);

    submitButton.setAttribute('disabled','true');

    alertMessage.style.display = 'none';
};

function fieldIsValid() {
    let id = idField.value;
    let category = categoryField.value;

    if (id && category) {
        submitButton.removeAttribute('disabled');
        alertMessage.style.display = 'none';
    } else {
        submitButton.setAttribute('disabled','true');
        alertMessage.style.display = 'block';
    }
}

function getInfo() {
    let id = idField.value;
    let category = categoryField.value;

    let xhr = new XMLHttpRequest();
    xhr.open('GET',`https://swapi.dev/api/${category}/${id}`,true);
    xhr.send();

    xhr.onreadystatechange = () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            renderResults(xhr.responseText);
        } 
    }
}

function fetchInfo() {
    let id = idField.value;
    let category = categoryField.value;

    fetch(`https://swapi.dev/api/${category}/${id}`).then(resp => {
        return resp.json();
    }).then(data => {
        renderResults(data);
    }).catch(err => {
        console.error(err);
    })
}

function renderResults(responsePayload) {
    console.log(responsePayload);
}