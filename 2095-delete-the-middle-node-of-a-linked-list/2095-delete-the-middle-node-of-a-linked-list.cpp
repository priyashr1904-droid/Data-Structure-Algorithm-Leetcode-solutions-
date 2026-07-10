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
    ListNode* deleteMiddle(ListNode* head) {
      if (head == nullptr || head->next == nullptr) {
            return nullptr; 
        }
        
        ListNode* slow = head;
        ListNode* fast = head;
        ListNode* prev = nullptr;
        
        while (fast != nullptr && fast->next != nullptr) {
            prev = slow;
            slow = slow->next;
            fast = fast->next->next;
        }
        
        // Unlink the middle node safely
        prev->next = slow->next;
        
        // Free the memory of the unlinked node
        delete slow;
        
        return head;
    }
};