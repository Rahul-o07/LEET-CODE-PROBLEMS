import java.util.HashSet;

class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> seen = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            seen.add(c);
            if (seen.size() == 26) {
                return true;
            }
        }
        return false;
    }
}
