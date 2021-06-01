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

