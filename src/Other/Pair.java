package Other;

public class Pair <T1 extends Object, T2 extends Object> {
    private T1 first;
    private T2 second;

    public Pair() {
        first = null;
        second = null;
    }
    public Pair(T1 _first, T2 _second) {
        first = _first;
        second = _second;
    }
    public final T1 getFirst() {
        return first;
    }
    public final T2 getSecond() {
        return second;
    }

}
