# Algorithm
Get every bits from the end to the start and add it to the output one by one- the origin n move rightwards, the output move leftwards
# Pseudocode
```Java
Input: int n
Output: int output(a reverse number)

int output <- 0
// get every bit through one loop
for int  i <- 0 to 31
  // make the initialized output move leftwards to make sure the new bit will be added on the last digit
  output <<= 1
   //get the last bit of this number by using n & 1, add this bit to the output 
  output += (n & 1)
  //after getting the last bit, make n move rightwards
  n >>= 1
```
# Complexity
- Time complexity: O(1) <br>
loop from bit 0 to bit 31 of a number -> the time complexity is cosntant.
- Space complexity: O(1) <br>
Use output to store -> 1 variable -> O(1)
