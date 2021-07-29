from sys import stdin

# 예제입력받기
n, m = map(int, stdin.readline().split())
list = list(map(int, stdin.readline().split()))
result = 0

for i in range(n):
    for j in range(i+1, n):
        for k in range(j+1, n):
            if list[i]+list[j]+list[k] > m: # m이 넘어가면 패스
                continue
            else:
                result = max(result, list[i]+list[j]+list[k])

print(result)

