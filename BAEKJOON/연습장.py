from sys import stdin
input = stdin.readline

N = int(input())

graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))


def dfs(i):
    if False not in visited:
        result.append([sum(s),i])

    for x in range(len(graph[i])):
        if not visited[x] and graph[i][x] > 0: #방문한적없고 0이 아닌 경우
            visited[x] = True
            s.append(graph[i][x])
            dfs(x)
            s.pop()
            visited[x] = False

aa = []
for i in range(N):
    result = []
    s = []
    visited = [False] * N
    visited[i] = True
    dfs(i)
    visited[i] = False
    print(result)
    for to, last in result:
        if graph[last][i] != 0:
            to += graph[last][i]
            aa.append(to)

print(min(aa))