# Part 1: Bit manipulation
## Bitwise Operators

1. NOT ( ~ ): Bitwise NOT is an unary operator that flips the bits of the number i.e., if the ith bit is 0, it will change it to 1 and vice versa. Bitwise NOT is nothing but simply the one’s complement of a number. Lets take an example. 
N = 5 = 101
~N = ~5 = ~(101) = (010)

2. AND ( & ): Bitwise AND is a binary operator that operates on two equal-length bit patterns. If both bits in the compared position of the bit patterns are 1, the bit in the resulting bit pattern is 1, otherwise 0.
A = 5 = (101) , B = 3 = (011) A & B = (101) & (011) = (001) = 1

3. OR ( | ): Bitwise OR is also a binary operator that operates on two equal-length bit patterns, similar to bitwise AND. If both bits in the compared position of the bit patterns are 0, the bit in the resulting bit pattern is 0, otherwise 1.
A = 5 = (101) , B = 3 = (011)
A | B = (101) | (011) = (111) = 7

4. XOR ( ^ ): Bitwise XOR also takes two equal-length bit patterns. If both bits in the compared position of the bit patterns are 0 or 1, the bit in the resulting bit pattern is 0, otherwise 1.
A = 5 = (101) , B = 3 = (011)
A ^ B = (101) ^ (011) = (110) = 6

5. Left Shift ( << ): Left shift operator is a binary operator which shift the some number of bits, in the given bit pattern, to the left and append 0 at the end. Left shift is equivalent to multiplying the bit pattern with  ( if we are shifting k bits ).
1 << 1 = 2 = 21
1 << 2 = 4 = 22 1 << 3 = 8 = 23
1 << 4 = 16 = 24 
…
1 << n = 2n

6. Right Shift ( >> ): Right shift operator is a binary operator which shift the some number of bits, in the given bit pattern, to the right and append 1 at the end. Right shift is equivalent to dividing the bit pattern with 2k ( if we are shifting k bits ).
4 >> 1 = 2
6 >> 1 = 3
5 >> 1 = 2
16 >> 4 = 1

<strong>Example: </strong><br>
1010 & 0101 == 0000
1100 & 0110 == 0100

1010 | 0101 == 1111
1100 | 0110 == 1110

~1111 == 0000
~0011 == 1100

1010 ^ 0101 == 1111
1100 ^ 0110 == 1010

10000001 | 00100000 = 10100001 /* turned on bit 5 */

## A Word About Bit Order
Assuming that the most-significant-bit is on the left, notice that the value of bit 0 is 2^0, bit 1 is 2^1, ..., bit 7 is 2^7.<br>
<strong>Example: </strong> 10010110 (from bit 7 to bit 0)

# Part 2: Pseudocode
## Solution 1
```
Input: n 
Output: sum (the number of 1 bits of n)

sum <- 0 
// define a variable and compare it with every bit of n
mask <- 1 
// compare every bit from bit 0 to bit 32

for i <- 0 to 32-1
  //check the i^{th} bit of a number using a bit mask. If i^{th} bit is 1, update sum.
  if (n & mask) != 0 then sum++
  //update mask to change the bit of 1-bit
  mask <<= 1
  
return sum
```
## Solution 2
```
Input: n 
Output: sum (the number of 1 bits of n)

sum <- 0 
// when n was not be transfered to 0, use loop to check 1-bits
while (n != 0)
  // update sum since we will transfer the last 1-bit
  sum ++
  // a effective way to transfer every bit to 0 from the last 1-bit to the end  
  n = n & (n-1)

return sum
```
# Part 3：Complexity
1. Since bit manipulation is to calculate a specific number, we just need constant time to deal with this problem. The time complexity is O(1).
2. Also, the space complexity is O(1) n is a constant number and just takes constant space.
