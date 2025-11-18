const postLink = () => {
    fetch("url", { method: "POST" })
        .then((res) => res.json())
        .then((json) => console.log(json));
};
