from sys import stdin

# n, m입력 받기
n, m = map(int, stdin.readline().split())

# 보드 입력 받기
graph = []
for _ in range(n):
    graph.append(input())

# 결과값담기
result = []

for i in range(n-7):
    for j in range(m-7):
        f_w = 0 # w로 고쳐야하는 경우
        f_b = 0 # b로 고쳐야하는 경우
        for x in range(i, i+8):
            for y in range(j, j+8):
                if (x+y) % 2 == 0:
                    if graph[x][y] != 'W': f_w += 1
                    if graph[x][y] != 'B': f_b += 1
                else:
                    if graph[x][y] != 'B': f_w += 1
                    if graph[x][y] != 'W': f_b += 1
        result.append(f_w)
        result.append(f_b)

print(min(result))

