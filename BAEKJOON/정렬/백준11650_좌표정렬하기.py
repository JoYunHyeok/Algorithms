from sys import stdin

n = int(input())

a = []

for _ in range(n):
    x, y = map(int, stdin.readline().split())
    a.append((x,y))

a.sort(key=lambda x: (x[0], x[1]))

for i in a:
    print(i[0], i[1])