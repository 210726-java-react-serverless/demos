/*

    Write some JS logic that will allow you to enter some student information into the form fields on the page.
    When the "Add Student" button is clicked, insert the provided data into the table body. Be sure to generate
    an auto-incrementing ID value for each student added to the table.

    NOTE: You will not need to edit the HTML file at all for this activity.

 */


window.onload = function() {
    console.log("testtttt")
}

function* idGenerator() {
    let idCounter = 1;
    while(true) {
        yield idCounter++;
    }
}

let idGen = idGenerator();

function addStudent() {

    // Get input field values
    let studentNameInputField = document.getElementById('student-name');
    let studentName = studentNameInputField.value;
    let studentMajor = document.getElementById('student-major').value;

    // Validate the values (ensure they are not empty strings)
    if (studentName && studentMajor) {

        // Create a row and cells for the students table
        let row = document.createElement('tr');
        let studentIdCell = document.createElement('td');
        let studentNameCell = document.createElement('td');
        let studentMajorCell = document.createElement('td');

        // Append cells to the row
        row.appendChild(studentIdCell);
        row.appendChild(studentNameCell);
        row.appendChild(studentMajorCell);

        // Append the row to the pre-existing table
        document.getElementById('student-table-body').appendChild(row);

        // Add student info to the newly appended row
        studentIdCell.innerText = idGen.next().value;
        studentNameCell.innerText = studentName;
        studentMajorCell.innerText = studentMajor;

        // Clear the input for the fields, for future values to be provided
        studentNameInputField.value = '';
        document.getElementById('student-major').value = '';
    }

}

// Create an event listener that will fire off when the button is clicked
document.getElementById('add-student').addEventListener('click', addStudent); // <--- example of a callback
>>>>>>> dbab5e69d4f9c41d1139c3c9b8dcd41961e747d4
