# Array and String
## 1. Array Operations
```Java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
    
        // 1. Initialize
        int[] a0 = new int[5];
        int[] a1 = {1, 2, 3};
        
        // 2. Get Length
        System.out.println("The size of a1 is: " + a1.length);
        
        // 3. Access Element
        System.out.println("The first element is: " + a1[0]);
        
        // 4. Iterate all Elements
        System.out.print("[Version 1] The contents of a1 are:");
        for (int i = 0; i < a1.length; ++i) {
            System.out.print(" " + a1[i]);
        }
        System.out.println();
        
        System.out.print("[Version 2] The contents of a1 are:");
        for (int item: a1) {
            System.out.print(" " + item);
        }
        System.out.println();
        
        // 5. Modify Element
        a1[0] = 4;
        
        // ***6. Sort
        Arrays.sort(a1);
    }
}
```
## 2. ArrayList Operations
```Java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // 1. initialize
        List<Integer> v0 = new ArrayList<>();
        List<Integer> v1;                           // v1 == null
        
        // ***2. cast an array to a vector
        Integer[] a = {0, 1, 2, 3, 4};
        v1 = new ArrayList<>(Arrays.asList(a));
        
        // ***3. make a copy(difference between tqo approaches)
        List<Integer> v2 = v1;                      // another reference to v1
        List<Integer> v3 = new ArrayList<>(v1);     // make an actual copy of v1
        
        // 3. get length
        System.out.println("The size of v1 is: " + v1.size());
        
        // 4. access element
        System.out.println("The first element in v1 is: " + v1.get(0));
        
        // 5. iterate the vector
        System.out.print("[Version 1] The contents of v1 are:");
        for (int i = 0; i < v1.size(); ++i) {
            System.out.print(" " + v1.get(i));
        }
        System.out.println();
        
        System.out.print("[Version 2] The contents of v1 are:");
        for (int item : v1) {
            System.out.print(" " + item);
        }
        System.out.println();
        
        // 6. modify element
        v2.set(0, 5);       //* modify v2 will actually modify v1
        System.out.println("The first element in v1 is: " + v1.get(0));
        v3.set(0, -1);
        System.out.println("The first element in v1 is: " + v1.get(0));
        
        // ***7. sort
        Collections.sort(v1);
        
        // 8. add new element at the end of the vector
        v1.add(-1);
        v1.add(1, 6);
        
        // 9. delete the last element
        v1.remove(v1.size() - 1);
    }
}
```
## 3. 2D Array
```Java
// "static void main" must be defined in a public class.
public class Main {
    private static void printArray(int[][] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.println(a[i]);
        }
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; a[i] != null && j < a[i].length; ++j) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("Example I:");
        int[][] a = new int[2][5];
        printArray(a);
        System.out.println("Example II:");
        int[][] b = new int[2][];
        printArray(b);
        System.out.println("Example III:");
        b[0] = new int[3];
        b[1] = new int[5];
        printArray(b);
    }
}
```
#### Result
```
Example I:
[I@7d4991ad
[I@28d93b30
0 0 0 0 0 
0 0 0 0 0 
Example II:
null
null


Example III:
[I@1b6d3586
[I@4554617c
0 0 0 
0 0 0 0 0 
```
#### Principles
In Java, a two-dimensional array is actually one-dimensional array which contains M elelments, each of which is an array of N integers. (N can be different in anyone in these M elements)
## 4. Introduction to String (focus on differences between array and string)
- <strong> Compare function </strong><br>
Since Java does not support operator overloading, we may not use "==" to compare two strings. When we use "==", it actually compares whether these two objects are the same object.
```Java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // initialize
        String s1 = "Hello World";
        System.out.println("s1 is \"" + s1 + "\"");
        String s2 = s1;
        System.out.println("s2 is another reference to s1.");
        String s3 = new String(s1);
        System.out.println("s3 is a copy of s1.");
        
        // compare using '=='
        System.out.println("Compared by '==':");
        
        // true since string is immutable and s1 is binded to "Hello World"
        System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
        
        // true since s1 and s2 is the reference of the same object
        System.out.println("s1 and s2: " + (s1 == s2));
        
        // false since s3 is refered to another new object
        System.out.println("s1 and s3: " + (s1 == s3));
        
        // compare using 'equals'
        System.out.println("Compared by 'equals':");
        // all true since contents of all the strings are "Hello world"
        System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
        System.out.println("s1 and s2: " + s1.equals(s2));
        System.out.println("s1 and s3: " + s1.equals(s3));
        
        // compare using 'compareTo'
        System.out.println("Compared by 'compareTo':");
        // all true since ASCII values of all the strings are equal and thus all the CompareTo methods return 0
        System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
        System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
        System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));
    }
}
```
Other Reference: [Java | ==, equals(), compareTo(), equalsIgnoreCase() and compare()](https://www.geeksforgeeks.org/java-equals-compareto-equalsignorecase-and-compare/)
>  <strong> Conclusion: </strong> <br>
    1. ==: compare the object<br>
    2. equals: compare the content of string <br>
    3. compareTo: compare the ASCII value of the string <br>
    4. equalsIgnoreCase: similar to equals, but ignore the case <br>
    5. compare: should use Collator class which is in java.text packages; can define our own custom comparison rules
- <strong> Immutable </strong><br>
In Java, the string is immutable, which means that you cannot modify the string like what you did in array.
``` Java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        String s1 = "Hello World";
        s1[5] = ',';
        System.out.println(s1);
    }
}
```
#### Result
```
Line 5: error: array required, but String found [in Main.java]
        s1[5] = ',';
          ^
```
> <strong> More discussions: Problems </strong><br> 
   *1. Modification Operation:*<br>
    If you want to modify just one of the characters, you have to create a new string. <br>
    *2. String Concatenation:*</strong><br>
    In Java, since the string is immutable, concatenation works by first allocating enough space for the new       string, copy the contents from the old string and append to the new string. <br>
    Therefore, the time complexity in total will be: 5 + 5 × 2 + 5 × 3 + … + 5 × n = 5 × (1 + 2 + 3 + … + n) = 5 × n × (n + 1) / 2, which is O(n^2).
```Java
    // "static void main" must be defined in a public class.
    public class Main {
        public static void main(String[] args) {
            String s = "";
            int n = 10000;
            for (int i = 0; i < n; i++) {
                s += "hello";
            }
        }
    }
```
> <strong> More discussions: Solutions </strong><br> 
    1.  If you did want your string to be mutable, you can convert it to a char array.
 ```Java
    // "static void main" must be defined in a public class.
    public class Main {
        public static void main(String[] args) {
            String s = "Hello World";
            char[] str = s.toCharArray();
            str[5] = ',';
            System.out.println(str);
        }
    }
 ```
   > 2. If you have to concatenate strings often, it will be better to use some other data structures like StringBuilder. The below code runs in O(n) complexity.
```Java
    // "static void main" must be defined in a public class.
    public class Main {
        public static void main(String[] args) {
            int n = 10000;
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < n; i++) {
                str.append("hello");
            }
            String s = str.toString();
        }
    }
```
Other reference: [StringBuilder](https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/)
```Java
// Java code to illustrate 
// methods of StringBuilder 

import java.util.*; 
import java.util.concurrent.LinkedBlockingQueue; 

public class GFG1 { 
	public static void main(String[] argv) 
		throws Exception 
	{ 

		// create a StringBuilder object 
		// with a String pass as parameter 
		StringBuilder str 
			= new StringBuilder("AAAABBBCCCC"); 

		// print string 
		System.out.println("String = "+ str.toString()); 

		// reverse the string 
		StringBuilder reverseStr = str.reverse(); 

		// print string 
		System.out.println("Reverse String = "+ reverseStr.toString()); 

		// Append ', '(44) to the String 
		str.appendCodePoint(44); 

		// Print the modified String 
		System.out.println("Modified StringBuilder = "+ str); 

		// get capacity 
		int capacity = str.capacity(); 

		// print the result 
		System.out.println("StringBuilder = " + str); 
		System.out.println("Capacity of StringBuilder = "+ capacity); 
	} 
} 
```
- <strong> Other operations: concatenate, indexOf and substring </strong> <br>
```Java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        String s1 = "Hello World";
        // 1. concatenate
        s1 += "!";
        System.out.println(s1);
        
        // 2. find (start from index 0)
        System.out.println("The position of first 'o' is: " + s1.indexOf('o'));
        System.out.println("The position of last 'o' is: " + s1.lastIndexOf('o'));
        
        // 3. get substring (substring(starting index, ending index + 1))
        System.out.println(s1.substring(6, 11));
    }
}
```
#### Result
```
Hello World!
The position of first 'o' is: 4
The position of last 'o' is: 7
World
```
> <strong> Complexity of built-in operation: </strong> <br>
For instance, if the length of the string is N, the time complexity of both finding operation and substring operation is O(N). Never forget to take the time complexity of built-in operations into consideration when you compute the time complexity for your solution.<br>
Other reference: [String built-in methods](https://www.geeksforgeeks.org/string-class-in-java/)
```Java
// Java code to illustrate different constructors and methods 
// String class. 

import java.io.*; 
import java.util.*; 
class Test 
{ 
	public static void main (String[] args) 
	{ 
		String s= "GeeksforGeeks"; 
		// or String s= new String ("GeeksforGeeks"); 

		// *1.Returns the number of characters in the String. (这里的length带括号)
		System.out.println("String length = " + s.length()); 

		// 2. Returns the character at ith index. 
		System.out.println("Character at 3rd position = " + s.charAt(3)); 

		// 3. Returns the substring from the ith index character to end of string 
		System.out.println("Substring " + s.substring(3)); 

		// 4. Returns the substring from i to j-1 index. 
		System.out.println("Substring = " + s.substring(2,5)); 

		// 5. Concatenates string2 to the end of string1. 
		String s1 = "Geeks"; 
		String s2 = "forGeeks"; 
		System.out.println("Concatenated string = " + s1.concat(s2)); 

		// 6. Returns the index within the string of the first occurrence of the specified string. 
		String s4 = "Learn Share Learn"; 
		System.out.println("Index of Share " + s4.indexOf("Share")); 

		// 7. Returns the index within the string of the 
		// first occurrence of the specified string, 
		// starting at the specified index. 
		System.out.println("Index of a = " + s4.indexOf('a',3)); 

		// 8. Checking equality of Strings 
		Boolean out = "Geeks".equals("geeks"); 
		System.out.println("Checking Equality " + out); 
		out = "Geeks".equals("Geeks"); 
		System.out.println("Checking Equality " + out); 

		out = "Geeks".equalsIgnoreCase("gEeks "); 
		System.out.println("Checking Equality " + out); 

		int out1 = s1.compareTo(s2); 
		System.out.println("If s1 = s2 " + out); 

		// 9. Converting cases 
		String word1 = "GeeKyMe"; 
		System.out.println("Changing to lower Case " + word1.toLowerCase()); 

		// 10. Converting cases 
		String word2 = "GeekyME"; 
		System.out.println("Changing to UPPER Case " + word1.toUpperCase()); 

		// 11.* Trimming the word : :Returns the copy of the String, by removing whitespaces at both ends.
		String word4 = " Learn Share Learn "; 
		System.out.println("Trim the word " + word4.trim()); 

		// 12.* Replacing characters 
		String str1 = "feeksforfeeks"; 
		System.out.println("Original String " + str1); 
		String str2 = "feeksforfeeks".replace('f' ,'g') ; 
		System.out.println("Replaced f with g -> " + str2); 
	} 
} 
```
## 5. Two pointers
1. Scenario 1: Iterate the array from two ends to the middle. One pointer starts from the beginning while the other pointer starts from the end.
2.  Scenario 2：One slow-runner and one fast-runner at the same time. The key to solving this kind of problems is to determine the movement strategy for both pointers.
## 6. Conclusion
1. There are some other data structures which are similar to the array but have some different properties:

- String (has been introduced in this card)
- Hash Table
- Linked List
- Queue
- Stack

2. As we mentioned, we can call the built-in function to sort an array. But it is useful to understand the principle of some widely-used sorting algorithms and their complexity.

3. Binary search is also an important technique used to search a specific element in a sorted array.

4. We have introduced two-pointer technique in this chapter. It is not easy to use this technique flexibly. This technique can also be used to solve:
- Slow-pointer and fast-pointer problem in Linked List
- Sliding Window Problem

5. The two-pointer technique sometimes will relate to Greedy Algorithm which helps us design our pointers' movement strategy.
