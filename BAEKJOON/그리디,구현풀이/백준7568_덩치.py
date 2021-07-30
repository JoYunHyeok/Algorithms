from sys import stdin

n = int(input()) # n 입력받기
n_list = [] # 입력받을 x,y 쌍을 담아줄 리스트 생성

# 리스트에 x,y 쌍 넣어주기
for i in range(n):
    a = list(map(int, stdin.readline().split()))
    n_list.append(a)

# 카운트 할 리스트 생성
count_list = [1 for _ in range(n)]

for i in range(n):
    for j in range(0, n):
        if i == j: # 같으면 패스
            continue
        if n_list[i][0] < n_list[j][0] and n_list[i][1] < n_list[j][1]: # x끼리, y끼리 비교
            count_list[i] += 1

print(' '.join((map(str, count_list)))) # 결과값 출력

