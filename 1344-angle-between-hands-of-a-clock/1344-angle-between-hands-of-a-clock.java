class Solution {
    public double angleClock(int hour, int minutes) {
        double minute_angle=minutes*6;
        double hour_angle=(hour%12)*30 + minutes*0.5;
        double diff=Math.abs(hour_angle-minute_angle);
        return Math.min(diff,360-diff);
    }
}