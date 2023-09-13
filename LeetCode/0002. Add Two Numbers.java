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
 import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode aux = l1;
        String s1 = "";
        while (aux.next != null){
            s1 = aux.val + s1;
            aux = aux.next;
        }
        s1 = aux.val + s1;
        BigInteger a = new BigInteger(s1);

        aux = l2;
        String s2 = "";
        while (aux.next != null){
            s2 = aux.val + s2;
            aux = aux.next;
        }
        s2 = aux.val + s2;
        BigInteger b = new BigInteger(s2);

        a = a.add(b);
        s2 = "";
        s2 = a.toString();
        aux = null;
        for (int i = 0; i < s2.length(); i++){
            ListNode novo = new ListNode(Integer.parseInt(s2.substring(i, i+1)), aux);
            aux = novo;
        }

        return aux;
    }
}
