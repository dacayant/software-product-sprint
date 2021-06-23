
// Show-hide elements
$(document).ready(
    // How to use:
    // Add the 'hide-' or 'show-' name to the trigger element, followed by the id of the target element
    // Detects when elements with 'show-' in their name and the 'trigger' class are clicked
    function(){
        $( "[name*='show-']" ).click(
            function(){
                // Takes the id number in the name of the trigger element
                var trigger_id = $(this).attr("name").replace("show-", "");
                // Shows the element with the corresponding id
                showElement(trigger_id);
            }
        );

        $( "[name*='hide-']" ).click(
            function(){
                var trigger_id = $(this).attr("name").replace("hide-", "");
                hideElement(trigger_id);
            }
        );
});

function showElement(id) {
    $("#" + id).fadeIn();
}

function hideElement(id) {
    $("#" + id).hide();
}

// ------------------------------------------------------------------------------------ //
// Modal-Only Code 

// Change image-preview when 
function preview_image(event) 
{
 var reader = new FileReader();
 reader.onload = function()
 {
  var output = document.getElementById('img-preview');
  output.src = reader.result;
 }
 reader.readAsDataURL(event.target.files[0]);
}

// Hide when click not Modal


// ------------------------------------------------------------------------------------ //

// Fetchs the content from the /hello servlet
async function displayHello() {
    const response = await fetch('/hello');
    const text = await response.text()


/** Fetchs the content from the /hello servlet */
async function displayHello() {
    const response = await fetch('/hello');
    const text = await response.text()

    const testContainer = document.getElementById('owner-greeting-container');
    testContainer.innerHTML = text;
}

// Fetches Content from the /more-about servlet
async function displayFavorites(){
    const response = await fetch('/more-about');
    const favorites = await response.json();

    const testContainer = document.getElementById('favorites-container');
    testContainer.innerHTML = '';

    // Create a Bulleted List
    testContainer.appendChild(
        createListElement("Food: " + favorites.Food));
    testContainer.appendChild(
        createListElement("Show: " + favorites.Show));
    testContainer.appendChild(
        createListElement("Movie: " + favorites.Movie));
    testContainer.appendChild(
        createListElement("Band: " + favorites.Band));
}

// Creates an <li> element containing text
function createListElement(text) {
    const liElement = document.createElement('li');
    liElement.innerText = text;
    return liElement;
}

function addRandomGreeting() {
    const greetings =
        ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

    // Pick a random greeting.
    const greeting = greetings[Math.floor(Math.random() * greetings.length)];

    // Add it to the page.
    const greetingContainer = document.getElementById('greetings-container');
    greetingContainer.innerText = greeting;

}

}

