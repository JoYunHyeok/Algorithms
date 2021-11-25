n = int(input())

a = []

for _ in range(n):
    a.append(int(input()))

for _ in range(2):
    cnt = 1
    temp = a[0]
    for i in range(1, n):
        if temp < a[i]:
            temp = a[i]
            cnt += 1
    print(cnt)
    a.reverse()
