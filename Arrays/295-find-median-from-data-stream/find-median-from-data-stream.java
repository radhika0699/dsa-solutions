class MedianFinder {
    //stores smaller nos -> root is largest
    PriorityQueue<Integer> maxHeap;
    //stores larger nos -> root is smallest
    PriorityQueue<Integer> minHeap;

    // add to maxHeap
    // move maxHeap.top → minHeap
    // balance sizes
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
        minHeap = new PriorityQueue<>((a,b) -> a-b);
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {

        if(maxHeap.size() > minHeap.size())
            return maxHeap.peek();
         return (minHeap.peek() + maxHeap.peek()) / 2.0;

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */