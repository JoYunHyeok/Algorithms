import sys

n = int(input())
graph = [[] for _ in range(n + 1)]
parent = [[] for _ in range(n + 1)]

# 트리를 그래프 형태로 생성
# 핵심은 인접리스트를 만들어서 방문마다 자식녿의 부모노드를 지워주는것!!!
for _ in range(n - 1):
    i, j = map(int, sys.stdin.readline().split())
    graph[i].append(j)
    graph[j].append(i)

def dfs(start):
    stack = [start]

    while stack:
        node = stack.pop()
        for i in graph[node]:
            parent[i].append(node)
            stack.append(i)
            graph[i].remove(node)

dfs(1)

for i in range(2, len(parent)):
    print(parent[i][0])