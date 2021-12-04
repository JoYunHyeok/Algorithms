# import copy
# from collections import deque
# from sys import stdin
# input = stdin.readline
#
#
# N, L, R = map(int, input().split())
# graph = [list(map(int, input().split())) for _ in range(N)]
# result = 0 # bfs탐색한 횟수
#
#
# dy = [-1, 1, 0, 0]
# dx = [0, 0, -1, 1]
# def bfs():
#     global flag
#     visited = [[False] * N for _ in range(N)]
#     q = deque()
#     q.append((0, 0))
#     total = 0 # 이동가능한 구간 합
#     cnt = 0
#     while q:
#         y, x = q.popleft()
#         for l in range(4):
#             yy = y + dy[l]
#             xx = x + dx[l]
#             if 0 <= yy < N and 0 <= xx < N:
#                 if not visited[yy][xx] and (L <= abs(graph[y][x] - graph[yy][xx]) <= R or graph[yy][xx] == graph[y][x])  : #
#                     q.append((yy, xx))
#                     visited[yy][xx] = True
#                     total += graph[yy][xx]
#                     cnt += 1
#
#     total //= cnt
#     for i in range(N):
#         for j in range(N):
#             if visited[i][j] == True:
#                 graph[i][j] = total
#                 flag = True
#
# flag = True
# while flag:
#     a = copy.deepcopy(graph)
#     bfs()
#     if graph == a:
#         break
#     result += 1
# print(result)



from collections import deque
from sys import stdin
input = stdin.readline


N, L, R = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
def bfs(i, j):
    q = deque()
    q.append((i, j))
    temp = []
    temp.append([i, j])
    while q:
        y, x = q.popleft()
        for l in range(4):
            yy = y + dy[l]
            xx = x + dx[l]
            if 0 <= yy < N and 0 <= xx < N and not visited[yy][xx]:
                if L <= abs(graph[yy][xx] - graph[y][x]) <= R:
                    visited[yy][xx] = True
                    q.append((yy, xx))
                    temp.append([yy, xx])
    return temp

cnt = 0
while True:
    visited = [[False] * N for _ in range(N)]
    flag = False
    for i in range(N):
        for j in range(N):
            if visited[i][j] == False:
                visited[i][j] = True
                temp = bfs(i, j)
                if len(temp) > 1:
                    flag = True
                    num = sum(graph[y][x] for y, x in temp) // len(temp)
                    for y, x in temp:
                        graph[y][x] = num
    if not flag:
        break
    cnt += 1
print(cnt)

'''
2 5 10
30 45
40 60
'''















