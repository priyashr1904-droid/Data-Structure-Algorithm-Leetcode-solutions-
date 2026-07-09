/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if (!head || !head->next) return head;
        
        ListNode* odd = head;          // Starts at the first node (index 1)
        ListNode* even = head->next;    // Starts at the second node (index 2)
        ListNode* evenHead = even;      // Save the start of the even list to connect later
        
        // Loop runs until we reach the end of the list
        while (even && even->next) {
            odd->next = even->next;     // Link the current odd node to the next odd node
            odd = odd->next;            // Move the odd pointer forward
            
            even->next = odd->next;     // Link the current even node to the next even node
            even = even->next;          // Move the even pointer forward
        }
        
        odd->next = evenHead;           // Connect the end of the odd list to the head of the even list
        
        return head;
    }
};