# https://www.acmicpc.net/problem/1003
# 보텀업 다이나믹 프로그래밍 소스코드(python)
from sys import stdin

t = int(input())
dp = [0] * 41
dp[0] = (1, 0)
dp[1] = (0, 1)

for i in range(2, len(dp)):
    dp[i] = (dp[i - 1][0] + dp[i - 2][0], dp[i - 1][1] + dp[i - 2][1])

for _ in range(t):
    print(*dp[int(input())])

