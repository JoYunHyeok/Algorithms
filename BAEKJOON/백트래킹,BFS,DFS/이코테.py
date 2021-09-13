# # 입력받기
# n, m = map(int, input().split())
#
# graph = []
# for i in range(n):
#     graph.append(list(map(int, input())))
#
#
# def dfs(x, y):
#     if x <= -1 or x >= n or y <= -1 or y >= m:
#         return False
#
#     if graph[x][y] == 0:
#         graph[x][y] = 1
#         dfs(x - 1, y) # 상
#         dfs(x, y-1) # 좌좌
#         dfs(x+1, y) # 하
#         dfs(x, y+1) # 우
#         return True
#     return False
#
# result = 0
# for i in range(n):
#     for j in range(m):
#         if dfs(i, j) == True:
#             result += 1
#
# print(result)

# from collections import deque
#
# n, m = map(int, input().split())
#
# graph = []
# for i in range(n):
#     graph.append(list(map(int, input())))
#
# # 상하좌우
# dx = [-1, 1, 0, 0]
# dy = [0, 0, -1, 1]
#
# def bfs(x,y):
#     queue = deque()
#     queue.append((x,y))
#     #큐가 빌때까지
#     while queue:
#         x,y = queue.popleft()
#         for i in range(4):
#             nx = x + dx[i]
#             ny = y + dy[i]
#
#             if nx < 0 or nx >= n or ny < 0 or ny >= m:
#                 continue
#
#             if graph[nx][ny] == 0:
#                 continue
#
#             if graph[nx][ny] == 1:
#                 graph[nx][ny] = graph[x][y] + 1
#                 queue.append((nx, ny))
#
#     return graph[n-1][m-1]
#
#
# print(bfs(0,0))

from collections import deque
from sys import stdin

n, m, v = map(int, stdin.readline().split())
graph = [[0] * (n+1) for _ in range(n+1)] # 인접행렬

for _ in range(m):
    x, y = map(int, stdin.readline().split())
    graph[x][y] = 1
    graph[y][x] = 1

visited = [False] * (n + 1)  # 방문노드 False로 초기화

def dfs(graph, v):

    visited[v] = True # 방문하면 True
    print(v, end=' ') # 방문한 노드 출력
    for i in range(len(graph[v])):
        if graph[v][i] == 1 and visited[i] == False:
            dfs(graph, i)


def bfs(graph, v):
    queue = deque([v])
    visited = [False] * (n + 1)  # 방문노드 False로 초기화
    visited[v] = True

    while queue:
        v = queue.popleft() # 방문한 노드 pop
        print(v, end=' ') # 방문한 노드 출력
        for i in range(len(graph[v])):
            if graph[v][i] == 1 and visited[i] == False:
                queue.append(i) # 순서대로 담기
                visited[i] = True # 담는 즉시 방문기록

dfs(graph, v)
print()
bfs(graph, v)
































