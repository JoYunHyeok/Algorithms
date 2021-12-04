# from collections import deque
# from sys import stdin
# input = stdin.readline
# MAX = 100000
# n, k = map(int, input().split())
# visited = [False] * (MAX+1)
# graph = [0] * (MAX+1)
# visited[n] = True
# cnt = 0
# result = 0
#
# def bfs():
#     global cnt
#     global result
#     queue = deque()
#     queue.append(n)
#     cnt = 0
#     while queue:
#         x = queue.popleft()
#
#         if x == k:
#             result = graph[x]
#             cnt += 1
#
#         for dx in [x-1, x+1, x*2]:
#             if 0 <= dx <= MAX:
#                 if not visited[dx] or graph[dx] == graph[x] + 1:
#                     queue.append(dx)
#                     visited[dx] = True
#                     graph[dx] = graph[x] + 1
#
# bfs()
# print(result)
# print(cnt)
#
# # 5 - 10 - 9 - 18 - 17
# # 5 - 4  - 8 - 16 - 17


from collections import deque
from sys import stdin
input = stdin.readline
MAX = 100000
n, k = map(int, input().split())
visited = [False] * (MAX+1)
graph = [0] * (MAX+1)
# visited[n] = True
cnt = 0
result = 0
first_check = True

def bfs():
    global cnt
    global result
    global first_check
    queue = deque()
    queue.append((n, 0))
    cnt = 0
    # 1. 모든경로를 탐색 => pop을 했을 때 방문처리
    # 2. 최소시간을 구해야한다.
    # 최소시간을 구했으면 최소시간에 목적지에 갈 수 있는 경우의 수를 출력해야한다.
    while queue:
        x, seq = queue.popleft()
        visited[x] = True

        if first_check == False and x == k and seq == result:
            print(result)
            cnt += 1

        if first_check == True and x == k: # 최초로 목적지에 도달시 최소기록 시간기록
            result = seq
            cnt += 1
            first_check = False

        for dx in [x-1, x+1, x*2]:
            if 0 <= dx <= MAX:
                if not visited[dx]:
                    queue.append((dx, seq+1))
                    graph[dx] = graph[x] + 1

bfs()

print(cnt)

# 5 - 10 - 9 - 18 - 17
# 5 - 4  - 8 - 16 - 17