package Other;

public class StringFormatter {
    public static int length;
    public static String modifyInvisibleCharacters(String _str) {
        StringBuilder str = new StringBuilder();
        str.append("\"");
        length = 0;
        for (int i = 0; i < _str.length(); i++) {
            if (_str.charAt(i) == '\\' && i + 1 < _str.length()) {
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
            ++ length;
        }
        str.append("\"");
        while (true) {
            boolean flag = true;
            for (int i = str.length() - 1; i >= 0; i--) {
                if (i > 3) {
                    if (str.charAt(i) == '\"' && str.charAt(i - 1) == '\"') {
                        str.deleteCharAt(i);
                        str.deleteCharAt(i - 1);
                        str.deleteCharAt(i - 2);
                        str.deleteCharAt(i - 3);
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) break;
        }
        str.append(", 0");
        return str.toString();
    }
}
