package Error;

public class RuntimeError extends Error {
    public RuntimeError(String Message) {
        super("Runtime error : " + Message);
    }
}
