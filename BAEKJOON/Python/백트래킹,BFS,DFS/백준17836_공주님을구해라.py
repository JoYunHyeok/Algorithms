from collections import deque
from sys import stdin
input = stdin.readline
# 상하좌우
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

n, m, t = map(int, input().split())
graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            graph[i][j] = -1
        if graph[i][j] == 2:
            graph[i][j] = -2

def bfs(i, j, knife_list):
    queue = deque()
    queue.append((i, j))
    while queue:
        y, x = queue.popleft()
        for l in range(4):
            yy = dy[l] + y
            xx = dx[l] + x
            # 검이 반드시 하나가 있는 경우만을 생각했다.
            # 검이 여러개 있을 경우가 있는 것같고 검을 만날때만다 값을 반환해주는 식으로 구현을 해야할 것 같다.
            if 0 <= yy < n and 0 <= xx < m and graph[yy][xx] == -2: #검을 찾았다면
                graph[yy][xx] = 0
                knife_list.append([yy, xx, graph[y][x]])

            if 0 <= yy < n and 0 <= xx < m and graph[yy][xx] == 0:
                queue.append((yy, xx))
                graph[yy][xx] = graph[y][x] + 1


knife_list = []
bfs(0, 0, knife_list)


min_d = 0

if knife_list: #칼이 있다면
    a, b, k = knife_list[0]
    knife_distance = (k+1) + (n-1-a) + (m-1-b)
else:
    knife_distance = graph[n-1][m-1]


if graph[n-1][m-1] != 0: # 도달가능
    min_d = min(knife_distance, graph[n-1][m-1])
else:
    min_d = knife_distance

if min_d > t:
    print("Fail")
else:
    print(min_d)


'''
6 6 15
0 0 1 2 1 1
0 0 0 0 0 0
0 0 0 0 1 0
0 0 0 0 0 2
1 1 1 1 1 1
0 0 0 0 0 0
'''

# from collections import deque
# from sys import stdin
# input = stdin.readline
# # 상하좌우
# def bfs():
#     global sword
#     q = deque()
#     q.append((0, 0))
#     visited[0][0] = 1
#     while q:
#         y, x = q.popleft()
#         if graph[y][x] == 2:
#             sword = n-1-x + m-1-y + visited[y][x]-1
#         if x == n-1 and y == m-1:
#             return min(visited[y][x]-1, sword)
#         for l in range(4):
#             yy = y + dy[l]
#             xx = x + dx[l]
#             if 0 <= yy < n and 0 <= xx < m and graph[yy][xx] != 1:
#                 if visited[yy][xx] == 0:
#                     q.append((yy, xx))
#                     visited[yy][xx] = visited[y][x] + 1
#
#
# dy = [-1, 1, 0, 0]
# dx = [0, 0, -1, 1]
# n, m, t = map(int, input().split())
# graph = [list(map(int, input().split())) for _ in range(n)]
# visited = [[0] * m for _ in range(n)]
# sword = 1000000
# res = bfs()
#
# print("Fali" if res > t else res)
