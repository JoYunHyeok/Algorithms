from sys import stdin
input = stdin.readline

N = int(input())

graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))


def dfs(i):
    if False not in visited:
        result.append([sum(s), i])

    for x in range(len(graph[i])):
        if not visited[x] and graph[i][x] > 0: #방문한적없고 0이 아닌 경우
            visited[x] = True
            s.append(graph[i][x])
            dfs(x)
            s.pop()
            visited[x] = False

sum_result = []
for start in range(N):
    result = []
    s = []
    visited = [False] * N
    visited[start] = True
    dfs(start)
    visited[start] = False

    for total, end in result: # 마지막 방문 end -> start의 값도 더해준다.
        if graph[end][start] != 0:
            total += graph[end][start]
            sum_result.append(total)

print(min(sum_result))


'''
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0
'''