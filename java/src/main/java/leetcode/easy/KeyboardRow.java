package leetcode.easy;

import java.util.ArrayList;

public class KeyboardRow {
    public static void main(String[] args) {
        findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
    }

    static public String[] findWords(String[] words) {
        //                 A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
        byte[] alphabet = {2, 1, 1, 2, 3, 2, 2, 2, 3, 2, 2, 2, 1, 1, 3, 3, 3, 3, 2, 3, 3, 1, 3, 1, 3, 1};
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            int prev = alphabet[(int) word.toLowerCase().charAt(0) - 97];
            boolean isFromSingleRow = true;
            for (char c : word.toLowerCase().toCharArray())
                if (prev != alphabet[(int) c - 97])
                    isFromSingleRow = false;

            if (isFromSingleRow) {
                result.add(word);
                System.out.println(word);
            }
        }
        String[] resultarr = new String[result.size()];
        return result.toArray(resultarr);
    }

}
