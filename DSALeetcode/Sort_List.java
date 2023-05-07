//Leetcode 148. Sort List 
//https://leetcode.com/problems/sort-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null) return head;
        head=mergeSort(head);
        return head;
    }
    public ListNode mergeSort(ListNode head){
        if(head.next==null) return head;
        
        ListNode mid=findMin(head);
        ListNode head2=mid.next;
        
        mid.next=null;
        ListNode h1=mergeSort(head);
        ListNode h2=mergeSort(head2);
        ListNode res=merge(h1,h2);
        
        return res;
    }
    public ListNode merge(ListNode h1,ListNode h2){
        ListNode comp=new ListNode(-1);
        ListNode tmp=comp;
        
        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                tmp.next=h1;
                h1=h1.next;
            }else{
                tmp.next=h2;
                h2=h2.next;
            }
            tmp=tmp.next;
        }
        
        while(h1!=null){
            tmp.next=h1;
            h1=h1.next;
            tmp=tmp.next;
        }
        while(h2!=null){
            tmp.next=h2;
            h2=h2.next;
            tmp=tmp.next;
        }
        return comp.next;
    }
    public ListNode findMin(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
}
