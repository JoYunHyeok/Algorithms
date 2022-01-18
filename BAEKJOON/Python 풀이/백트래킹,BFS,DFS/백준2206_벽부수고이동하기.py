# # 벽을 하나 부쉴 수 있다는 점
# # 불가능이면 -1
# # 최단거리 = bfs
# from collections import deque
# from sys import stdin
#
# n, m = map(int, stdin.readline().split())
#
# graph = []
# for _ in range(n):
#     graph.append(list(map(int, stdin.readline().strip())))
# # print("bfs 적용 전",visit)
# dx = [-1, 1, 0, 0]
# dy = [0, 0, -1, 1]
#
# def bfs():
#     queue = deque()
#     queue.append([0, 0, 1])
#     visit = [[[0] * 2 for _ in range(m)] for _ in range(n)]
#     visit[0][0][1] = 1 # 벽을 한번 부술 수 있는 상태에서 시작
#
#     while queue:
#         x, y, w = queue.popleft()
#         if x == n-1 and y == m-1:
#             return visit[x][y][w]
#         for i in range(4):
#             xx = x + dx[i]
#             yy = y + dy[i]
#             if 0 <= xx < n and 0 <= yy < m:
#                 if graph[xx][yy] == 1 and w == 1: # 벽을 만나고 벽을 한번 부술 수 있는 경우
#                     visit[xx][yy][0] = visit[x][y][w] + 1
#                     queue.append([xx, yy, 0])
#                 elif graph[xx][yy] == 0 and visit[xx][yy][w] == 0: # 벽이 없고 방문한적이 없는 경우
#                     visit[xx][yy][w] = visit[x][y][w] + 1
#                     queue.append([xx, yy, w])
#     return -1
#
# print(bfs())
# # print("bfs 적용 후",visit)




from collections import deque
from sys import stdin
input = stdin.readline

N, M = map(int, input().split())

graph = []
for _ in range(N):
    graph.append(list(map(int, input().strip())))

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
visited = [[[0] * 2 for _ in range(M)] for _ in range(N)] # 3차원 배열로 시작, 마지막 원소는 벽을 부술 수 있는 상태
def bfs():

    q = deque()
    q.append((0, 0, 1)) # 벽을 부술 수 있는 상태에서 시작
    visited[0][0][1] = 1

    while q:
        y, x, w = q.popleft()
        # if y == N-1 and x == M-1:
        #     print(visited[y][x][w])
        #     return

        for l in range(4):
            yy = dy[l] + y
            xx = dx[l] + x
            if 0 <= xx < M and 0 <= yy < N:
                if graph[yy][xx] == 1 and w == 1: #벽을 만나고 하나 부술 수 있는 경우
                    visited[yy][xx][0] = visited[y][x][w] + 1
                    q.append((yy, xx, 0))
                elif graph[yy][xx] == 0 and not visited[yy][xx][w]:
                    visited[yy][xx][w] = visited[y][x][w] + 1
                    q.append((yy, xx, w))
    # print(-1)
    return

bfs()


if visited[N-1][M-1][0] == 0 and visited[N-1][M-1][1] == 0:
    print(-1)
elif visited[N-1][M-1][0] == 0 and visited[N-1][M-1][1] > 0:
    print(visited[N-1][M-1][1])
else:
    print(visited[N-1][M-1][0])



'''
벽부수고이동하기 문제
- 벽을 부수는 한번 경우
- 그냥 가는 경우

말이 되고픈 원숭이
- 말 처럼 가는 경우
- 그냥 가는 경우

두 가지의 이동 방법이 있다면 3차원 배열문제로
근데 말이 되고픈 원숭이 문제처럼 말 처럼 가는 경우의 횟 수 K가 주어진다면 k를 모두 고려해주기 위해
[[[False] * (K + 1) for _ in range(W)] for _ in range(H)] 이런식으로 방문 배열을 생성한다.
벽부수고 이동하기 문제의 경우 k가 1번이기 때문에 visited = [[[0] * 2 for _ in range(M)] for _ in range(N)]
로 방문배열을 생성한것.
'''
















































