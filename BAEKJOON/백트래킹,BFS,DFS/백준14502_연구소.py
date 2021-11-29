import copy
from sys import stdin
from collections import deque

n ,m = map(int, input().split())
graph = []
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
max_result = 0
queue = deque()
for _ in range(n):
    graph.append(list(map(int, input().split())))

def bfs(graph):
    global max_result

    while queue:
        y, x = queue.popleft()
        for l in range(4):
            ny = dy[l] + y
            nx = dx[l] + x
            if 0 <= ny < n and 0 <= nx < m and graph[ny][nx] == 0:
                queue.append((ny, nx))
                graph[ny][nx] = 2

    zero_cnt = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                zero_cnt += 1

    max_result = max(max_result, zero_cnt)


def wallSetting(cnt):
    if cnt == 3:
        for i in range(n):
            for j in range(m):
                if graph[i][j] == 2:
                    queue.append((i, j))
        graph_copy = copy.deepcopy(graph)
        bfs(graph_copy)
        return

    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                graph[i][j] = 1
                wallSetting(cnt+1)
                graph[i][j] = 0

wallSetting(0)
print(max_result)