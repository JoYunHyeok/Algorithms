from collections import deque
from sys import stdin

def bfs(start):
    visit[start] = 1 # 시작점은 1로 시작
    queue = deque()
    queue.append(start)
    while queue:
        x = queue.popleft()
        for i in graph[x]:
            if visit[i] == 0:
                visit[i] = -visit[x] # 방문된적이 없고 연결시 부호를 바꿔 넣어준다.
                queue.append(i)
            else:
                if visit[i] == visit[x]: # 방문된적이 있고 부호가 같다면 이분그래프가 아니다. False 리턴
                    return False
    return True


k = stdin.readline()
for _ in range(k):
    v, e = stdin.readline().split()
    isTrue = True
    graph = [[] for _ in range(v+1)] # 정점과 간선 정보를 가지고 그래프를 생성
    visit = [0 for _ in range(v+1)] # 이분그래프를 판별하기 위한 그래프
    for _ in range(e):
        a ,b = stdin.readline().split()
        graph[a].append(b)
        graph[b].append(a)
    for y in range(1, v+1):
        if visit[y] == 0: # 방문한 적이 없다면
            if not bfs(y):
                isTrue = False # 이분그래프가 아니라면
                break
    print("YES"if isTrue else "NO")

