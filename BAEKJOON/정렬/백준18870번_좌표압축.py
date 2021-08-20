# from sys import stdin
#
# n = int(input())
# a = list(map(int, stdin.readline().split()))
# b = sorted(set(a)) # set으로 중복을 제거
#
# # print(a)
# # print(b)
#
# for i in range(len(a)):
#     for j in range(len(b)):
#         if a[i] == b[j]:
#             a[i] = j
#
# print(a)

from sys import stdin

n = int(input())
a = list(map(int, stdin.readline().split()))
b = sorted(set(a)) # set으로 중복을 제거

b_dict = {b[i] : i for i in range(len(b))}

for i in a:
    print(b_dict[i], end= ' ')
