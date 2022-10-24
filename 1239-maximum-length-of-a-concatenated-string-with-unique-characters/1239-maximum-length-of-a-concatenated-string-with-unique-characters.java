class Solution {

    public int maxLength(List<String> arr) {
        return helper(arr, 0, "");
    }

    private int helper(List<String> arr, int i, String res) {
        if (i == arr.size()) return res.length();

        int inc = 0;
        if (isValid(res + arr.get(i))) inc = helper(arr, i + 1, res + arr.get(i));
        int exc = helper(arr, i + 1, res);

        return Math.max(inc, exc);
    }

    boolean isValid(String str) {
        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
            if (arr[str.charAt(i) - 'a'] > 1) return false;
        }
        return true;
    }
}
