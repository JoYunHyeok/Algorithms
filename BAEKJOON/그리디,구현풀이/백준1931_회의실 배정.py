from sys import stdin

n = int(input())
s_list = []
for i in range(n):
    first, second = map(int, stdin.readline().split())
    s_list.append([first, second])

# 빨리 끝날수 록 뒤에 고려해볼 회의가 많아서 빨리 끝나는 회의 순서대로 정렬 해야함!
s_list = sorted(s_list, key=lambda a: a[0]) # 시작 시간 먼저 정렬
s_list = sorted(s_list, key=lambda a: a[1]) # 끝나는 시간 정렬

last = 0
cnt = 0
for i, j in s_list:
    if i >= last:
        cnt += 1
        last = j
print(cnt)

