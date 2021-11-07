## 내 풀이
from sys import stdin
input = stdin.readline

a = list(map(int, input().strip()))
a.sort(reverse=True)
print(*a, sep="")

## 동빈나 풀이
array = input()
for i in range(9, 1, -1):
    for j in array:
        if int(j) == i:
            print(i, end='')