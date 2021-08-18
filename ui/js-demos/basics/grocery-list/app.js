/*

    Write some JS logic that will allow for users to provide an item that will be added to their Grocery List
    when the "Add Item" button is clicked (if they do not provide a value, then nothing should be added).

    Additionally, you should implement functionality that allows users to click an item in their grocery list to
    move it to the Purchased Items list. Likewise, clicking an item in the Purchased list should move that item
    back to the grocery list.

    NOTE: You will not need to edit the HTML file at all for this activity.

 */

const grocery = document.getElementById('grocery-list-items');
const purchased = document.getElementById('purchased-items');
const input = document.getElementById('new-item');
const button = document.getElementById('add-item');

button.addEventListener('click', addItem);
input.addEventListener('keydown', function(e) {
    if (e.key == 'Enter') {
        addItem();
    }
})
grocery.addEventListener('mouseover', changeCursor);
purchased.addEventListener('mouseover', changeCursor);

grocery.addEventListener('click',function(e) {
    moveItemToPurchased(e.target);
})

purchased.addEventListener('click',function(e) {
    moveItemToGrocery(e.target);
})

function addItem() {
    if (input.value) {
        let newItem = `
        <li>${input.value}</li>`;
        grocery.innerHTML += newItem;
        input.value = '';
    }
}

function moveItemToPurchased(element) {
    purchased.appendChild(element);
    //grocery.removeChild(element);
}

function moveItemToGrocery(element) {
    grocery.appendChild(element);
    //purchased.removeChild(element);
}

function changeCursor() {
    grocery.style.cursor = 'pointer';
    purchased.style.cursor = 'pointer';
}
