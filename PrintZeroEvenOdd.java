class ZeroEvenOdd {
    private int n;
    private volatile int current;
    
    private Semaphore sem1, sem2, sem3;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        current = 0;
        
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
        
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        
        for(int i = 0; i < n; i++) {
            sem1.acquire();
            printNumber.accept(0);
            current++;
            if(current % 2 == 0) sem2.release();
            else sem3.release(); 
        }
        
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        
        for(int i = 2; i <= n; i += 2) {
            sem2.acquire();
            printNumber.accept(i);
            sem1.release();  
        }
        
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        
        for(int i = 1; i <= n; i += 2) {
            sem3.acquire();
            printNumber.accept(i);
            sem1.release();  
        }
        
    }
}
