class Solution {
    public String removeOccurrences(String s, String part) {
        while(s.indexOf(part) != -1){
            s = s.replaceFirst(part, "");
            // int index = s.indexOf(part);
            // s = s.substring(0, index) + s.substring(index + part.length(), s.length());
        }
        return s;
    }
}