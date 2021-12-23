# 내가 푼 문제풀이
# from sys import stdin
#
# list = list(map(int, stdin.readline().split()))
#
# if list == [1,2,3,4,5,6,7,8]:
#     print("ascending")
# elif list == [8,7,6,5,4,3,2,1]:
#     print("descending")
# else:
#     print("mixed")

#해설 문제풀이
from sys import stdin
input = stdin.readline

a = list(map(int, input().split()))

ascending = True
descending = True

for i in range(1, 8):
    if a[i] > a[i-1]:
        descending = False
    elif a[i] < a[i-1]:
        ascending = False

if ascending:
    print('ascending')
elif descending:
    print('descending')
else:
    print('mixed')
