//leetcode 49


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String str;
    Map<String, List<String>> map = new HashMap<>();
    
    for(int i=0; i< strs.length; i++){
        str = sortString(strs[i]);

        if(map.containsKey(str)){
            map.get(str).add(strs[i]);
        }else{
            map.put(str, new ArrayList<>(Arrays.asList(strs[i])));
        }
    }
     
    return new ArrayList<>(map.values());
    }
    
    
    public String sortString(String s){
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
}
}
