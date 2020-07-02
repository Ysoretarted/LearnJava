package main.com.zju.Ysoretarted.Offer;

/**
 * @author zcz
 * @CreateTime 2020/6/2 10:39
 */
public class Solution111 {
    static class Node{
        Integer value;
        Node next;
        Node(Integer a, Node nxt){
            this.next = nxt;
            this.value = a;
        }
    }
    public static Node tranverse(Node head, int slot,int len){
        if(slot <= 1 || slot > len){
            return head;
        }
        Node newHead = null;
        Node tail = null;
        Node next;
        Node now = head;
        int time = len / slot;
        Node lastTail = null;
        Node nowTail = null;
        for(int i = 1; i <= time; ++i) {
            tail = null;
            for (int j = 1; j <= slot; ++j) {
                if (j == 1)
                    nowTail = now;
                next = now.next;
                now.next = tail;
                tail = now;
                now = next;
            }
            if (newHead == null) {
                newHead = tail;
            }
            if (lastTail != null) {
                lastTail.next = tail;
            }
            lastTail = nowTail;
        }
        if(len % slot != 0){
            lastTail.next = now;
        }
        return newHead;
    }
    public static Node buileLinkList(int[] arr){
        int len = arr.length;
        if(len == 0)
            return null;
        Node head = new Node(arr[0], null);
        Node tail = head;
        for(int i = 1;i < len; ++i){
            tail.next = new Node(arr[i], null);
            tail = tail.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        Node head = buileLinkList(a);
        head = tranverse(head,7,a.length);
        while(head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}
