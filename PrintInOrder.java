class Foo {
    
    private Semaphore sem1, sem2;

    public Foo() {
        sem1 = new Semaphore(1);
        sem2 = new Semaphore(1);
        
        try {
            sem1.acquire();
            sem2.acquire();
        } catch (InterruptedException e) {
            System.out.println("Something went wrong while acquiring semaphores");
        }
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        sem1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        sem1.acquire();
        sem1.release();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        sem2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        sem2.acquire();
        sem2.release();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
