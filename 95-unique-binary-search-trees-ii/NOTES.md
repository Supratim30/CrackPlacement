```
Question
Given an integer n, return all the structurally unique
BST's (binary search trees), which has exactly n nodes of
unique values from 1 to n. Return the answer in any order.
​
Thoughts Before Coding
- We are given a number 'n', which means we can use the node values from '1 -> n'
- For each of the numbers from '1 -> n', which we will denote as 'i'
- We can create a root node the value 'i'
- Then the values from '1 -> i - 1' can be used to create the left subtrees of 'i'
- Then the values from 'i + 1 -> n' can be used to create the right subtree of 'i'
- Then in order to generate all of the possible BSTs
- We have to pair up all combinations of left and right subtrees which are rooted at 'i'
​
Answer
- Lets validate the input parameter
- If 'n' is equal to 0
- Return an empty list
- Implement a recursive approach to generate all of the BSTs
- What parameters do we need?
- left, initially 1
- right, initially 'n'
- In each of the recursive calls
- Create a list 'roots'
- If 'left' is greater than 'right'
- Add 'null' to 'roots'
- Else
- Iterate through from 'left -> right', denoted as 'i'
- Recursively find the left subtrees 'leftSubtrees' of 'i'
- right => i - 1
- Recursively find the right subtrees 'rightSubtrees' of 'i'
- left => i + 1
- Perform a nested 'for' loop on 'leftSubtrees' and 'rightSubtrees',
which we can denote as 'leftSubtree' and 'rightSubtree'
- Create a new node 'root' with the value of 'i'
- Set 'root.left' to 'leftSubtree'
- Set 'root.right' to 'rightSubtree'
- Add 'root' to 'roots'
- Return 'roots'
```