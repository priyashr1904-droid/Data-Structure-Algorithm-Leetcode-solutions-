/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if (!headA || !headB) return nullptr;
        
        ListNode* ptrA = headA;
        ListNode* ptrB = headB;
        
        // Loop runs until the two pointers meet
        while (ptrA != ptrB) {
            // If ptrA reaches the end of list A, redirect it to head of list B
            // Otherwise, move it to the next node
            ptrA = (ptrA == nullptr) ? headB : ptrA->next;
            
            // If ptrB reaches the end of list B, redirect it to head of list A
            // Otherwise, move it to the next node
            ptrB = (ptrB == nullptr) ? headA : ptrB->next;
        }
        
        // If they intersect, ptrA (or ptrB) points to the intersection node.
        // If they don't intersect, both pointers will eventually become nullptr at the same time, exiting the loop.
        return ptrA;
    }
};