# from collections import deque
# from sys import stdin
# input = stdin.readline
#
# N, M = map(int, input().split())
# a_list =[[] for _ in range(N)]
#
#
# for _ in range(M):
#     a, b = map(int, input().split())
#     a_list[a].append(b)
#     a_list[b].append(a)
#
# def bfs(start):
#     visited = [0] * N
#     q.append([start, visited])
#
#     visited[start] = 1
#     while q:
#         x, visited = q.popleft()
#         for xx in a_list[x]:
#             if not visited[xx]:
#                 copy_visited = visited.copy()
#                 copy_visited[xx] = visited[x] + 1
#                 q.append([xx, copy_visited])
#
#     if max(visited) == 5:
#         print(1)
#         exit()
#
# q = deque()
# for i in range(N):
#     bfs(i)
#
# print(0)

'''
bfs풀이
'''
from sys import stdin
input = stdin.readline

N, M = map(int, input().split())
a_list =[[] for _ in range(N)]
visited = [False] * N

for _ in range(M):
    a, b = map(int, input().split())
    a_list[a].append(b)
    a_list[b].append(a)

# print(a_list)

def dfs(i, num):

    if num == 4:
        print(1)
        exit(0)

    for x in a_list[i]:
        if not visited[x]:
            visited[x] = True
            dfs(x, num+1)
            visited[x] = False

for i in range(N):
    visited[i] = True
    dfs(i, 0)
    visited[i] = False

print(0)