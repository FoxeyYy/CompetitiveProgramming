class H2O {
    
    private Semaphore hydSem, oxSem;

    public H2O() {
        
        hydSem = new Semaphore(2);
        oxSem = new Semaphore(0);
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
        hydSem.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oxSem.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
        oxSem.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        hydSem.release(2);
    }
}
