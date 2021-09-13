from collections import deque
from sys import stdin

m, n = map(int, stdin.readline().split()) # m가로, n세로

graph = []
for _ in range(n):
    graph.append(list(map(int, stdin.readline().split())))

# print(graph)

# 상하좌우
xh = [-1, 1, 0, 0]
yw = [0, 0, -1, 1]

def bfs():
    while queue:
        x, y = queue.popleft()
        for d in range(4):
            xx = xh[d] + x
            yy = yw[d] + y
            if 0 <= xx < n and 0 <= yy <m and graph[xx][yy] == 0:
                graph[xx][yy] = graph[x][y] + 1
                queue.append([xx, yy])

queue = deque()
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            queue.append(([i,j])) # bfs함수 내부가 아닌 여기서 append를 해준다!!
    print(queue)
bfs()
# print(graph) # bfs 수행 후 graph 점검

result = -2 # 임의로 설정한 최소값
flag = False # graph 탐색시 0인 값이 있다면 -1 출력위함
for row in graph:
    for r in row:
        if r == 0:
            flag = True
        result = max(result, r) # 최대값

if flag == True: print(-1)
elif result == -1: print(0) # 모두 익은 경우 : 0출력
else: print(result-1) # 결과 출력

# 헷갈리지말자 graph[n-1][m-1]까지의 최소거리를 구하는 문제가 아니다.
# 반복문으로 2차원배열을 돌면서 큐에 '1'일때 위치를 담는다.
# 예제입력 3번의 경우 0,0과 3,5이 담긴다
# 0,0 out 1,0 in
# 3,5 out 2,5 in 이런식으로 양쪽에서 좁혀오기 때문에 최소날짜가 7이 나오고 첫 시작 카운트를 빼주면 6!





