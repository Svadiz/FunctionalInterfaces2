public class Worker {
    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    private OnTaskDoneListener callback;

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    public void start() {
        for (int i = 0; i < 33; i++) {
            callback.onDone("Task " + i + " is done");
        }
    }

    public void start1() {
        for (int i = 34; i < 100; i++) {
            callback.onDone("Task " + i + " is done");
        }
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }

    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskErrorListener errorCallback) {
        this.errorCallback = errorCallback;
    }

    public void mistake() {
        errorCallback.onError("Task " + 33 + " is not done");
    }
}

