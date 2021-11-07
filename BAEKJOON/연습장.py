from sys import stdin
input = stdin.readline

a = []
n = int(input())
for _ in range(n):
    x, y = map(int, input().split())
    a.append((x,y))
a = sorted(a)

for i in a:
    print(i[0], i[1])