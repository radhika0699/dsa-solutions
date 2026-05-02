class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //Approach 2 - sort and use hash table with sorted string as key and anagrams as values
        Map<String, List<String>> hm = new HashMap();
        for(String s : strs)
        {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sorted = String.valueOf(ch);
            if(!hm.containsKey(sorted))
                hm.put(sorted, new ArrayList<>());
            hm.get(sorted).add(s);
        }
        return new ArrayList<>(hm.values());
    }
}


        // ---------------------------------------------------------------------------------
        // List<List<String>> res = new ArrayList<>();
        // //each string check if anagram exists,else add new list, check first ele of each list
        // for(String s : strs)
        // {
        //     if(!checkExistingAnagram(s, res))
        //     {
        //         List<String> temp = new ArrayList();
        //         temp.add(s);
        //         res.add(temp);
        //     }
        // }
        // return res;
    // }
//     private boolean checkExistingAnagram(String s, List<List<String>> res)
//     {
//         if(s == "")
//             return false;
//         for(List<String> s1 : res)
//         {
//             if(checkAnagram(s1.get(0), s))
//             { 
//                 s1.add(s);   
//                 return true;
//             }
            
//         }
//         return false;
//     }
//     private boolean checkAnagram(String mainStr, String s)
//     {
//         Map<Character, Integer> hm = new HashMap();
//         if(s.length() != mainStr.length())
//             return false;
//         for(char c : mainStr.toCharArray())
//             hm.put(c, hm.getOrDefault(c,0) + 1);
//         for(char ch : s.toCharArray())
//         {
//             if(!hm.containsKey(ch) || hm.get(ch) <= 0)
//                 return false;
//             hm.put(ch, hm.get(ch) - 1);
//         }
//         return true;
    
//     }
// }