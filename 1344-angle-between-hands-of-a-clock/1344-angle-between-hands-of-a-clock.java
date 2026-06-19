class Solution {
    public double angleClock(int hour, int minutes) {
        // Calculate the position of the minute hand relative to 12 o'clock
        double minuteAngle = minutes * 6.0;
        
        // Calculate the position of the hour hand relative to 12 o'clock
        // hour % 12 handles the 12 o'clock case (making it 0)
        double hourAngle = (hour % 12) * 30.0 + minutes * 0.5;
        
        // Find the absolute difference between the two angles
        double diff = Math.abs(hourAngle - minuteAngle);
        
        // Return the smaller angle between the two possible paths
        return Math.min(diff, 360.0 - diff);
    }
}