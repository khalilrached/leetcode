// problems.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>

struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
    
};

ListNode* deleteDuplicates(ListNode* head) {
    ListNode* cur = head, * start = head;
    while (cur->next != nullptr)
    {
        ListNode* _cur = cur;
        while (cur->val == _cur->val)
        {
            _cur = _cur->next;
        }
        cur->next = _cur;
        cur = _cur->next;
    }
    return start;
}

int main()
{
    ListNode last;
    ListNode blast;
    ListNode second;
    ListNode third;
    last.val = 2;
    last.next = nullptr;
    blast.val = 2;
    blast.next = &last;
    second.val = 1;
    second.next = &blast;
    third.val = 1;
    third.next = &second;
    ListNode* cur = deleteDuplicates(&third);

    while (cur != nullptr) {
        std::cout << cur->val << std::endl;
        cur = cur->next;
    }

}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
