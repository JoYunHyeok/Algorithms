computers = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
n = 3


def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]


def union(parent, a, b, rank):
    a = find(parent, a)
    b = find(parent, b)
    '''
    if a <= b:
        parent[b] = a
    else:
        parent[a] = b
    '''
    if rank[a] > rank[b]:
        parent[b] = a
    else:
        parent[a] = b
        if rank[a] == rank[b]:
            rank[b] += 1


def solution(n, computers):
    parent = [0] * (n + 1)
    rank = dict()
    for i in range(n + 1):
        parent[i] = i
        rank[i] = 0

    answer = 1
    a_list = []  # 네트워크를 연결할 컴퓨터 담기

    for i in range(n):
        for j in range(n):
            if i == j: continue
            if computers[i][j] == 1:
                a_list.append([i + 1, j + 1])
    print(a_list)

    for a, b in a_list:
        # if parent[a] != parent[b]:
        # if find(parent, a) != find(parent, b):
        union(parent, a, b, rank)

    maps = {}
    for idx in range(1, len(parent)):
        if not parent[idx] in maps:
            maps[parent[idx]] = 0
    print(maps)
    answer = len(maps)

    return answer
print(solution(n, computers))

from collections import deque


def bfs(i, visited, n, computers):
    q = deque()
    q.append(i)
    visited[i] = True
    while q:
        x = q.popleft()
        for k in range(n):
            if computers[x][k] == 1 and not visited[k]:
                q.append(k)
                visited[k] = True


def solution(n, computers):
    answer = 0
    visited = [False] * n
    for i in range(n):
        if not visited[i]:
            bfs(i, visited, n, computers)
            answer += 1
    return answer


# def find(parent, x):
#     if parent[x] != x:
#         parent[x] = find(parent, parent[x])
#     return parent[x]
#
#
# def union(parent, a, b, rank):
#     a = find(parent, a)
#     b = find(parent, b)
#     '''
#     if a <= b:
#         parent[b] = a
#     else:
#         parent[a] = b
#     '''
#     if rank[a] > rank[b]:
#         parent[b] = a
#     else:
#         parent[a] = b
#         if rank[a] == rank[b]:
#             rank[b] += 1
#
#
# def solution(n, computers):
#     parent = dict()
#     rank = dict()
#     for i in range(n):
#         parent[i] = i
#         rank[i] = 0
#
#     a_list = []  # 네트워크를 연결할 컴퓨터 담기
#
#     for i in range(n):
#         for j in range(n):
#             if i == j: continue
#             if computers[i][j] == 1 and parent[i] != parent[j]:
#                 union(parent, i, j, rank)
#                 # a_list.append([i, j])
#     # print(a_list)
#
#     # for a, b in a_list:
#     #     # if parent[a] != parent[b]:
#     #     # if find(parent, a) != find(parent, b):
#     #     union(parent, a, b, rank)
#
#     maps = {}
#     for idx in range(len(parent)):
#         v = find(parent, parent[idx])
#         if not v in maps:
#             maps[v] = 1
#     print(maps)
#     answer = len(maps)
#     # answer = {find(parent, v): k for k, v in parent.items()}
#     return answer