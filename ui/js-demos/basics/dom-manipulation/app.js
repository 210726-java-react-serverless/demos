const appRoot = document.getElementById('app-root');
const loginButton = document.getElementById('login-button');
const usernameInput = document.getElementById('username-field');
const passwordInput = document.getElementById('password-field');

/*
    The addEventListener method takes a event (as a string) and a callback function. This
    callback function will be invoked when the specified event occurs on the target element.
 */
loginButton.addEventListener('click', login);
usernameInput.addEventListener('keyup', function(e) {
    console.log(e); // "e" is our Event object
    console.log(e.target.value); // the target of the Event object is the element on which the event occurred
})

passwordInput.addEventListener('keyup', function (e) {
    if (e.key === 'Enter') {
        login();
    }
})

function login(e) {

    let username = usernameInput.value;
    let password = passwordInput.value;

    // template literals are useful for easy value interpolation
    console.log(`Attempting to authenticate using credentials: ${username} ${password}`);

    // doing this to simulate us talking to some API/server
    setTimeout(() => {

        console.log('My fake login is done!');

        let pTag = document.createElement('p');
        pTag.innerText = `Logged in ${username}, navigating to dashboard...`;

        appRoot.append(pTag);

        setTimeout(() => {
            renderDashboard();
        }, 1000);

    }, 2000); // time value is in milliseconds

}


function renderDashboard() {

    // template literals (strings using backticks ``) respect white space!
    let dashboardTemplate = `
    <div id="dashboard-component">
        <h1>Dashboard works!</h1>
    </div>
    `;

    appRoot.innerHTML = dashboardTemplate;
}
