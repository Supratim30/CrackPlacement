class Solution {

    public boolean checkIfPangram(String sentence) {
        sentence = sentence.toLowerCase();
        boolean pangram = true;
        for (char c = 'a'; c <= 'z'; c++) {
            if (!sentence.contains(String.valueOf(c))) {
                pangram = false;
                break;
            }
        }
        return pangram;
    }
}
