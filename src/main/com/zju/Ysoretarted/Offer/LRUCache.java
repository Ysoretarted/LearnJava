package main.com.zju.Ysoretarted.Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zcz
 * @CreateTime 2020/6/4 11:10
 */
public class LRUCache {
    static class Node {
        Integer key;
        Integer value;
        Node pre;
        Node next;

        Node(Integer k, Integer v, Node p, Node nxt) {
            this.key = k;
            this.value = v;
            this.pre = p;
            this.next = nxt;
        }
    }

    // 维护一个 head、tail节点在逻辑上处理起来方便
    private static Node head = new Node(null, null, null, null);  //靠近head是最近使用过的
    private static Node tail = new Node(null, null, head, null);
    private static Map map = new HashMap<Integer, Node>();
    private static int capacity;
    private static int len = 0;

    public LRUCache(int capacity) {
        len = 0;
        head.next = tail;
        this.capacity = capacity;
    }

    public static int get(int key) {
        Node res = (Node) map.get(key);
        if (res == null)
            return -1;
        //  维护前后节点 之间的联系
        Node pre = res.pre;
        Node next = res.next;
        pre.next = next;
        next.pre = pre;

        //插入head之后
        putNodeEnough(res);
        return res.value;
    }

    public static void put(int key, int value) {
        Node res = (Node) map.get(key);
        if (res == null) {
            if (len < capacity) {
                Node now = putEnough(key, value);
                map.put(key, now); // 维护查找表
                len++;
            } else {
                // 把最近没使用的节点从 查找表中移除
                map.remove(tail.pre.key);//map.remove(key);// 把最近没使用的节点从 查找表中移除
                Node ppre = tail.pre.pre;// tail的前两个节点
                ppre.next = tail;
                tail.pre = ppre;
                // 插入更新之后的节点
                Node now = putEnough(key, value);
                map.put(key, now);
            }
        } else {
            //维护前后节点的联系
            res.value = value;
            Node pre = res.pre;
            Node next = res.next;
            pre.next = next;
            next.pre = pre;

            putNodeEnough(res);
        }
    }

    // 容量足够的情况下， 头插
    private static Node putEnough(int key, int value) {
        Node next = head.next; // 插入点的下一个节点
        Node now = new Node(key, value, head, next);
        head.next = now;// 改变插入点的前一个节点的next
        next.pre = now;// 改变插入点的下一个节点的pre
        return now;
    }

    private static Node putNodeEnough(Node now) {
        Node next = head.next; // 插入点的下一个节点
        now.pre = head;
        now.next = next;
        head.next = now;// 改变插入点的前一个节点的next
        next.pre = now;// 改变插入点的下一个节点的pre
        return now;
    }

    public static void main(String[] args) {
        LRUCache test = new LRUCache(2);
        test.put(1,1);
        test.put(2,2);
        test.get(1);


        test.put(3,3);
        test.get(2);
        test.put(4,4);
        test.get(1);
        test.get(3);
        test.get(4);
        System.out.println("DDDAAA");
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

