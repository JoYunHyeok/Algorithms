# from collections import deque
# from sys import stdin
# input = stdin.readline
#
# # visited = [[False] * 8 for _ in range(8)]
# graph = []
# for _ in range(8):
#     graph.append(list(input().strip()))
#
# dy = [0, -1, 1, 0, 0, -1, 1, -1, 1]
# dx = [0, 0, 0, -1, 1, -1, -1, 1, 1]
# visited = [[False] * 8 for _ in range(8)]
# def bfs():
#     q = deque()
#     q.append((7, 0)) # 왼쪽 맨아래부터 시작
#
#     while q:
#
#         y, x = q.popleft()
#         if visited[0][7]: # 오른쪽 맨위를 방문했다면
#             return 1
#
#         # 이동거리안에서 갈 수 있는 지점, 큐에넣고 방문처리
#         for l in range(9):
#             yy = dy[l] + y
#             xx = dx[l] + x
#             if 0 <= yy < 8 and 0 <= xx < 8:
#                 if not visited[yy][xx] and graph[yy][xx] == '.': # 방문한적 없고 '.'이라면
#                     visited[yy][xx] = True
#                     q.append((yy, xx))
#         print("test1", q)
#
#         # 벽 이동하고 벽이 있는 지점이 True면 False로 바꾸고 q.remove() 방문, 큐에 남은게 없다면 0출력
#         for i in range(7, 0, -1):
#             for j in range(8):
#                 if graph[i][j] == '#':
#                     graph[i][j] = '.'
#                     if i + 1 < 8:
#                         graph[i + 1][j] = '#'
#
#         # copy_q = q.copy()
#         for i in range(8):
#             for j in range(8):
#                 if graph[i][j] == '#' and visited[i][j]:
#                     visited[i][j] = False
#                     # 큐안에 있는 i, j를 모두 제거 해야한다.
#                     # for z in range(len(q)):
#                     #     if q[z] == (i, j):
#                     #         copy_q.remove((i, j))
#                     if (i, j) in q:
#                         q.remove((i, j))
#                     print("test2", q)
#         # q = copy_q
#
#     return 0
#
# print(bfs())



'''
........
........
........
........
........
########
########
........
'''


# import sys
# input = sys.stdin.readline
# from collections import deque
#
# dy = [0, -1, 1, 0, 0, -1, 1, -1, 1]
# dx = [0, 0, 0, -1, 1, -1, -1, 1, 1]
# graph = [list(input().strip()) for _ in range(8)]
#
# def bfs():
#     queue = deque()
#     queue.append((7, 0, 0))
#     while queue:
#         y, x, turn = queue.popleft()
#         for l in range(9):
#             yy = y + dy[l]
#             xx = x + dx[l]
#             if 0 <= yy < 8 and 0 <= xx < 8:
#                 if not graph[yy-turn][xx] == '#' and not graph[yy-turn-1][xx] == '#':
#                     if yy-turn < 0:
#                         return 1
#                     queue.append([yy, xx, turn+1])
#     return 0
#
# print(bfs())

'''
뒤로도 움직인다. 중요한 아이디어는 맨위 행으로 가면 끝난다는 것.

벽의 위치는 turn으로 내리는척 탐색으로 처리.
'''

# 움직이는 미로 탈출

from collections import deque
n, m = 8, 8
graph = []
for _ in range(n):
    graph.append(input())
dy = [0, -1, 1, 0, 0, -1, 1, -1, 1]
dx = [0, 0, 0, -1, 1, -1, -1, 1, 1]


def bfs():
    q = deque()
    q.append((7, 0))

    while q:

        visited = [[False] * m for _ in range(n)]

        for _ in range(len(q)):
            y, x = q.popleft()

            if graph[y][x] == '#':
                continue

            if y == 0 and x == 7:
                return 1

            for i in range(9):
                yy = y + dy[i]
                xx = x + dx[i]

                if 0 <= yy < n and 0 <= xx < m:
                    if graph[yy][xx] == '.' and not visited[yy][xx]:
                        q.append((yy, xx))
                        visited[yy][xx] = True

        graph.pop()
        graph.insert(0, '........')

    return 0


print(bfs())















