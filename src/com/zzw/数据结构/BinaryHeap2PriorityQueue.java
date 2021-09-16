package com.zzw.数据结构;


/**
 * @author Zhangzhiwei
 * @Description: 二叉堆（Binary Heap）没什么神秘，性质比二叉搜索树 BST 还简单。其主要操作就两个，sink（下沉）和 swim（上浮），用以维护二叉堆的性质。其主要应用有两个，
 * 首先是一种排序方法「堆排序」，
 * 第二是一种很有用的数据结构「优先级队列」。
 * @return
 * @date 2021/9/16 10:01 AM
 */
public class BinaryHeap2PriorityQueue<Key extends Comparable<Key>> {
    // 存储元素的数组
    private Key[] pq;
    // 当前 Priority Queue 中的元素个数,也是优先级队列的下标
    private int N = 0;

    public BinaryHeap2PriorityQueue(int cap) {
        // 索引 0 不用，所以多分配一个空间
        pq = (Key[]) new Comparable[cap + 1];
    }

    /* 返回当前队列中最大元素 */
    public Key max() {
        return pq[1];
    }

    /* 插入元素 e */
    // insert 方法先把要插入的元素添加到堆底的最后，然后让其上浮到正确位置。
    public void insert(Key e) {
        N++;
        pq[N] = e;
        swim(N);
    }

    /* 删除并返回当前队列中最大元素 */
    // delMax 方法先把堆顶元素 A 和堆底最后的元素 B 对调，然后删除 A，最后让 B 下沉到正确位置。
    public Key delMax() {
        Key max = pq[1];
        exch(1, N);
        pq[N] = null;
        N--;
        sink(1);
        return max;
    }

    /* 上浮第 k 个元素，以维护最大堆性质 */
    private void swim(int k) {
        // 若父节点比当前节点小，则把当前节点和父节点交换
        while (k > 1 && less(parent(k), k)) {
            exch(k, parent(k));
            k = parent(k);
        }
    }

    /* 下沉第 k 个元素，以维护最大堆性质 */
    private void sink(int k) {
        while (left(k) <= N) {
            // 先假设左边子节点最大
            int older = left(k);
            if (right(k) <= N && less(older, right(k))) {
                older = right(k);
            }
            // 若当前节点比两个子节点都大，则不改变
            if (less(older, k)) {
                break;
            }
            exch(older, k);
            k = older;
        }
    }

    /* 交换数组的两个元素 */
    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /* pq[i] 是否比 pq[j] 小？ */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /* 还有 left, right, parent 三个方法 */
    // 父节点的索引
    static int parent(int root) {
        return root / 2;
    }

    // 左孩子的索引
    static int left(int root) {
        return root * 2;
    }

    // 右孩子的索引
    static int right(int root) {
        return root * 2 + 1;
    }
}
