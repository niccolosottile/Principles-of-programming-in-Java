package question_3;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        SortedLinkedList test = new SortedLinkedList();
        provideTest(test, "@2", "!", "3", "1", "2", "-1", "3.4", "a", "AAA", "aa", "A.B", "De1", "Do.l");
        log("-- Test: Unwanted elements --");
        log("The linked list should be \"a-aa-AAA\"");
        log("Contains 1?: " + test.isPresent("1"));
        log("Contains a?: " + test.isPresent("a"));
        log("Contains AAA?: " + test.isPresent("AAA"));
        log("Contains A?: " + test.isPresent("A"));
        log("Contains aa?: " + test.isPresent("aa"));
        log("Can it remove a non-existing and non-alphabetic element?: " + test.remove("3,.14"));

        provideTest(test);
        log("-- Test: SortedLinkedList simple functions --");
        log("Size of linked list: " + test.size());
        log("First element: " + test.getFirst().getString());
        log("Last element: " + test.getLast().getString());
        log("Element at index -2: " + (test.get(-2) == null ? "null" : test.get(-2).getString()));
        log("Element at index 0: " + test.get(0).getString());
        log("Element at index 2: " + test.get(2).getString());
        log("Element at index 50: " + (test.get(50) == null ? "null" : test.get(50).getString()));
        log("Contains a?: " + test.isPresent("a"));
        log("Contains A?: " + test.isPresent("A"));
        log("Contains aa?: " + test.isPresent("aa"));
        log("Contains C?: " + test.isPresent("C"));
        log("Contains H?: " + test.isPresent("H"));

        provideTest(test);
        log("-- Test: SortedLinkedList sorting functions --");
        log("List without using any form of sort method:");
        printInLine(test);
        log("Ascending order of linked list:");
        test.orderAscending();
        printInLine(test);
        log("Attempting to use the same function again:");
        test.orderAscending();
        printInLine(test);
        log("Descending order of linked list:");
        test.orderDescending();
        printInLine(test);
        log("Attempting to use the same function again:");
        test.orderDescending();
        printInLine(test);
        log("Setting order back to ascending!");
        test.orderAscending();
        printInLine(test);

        provideTest(test);
        log("-- Test: SortedLinkedList removing functions --");
        printInLine(test);
        log("Can it remove first?: " + test.removeFirst());
        printInLine(test);
        log("Can it remove first again?: " + test.removeFirst());
        printInLine(test);
        log("Can it remove last?: " + test.removeLast());
        printInLine(test);
        log("Can it remove last again?: " + test.removeLast());
        printInLine(test);
        log("Can it remove first then last?: " + (test.removeFirst() && test.removeLast()));
        printInLine(test);
        log("Can it remove last then first?: " + (test.removeLast() && test.removeFirst()));
        printInLine(test);
        log("Linked list should be empty!");

        provideTest(test, "B", "D", "E", "H", "J");
        log("-- Test: SortedLinkedList adding functions --");
        log("Please note that this test will assume that your add(String) function invokes the add(Node) function!");
        log("Can it add element \"A\" to the front of the linked list?");
        test.add("A");
        printInLine(test);
        log("Can it add element \"Z\" to the end of the linked list?");
        test.add("Z");
        printInLine(test);
        log("Can it add element \"C\" between B and D?");
        test.add("C");
        printInLine(test);
        log("Can it add element \"F\" between E and H?");
        test.add("F");
        printInLine(test);
        log("Can it add element \"G\" between F and H?");
        test.add("G");
        printInLine(test);
        log("Can it add element \"cc\" between C and D?");
        test.add("cc");
        printInLine(test);
        log("Can it add element \"ccc\" between cc and D?");
        test.add("ccc");
        printInLine(test);
        log("Can it add element \"CCCC\" between ccc and D?");
        test.add("CCCC");
        printInLine(test);
        log("Can it add element \"ZZ\" to the end of the linked list?");
        test.add("ZZ");
        printInLine(test);
        log("Can it *not* add element \"a\" to the linked list?");
        test.add("a");
        printInLine(test);
        log("Can it *not* add element \"z\" to the linked list?");
        test.add("z");
        printInLine(test);
        log("Can it *not* add element \"CC\" to the linked list?");
        test.add("CC");
        printInLine(test);
        log("Can it *not* add element \"ccC\" to the linked list?");
        test.add("ccC");
        printInLine(test);


        provideTest(test, "A", "B", "C", "D", "E", "F");
        log("-- Test: SortedLinkedList removing & sorting functions combined --");
        log("Removing string element \"B\" then changing order to descending:");
        test.remove("B");
        test.orderDescending();
        printInLine(test);
        log("Removing last element \"A\" then changing order to ascending:");
        test.removeLast();
        test.orderAscending();
        printInLine(test);
        log("Removing index 2 then changing order to descending:");
        test.remove(2);
        test.orderDescending();
        printInLine(test);
        log("Changing order to ascending then removing the head node \"C\":");
        test.orderAscending();
        test.removeFirst();
        printInLine(test);
        log("Changing order to ascending then removing the last node \"D\":");
        test.orderDescending();
        test.removeLast();
        printInLine(test);

        provideTest(test, "B", "J", "Y");
        log("-- Test: SortedLinkedList adding & sorting functions combined --");
        log("Please note that this test will assume that your add(String) function invokes the add(Node) function!");
        log("Changing order to descending then adding A to the end of the list:");
        test.orderDescending();
        test.add("A");
        printInLine(test);
        log("Changing order to ascending then adding Z to the end of the list:");
        test.orderAscending();
        test.add("Z");
        printInLine(test);
        log("Changing order to descending then adding C before B:");
        test.orderDescending();
        test.add("C");
        printInLine(test);
        log("Changing order to ascending then adding H after C:");
        test.orderAscending();
        test.add("H");
        printInLine(test);

        provideTest(test,  "B", "C", "D");
        log("-- Test: SortedLinkedList removing & adding functions combined --");
        log("Please note that this test will assume that your add(String) function invokes the add(Node) function!");
        log("Removing all elements then adding A, B and C:");
        test.removeFirst();
        test.removeLast();
        test.remove(0);
        test.add("A");
        test.add("B");
        test.add("C");
        printInLine(test);
        log("Removing first element \"A\" then adding \"aa\":");
        test.removeFirst();
        test.add("aa");
        printInLine(test);
        log("Removing element at index 1 and adding \"D\":");
        test.remove(1);
        test.add("D");
        printInLine(test);
        log("Adding \"E\", \"Ee\" then removing last element \"ee\" and adding \"Z\"");
        test.add("E");
        test.add("Ee");
        test.removeLast();
        test.add("Z");
        printInLine(test);


        provideTest(test);
        log("-- Test: SortedLinkedList removing, adding & sorting functions combined --");
        log("Please note that this test will assume that your add(String) function invokes the add(Node) function!");
        log("Can it remove first node (\"A\"), order descending, remove first node (\"H\"), then add \"Z\"?:");
        test.removeFirst();
        printInLine(test);
        test.orderDescending();
        printInLine(test);
        test.removeFirst();
        printInLine(test);
        test.add("Z");
        printInLine(test);
        log("Can it order ascending, remove index 2 (\"D\"), order descending, remove index 4 (\"C\") then order ascending?: ");
        test.orderAscending();
        printInLine(test);
        test.remove(2);
        printInLine(test);
        test.orderDescending();
        printInLine(test);
        test.remove(4);
        printInLine(test);
        test.orderAscending();
        printInLine(test);
        log("Can it add \"A\", order descending, remove last node (\"B\"), order ascending, remove last node (\"A\")?: ");
        test.add("A");
        printInLine(test);
        test.orderDescending();
        printInLine(test);
        test.remove("B");
        printInLine(test);
        test.orderAscending();
        printInLine(test);
        test.removeFirst();
        printInLine(test);

        provideTest(test);
        log("-- Test: SortedLinkedList printing the linked list --");
        test.print();
        log("If you are sure you obtained the results you need then you can submit the code for Q3!");
    }

    public static void log(String message) {
        System.out.println(message);
    }

    public static void provideTest(SortedLinkedList test, String... elements) {
        test.orderAscending();
        log("\n-- Performing the following test with a new list \"%s\" --".formatted(String.join("-", elements)));
        if (test.getFirst() != null) flushList(test);
        populateList(test, elements);
        printInLine(test);
    }

    public static void provideTest(SortedLinkedList test) {
        provideTest(test, "A", "B", "C", "D", "E", "F", "G", "H");
    }

    public static void populateList(SortedLinkedList test, String... strings) {
        for (String string : strings) {
            test.add(string);
        }
    }

    public static void flushList(SortedLinkedList test) {
        while (test.size() > 0) {
            test.removeFirst();
        }
    }

    public static void printInLine(SortedLinkedList ss) {
        for(int i = 0; i< ss.size(); i++){
            System.out.print(Objects.requireNonNullElse(ss.get(i), new Node("null")).getString() + (i == ss.size() - 1 ? "" : "-"));
        }
        System.out.println(" | size: " + ss.size());

        checkHeadTail(ss);
    }

    public static void checkHeadTail(SortedLinkedList ss){
        if(ss.size()>0){
            if(ss.getFirst().getPrev().getPrev() != null){
                throw new IllegalStateException("before head not null");
            }

            if(ss.getLast().getNext() != null){
                throw new IllegalStateException("after last not null");
            }
        }
    }
}
/*

-- Performing the following test with a new list "@2-!-3-1-2--1-3.4-a-AAA-aa-A.B-De1-Do.l" --
a-aa-AAA | size: 3
-- Test: Unwanted elements --
The linked list should be "a-aa-AAA"
Contains 1?: false
Contains a?: true
Contains AAA?: true
Contains A?: true
Contains aa?: true
Can it remove a non-existing and non-alphabetic element?: false

-- Performing the following test with a new list "A-B-C-D-E-F-G-H" --
A-B-C-D-E-F-G-H | size: 8
-- Test: SortedLinkedList simple functions --
Size of linked list: 8
First element: A
Last element: H
Element at index -2: null
Element at index 0: A
Element at index 2: C
Element at index 50: null
Contains a?: true
Contains A?: true
Contains aa?: false
Contains C?: true
Contains H?: true

-- Performing the following test with a new list "A-B-C-D-E-F-G-H" --
A-B-C-D-E-F-G-H | size: 8
-- Test: SortedLinkedList sorting functions --
List without using any form of sort method:
A-B-C-D-E-F-G-H | size: 8
Ascending order of linked list:
A-B-C-D-E-F-G-H | size: 8
Attempting to use the same function again:
A-B-C-D-E-F-G-H | size: 8
Descending order of linked list:
H-G-F-E-D-C-B-A | size: 8
Attempting to use the same function again:
H-G-F-E-D-C-B-A | size: 8
Setting order back to ascending!
A-B-C-D-E-F-G-H | size: 8

-- Performing the following test with a new list "A-B-C-D-E-F-G-H" --
A-B-C-D-E-F-G-H | size: 8
-- Test: SortedLinkedList removing functions --
A-B-C-D-E-F-G-H | size: 8
Can it remove first?: true
B-C-D-E-F-G-H | size: 7
Can it remove first again?: true
C-D-E-F-G-H | size: 6
Can it remove last?: true
C-D-E-F-G | size: 5
Can it remove last again?: true
C-D-E-F | size: 4
Can it remove first then last?: true
D-E | size: 2
Can it remove last then first?: true
 | size: 0
Linked list should be empty!

-- Performing the following test with a new list "B-D-E-H-J" --
B-D-E-H-J | size: 5
-- Test: SortedLinkedList adding functions --
Please note that this test will assume that your add(String) function invokes the add(Node) function!
Can it add element "A" to the front of the linked list?
A-B-D-E-H-J | size: 6
Can it add element "Z" to the end of the linked list?
A-B-D-E-H-J-Z | size: 7
Can it add element "C" between B and D?
A-B-C-D-E-H-J-Z | size: 8
Can it add element "F" between E and H?
A-B-C-D-E-F-H-J-Z | size: 9
Can it add element "G" between F and H?
A-B-C-D-E-F-G-H-J-Z | size: 10
Can it add element "cc" between C and D?
A-B-C-cc-D-E-F-G-H-J-Z | size: 11
Can it add element "ccc" between cc and D?
A-B-C-cc-ccc-D-E-F-G-H-J-Z | size: 12
Can it add element "CCCC" between ccc and D?
A-B-C-cc-ccc-CCCC-D-E-F-G-H-J-Z | size: 13
Can it add element "ZZ" to the end of the linked list?
A-B-C-cc-ccc-CCCC-D-E-F-G-H-J-Z-ZZ | size: 14
Can it *not* add element "a" to the linked list?
A-B-C-cc-ccc-CCCC-D-E-F-G-H-J-Z-ZZ | size: 14
Can it *not* add element "z" to the linked list?
A-B-C-cc-ccc-CCCC-D-E-F-G-H-J-Z-ZZ | size: 14
Can it *not* add element "CC" to the linked list?
A-B-C-cc-ccc-CCCC-D-E-F-G-H-J-Z-ZZ | size: 14
Can it *not* add element "ccC" to the linked list?
A-B-C-cc-ccc-CCCC-D-E-F-G-H-J-Z-ZZ | size: 14

-- Performing the following test with a new list "A-B-C-D-E-F" --
A-B-C-D-E-F | size: 6
-- Test: SortedLinkedList removing & sorting functions combined --
Removing string element "B" then changing order to descending:
F-E-D-C-A | size: 5
Removing last element "A" then changing order to ascending:
C-D-E-F | size: 4
Removing index 2 then changing order to descending:
F-D-C | size: 3
Changing order to ascending then removing the head node "C":
D-F | size: 2
Changing order to ascending then removing the last node "D":
F | size: 1

-- Performing the following test with a new list "B-J-Y" --
B-J-Y | size: 3
-- Test: SortedLinkedList adding & sorting functions combined --
Please note that this test will assume that your add(String) function invokes the add(Node) function!
Changing order to descending then adding A to the end of the list:
Y-J-B-A | size: 4
Changing order to ascending then adding Z to the end of the list:
A-B-J-Y-Z | size: 5
Changing order to descending then adding C before B:
Z-Y-J-C-B-A | size: 6
Changing order to ascending then adding H after C:
A-B-C-H-J-Y-Z | size: 7

-- Performing the following test with a new list "B-C-D" --
B-C-D | size: 3
-- Test: SortedLinkedList removing & adding functions combined --
Please note that this test will assume that your add(String) function invokes the add(Node) function!
Removing all elements then adding A, B and C:
A-B-C | size: 3
Removing first element "A" then adding "aa":
aa-B-C | size: 3
Removing element at index 1 and adding "D":
aa-C-D | size: 3
Adding "E", "Ee" then removing last element "ee" and adding "Z"
aa-C-D-E-Z | size: 5

-- Performing the following test with a new list "A-B-C-D-E-F-G-H" --
A-B-C-D-E-F-G-H | size: 8
-- Test: SortedLinkedList removing, adding & sorting functions combined --
Please note that this test will assume that your add(String) function invokes the add(Node) function!
Can it remove first node ("A"), order descending, remove first node ("H"), then add "Z"?:
B-C-D-E-F-G-H | size: 7
H-G-F-E-D-C-B | size: 7
G-F-E-D-C-B | size: 6
Z-G-F-E-D-C-B | size: 7
Can it order ascending, remove index 2 ("D"), order descending, remove index 4 ("C") then order ascending?: 
B-C-D-E-F-G-Z | size: 7
B-C-E-F-G-Z | size: 6
Z-G-F-E-C-B | size: 6
Z-G-F-E-B | size: 5
B-E-F-G-Z | size: 5
Can it add "A", order descending, remove last node ("B"), order ascending, remove last node ("A")?: 
A-B-E-F-G-Z | size: 6
Z-G-F-E-B-A | size: 6
Z-G-F-E-A | size: 5
A-E-F-G-Z | size: 5
E-F-G-Z | size: 4

-- Performing the following test with a new list "A-B-C-D-E-F-G-H" --
A-B-C-D-E-F-G-H | size: 8
-- Test: SortedLinkedList printing the linked list --
A
B
C
D
E
F
G
H
If you are sure you obtained the results you need then you can submit the code for Q3!
 */