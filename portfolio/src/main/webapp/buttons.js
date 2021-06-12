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

// CReates an <li> element containing text
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