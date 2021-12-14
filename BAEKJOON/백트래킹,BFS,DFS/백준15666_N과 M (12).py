from sys import stdin

input = stdin.readline

N, M = map(int, input().split())

array = list(map(int, input().split()))
array = sorted(array)
s = []

def dfs(start):
    if len(s) == M:
        print(*s, sep=' ')
        return

    temp = 0
    for i in range(start, len(array)):
        if temp != array[i]:
            s.append(array[i])
            temp = array[i]
            dfs(i)
            s.pop()

dfs(0)