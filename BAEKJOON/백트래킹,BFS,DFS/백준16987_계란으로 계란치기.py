# from sys import stdin
# input = stdin.readline
#
# N = int(input())
# array = []
# for _ in range(N):
#     array.append(list(map(int, input().split())))
# visited = [False] * N
# # print(array)
#
# s = []
# cnt = 0
# def dfs():
#     global cnt
#     if len(s) == 2:
#         if s[0] == array[-1]: # 가장 최근에 든 계란이 마지막 계란이라면 종료
#             return -1
#         print("test", s)
#         print("첫번째 계란 내구도",s[0][0] - s[1][1])
#         print("두번째 계란 내구도", s[1][0] - s[0][1])
#         s[0][0] -= s[1][1]
#         s[1][0] -= s[0][1]
#         for e in range(2):
#             if s[e][0] < 0:
#                 visited[e] = True
#                 cnt += 1
#             else:
#                 visited[e] = False
#
#         if s[0][0] < 0: # 손에 쥔 계란이 깨지면
#             return -1
#
#
#     for i in range(N):
#         if not visited[i]:
#             visited[i] = True
#             s.append(array[i])
#             dfs()
#             visited[i] = False
#             s.pop()
#
# dfs()
# print(cnt)

from sys import stdin
input = stdin.readline

n = int(input())
s = [0]*n
w = [0]*n

for i in range(n):
    s[i], w[i] = map(int, input().split())

print("내구도 s :", s)
print("w :", w)

result = 0

def dfs(idx, eggs):
    global result
    if idx == n: # 계란이 두개가 되면
        cnt = 0
        for i in range(n):
            if eggs[i] <= 0: #깨진 계란이 있으면 cnt 올리기
                cnt += 1
        if cnt > result:
            result = cnt
        return

    if eggs[idx] > 0: # 내구도가 0이상
        for i in range(n):
            flag = False
            if eggs[i] > 0 and i != idx: # 내구도가 0이상이고 서로 다른 계란일때
                flag = True
                tmp = eggs[:]
                tmp[i] -= w[idx]
                tmp[idx] -= w[i]
                dfs(idx+1, tmp)
        if not flag:
            dfs(idx+1, eggs)
    else: # 내구도가 0이하
        dfs(idx+1, eggs)

dfs(0, s)
print(result)

























