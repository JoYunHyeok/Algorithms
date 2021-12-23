from collections import deque
import sys
input = sys.stdin.readline

# 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]

m, n, h = map(int, input().split())

# 3차원 배열 생성
graph = []
for _ in range(h):
    g = []
    for j in range(n):
        g.append(list(map(int, input().split())))
    graph.insert(0, g)
# print("bfs 적용 전",graph) #<=====================

def bfs():
    while q:
        a, b, c = q.popleft()

        for i in range(6):
            x = a + dx[i]
            y = b + dy[i]
            z = c + dz[i]
            if 0 <= x < n and 0 <= y < m and 0 <= z < h and graph[z][x][y] == 0:
                q.append([x, y, z])
                graph[z][x][y] = graph[c][a][b] + 1


q = deque()
isTrue = False

for z in range(h):
    for x in range(n):
        for y in range(m):
            if graph[z][x][y] == 1:
                q.append([x, y, z])

bfs()
# print("bfs 적용 후", graph) #<=====================

max_num = 0
for z in range(h):
    for x in range(n):
        for y in range(m):
            if graph[z][x][y] == 0:
                isTrue = True
            max_num = max(max_num, graph[z][x][y])

if isTrue == True:
    print(-1)
else:
    print(max_num - 1)

# [복습]
# 백준7569 토마토
from collections import deque
from sys import stdin
input = stdin.readline
m, n, h = map(int, input().split())

graph = []
for _ in range(h):
    a = []
    for _ in range(n):
        a.append(list(map(int, input().split())))
    graph.append(a)

# print(graph)
dy = [0 , 0, -1, 1, 0, 0]
dx = [0, 0, 0, 0, -1, 1]
dh = [-1, 1, 0, 0, 0, 0]

def bfs():
    while queue:
        z, y, x = queue.popleft()
        for l in range(6):
            zz = dh[l] + z
            yy = dy[l] + y
            xx = dx[l] + x
            if 0<=zz<h and 0<=yy<n and 0<=xx<m and graph[zz][yy][xx] == 0:
                queue.append((zz, yy, xx))
                graph[zz][yy][xx] = graph[z][y][x] + 1


queue = deque()
for k in range(h):
    for i in range(n):
        for j in range(m):
            if graph[k][i][j] == 1:
                queue.append((k,i,j))

bfs()

flag = False
max = -2
for k in range(h):
    for i in range(n):
        for j in range(m):
            if graph[k][i][j] == 0:
                flag = True
            if graph[k][i][j] > max:
                max = graph[k][i][j]

if flag:
    print(-1)
else:
    if max == 1:
        print(0)
    else:
        print(max-1)