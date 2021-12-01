from collections import deque
from sys import stdin
input = stdin.readline
MAX = 100000
n, k = map(int, input().split())
visited = [False] * (MAX+1)
graph = [0] * (MAX+1)
visited[n] = True
cnt = 0
result = 0
def bfs():
    global cnt
    global result
    queue = deque()
    queue.append(n)
    cnt = 0
    while queue:
        x = queue.popleft()

        if x == k:
            result = graph[x]
            cnt += 1

        for dx in [x-1, x+1, x*2]:
            if 0 <= dx <= MAX:
                if not visited[dx] or graph[dx] == graph[x] + 1:
                    queue.append(dx)
                    visited[dx] = True
                    graph[dx] = graph[x] + 1

bfs()
print(result)
print(cnt)

# 5 - 10 - 9 - 18 - 17
# 5 - 4  - 8 - 16 - 17

