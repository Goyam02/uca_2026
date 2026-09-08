function NewPromise(executorFunction) {
    let state = "pending";
    let value;
    let reason;

    let successCallbacks = [];
    let failureCallbacks = [];

    const resolve = (result) => {
        if (state !== "pending") return;

        state = "fulfilled";
        value = result;

        successCallbacks.forEach(callback => callback(value));
    };

    const reject = (error) => {
        if (state !== "pending") return;

        state = "rejected";
        reason = error;

        failureCallbacks.forEach(callback => callback(reason));
    };

    this.then = function (onSuccess) {
        return new NewPromise((resolve, reject) => {

            const handleSuccess = (value) => {
                try {
                    const result = onSuccess(value);
                    resolve(result);
                } catch (error) {
                    reject(error);
                }
            };

            if (state === "fulfilled") {
                handleSuccess(value);
            } 
            else if (state === "pending") {
                successCallbacks.push(handleSuccess);
            }

        });
    };

    this.catch = function (onError) {
        return new NewPromise((resolve, reject) => {

            const handleError = (reason) => {
                try {
                    const result = onError(reason);
                    resolve(result);
                } catch (error) {
                    reject(error);
                }
            };

            if (state === "rejected") {
                handleError(reason);
            } 
            else if (state === "pending") {
                failureCallbacks.push(handleError);
            }

        });
    };

    try {
        executorFunction(resolve, reject);
    } catch (error) {
        reject(error);
    }
}