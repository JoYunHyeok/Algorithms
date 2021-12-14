from sys import stdin

input = stdin.readline

N, M = map(int, input().split())

array = list(map(int, input().split()))
array = sorted(array)

s = []
# 1 7 9 9
visited = [False] * N
def dfs():

    if len(s) == M:
        print(*s, sep=' ')
        return
    
    temp = 0
    for i in range(len(array)):
        if not visited[i] and temp != array[i]:
            s.append(array[i])
            visited[i] = True
            temp = array[i]
            dfs()
            s.pop()
            visited[i] = False

dfs()