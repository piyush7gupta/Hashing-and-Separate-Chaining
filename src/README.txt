In this Assignment I have implemented Hashtable interface using Double Hashing and BST.
I have made a generic Pair class which implements Comparable, in which I implemented Compare 2 function which in this assignment compare 1st name of person. I have also made the function toString which return the concatenate string of first and last name.
I have also made a Node class for BST which has variable key, obj, left and right.
I have also made A Student class implementing Student_ interface which is object in this assignment having variable first name, last name, cg, department, and hostel.
For Double Hashing I have made two arrays of capacity given. In one I store the key and in other object at same index. The function I implemented in Doble Hashing are:
Insert: First I find the hash1 value of key then I check that if that pointer in array is null or not. If not then I add hash2 value of that variable and repeat the same till I find null value.
Contains : First I find the hash1 value of key then I check that if the key at that pointer is equal to the key which we have to found. If same then it returns true else add hash2 value to the pointer. I repeat it till the key is not found or the value reaches the initial value.If it reaches again the same value then it does not contain  that key and it return false.
Update: First it checks if it contains that key or not. IF not then it returns -1 else I found the key using same algo contains function and update the object.
Delete: First it checks if it contains that key or not. IF not then it returns -1 else I found the key using same algo contains function and delete the key and object.
Address: First it checks if it contains that key or not. If not then it throws exception else I found the key using same algo contains function and return the index.
Get: First it checks if it contains that key or not. If not then it throws exception else using address function it first find the value and then return the object at that value.
Average time Complexity for all function O(1)
Worst time Complexity for all function O(n)

For SCBST I have made a array of Object class in this Assignment that Object is node(BST) class that I have made. The function I implemented in SCBST are
Insert : First I find the hash value of the key then for that BST. I start from the root if the root is null insert the key at null else compare the two keys using compareTo function defined above. If first name of given key is greater than first name of key at that node then pass the pointer to the right of the node else to the left. Repeated it till I found null node then inserted the node there.
Contains : First I find the hash value of the key then for that BST. I start from the root if the root.key is equal to the given key then it retuens true else compare the two keys using compareTo function defined above. If first name of given key is greater than first name of key at that node then pass the pointer to the right of the node else to the left. Repeated it till I found null node or node whose key is same as given key. If node whose key is same as given key is found then return true else if null is found then return false.
Update: First it checks if it contains that key or not. IF not then it returns -1 else I found the node using same algo contains function and update the object
Delete : First it checks if it contains that key or not. IF not then it returns -1 else I found the node(N1) using same algo contains function. Now there are three case the node to be deleted ontain 0,1 or 2 child. If both nodes are null then delete the node. If left node is null then I find the left most node(N2) of the right node and assign the value and key of that N2 to the N1 and delete the N2. If only right node is null then I point the pointer of previous node directly to left node of node to be deleted.
Address: First it checks if it contains that key or not. If not then it throws exception else I found the key using same algo contains function and return the address.
Get: First it checks if it contains that key or not. If not then it throws exception else I found the key using same algo contains function and return the object.
Average time Complexity for all function O(log n)
Worst time Complexity for all function O(n)
