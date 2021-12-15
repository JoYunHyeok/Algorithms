'''
말의 움직임 K가 다 소모되고 원숭이 걸음으로 갈 수 있는줄 알았음
if c == 8:
    if (y, x) not in q:
        q.append((y, x))
위 코드를 추가해서 방지해주려고 했지만 실패, 문제 접근이 잘못된 듯
'''

from collections import deque
from sys import stdin
input = stdin.readline

K = int(input())
W, H = map(int, input().split())
graph = []
for _ in range(H):
    graph.append(list(map(int, input().split())))
visited = list([False] * W for _ in range(H))

# 0~7 : horse, 8~11 : monkey
hy = [-1, 1, -2, 2, -2, 2, -1, 1]
hx = [-2, -2, -1, -1, 1, 1, 2, 2]

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
ly, lx, c = 0, 0, 0

def bfs():
    global K
    q = deque()
    q.append((0, 0))
    visited[0][0] = True
    flag = True
    while q:
        y, x = q.popleft()
        if y == H-1 and x == W-1:
            print(graph[y][x])
            return

        if K > 0 and flag:
            ly, lx, c = hy, hx, 8
            K -= 1

        else:
            ly, lx, c = dy, dx, 4

        for l in range(c):
            yy = ly[l] + y
            xx = lx[l] + x

            if 0 <= xx < W and 0 <= yy < H:
                if not visited[yy][xx] and graph[yy][xx] == 0:
                    q.append((yy, xx))
                    visited[yy][xx] = True
                    graph[yy][xx] = graph[y][x] + 1

                if c == 8:
                    if (y, x) not in q:
                        q.append((y, x))

    print(-1)
    return

bfs()

'''
0
4 4
0 0 0 0
1 0 1 0
0 1 0 0
0 1 0 0

2
4 4
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
'''

# 답 본것
from collections import deque
from sys import stdin
input = stdin.readline

K = int(input())
W, H = map(int, input().split())
graph = []
for _ in range(H):
    graph.append(list(map(int, input().split())))

hy = [-1, 1, -2, 2, -2, 2, -1, 1]
hx = [-2, -2, -1, -1, 1, 1, 2, 2]

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

visited = [[[False] * (K + 1) for _ in range(W)] for _ in range(H)] # 왜 두개?

def bfs():
    q = deque()
    q.append((0, 0, 0, 0))
    visited[0][0][0] = True
    while q:
        y, x, horse, cnt = q.popleft()
        if y == H-1 and x == W-1:
            print(cnt)
            return

        for l in range(4):
            yy, xx = dy[l] + y, dx[l] + x
            if 0 <= yy < H and 0 <= xx < W:
                if not visited[yy][xx][horse] and graph[yy][xx] == 0:
                    visited[yy][xx][horse] = True
                    q.append((yy, xx, horse, cnt + 1))

        if horse < K:
            for l in range(8):
                yy, xx = hy[l] + y, hx[l] + x
                if 0 <= yy < H and 0 <= xx < W:
                    if not visited[yy][xx][horse + 1] and graph[yy][xx] == 0:
                        visited[yy][xx][horse + 1] = True
                        q.append((yy, xx, horse + 1, cnt + 1))

    print(-1)
    return

bfs()











