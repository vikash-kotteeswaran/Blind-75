# Solution

## [Problem](https://leetcode.com/problems/counting-bits/)

## Approach 1

Size of array in Given problem can be divided as 1, 2, 4, 8, 16, 32....etc
- In 1st cycle we fill upto 1 element
- In 2nd cycle we fill upto 2 element
- In 3rd cycle we fill upto 4 element
- In 4th cycle we fill upto 8 element
- ...etc
  
Each cycle Reuses previous cycle elements.. thats it

![image](https://github.com/vikash-kotteeswaran/Blind-75/assets/71982791/bceeeef8-ba1f-412d-9e71-29c8e3e6e977)

Credits: https://leetcode.com/problems/counting-bits/solutions/3987211/fast-simple-accepted-java-code-beats-90/

### Code
```
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        int refIdx = 0, powersOfTwo = 1;
        res[0] = 0;
        for (int idx = 1; idx <= n; idx++) {
            // Resetting at Powers of Two and the count will be always 1 for powers of two
            if (powersOfTwo*2 == idx) {
                refIdx = 0;
                powersOfTwo *= 2;
            }
            res[idx] = res[refIdx] + 1;
            refIdx++;
        }

        return res;
    }
}
```

## Approach 2

**It works on two principles**
- Right Shifting the Bits of a number once halfs the value of the number. Left Shifting the Bits of a number once doubles the value of the number   _**(Upon you to verify this)**_
- Number of 1's in the Bit representation of a number would either be equal to the Number of 1's in the Bit representation of the number halfed if the number is even
  or be equal to the \[Number of 1's in the Bit representation of the number halfed + 1\] if the number is even  _**(Upon you to verify this)**_

Applying both the principle,
- Number of 1's in the Bit representation of "1" = Number of 1's in the Bit representation of "1/2" + 1 = 1
- Number of 1's in the Bit representation of "2" = Number of 1's in the Bit representation of "2/2" = 1
- Number of 1's in the Bit representation of "3" = Number of 1's in the Bit representation of "3/2" + 1 = 2
- Number of 1's in the Bit representation of "4" = Number of 1's in the Bit representation of "4/2" = 1
- Number of 1's in the Bit representation of "5" = Number of 1's in the Bit representation of "5/2" + 1 = 2
- Number of 1's in the Bit representation of "6" = Number of 1's in the Bit representation of "6/2" = 2
- Goes so on

### Code
```
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        int refIdx = 0, powersOfTwo = 1;
        res[0] = 0;
        for (int idx = 1; idx <= n; idx++) {
            res[idx] = res[idx/2] + idx%2; // res[idx] = res[idx >> 1] + idx % 2;
        }

        return res;
    }
}
```
