class Solution {
    public long countNoZeroPairs(long n) {
        q4 res=new q4();
        return res.solve(n);
    }
}
class q4{
    public long solve(long n){
        long tmp=n;
        List<Integer> digs=new ArrayList<>();
        while(tmp>0){
            digs.add((int)(tmp%10));
            tmp/=10;
        }
        int len=digs.size();
        long res=0;
        for(int la=1;la<=len;la++){
            for(int lb=1;lb<=len;lb++){
                long[] carryDp=new long[2];
                carryDp[0]=1;
                for(int i=0;i<len;i++){
                    long[] nextDp=new long[2];
                    int tg=digs.get(i);
                    int aLo=(i<la)?1:0;
                    int aHi=(i<la)?9:0;
                    int bLo=(i<lb)?1:0;
                    int bHi=(i<lb)?9:0;
                    for(int c=0;c<=1;c++){
                        long cnt=carryDp[c];
                        if(cnt==0) continue;
                        for(int a=aLo;a<=aHi;a++){
                            for(int b=bLo;b<=bHi;b++){
                                int sum=a+b+c;
                                if(sum%10==tg) nextDp[sum/10]+=cnt;
                            }
                        }
                    }
                    carryDp=nextDp;
                }
                res+=carryDp[0];
            }
        }
        return res;
    }
}
