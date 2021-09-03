from sys import stdin
import heapq
# 3 2 1
# 1 2 4
# 1 3 2

input = stdin.readline
INF = int(1e9)

n, m, c = map(int, input().split())

graph = [[] for i in range(n+1)]

# 최단 거리 테이블을 모두 무한으로 초기화
distance = [INF] * (n + 1)

# 모든 간선 정보를 입력받기
for _ in range(m):
    x, y, z = map(int, input().split())
    # 특정 도시x에서 y로 이어지는 통로가 있으며 메시지가 전달되는 시간이 z라는 의미
    graph[x].append((y, z))

def dijkastra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))


dijkastra(c)

count = 0
max_distance = 0
for d in distance:
    if d != 1e9:
        count += 1
        max_distance = max(max_distance, d)

print(count - 1, max_distance)


