from collections import deque
from sys import stdin
input = stdin.readline
q = deque()
visited = dict()

N, K = map(int, input().split())
water = list((map(int, input().split())))

for w in water:
    q.append(w)
    visited[w] = 0

while q:
    if K <= 0:
        break
    x = q.popleft()
    for xx in [x-1, x+1]:
        if xx not in visited and K > 0: #방문하지 않았다면
            visited[xx] = visited[x] + 1
            K -= 1
            q.append(xx)

result = 0
for k, v in visited.items():
    result += v
print(result)

'''
추가예제입력 : 방문처리와 k가 0이상인 경우에 큐에 추가해줘야 한다.
1 1
0
'''