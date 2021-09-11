from sys import stdin
from collections import deque

input = stdin.readline

n = int(input())
a, b = map(int, input().split())
m = int(input())

graph = [[] for _ in range(n+1)]
visited = [0 for _ in range(n+1)]
for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

def bfs(start):
    queue = deque()
    queue.append(start)
    visited[start] = 1
    while queue:
        node = queue.popleft()

        for i in graph[node]:
            if visited[i] == 0:
                visited[i] += (visited[node] + 1)
                queue.append(i)

bfs(a)

if visited[b] != 0:
    print(visited[b]-1)
else:
    print(-1)



## 유니온 파인드로 풀어봄
# parent = [i for i in range(n+1)]
# cnt_list = [0 for _ in range(n+1)]
#
# def find_parent(parent, x):
#     if parent[x] != x:
#         parent[x] = find_parent(parent, parent[x])
#
#     return parent[x]
#
# def union_parent(parent, x, y):
#     a = find_parent(parent, x)
#     b = find_parent(parent, y)
#
#     if a < b:
#         parent[b] = a
#         if cnt_list[x] == 0:
#             cnt_list[y] += 1
#         else:
#             cnt_list[y] += (cnt_list[x]+1)
#     else:
#         parent[a] = b
#
# for _ in range(m):
#     x, y = map(int, input().split())
#     union_parent(parent, x, y)
#
# if find_parent(parent, a) == find_parent(parent, b):
#     print(cnt_list[a] + cnt_list[b])
# else:
#     print(-1)