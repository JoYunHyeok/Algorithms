from collections import deque
from sys import stdin
input = stdin.readline

N, M = map(int, input().split())
graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))
H, W, Sr, Sc, Fr, Fc = map(int, input().split())
visited = [[False] * M for _ in range(N)]

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

# 시간초과 원인 : bfs함수안에서 직사각형이 격자안에만 들어간다면 계속 이 함수가 실행됨
def check(i, j):
    flag = True
    for a in range(H):
        for b in range(W):
            if graph[i+a][j+b] == 1:
                flag = False
    return flag


def bfs():
    q = deque()
    q.append((Sr - 1, Sc - 1, 0))

    while q:
        y, x, cnt = q.popleft()
        visited[y][x] = True

        if y == Fr-1 and x == Fc-1:
            print(cnt)
            return

        for l in range(4):
            yy = dy[l] + y
            xx = dx[l] + x
            # 직사각형 범위계산
            if 0 <= yy < N and 0 <= xx < M and 0 <= yy + H - 1 < N and 0 <= xx + W - 1 < M:
                if not visited[yy][xx]:
                    # yy, yy+H-1, xx, xx+W-1 중에 1이 있다면 못들어감
                    if check(yy, xx):
                        visited[yy][xx] = True
                        q.append((yy, xx, cnt+1))
    print(-1)
    return

bfs()

'''
4 5
0 0 0 0 0
0 0 1 0 0
0 0 1 0 0
0 0 0 0 0
2 2 1 1 1 4
'''

from collections import deque
from sys import stdin
input = stdin.readline

N, M = map(int, input().split())
graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))
H, W, Sr, Sc, Fr, Fc = map(int, input().split())
visited = [[False] * M for _ in range(N)]

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

# 시간초과를 막기 위해 미리 벽을 저장해둔다.
walls = []
for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            walls.append((i, j))

# 저장해둔 벽이 직사각형 범위 내에 있다면 False를 반환
def check(i, j):
    for w_row, w_col in walls:
        if i <= w_row < i+H and j <= w_col < j+W:
            return False
    return True


def bfs():
    q = deque()
    q.append((Sr - 1, Sc - 1, 0))

    while q:
        y, x, cnt = q.popleft()
        visited[y][x] = True

        if y == Fr-1 and x == Fc-1:
            print(cnt)
            return

        for l in range(4):
            yy = dy[l] + y
            xx = dx[l] + x
            # 직사각형 범위계산
            if 0 <= yy < N and 0 <= xx < M and 0 <= yy + H - 1 < N and 0 <= xx + W - 1 < M:
                if not visited[yy][xx]:
                    if check(yy, xx):
                        visited[yy][xx] = True
                        q.append((yy, xx, cnt+1))

    print(-1)
    return

bfs()