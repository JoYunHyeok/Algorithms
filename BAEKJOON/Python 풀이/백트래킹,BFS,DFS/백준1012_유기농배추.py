from sys import stdin
import sys
sys.setrecursionlimit(10**9)

t = int(input()) # 테스트케이스 2개
result_list = []

def make_graph(m, n, k):
    graph = [[0] * m for _ in range(n)]
    for _ in range(k):
        x, y = map(int, stdin.readline().split())
        graph[y][x] = 1
    return graph


def dfs(y, x):
    if x <= -1 or x >= m or y <= -1 or y >= n:
        return False

    if graph[y][x] == 1:
        graph[y][x] = 0
        dfs(y-1, x)
        dfs(y+1, x)
        dfs(y, x-1)
        dfs(y, x+1)
        return True
    return False


for _ in range(t):
    result = 0
    m, n, k = map(int, stdin.readline().split())
    graph = make_graph(m, n, k)
    for i in range(n):
        for j in range(m):
            if dfs(i,j) == True:
                result += 1
    result_list.append(result)

print(*result_list, sep='\n')



#복습 dfs풀이 => 근데 런타임에러..
from sys import stdin
import sys
sys.setrecursionlimit(10**9)
# bfs

input = stdin.readline

t = int(input())


def dfs(i, j):
    if i <= -1 or i >= n or j <= -1 or j >= m:
        return False

    if graph[i][j] == 1:
        graph[i][j] = 0
        dfs(i - 1, j)
        dfs(i + 1, j)
        dfs(i, j - 1)
        dfs(i, j + 1)
        return True
    return False

while t:
    t -= 1
    m, n, k = map(int, input().split())
    graph = [[0] * m for _ in range(n)]

    for _ in range(k):
        x, y = map(int, input().split())
        graph[y][x] = 1

    result = 0
    for i in range(n):
        for j in range(m):
            if dfs(i, j) == True:
                result += 1
    print(result)

# bfs풀이 복습
from sys import stdin
from collections import deque

input = stdin.readline

t = int(input())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(i, j):
    queue = deque()
    queue.append((i, j))

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx, ny))


while t:
    t -= 1
    m, n, k = map(int, input().split())
    graph = [[0] * m for _ in range(n)]

    for _ in range(k):
        x, y = map(int, input().split())
        graph[y][x] = 1


    result = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                bfs(i, j)
                result += 1
    print(result)




























































