# 백준2606 바이러스
# from collections import deque
#
# n = int(input())
# m = int(input())
#
# graph = [[] for _ in range(n+1)]
# visited = [False] * (n+1)
#
# for _ in range(m):
#     a, b = map(int, input().split())
#     graph[a].append(b)
#     graph[b].append(a)
#
# def bfs(x):
#     queue= deque([x])
#     visited[x] = True
#     cnt = 0
#     while queue:
#         q = queue.popleft()
#         for com in graph[q]:
#             if not visited[com]:
#                 queue.append(com)
#                 visited[com] = True
#                 cnt += 1
#     print(cnt)
#
# bfs(1)

# 백준1260 DFS와 BFS
# 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
# 인접리스트로 하면 위의 조건에 걸린다. 인접행렬로 풀어야한다.
from collections import deque
from sys import stdin

# n, m, v = map(int, stdin.readline().split())
# graph = [[0] * (n+1) for _ in range(n+1)] # 인접행렬
#
# for _ in range(m):
#     x, y = map(int, stdin.readline().split())
#     graph[x][y] = 1
#     graph[y][x] = 1
#
# visited = [False] * (n + 1)  # 방문노드 False로 초기화
#
# def dfs(graph, v):
#
#     visited[v] = True # 방문하면 True
#     print(v, end=' ') # 방문한 노드 출력
#     for i in range(len(graph[v])):
#         if graph[v][i] == 1 and visited[i] == False:
#             dfs(graph, i)
#
#
# def bfs(graph, v):
#     queue = deque([v])
#     visited = [False] * (n + 1)  # 방문노드 False로 초기화
#     visited[v] = True
#
#     while queue:
#         v = queue.popleft() # 방문한 노드 pop
#         print(v, end=' ') # 방문한 노드 출력
#         for i in range(len(graph[v])):
#             if graph[v][i] == 1 and visited[i] == False:
#                 queue.append(i) # 순서대로 담기
#                 visited[i] = True # 담는 즉시 방문기록
#
# dfs(graph, v)
# print()
# bfs(graph, v)


#백준11725 트리의 부모찾기
from collections import deque

n = int(input())

graph = [[] for _ in range(n+1)]
root = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (n+1)

# def bfs(v):
#     queue = deque([v])
#     while queue:
#         node = queue.popleft()
#         for i in graph[node]:
#             root[i].append(node)
#             queue.append(i)
#             graph[i].remove(node)
# bfs(1)

def dfs(v):
    stack = [v]
    while stack:
        node = stack.pop()
        for i in graph[node]:
            root[i].append(node)
            stack.append(i)
            graph[i].remove(node)
dfs(1)

for i in range(2, len(root)):
    print(root[i][0])

