                                    LinkedList Implementation in Java
Overview
    This Java program implements a singly linked list with various features, including sorting, insertion, deletion, and
    merging. The LinkedList class enables operations such as inserting elements at the beginning, end, or at a specific
    index, deleting elements, sorting the list using merge sort, and splitting the list into two sublists.

Methods:
    void mergeSort(): Sort the list using merge sort.
    void insertAtBeginning(int value): Insert a node with the given value at the beginning of the list.
    void insertAtEnd(int value): Insert a node with the given value at the end of the list.
    void insertAtIndex(int index, int value): Insert a node with the given value at the specified index.
    void deleteFirst(): Delete the first node of the list.
    void deleteLast(): Delete the last node of the list.
    void deleteAtIndex(int index): Delete the node at the specified index.
    LinkedList[] twoSublistSplit(): Split the list into two sublists and return them as LinkedList objects.
    LinkedList mergeLists(LinkedList listA, LinkedList listB): Merge two sorted linked lists into one sorted linked list.
    void printList(): Print the entire linked list.
    private void printListFromNode(Node node): Print the list starting from a given node.

Helper Methods:
    Merge Sort Helper: Recursive helper methods for merge sorting.
    Merge Helper: A helper method to merge two sorted linked lists.
    Middle Finding: Uses the slow and fast pointer technique to find the middle of the list for splitting.