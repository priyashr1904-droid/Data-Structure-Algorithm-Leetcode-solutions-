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
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* curr = head;
        for (int i = 0; i < k; ++i) {
            if (!curr) return head; // Less than k nodes remain, leave them as is
            curr = curr->next;
        }
        
        // Step 2: Reverse the first k nodes
        ListNode* prev = nullptr;
        curr = head;
        for (int i = 0; i < k; ++i) {
            ListNode* nextNode = curr->next;
            curr->next = prev;
            prev = curr;
            curr = nextNode;
        }
        
        // Step 3: Recurse for the remaining groups and connect the tail
        if (curr != nullptr) {
            head->next = reverseKGroup(curr, k);
        }
        
        // 'prev' is the new head of this reversed k-group segment
        return prev;
    
    }
};