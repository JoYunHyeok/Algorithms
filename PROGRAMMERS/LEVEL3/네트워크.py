# def find(parent, x):
#     if parent[x] != x:
#         parent[x] = find(parent, parent[x])
#     return parent[x]
#
#
# def union(parent, a, b):
#     a = find(parent, a)
#     b = find(parent, b)
#
#     if a != b:
#         parent[b] = a
#
#
# def solution(n, computers):
#     parent = [0] * (n + 1)
#     for i in range(n + 1):
#         parent[i] = i
#
#     answer = 0
#     a_list = []  # 네트워크를 연결할 컴퓨터 담기
#
#     for i in range(n):
#         for j in range(n):
#             if i == j: continue
#             if computers[i][j] == 1:
#                 a_list.append([i + 1, j + 1])
#
#     for a, b in a_list:
#         if find(parent, a) != find(parent, b):
#             union(parent, a, b)
#
#     # print(parent)
#     result = parent[1]
#     for p in parent:
#         if result != p:
#             answer += 1
#
#     return answer

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