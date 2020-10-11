class FizzBuzz {

    //Non optimal, threads might waste CPU cycles. Fine grained semaphores would be more suitable
    private int n;
    private AtomicInteger current = new AtomicInteger(1);


    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        
        int value;
        
        while((value = current.get()) <= n) {
            if (value % 3 == 0 && value % 15 != 0) {
                printFizz.run();
                value = current.incrementAndGet();
            }
        }
        
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        int value;
        
        while((value = current.get()) <= n) {
            if (value % 5 == 0 && value % 15 != 0) {
                printBuzz.run();
                value = current.incrementAndGet();
            }
        }
        
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        
        int value;
        
         while((value = current.get()) <= n) {
            if (value % 15 == 0) {
                printFizzBuzz.run();
                value = current.incrementAndGet();
            }
        }
        
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        
        int value;
        
        while((value = current.get()) <= n) {
            if (value % 3 != 0 && value % 5 != 0) {
                printNumber.accept(value);
                value = current.incrementAndGet();
            }        
        }
        
    }
    
}
