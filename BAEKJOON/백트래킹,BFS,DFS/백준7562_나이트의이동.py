from collections import deque
from sys import stdin


def bfs(x, y):
    # 나이트의 이동범위
    dx = [-1, 1, -2, 2, -2, 2, -1, 1]
    dy = [-2, -2, -1, -1, 1, 1, 2, 2]
    queue = deque()
    queue.append([x, y])

    while queue:
        x, y = queue.popleft()
        if x == n and y == m:
            print(graph[x][y])
            break

        for i in range(8): # 나이트의 이동
            xx = x + dx[i]
            yy = y + dy[i]
            if 0 <= xx < l and 0 <= yy < l and graph[xx][yy] == 0:
                graph[xx][yy] = graph[x][y] + 1
                queue.append([xx, yy])


n = int(input())
for _ in range(n):
    l = int(input())
    graph = [[0]*l for _ in range(l)] # 체스판 생성
    x, y = map(int, stdin.readline().split()) # 현재 있는 칸
    n, m = map(int, stdin.readline().split()) # 목표지점의 칸
    bfs(x, y)

