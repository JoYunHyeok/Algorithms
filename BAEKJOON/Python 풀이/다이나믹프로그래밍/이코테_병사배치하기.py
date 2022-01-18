'''
기본 아이디어는 가장 긴 증가하는 부분수열(Longest Increasing Subsequence, LIS)
로 알려진 전형적인 다이나믹 프로그래밍 문제의 아이디어와 같습니다.

예를 들어 하나의 수열 array = {4, 2, 5, 8, 4, 11, 15}이 있다고 합시다.
이 수열의 가장 긴증가하는 부분수열은 {4, 5, 8, 11, 15}

본 문제는 가장 긴 감소하는 부분수열을 찾는 문제로 치환할 수 있으므로, LIS 알고리즘을 조금
수정하여 적용함으로써 정답을 도출할 수 있습니다.
'''

from sys import stdin

n = int(input())
array = list(map(int, stdin.readline().split()))
array.reverse()

dp = [1] * n

for i in range(1, n):
    for j in range(0, i):
        if array[j] < array[i]:
            dp[i] = max(dp[i], dp[j] + 1)

print(n - max(dp))


# 7
# 15 11 4 8 5 2 4
