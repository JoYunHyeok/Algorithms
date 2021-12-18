from collections import deque
from sys import stdin
input = stdin.readline

R, C = map(int, input().split())
graph = []
for _ in range(R):
    graph.append(list(input().strip()))

visited = [[0] * C for _ in range(R)]
for i in range(R):
    for j in range(C):
        if graph[i][j] == 'J':
            visited[i][j] = 7
        if graph[i][j] == 'F':
            visited[i][j] = 1

q = deque()
y, x = 0, 0
for i in range(R):
    for j in range(C):
        if graph[i][j] == 'F':
            q.append((i, j, 'F', 0))
        if graph[i][j] == 'J':
            y, x = i, j
q.appendleft((y, x, 'J', 1))

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

def bfs():
    while q:
        y, x, z, cnt = q.popleft()
        if visited[y][x] == 7:
            if not (1 <= y < R-1 and 1 <= x < C-1):
                print(cnt)
                exit()

        for l in range(4):
            yy = dy[l] + y
            xx = dx[l] + x
            if 0 <= yy < R and 0 <= xx < C:
                if z == 'J': # 지훈이라면
                    if graph[yy][xx] == '.' and not visited[yy][xx]:
                        visited[yy][xx] = 7
                        q.append((yy, xx, 'J', cnt+1))
                        # print("지호 : ", (yy, xx))

                if z == 'F': # 불이라면
                    if graph[yy][xx] == '.' and visited[yy][xx] in (0, 7):
                        visited[yy][xx] = -1
                        q.append((yy, xx, 'F', 0))

    print("IMPOSSIBLE")
    return

bfs()

# print(graph)
# print(visited)

'''
추가예제입력 

5 5
....F
...J#
....#
....#
...#.
 
출력: 4


3 4
###F
.J#.
###.

출력 : 2

'''