# Java Partition List Algorithm

A straightforward and well-commented Java implementation of the classic "Partition List" problem. This solution rearranges a linked list such that all nodes with values less than a pivot `x` come before all nodes with values greater than or equal to `x`, while maintaining the original relative order within each partition.



---

## Problem Description 

Given the `head` of a linked list and a value `x`, partition it such that all nodes **less than** `x` come before nodes **greater than or equal to** `x`. The original relative order of the nodes in each of the two partitions should be preserved.

### Example

* **Input List:** `1 -> 4 -> 3 -> 2 -> 5 -> 2`
* **Pivot `x`:** `3`
* **Output List:** `1 -> 2 -> 2 -> 4 -> 3 -> 5`

**Explanation:**
* All nodes less than 3 (`1`, `2`, `2`) are moved to the front.
* All nodes greater than or equal to 3 (`4`, `3`, `5`) are moved to the back.
* The relative order is maintained: `1` is still before the two `2`s, and `4` is still before `3` and `5`.

---

## How It Works 

The algorithm uses a simple and efficient **two-pointer approach** to build two new lists.

1.  **Initialization**: Two dummy nodes, `beforeHead` and `afterHead`, are created to serve as the starting points for two new lists.
    * The `before` list will store all nodes with values less than `x`.
    * The `after` list will store all nodes with values greater than or equal to `x`.

2.  **Iteration**: The code traverses the original linked list node by node.
    * If a node's value is less than `x`, it's appended to the `before` list.
    * Otherwise, it's appended to the `after` list.

3.  **Merging**: After iterating through all the nodes, the `before` list is linked to the `after` list.
    * The end of the `before` list (`beforeTail.next`) is connected to the start of the `after` list (`afterHead.next`).
    * The end of the `after` list is terminated with `null` to prevent cycles.

This approach ensures that the original nodes are simply rearranged, not re-created, making the solution efficient in terms of memory.

---

## How to Run the Code 

The code is self-contained in a single Java file and includes a `main` method to handle user input.

1.  **Save the Code**: Save the code in a file named `Main.java`.

2.  **Compile**: Open a terminal or command prompt and run the Java compiler:
    ```bash
    javac Main.java
    ```

3.  **Execute**: Run the compiled code:
    ```bash
    java Main
    ```

4.  **Provide Input**: The program will prompt you to enter the linked list elements and the pivot value.
    ```
    Enter list elements separated by spaces (e.g., 1 4 3 2 5 2).
    Enter a non-integer to stop:
    1 4 3 2 5 2 q
    Original List: 1 -> 4 -> 3 -> 2 -> 5 -> 2 -> NULL

    Enter the partition value (x): 3
    Partitioned List: 1 -> 2 -> 2 -> 4 -> 3 -> 5 -> NULL
    ```

---
