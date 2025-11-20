const submitForm = document.querySelector("form#submitForm");
const fieldLink = document.querySelector("aside#fieldLink");
const newLink = document.querySelector("span#newLink");

submitForm.addEventListener("submit", (event) => {
    event.preventDefault();
    postLink();
    fieldLink.classList.remove("hidden");
});

const postLink = async () => {
    const data = new FormData(submitForm);
    const formProps = Object.fromEntries(data);

    const res = await fetch("http://127.0.0.1:8080/api/links", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(formProps),
    })
        .then((res) => res.json())
        .then((json) => (newLink.innerHTML = json.url));
};
