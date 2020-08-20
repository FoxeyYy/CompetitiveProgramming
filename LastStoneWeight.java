class Solution {

    //Time: O(N*logN) where N is stones length
    //Space: O(N) where N is stones length
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for (Integer stone: stones) {
            heap.add(stone);
        }
        
        while(heap.size() > 1) {
            
            int heaviest = heap.poll();
            int nextHeaviest = heap.poll();
            
            int newStone = heaviest - nextHeaviest;
            
            if (newStone == 0) continue;
            
            heap.add(newStone);
            
        }
        
        return heap.size() == 0 ? 0 : heap.poll();
        
    }
}
