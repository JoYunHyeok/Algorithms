from sys import stdin

n = int(input())

graph = []
for _ in range(n):
    graph.append(list(map(int, stdin.readline().strip())))

cnt = 0
cnt_list = []

def dfs(x, y):
    global cnt
    if x <= -1 or x >= n or y <= -1 or y >= n:
        return False

    if graph[x][y] == 1:
        cnt += 1
        graph[x][y] = 0
        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)
        return True
    return False

result = 0
for i in range(n):
    for j in range(n):
        if dfs(i, j) == True:
            result += 1
            cnt_list.append(cnt)
            cnt = 0

cnt_list.sort()
print(result)
print(*cnt_list, sep='\n')





































