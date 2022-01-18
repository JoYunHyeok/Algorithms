from sys import stdin
input = stdin.readline

N, M = map(int, input().split())

array = list(map(int, input().split()))
array.sort()

s = []
def dfs(start):
    if len(s) == M:
        print(*s, sep=' ')
        return

    for i in range(start, N):
        if array[i] not in s:
            s.append(array[i])
            dfs(i+1)
            s.pop()
dfs(0)