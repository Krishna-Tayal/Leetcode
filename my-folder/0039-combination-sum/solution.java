class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        solve(res,list,candidates,target,0,0);
        return res;
    }
    public void solve(List<List<Integer>> res,List<Integer> list,int[] candidates,int target,int sum,int start){
        if(sum>target){
            return;
        }
        if(sum==target){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            solve(res, list, candidates, target ,sum + candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
