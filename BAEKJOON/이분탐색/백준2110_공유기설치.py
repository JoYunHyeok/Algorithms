'''
1. 데이터의 갯수가 10억이상이면 이진탐색 고려하기
2. 이진탐색은 재귀, 반복문으로 풀 수 있고 반복문이 유리하다.
'''

from sys import stdin

n, c = map(int, stdin.readline().split())
a_list = [int(stdin.readline()) for _ in range(n)]
a_list.sort()

start = 1
end = a_list[-1] - a_list[0] # 끝집과 처음집을 뺴준 총 거리

result = 0 # 결과값 저장
while start <= end:
    mid = (start + end) // 2

    selected = a_list[0]
    cnt = 1 # selected 로 첫집을 선택했으니 카운트를 하나 올려준 상태로 저장
    for i in range(1, len(a_list)):
        if a_list[i] >= selected + mid: # 선택된 집좌표 + 탐색거리(mid)가 이동할 집좌표보다 작거나 같다면
            cnt += 1
            selected = a_list[i] # 이동할 좌표

    if cnt >= c:
        start = mid + 1
        result = mid
    else:
        end = mid - 1

print(result)



