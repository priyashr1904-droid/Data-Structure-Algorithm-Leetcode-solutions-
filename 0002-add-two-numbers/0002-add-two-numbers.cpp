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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode dummy(0); // Dummy node to anchor the result list
        ListNode* tail = &dummy;
        int carry = 0;
        
        // Loop runs until both lists are exhausted AND there is no remaining carry
        while (l1 != nullptr || l2 != nullptr || carry != 0) {
            int sum = carry;
            
            if (l1 != nullptr) {
                sum += l1->val;
                l1 = l1->next;
            }
            
            if (l2 != nullptr) {
                sum += l2->val;
                l2 = l2->next;
            }
            
            carry = sum / 10; // Extract the carry (e.g., 12 / 10 = 1)
            int digit = sum % 10; // Extract the single digit to store (e.g., 12 % 10 = 2)
            
            // Create a new node with the digit and attach it to the result list
            tail->next = new ListNode(digit);
            tail = tail->next;
        }
        
        return dummy.next;
    }
};