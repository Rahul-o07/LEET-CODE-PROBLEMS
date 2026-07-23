import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
        };
        int[] charRow = new int[26];
        for (int i = 0; i < rows.length; i++) {
            for (char c : rows[i].toCharArray()) {
                charRow[c - 'a'] = i;
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (word.isEmpty()) continue;
            
            String lowerWord = word.toLowerCase();
            int targetRow = charRow[lowerWord.charAt(0) - 'a'];
            boolean isValid = true;
            
            for (int i = 1; i < lowerWord.length(); i++) {
                if (charRow[lowerWord.charAt(i) - 'a'] != targetRow) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
}
