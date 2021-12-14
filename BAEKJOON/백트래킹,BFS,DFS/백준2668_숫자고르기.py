'''
dfs 풀이
- 사이클이라는 특징을 찾는게 중요
- 사이클을 도는 것 -> 재귀, dfs?
- bfs도 풀이 가능
'''
from sys import stdin
from collections import defaultdict
input = stdin.readline

def dfs(i, check):
    check.add(i)
    visited[i] = True
    for v in graph[i]:
        if v not in check:
            dfs(v, check.copy())
        else: #사이클이 생기면!
            # print("test", check)
            result.extend(list(check))
            return

N = int(input())
graph = defaultdict(list)
for i in range(1, N+1):
    x = int(input())
    graph[x].append(i)

visited = [False for _ in range(N+1)]
result = []
for i in range(1, N+1):
    if not visited[i]:
        dfs(i, set([]))

result.sort()

print(len(result))
print(*result, sep="\n")

'''
bfs풀이 - 다시 풀어보면 좋을듯 - 12/13
'''
from sys import stdin
from collections import defaultdict
from collections import deque
input = stdin.readline

def bfs():
    while q:
        i, check = q.popleft()
        check.add(i)
        visited[i] = True

        for v in graph[i]:
            if v not in check:
                q.append([v, check.copy()])
            else: #사이클이 생기면!
                result.extend(list(check))
                return


N = int(input())
graph = defaultdict(list)
for i in range(1, N+1):
    x = int(input())
    graph[x].append(i)

visited = [False for _ in range(N+1)]
result = []

q = deque()
for i in range(1, N+1):
    if not visited[i]:
        q.append([i, set([])])
        bfs()

result.sort()

print(len(result))
print(*result, sep="\n")
