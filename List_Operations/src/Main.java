//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            LinkedList mergedlist = new LinkedList();
            LinkedList list = new LinkedList();
            LinkedList listA = new LinkedList();
            LinkedList listB = new LinkedList();



            //A)Insertion Beginning, End, Index
//            list.insertAtBeginning(10);
//
//            //list.insertAtEnd(5);
//            list.insertAtBeginning(20);
//
//            list.insertAtEnd(30);
//          list.insertAtIndex(3, 35);
//          list.insertAtEnd(50);
//        list.printList();
//
//             //B)Deletion first, last, index
////            list.deleteFirst();
////            list.deleteLast();
////            list.deleteAtIndex(1);
////            list.printList();
////           //C)
//            LinkedList[] splitlists = list.twoSublistSplit();
////
////            //C)
//            System.out.println("Front Split: ");
//            splitlists[0].printList();
//            System.out.println("Back Split: ");
//            splitlists[1].printList();

            //print the list


            //D)printing the merged list
            listA.insertAtBeginning(10);
            listA.insertAtBeginning(20);
            listA.insertAtBeginning(30);
            System.out.println("List A: ");
            listA.printList();
            listB.insertAtBeginning(15);
            listB.insertAtBeginning(25);
            System.out.println("List B: ");
            listB.printList();
            mergedlist = mergedlist.mergeLists(listA, listB);
            System.out.println("Merged List: ");
            mergedlist.printList();
        }
    }
