from sys import stdin

n = int(input())

a = []
for i in range(n):
    a.append(list(stdin.readline().split()))

a.sort(key=lambda i : int(i[0])) # 나이를 기준으로 정렬

for x in a:
    print(x[0], x[1])