package lc.backtracking;

import java.util.List;
import java.util.ArrayList;

public class LetterCombinationOfPhoneNumbers {
	public List<String> letterCombinations(String digits) {
        List<String> rs = new ArrayList<>();
        if(digits == null || digits.length() == 0) return rs;
        String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combine(rs, keys, digits, "");
        return rs;
    }
    
    private void combine(List<String> rs, String[] keys, String digits, String letters) {
        if(letters.length() == digits.length()) {
            rs.add(letters);
            return;
        }
        
        for(char c : keys[digits.charAt(letters.length())-'0'].toCharArray()) {
            letters += c;
            combine(rs, keys, digits, letters);
            letters = letters.substring(0, letters.length()-1);
        }
    }
}
