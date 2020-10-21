class Solution {
    
    //Time: O(n) where n is number of asteroids
    //Space: O(n) where n is number of asteroids
    public int[] asteroidCollision(int[] asteroids) {
        
        Deque<Integer> remaining = new LinkedList<>();
        
        for(int asteroid: asteroids) {
            
            while(asteroid < 0 && !remaining.isEmpty() && remaining.peekLast() > 0) {
                int prev = remaining.pollLast();
                
                if (Math.abs(asteroid) > prev) asteroid = asteroid;
                else if (Math.abs(asteroid) < prev) asteroid = prev;
                else asteroid = 0;
                            
            }
            
            if (asteroid != 0) remaining.addLast(asteroid);
                
        }
        
        int[] sol = new int[remaining.size()];
        
        int idx = 0;
        for(Integer asteroid: remaining) {
            sol[idx] = asteroid;
            idx++;
        }
        
        return sol;
        
    }
    

}
