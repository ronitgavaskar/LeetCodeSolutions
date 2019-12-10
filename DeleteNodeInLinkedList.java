/**
Delete node in a linked list

ex: [4,5,1,9] => [4,1,9] if node to be deleted is 5
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        // node is the node to be deleted;
        
        // replace node with the next node in the linked list chain (value)
        node.val = node.next.val;
        
        // the next node would be next next
        node.next = node.next.next;
    }
}
