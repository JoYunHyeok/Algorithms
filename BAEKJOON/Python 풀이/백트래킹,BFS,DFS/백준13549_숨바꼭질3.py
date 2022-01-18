# [복습]
# break문을 안걸어서 틀림
from collections import deque
n, k = map(int, input().split())
MAX = 100000
cnt_list = [0] * (MAX+1)
visited = [False] * (MAX+1)
visited[n] = True
def bfs():
    queue = deque()
    queue.append(n)
    while queue:
        x = queue.popleft()
        if x == k:
            print(cnt_list[x])
            break

        for dx in [x*2, x-1, x+1]:
            if x*2 == dx and 0 <= dx <= MAX and not visited[dx]:
                queue.append(dx)
                cnt_list[dx] = cnt_list[x]
                visited[dx] = True

            if (dx-1==x or dx+1==x ) and 0 <= dx <= MAX and not visited[dx]:
                queue.append(dx)
                cnt_list[dx] = cnt_list[x] + 1
                visited[dx] = True

bfs()



# # [복습]
# # break문을 안걸어서 틀림
# from collections import deque
# n, k = map(int, input().split())
# MAX = 100000
# cnt_list = [-1] * (MAX+1)
# cnt_list[n] = 0
# def bfs():
#     queue = deque()
#     queue.append(n)
#     while queue:
#         x = queue.popleft()
#         if x == k:
#             print(cnt_list[x])
#             break
#
#         for dx in [x*2, x-1, x+1]:
#             if dx // 2 == x and 0 <= dx <= MAX and cnt_list[dx] == -1:
#                 queue.append(dx)
#                 cnt_list[dx] = cnt_list[x]
#
#             elif (dx-1 == x or dx+1 == x) and 0 <= dx <= MAX and cnt_list[dx] == -1:
#                 queue.append(dx)
#                 cnt_list[dx] = cnt_list[x] + 1
#
# bfs()


