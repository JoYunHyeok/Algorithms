from sys import stdin

input = stdin.readline

N, M = map(int, input().split())

array = list(map(int, input().split()))
array = sorted(array)
s = []
visited = [False] * N

def dfs(start):
    if len(s) == M:
        print(*s, sep=' ')
        return

    temp = 0
    for i in range(start, len(array)):
        if not visited[i] and temp != array[i]:
            s.append(array[i])
            visited[i] = True
            temp = array[i]
            dfs(i)
            s.pop()
            visited[i] = False


dfs(0)