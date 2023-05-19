public abstract class RequestHandlerTemplate {
    public abstract boolean validateInput(String input);
    public abstract void logRequest(String input);
    public abstract void notifyUser(String input);
    public abstract void processRequest(String input);

    public void processRequest(Request request, String input) {
        validateInput(input);
        logRequest(input);
        request.execute(input);
        notifyUser(input);
    }
}
