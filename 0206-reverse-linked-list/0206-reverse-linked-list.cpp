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
    ListNode* reverseList(ListNode* head) {
        ListNode* prev = nullptr;
        ListNode* curr = head;
        
        while (curr != nullptr) {
            ListNode* nextNode = curr->next; // 1. Save next node
            curr->next = prev;               // 2. Reverse the link
            prev = curr;                     // 3. Move prev forward
            curr = nextNode;                 // 4. Move curr forward
        }
        
        // At the end, prev will be pointing to the new head of the reversed list
        return prev;
    }
};