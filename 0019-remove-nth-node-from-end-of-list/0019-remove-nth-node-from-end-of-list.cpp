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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* dummy = new ListNode(0, head);
        ListNode* fast = dummy;
        ListNode* slow = dummy;
        
        // 1. Move the fast pointer n + 1 steps ahead
        for (int i = 0; i <= n; ++i) {
            fast = fast->next;
        }
        
        // 2. Move both pointers together until fast reaches the end
        while (fast != nullptr) {
            fast = fast->next;
            slow = slow->next;
        }
        
        // 3. slow->next is the node to be deleted
        ListNode* nodeToDelete = slow->next;
        slow->next = slow->next->next;
        
        // Free memory of the deleted node to avoid memory leaks
        delete nodeToDelete;
        
        // Get the real head pointer and clean up the dummy node
        ListNode* newHead = dummy->next;
        delete dummy;
        
        return newHead;
    }
};