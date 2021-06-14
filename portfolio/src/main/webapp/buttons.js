/** Fetchs the content from the /hello servlet */
async function displayHello() {
    const response = await fetch('/hello');
    const text = await response.text()

    const testContainer = document.getElementById('greeting-container');
    testContainer.innerText = text;
}