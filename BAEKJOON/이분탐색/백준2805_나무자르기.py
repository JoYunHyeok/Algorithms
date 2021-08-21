from sys import stdin

n, m = map(int, stdin.readline().split())
a_list = list(map(int, stdin.readline().split()))

start, end = 1, max(a_list)

while start <= end:
    mid = (start + end) // 2

    cnt = 0

    # 방법 1
    # for tree in a_list:
    #     if tree - mid > 0:
    #         cnt += tree - mid

    # 방법 2
    cnt = sum(tree - mid if tree - mid > 0 else 0 for tree in a_list)

    if cnt >= m:
        start = mid + 1
    else:
        end = mid - 1

print(end)