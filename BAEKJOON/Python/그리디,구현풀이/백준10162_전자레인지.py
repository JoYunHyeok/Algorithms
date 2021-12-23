t = int(input())

array = [300, 60, 10]

result = []
for i in array:

    if t % array[-1] != 0:
        print(-1)
        break

    cnt = 0
    if t >= i:
        cnt = t // i
        t %= i
    result.append(cnt)

print(*result, sep=" ")

