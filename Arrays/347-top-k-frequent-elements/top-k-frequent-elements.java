class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap();

        //add to map - O(N)
        for(int a : nums)
            hm.put(a, hm.getOrDefault(a,0)+1);
        //1 3
        //2 2
        //3 1

        //Ascending order -> min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> hm.get(a) - hm.get(b));
        for(int a : hm.keySet())
        {
            //3 2 1
            pq.offer(a);
            //pop elements from beginning as have less freq O(nlogk)
            if(pq.size() > k)
                pq.poll();
        }

        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = pq.poll();
        }
        return top;
    }
}