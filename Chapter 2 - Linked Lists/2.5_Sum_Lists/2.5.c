#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*
You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
Output: 2 -> 1 -> 9. That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
EXAMPLE
lnput: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
Output: 9 -> 1 -> 2. That is, 912.
*/

struct Node{
    struct Node* next;
    int value;
};

typedef struct Node node;

node* createList(int value) {
    node* head = malloc(sizeof(node));
    head->value = value;
    head->next = NULL;
    return head;
}

int find(node* head, int value) {
    node* trav = head;
    while (trav->next != NULL && trav->value != value) {
        trav = trav->next;
    }
    return (trav->value == value);
}

node* addNode(node* head, int value) {
    node* new = malloc(sizeof(node));
    new->value = value;
    new->next = head;
    return new;
}

node* removeNode(node* head, int value) {
    if (head == NULL) return head;
    if (head->value == value) {
        node* new = head->next;
        free(head);
        return new;
    }
    node* trav = head;
    while (trav->next != NULL) {
        if (trav->next->value == value) {
            node* temp = trav->next;
            trav->next = trav->next->next;
            free(temp);
            return head;
        }
        trav = trav->next;
    }
    return head;
}

void printList(node* head) {
    node* trav = head;
    while (trav != NULL) {
        printf("%d ", trav->value);
        trav = trav->next;
    }
    printf("\n");
    return;
}

int numberOfDigits(int number) {
    int result = 0;
    while (number > 0) {
        number /= 10;
        result++;
    }
    return result;
}

int convertToNumber(node* head) {
    int result = 0;
    int power = 0;
    node* trav = head;
    while (trav != NULL) {
        result += trav->value*pow(10,power);
        power++;
        trav = trav->next;
    }
    return result;
}

int convertToNumberReverse(node* head) {
    int result = 0;
    node* trav = head;
    while (trav != NULL) {
        result *= 10;
        result += trav->value;
        trav = trav->next;
    }
    return result;
}

node* convertToList(int number) {
    node* list = NULL;
    int digits = numberOfDigits(number);
    int value;
    while (digits > 0) {
        value = number/pow(10,digits-1);
        number -= value*pow(10,digits-1);
        list = addNode(list,value);
        digits--;
    }
    return list;
}

node* convertToListReverse(int number) {
    node* list = NULL;
    int digits = numberOfDigits(number);
    int value;
    while (digits > 0) {
        value = number%10
        number -= value;
        number /= 10;
        list = addNode(list,value);
        digits--;
    }
    return list;
}


int main() {
    node* list = createList(6);
    list = addNode(list,1);
    list = addNode(list,7);
    printList(list);
    node* list2 = createList(2);
    list2 = addNode(list2,9);
    list2 = addNode(list2,5);
    printList(list2);
    int sum = convertToNumber(list) + convertToNumber(list2);
    node* list3 = convertToList(sum);
    printList(list3);
    int sum2 = convertToNumberReverse(list) + convertToNumberReverse(list2);
    node* list4 = convertToListReverse(sum2);
    printList(list4);
}
