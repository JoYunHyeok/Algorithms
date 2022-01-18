# 답을 봐도 이해가 잘 안감..

# from sys import stdin
# input = stdin.readline
#
# N, M = map(int, input().split())
#
# graph = [[0 for _ in range(M + 1)] for _ in range(N + 1)]
# answer = 0
# # print(graph)
#
# def dfs(cnt):
#     global answer
#     if cnt == N * M:
#         answer += 1
#         return
#
#     y = cnt // M + 1
#     x = cnt % M + 1
#
#     dfs(cnt + 1)
#
#     # 만약에 놓을 수 있는 곳이라면
#     if graph[y - 1][x] == 0 or graph[y][x - 1] == 0 or graph[y - 1][x - 1] == 0:
#         graph[y][x] = 1
#         dfs(cnt + 1)
#         graph[y][x] = 0
#
# dfs(0)
# print(answer)
