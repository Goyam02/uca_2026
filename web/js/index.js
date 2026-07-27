const worker = new Worker("js/web_worker.js");

worker.postMessage("fetchUsers");

worker.onmessage = function (event) {
    const { users, error } = event.data;

    if (error) {
        console.error("Error:", error);
        worker.terminate();
        return;
    }

    users.forEach(user => {
        const status = user.active ? "Active" : "Inactive";
        console.log(`${user.name} - ${status}`);
    });

    worker.terminate();
};

worker.onerror = function (error) {
    console.error("Web Worker Error:", error.message);
    worker.terminate();
};