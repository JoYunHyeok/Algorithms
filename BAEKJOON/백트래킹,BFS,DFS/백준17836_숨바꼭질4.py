# from collections import deque
# from sys import stdin
# input = stdin.readline
#
# n, k = map(int, input().split())
# MAX = 100000
# visited = [False] * (MAX+1)
# graph = [0] * (MAX+1)
#
# def bfs():
#     q = deque()
#     q.append(n)
#     visited[n] = True
#
#     while q:
#         x = q.popleft()
#
#         if x == k:
#             return graph[x]
#             break
#
#         for dx in [x-1, x+1, x*2]:
#             if 0<= dx<= MAX and not visited[dx]:
#                 q.append(dx)
#                 visited[dx] = True
#                 graph[dx] = graph[x] + 1
#
#
# cnt = bfs()
#
# b = list(filter(lambda x: graph[x] == 3, range(len(graph))))
# print(b)
# result = [k]
# for i in range(cnt, 0, -1):
#     a = list(filter(lambda x: graph[x] == i-1, range(len(graph))))
#     for j in a:
#         if k + 1 == j or k - 1 == j or k // 2 == j:
#             result.append(j)
#             k = j
#             break
#
# result.reverse()
# print(*result, sep=' ')


from collections import deque
from sys import stdin
input = stdin.readline

n, k = map(int, input().split())
MAX = 100000
visited = [False] * (MAX+1)
graph = [0] * (MAX+1)
parent = [0] * (MAX+1)

def path(x):
    result = []
    temp = x
    for _ in range(graph[x]+1):
        result.append(temp)
        temp = parent[temp]
    result.reverse()
    print(*result, sep=' ')


def bfs():
    q = deque()
    q.append(n)
    visited[n] = True

    while q:
        x = q.popleft()

        if x == k:
            print(graph[x])
            path(x)

        for dx in [x-1, x+1, x*2]:
            if 0 <= dx <= MAX and not visited[dx]:
                q.append(dx)
                visited[dx] = True
                graph[dx] = graph[x] + 1
                parent[dx] = x


bfs()