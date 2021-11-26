'''
- 제한이 10억일때 이진탐색
- 반복적으로 중량을 선택하고 이동이 가능한 경우를 찾는다.

다른 예제
답이 5가 나와야함
3 3
1 2 9
2 3 5
1 3 2
1 3
'''
from collections import deque

n, m = map(int,input().split())

a_list = [[] for _ in range(n+1)]
start = 1000000000
end = 1

def bfs(c):
    queue = deque([start_node])
    visited = [False] * (n+1)
    visited[start_node] = True
    while queue:
        x = queue.popleft()
        for y, weight in a_list[x]: # mid값이 거리에 해당하는 weight보다 작은지 검사
            if not visited[y] and weight >= c:
                visited[y] = True
                queue.append(y)
    return visited[end_node]

for _ in range(m): # 양방향
    a, b, c = map(int, input().split())
    a_list[a].append((b, c))
    a_list[b].append((a, c))
    start = min(start, c)
    end = max(end, c)

start_node, end_node = map(int, input().split())

result = start
while start <= end:
    mid = (start + end) // 2
    if bfs(mid):
        result = mid
        start = mid + 1
    else:
        end = mid - 1

print(result)