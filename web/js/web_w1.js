self.onmessage = async function (event) {

    if (event.data !== "fetchUsers") {
        return;
    }

    try {

        const response = await fetch("https://dummyapi.com/users");

        if (!response.ok) {
            throw new Error("Failed to fetch users");
        }

        const users = await response.json();

        if (!users || users.length === 0) {
            self.postMessage({
                error: "No users found"
            });
            return;
        }

        self.postMessage({
            users: users
        });

    } catch (error) {

        self.postMessage({
            error: error.message
        });

    }
};