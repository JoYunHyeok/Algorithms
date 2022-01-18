# # bfs, deque
# from collections import deque
# from sys import stdin
#
# n, m = map(int, stdin.readline().split()) # n, m 입력받기
#
# graph = [] # 2차원 배열로 nxm크기의 미로생성
# for _ in range(n):
#     graph.append(list(map(int, stdin.readline().strip())))
#
# # 상하좌우
# h = [-1, 1, 0, 0]
# w = [0, 0, -1, 1]
#
# def bfs(x,y):
#     queue = deque()
#     queue.append((x,y))
#
#     while queue:
#         x, y = queue.popleft()
#         for d in range(4): #상하좌우
#             xh = x + h[d]
#             yw = y + w[d]
#             if 0 <= xh < n and 0 <= yw < m:
#                 if graph[xh][yw] == 1: # 이동할 수 있는 '1'칸을 만족한다면 +1을 해준다.
#                     graph[xh][yw] = graph[x][y] + 1
#                     queue.append((xh,yw))
#
#     return graph[n-1][m-1] # 목적지n, m의 값 출력:
#
# print(bfs(0,0))



from collections import deque

m, n = map(int, input().split())
s = []
queue = deque()
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
for i in range(n):
    s.append(list(map(int, input().split())))


def bfs():
    while queue:
        a, b = queue.popleft()
        for i in range(4):
            x = a + dx[i]
            y = b + dy[i]
            if 0 <= x < n and 0 <= y < m and s[x][y] == 0:
                s[x][y] = s[a][b] + 1
                queue.append([x, y])


for i in range(n):
    for j in range(m):
        if s[i][j] == 1:
            queue.append([i, j])
bfs()
print(s)
isTrue = False
result = -2
for i in s:
    for j in i:
        if j == 0:
            isTrue = True
        result = max(result, j)
if isTrue == True:
    print(-1)
elif result == -1:
    print(0)
else:
    print(result - 1)


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