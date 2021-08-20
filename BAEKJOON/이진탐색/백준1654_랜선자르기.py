from sys import stdin

k, n = map(int, stdin.readline().split())
array = [ int(input()) for _ in range(k)]

start = 1 # 0으로 하면 런타임에러..!
end = max(array)


while start <= end:
    mid = (start+end) // 2
    cnt = 0
    for element in array:
        cnt += element // mid

    if cnt >= n:
        start = mid + 1
    else:
        end = mid - 1

print(end)








