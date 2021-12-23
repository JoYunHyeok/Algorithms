import collections
from sys import stdin

n = int(stdin.readline())
a_list = [int(stdin.readline()) for _ in range(n)]
a_list.sort()

def average(array):
    return round(sum(array) / n) # 산술평균

def center(array):
    return array[n//2]

def freq(array):
    cnt = collections.Counter(array).most_common()
    # 입력값이 5 4 2 2 2 -1 일 경우
    # [(2, 3), (-1, 1), (4, 1)]
    # 갯수가 많은 원소 기준으로 내림차순으로 정렬이 된다.

    if len(cnt) > 1: # 입력 값이 1개 이상인 경우
        if cnt[0][1] == cnt[1][1]: # 최빈값이 여러개일 경우
            return cnt[1][0]
        else: # 최빈값이 하나라면
            return cnt[0][0]
    else: # 입력 값이 하나라면 바로 출력
        return cnt[0][0]


def range(array):
    return array[-1] - array[0]

print(average(a_list))
print(center(a_list))
print(freq(a_list))
print(range((a_list)))
