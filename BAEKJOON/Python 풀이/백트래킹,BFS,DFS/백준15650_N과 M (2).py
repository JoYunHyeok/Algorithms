from sys import stdin

input = stdin.readline

N, M = map(int, input().split())

s = []
result = []
def dfs(start):
    if len(s) == M:
        print(*s, sep=' ')

    for i in range(start, N+1):
        if i not in s:
            s.append(i)
            dfs(i + 1)
            s.pop()

dfs(1)




