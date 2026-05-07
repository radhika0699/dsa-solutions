class Solution {
    Map<Integer, Integer> hm = new HashMap();
    int[] unique;
    public static Random rand = new Random();
    public int[] topKFrequent(int[] nums, int k) {
        // Map<Integer, Integer> hm = new HashMap();

        // //add to map - O(N)
        // for(int a : nums)
        //     hm.put(a, hm.getOrDefault(a,0)+1);
        // //1 3
        // //2 2
        // //3 1

        // //Ascending order -> min heap
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> hm.get(a) - hm.get(b));
        // for(int a : hm.keySet())
        // {
        //     //3 2 1
        //     pq.offer(a);
        //     //pop elements from beginning as have less freq O(nlogk)
        //     if(pq.size() > k)
        //         pq.poll();
        // }

        // int[] top = new int[k];
        // for(int i = k - 1; i >= 0; --i) {
        //     top[i] = pq.poll();
        // }
        // return top;
        //------------------------------------------------------------------------------------
        //Hoare's Algorithm - QuickSelect for QuickSort
        // add to map - O(N)
        for (int a : nums)
            hm.put(a, hm.getOrDefault(a, 0) + 1);
        unique = new int[hm.size()];
        int i = 0;
        for (int a : hm.keySet()) {
            unique[i] = a;
            i++;
        }
        //low, high,selected range -> n-k to n is most frequent k elements
        quickSelect(0, hm.size() - 1, hm.size() - k);
        return Arrays.copyOfRange(unique, hm.size() - k, hm.size());
    }

    private void quickSelect(int l, int r, int k) {
        if (l == r)
            return;

        int pInd = l + rand.nextInt(r - l + 1);
        //index of pivot/last ele after placing in correct pos
        int pivot = partition(l, r, pInd);
        if (k == pivot)
            return;
        else if (pivot < k)
            quickSelect(pivot + 1, r,k);
        else
            quickSelect(l, pivot - 1,k);

    }

    private int partition(int l, int r, int pIdx)
    {
        //lomuto's algo
        //l= 0, r= 0, pIdx = 2
        // 1 2 3 -> 3 1 2
        swap(l,pIdx);
        int g = l;
        for(int b = l+1; b <=r ; b++)
        {
            if(hm.get(unique[b]) < hm.get(unique[l]))
            {
                g++;
                swap(g,b);
            }
        }
        swap(g, l);
        return g;
    }
    private void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }
}