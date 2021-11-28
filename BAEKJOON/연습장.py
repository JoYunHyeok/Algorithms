# # 백준2606 바이러스
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
#
# # 백준1260 DFS와 BFS
# # 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
# # 인접리스트로 하면 위의 조건에 걸린다. 인접행렬로 풀어야한다.
# from collections import deque
# from sys import stdin
#
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
#
#
# #백준11725 트리의 부모찾기
# from collections import deque
#
# n = int(input())
#
# graph = [[] for _ in range(n+1)]
# root = [[] for _ in range(n+1)]
#
# for _ in range(n-1):
#     a, b = map(int, input().split())
#     graph[a].append(b)
#     graph[b].append(a)
#
# visited = [False] * (n+1)

# def bfs(v):
#     queue = deque([v])
#     while queue:
#         node = queue.popleft()
#         for i in graph[node]:
#             root[i].append(node)
#             queue.append(i)
#             graph[i].remove(node)
# bfs(1)
#
# def dfs(v):
#     stack = [v]
#     while stack:
#         node = stack.pop()
#         for i in graph[node]:
#             root[i].append(node)
#             stack.append(i)
#             graph[i].remove(node)
# dfs(1)
#
# for i in range(2, len(root)):
#     print(root[i][0])

# #미로탐색
# from sys import stdin
# from collections import deque
# input = stdin.readline
#
# n, m = map(int, input().split())
# graph = []
# for _ in range(n):
#     graph.append(list(map(int, input().strip())))
#
# dy = [-1, 1, 0, 0]
# dx = [0, 0, -1, 1]
#
# def bfs(i, j):
#     queue = deque()
#     queue.append((i, j))
#     while queue:
#         y, x = queue.popleft()
#         for l in range(4):
#             yy = dy[l] + y
#             xx = dx[l] + x
#             if 0 <= yy < n and 0 <= xx < m and graph[yy][xx] == 1:
#                 graph[yy][xx] = graph[y][x] + 1
#                 queue.append([yy, xx])
#
#
# bfs(0,0)
# print(graph[n-1][m-1])


# 2667 단지번호 붙이기
# 1에서 0으로 변할때마다 cnt += 1
'''
예외예시
3
000
001
000
'''
from collections import deque
from sys import stdin

# input = stdin.readline
#
# n = int(input())
# graph = []
# for _ in range(n):
#     graph.append(list(map(int, input().strip())))
#
# dy = [-1, 1, 0, 0]
# dx = [0, 0, -1, 1]
#
# def bfs(i, j):
#     queue = deque()
#     queue.append((i, j))
#     graph[i][j] = 0
#     cnt = 1
#     while queue:
#         y, x = queue.popleft()
#         for l in range(4):
#             yy = dy[l] + y
#             xx = dx[l] + x
#             if 0 <= yy < n and 0 <= xx < n and graph[yy][xx] == 1:
#                 graph[yy][xx] = 0
#                 queue.append((yy, xx))
#                 cnt += 1
#     return cnt
#
# result = []
# for i in range(n):
#     for j in range(n):
#         if graph[i][j] == 1:
#             result.append(bfs(i,j))
#
# result.sort()
# print(len(result))
# print(*result, sep='\n')

#백준7576 토마토
# from collections import deque
# from sys import stdin
# input = stdin.readline
# m, n = map(int, input().split())
# graph = []
# for _ in range(n):
#     graph.append(list(map(int, input().split())))
#
# dy = [-1, 1, 0, 0]
# dx = [0, 0, -1, 1]
# def bfs():
#     while queue:
#         y, x = queue.popleft()
#         for l in range(4):
#             yy = dy[l] + y
#             xx = dx[l] + x
#             if 0 <= yy < n and 0 <= xx < m and graph[yy][xx] == 0:
#                 graph[yy][xx] = graph[y][x] + 1
#                 queue.append((yy, xx))
# flag = True # 토마토가 미리 익어있는 상황 체크
# queue = deque()
# for i in range(n):
#     for j in range(m):
#         if graph[i][j] == 1:
#             queue.append((i, j))
#
# bfs()
# flag = False
# max = -2
# for i in range(n):
#     for j in range(m):
#         if graph[i][j] == 0:
#             flag = True
#         if graph[i][j] > max:
#             max = graph[i][j]
#
# if flag: # 모두 익지 못하는 상태
#     print(-1)
# else:
#     if max == 1: # 최댓값이 1이라면 모두 익어있는 상태
#         print(0)
#     else:
#         print(max-1)


# # 백준7569 토마토
# from collections import deque
# from sys import stdin
# input = stdin.readline
# m, n, h = map(int, input().split())
#
# graph = []
# for _ in range(h):
#     a = []
#     for _ in range(n):
#         a.append(list(map(int, input().split())))
#     graph.append(a)
#
# # print(graph)
# dy = [0 , 0, -1, 1, 0, 0]
# dx = [0, 0, 0, 0, -1, 1]
# dh = [-1, 1, 0, 0, 0, 0]
#
# def bfs():
#     while queue:
#         z, y, x = queue.popleft()
#         for l in range(6):
#             zz = dh[l] + z
#             yy = dy[l] + y
#             xx = dx[l] + x
#             if 0<=zz<h and 0<=yy<n and 0<=xx<m and graph[zz][yy][xx] == 0:
#                 queue.append((zz, yy, xx))
#                 graph[zz][yy][xx] = graph[z][y][x] + 1
#
#
# queue = deque()
# for k in range(h):
#     for i in range(n):
#         for j in range(m):
#             if graph[k][i][j] == 1:
#                 queue.append((k,i,j))
#
# bfs()
#
# flag = False
# max = -2
# for k in range(h):
#     for i in range(n):
#         for j in range(m):
#             if graph[k][i][j] == 0:
#                 flag = True
#             if graph[k][i][j] > max:
#                 max = graph[k][i][j]
#
# if flag:
#     print(-1)
# else:
#     if max == 1:
#         print(0)
#     else:
#         print(max-1)

#














































