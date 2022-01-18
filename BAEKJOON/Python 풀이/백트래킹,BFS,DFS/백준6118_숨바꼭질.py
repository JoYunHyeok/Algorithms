from collections import deque

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
result = [0] * (n+1)
visited = [False] * (n+1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs():
    queue = deque()
    queue.append(1)
    while queue:
        x = queue.popleft()
        for i in graph[x]:
            if not visited[i]:
                result[i] = result[x] + 1
                queue.append(i)
                visited[i] = True
bfs()
max = 0
a = []
for i in range(2, len(result)):
    if max < result[i]:
        max = result[i]
a.append(max)

for i in range(2, len(result)):
    if max == result[i]:
        print(i, end=' ')
        break

cnt = 0
for i in range(2, len(result)):
    if max == result[i]:
        cnt += 1
a.append(cnt)
print(*a, sep=' ')



