package trie;

/**
 *
 * @author ehn19
 */
public class Soundex {

    public static String soundex(String s) {
        char[] l = s.toUpperCase().toCharArray();
        char firstLetter = l[0];

        for (int i = 0; i < l.length; i++) {
            switch (l[i]) {

                case 'B':
                case 'F':
                case 'P':
                case 'V':
                    l[i] = '1';
                    break;

                case 'C':
                case 'G':
                case 'J':
                case 'K':
                case 'Q':
                case 'S':
                case 'X':
                case 'Z':
                    l[i] = '2';
                    break;

                case 'D':
                case 'T':
                    l[i] = '3';
                    break;

                case 'L':
                    l[i] = '4';
                    break;

                case 'M':
                case 'N':
                    l[i] = '5';
                    break;

                case 'R':
                    l[i] = '6';
                    break;

                default:
                    l[i] = '0';
                    break;
            }
        }

        String output = "" + firstLetter;
        for (int i = 1; i < l.length; i++) {
            if (l[i] != l[i - 1] && l[i] != '0') {
                output += l[i];
            }
        }
        return output;
    }
}
