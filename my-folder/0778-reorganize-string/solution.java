class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> map= new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<Character> heap =new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        StringBuilder result= new StringBuilder();

        heap.addAll(map.keySet());
        while(heap.size()>1){
            char first=heap.poll();
            char second=heap.poll();

            result.append(first).append(second);

            map.put(first,map.get(first)-1);
            map.put(second,map.get(second)-1);

            if(map.get(first)>0){
                heap.add(first);
            }
            if(map.get(second)>0){
                heap.add(second);
            }
        }
        if(!heap.isEmpty()){
            char last=heap.poll();
            if(map.get(last)>1){
                return "";
            }
            result.append(last);
        }
         
        return result.toString();
    }
}
