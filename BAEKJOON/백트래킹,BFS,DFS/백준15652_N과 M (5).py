from sys import stdin
input = stdin.readline

N, M = map(int, input().split())

array = list(map(int, input().split()))
array.sort()

s = []
def dfs():
    if len(s) == M:
        print(*s, sep=' ')
        return

    for i in range(N):
        if array[i] not in s:
            s.append(array[i])
            dfs()
            s.pop()
dfs()