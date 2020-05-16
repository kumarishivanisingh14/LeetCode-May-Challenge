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
        if(head == nullptr || head->next == nullptr) return head;
        
        ListNode *oddPointer = head;
        ListNode *evenPointer = head->next;
        ListNode *even = head->next;
        
        while(evenPointer != nullptr && evenPointer->next != nullptr){
            oddPointer->next = oddPointer->next -> next;
            oddPointer = oddPointer->next;
            evenPointer->next = evenPointer->next -> next;
            evenPointer = evenPointer->next;
        }
        oddPointer->next = even;
        return head;
    }
};