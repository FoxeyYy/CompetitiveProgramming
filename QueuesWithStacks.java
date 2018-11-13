import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem
public class QueuesWithStacks {
    
    static class MyQueue<T> {
        
        Stack<T> stack = new Stack<>();
        Stack<T> stack2 = new Stack<>();
        
        public void enqueue(T v) {
            stack.push(v);
        }
        
        public void dequeue() {
            if (stack2.isEmpty()) transfer();
            
            stack2.pop();
        }
        
        public T peek() {
            if (stack2.isEmpty()) transfer();
            
            return stack2.peek();
        }
        
        private void transfer() {
            while(!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
        }
        
    }
    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
