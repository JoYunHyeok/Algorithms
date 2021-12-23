# 이해를 못한 풀이.. 행과열 두가지의 경우 모두 생각해야한다.
# 지문에 "모든 행과 모든 열에 한 명 이사의 경비원이 있으면 좋겠다고 생각했다."
# n, m = map(int, input().split())
#
# a = []
# cnt = 0
#
# for _ in range(n):
#     a.append(list(input().strip()))
#
# for i in range(n):
#     flag = True
#     for j in range(m):
#         if a[i][j] == 'X':
#             flag = False
#     if flag:
#         cnt += 1
#
# print(cnt)

n, m = map(int, input().split())
a = []
for _ in range(n):
    a.append(list(input().strip()))

row = [0] * n
col = [0] * m
for i in range(n):
    for j in range(m):
        if a[i][j] == "X":
            row[i] = 1
            col[j] = 1
rcnt = 0
for r in row:
    if r == 0:
        rcnt += 1
ccnt = 0
for c in col:
    if c == 0:
        ccnt += 1

print(max(rcnt, ccnt))

















