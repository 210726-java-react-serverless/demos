/*

    Write some JS logic that will allow you to enter some student information into the form fields on the page.
    When the "Add Student" button is clicked, insert the provided data into the table body. Be sure to generate
    an auto-incrementing ID value for each student added to the table.

    NOTE: You will not need to edit the HTML file at all for this activity.

 */

const studentName = document.getElementById("student-name");
const major = document.getElementById("student-major");
const button = document.getElementById("add-student");
const tableBody = document.getElementById("student-table-body");

button.addEventListener('click', addStudent);
major.addEventListener('keydown', function(e) {
    if (e.key == 'Enter') {
        addStudent();
    }
})

let id = 0;

function addStudent() {
    // add student to table
    if (studentName.value && major.value) {
        let newStudent = `
        <tr>
            <td>
                ${id}
            </td>
            <td>
                ${studentName.value}
            </td>
            <td>
                ${major.value}
            </td>
        </tr>`;
        tableBody.innerHTML += newStudent;
        id++;
        studentName.value = '';
        major.value = '';
    }
    
}