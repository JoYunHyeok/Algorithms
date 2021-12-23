from sys import stdin

n, k = map(int, stdin.readline().split())

n_list = []
for _ in range(n):
    n_list.insert(0, int(input()))

count = 0
for i in n_list:
    if k >= i:
        count_i, k = divmod(k, i) # 튜플 형식으로 몫과 나머지를 반환
        count += count_i
        if k == 0:
            break

print(count)