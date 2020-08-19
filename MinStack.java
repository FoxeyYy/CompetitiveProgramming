class MinStack {
    
    Stack<Integer> elements = new Stack<>();
    Stack<Integer> mins = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        
        elements.push(x);
        if(mins.empty() || x <= getMin()) {
            mins.push(x);
        }
        
    }
    
    public void pop() {
        
        if (elements.empty()) return;
        
        int elem = elements.pop();
        
        if (elem == getMin()) mins.pop();
        
    }
    
    public int top() {
        
        return elements.peek();
        
    }
    
    public int getMin() {
        
        return mins.peek();
        
    }
}
