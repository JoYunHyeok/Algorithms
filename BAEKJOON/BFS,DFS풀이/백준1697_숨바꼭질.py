# 예시 5 - 10 - 9 - 18 - 17
# 가장 빠른 시간을 출력하기 => 가장 빠른 거리를 찾는 문제와 유사하다고 생각 => bfs문제
from collections import deque
from sys import stdin

n, k = map(int, stdin.readline().split())
MAX = 10 ** 5 # 범위를 지정
graph = [0] * (MAX+1)


def bfs():
    queue = deque()
    queue.append(n)
    while queue:
        x = queue.popleft()
        if x == k: # 수빈이가 동생을 찾을 경우 결과 '초' 출력
            print(graph[x])
            break
        for dx in [x-1, x+1, x*2]: # 이동할 수 있는 세가지 경우
            if 0 <= dx <= MAX and graph[dx] == 0:
                graph[dx] = graph[x] + 1 # 1초씩 증가
                queue.append(dx)

bfs()



