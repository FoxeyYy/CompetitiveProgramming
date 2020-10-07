class Solution {
    
    //Time: O(n) where n is number of people
    //Space: O(n) where n is number of people
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        Map<Integer, List<Integer>> sizeMembers = new HashMap<>();
        
        //Phase 1: Associate for each size its possible members
        for(int id = 0; id < groupSizes.length; id++) {
            int size = groupSizes[id];
            List<Integer> members = sizeMembers.getOrDefault(size, new LinkedList<>());
            members.add(id);
            sizeMembers.put(size, members);
        }
        
        //Phase 2: Group people together
        List<List<Integer>> groups = new LinkedList<>();
                
        for(Integer size: sizeMembers.keySet()) {
            List<Integer> members = sizeMembers.get(size);
            List<Integer> group = new LinkedList<>();
            while(!members.isEmpty()) {               
                group.add(members.get(0));
                members.remove(0);
                
                if(group.size() == size) {
                    groups.add(group);
                    group = new LinkedList<>();
                }
            }
        }
        
        return groups;
        
    }
}
