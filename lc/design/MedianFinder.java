package lc.design;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    Queue<Integer> smaller;
    Queue<Integer> larger;
    public MedianFinder() {
        smaller = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                return i2-i1;
            }
        });
        larger = new PriorityQueue<Integer>();
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        int sm = smaller.size();
        int lg = larger.size();
        if(sm == lg) {
            if(sm == 0 || num < larger.peek()) {
                smaller.offer(num);
            } else { // num >= larger.peek()
                larger.offer(num);
            } 
        } else {
            if(sm > lg) {
                if(num <= smaller.peek()) {
                    larger.offer(smaller.poll());
                    smaller.offer(num);
                } else {
                    larger.offer(num);
                }
            } else { // sm < lg
                if(num >= larger.peek()) {
                    smaller.offer(larger.poll());
                    larger.offer(num);
                } else {
                    smaller.offer(num);
                }
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        int sm = smaller.size();
        int lg = larger.size();
        if(sm == 0 && lg == 0) return 0d;
        if(sm > lg) return (double)smaller.peek();
        if(sm < lg) return (double)larger.peek();
        return ((double)smaller.peek() + (double)larger.peek()) / 2;
    }
}
