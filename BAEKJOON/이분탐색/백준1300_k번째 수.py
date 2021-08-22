from sys import stdin

n = int(stdin.readline())
k = int(stdin.readline())

# b_list = [(i+1) * (j+1) for i in range(n) for j in range(n)]
#
# b_list.sort()
# print(b_list)
# 정말 비효율적인 방법 이중for문을 통해 리스트를 만들어 오름차순정렬 -> 시간엄청 잡아먹음... 결과는 메모리초과

start, end = 1, k
while start <= end:
    mid = (start + end) // 2

    cnt = 0
    for i in range(1, n+1):
        cnt += min(mid//i, n)

    if cnt >= k:
        result = mid
        end = mid - 1
    else:
        start = mid + 1

print(result)