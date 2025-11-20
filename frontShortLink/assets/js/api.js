const submitForm = document.querySelector("form#submitForm");
const fieldLink = document.querySelector("aside#fieldLink");
const newLink = document.querySelector("span#newLink");
const raiseError = document.querySelector("h3#raiseError");

submitForm.addEventListener("submit", (event) => {
    event.preventDefault();
    postLink();
});

const postLink = async () => {
    const data = new FormData(submitForm);
    const formProps = Object.fromEntries(data);
    fieldLink.classList.add("hidden");
    raiseError.classList.add("hidden");

    try {
        const res = await fetch("http://127.0.0.1:8080/api/links", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(formProps),
        });

        if (!res.ok) {
            var erroDate = await res.json();
            throw new Error(erroDate.error || erroDate.message || erroDate.url);
        }

        const req = await res.json();
        fieldLink.classList.remove("hidden");
        newLink.innerHTML = req.url;
    } catch (err) {
        raiseError.classList.remove("hidden");
        raiseError.innerHTML = err;
    }
};
