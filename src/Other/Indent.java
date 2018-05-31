package Other;

public class Indent {
    public static String appendIndent(int cnt) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            str.append("\t");
        }
        return str.toString();
    }
}
