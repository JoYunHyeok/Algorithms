# from sys import stdin
# input = stdin.readline
#
# N = int(input())
#
# def dfs(res, cnt):
#
#     if cnt == N:
#         flag = True
#
#         s = str(res)
#         if len(s) > 1: # 길이가 2이상이라면
#             pre_num = s[0]
#             for i in range(1, len(s)):
#                 if pre_num <= s[i]:
#                     pre_num = s[i]
#                     flag = False
#
#         if flag:
#             print(res) # 12, 10
#
#             return
#         else:
#             cnt -= 1
#
#     dfs(res+1, cnt+1)

# dfs(0, 1)


from sys import stdin
input = stdin.readline

N = int(input())
num = [0] * 1000

def dfs(a, c, s):
    global t
    if a == c:
        t += 1
        if t == N:
            for i in range(0, a):
                print(num[i], end='')
    elif a > c:
        return
    else:
        for i in range(s+1):
            if i == 0 and a+1 != c:
                continue
            num[a] = i;
            dfs(a+1, c, i-1)

if N <= 10:
    print(N-1)
if N > 1023:
    print(-1)
else:
    t = 10
    for i in range(2, 1000):
        dfs(0, i, 9)

