package Other;

public class StringFormatter {
    public static String modifyInvisibleCharacters(String _str) {
        StringBuilder str = new StringBuilder();
        str.append("\"");
        for (int i = 0; i < _str.length(); i++) {
            if (_str.charAt(i) == '\\') {
                str.append("\", ");
                if (_str.charAt(i + 1) == 'n')
                    str.append("10");
                if (_str.charAt(i + 1) == '\"')
                    str.append("34");
                if (_str.charAt(i + 1) == '\\')
                    str.append("92");
                str.append(", \"");
                i ++;
            } else {
                str.append(_str.charAt(i));
            }
        }
        str.append("\", 0");
        return str.toString();
    }
}
