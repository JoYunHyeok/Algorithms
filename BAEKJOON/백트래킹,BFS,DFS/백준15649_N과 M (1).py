from sys import stdin
input = stdin.readline

def dfs(result, k):
    if k == M:
        print(*result, sep=' ')
        return

    for z in range(1, N+1):
        if str(z) in result: continue
        result.append(str(z))
        k += 1
        dfs(result, k)
        k -= 1
        result.pop()


N, M = map(int, input().split())
result = []
for i in range(1, N+1):
    result.append(str(i))
    dfs(result, 1)
    result.pop(-1)

