const worker = new Worker("js/web_w1.js");

worker.postMessage("fetchUsers");

worker.onmessage = function (event) {

    const { users, error } = event.data;
    const usersDiv = document.getElementById("users");

    if (error) {
        usersDiv.innerHTML = "No users found";
        worker.terminate();
        return;
    }

    users.forEach(user => {

        const status = user.active ? "Active" : "Inactive";

        const p = document.createElement("p");

        p.textContent = `${user.name} - ${status}`;

        usersDiv.appendChild(p);
    });

    worker.terminate();
};

worker.onerror = function () {
    document.getElementById("users").innerHTML = "No users found";
    worker.terminate();
};