class Solution {
    public String majorityFrequencyGroup(String s) {
        int n=s.length();
        Map<Character, Integer> map=new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        Map<Integer,Integer> freq=new HashMap<>();
        for(int i : map.values()){
            freq.put(i, freq.getOrDefault(i,0)+1);
        }

        int bestfreq=0;
        int maxsize=0;
        
        for(Map.Entry<Integer,Integer> e : freq.entrySet()){
            int f=e.getKey();
            int size=e.getValue();
            if(size>maxsize || (f>bestfreq && size==maxsize)){
                bestfreq=f;
                maxsize=size;
            }
        }
        StringBuilder sb= new StringBuilder();
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            if(e.getValue() == bestfreq){
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}
