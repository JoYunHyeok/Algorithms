from sys import stdin

n = int(input())
n_list = list(map(int, stdin.readline().split()))
n_list.sort()

sum = 0
result = 0
for i in range(n):
    if i-1 >= 0:
        sum = sum + n_list[i]
    else:
        sum = n_list[i]
    result += sum

print(result)

# n = int(input())
# s = list(map(int, input().split()))
# num = 0
# s.sort()
# print(s)
# for i in range(n):
#     for j in range(i + 1):
#         num += s[j]
# print(num)