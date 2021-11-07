# 틀린 풀이
n = int(input())

a = []
for _ in range(n):
    a.append(int(input()))

a.sort()
print(*a, sep="\n")

'''
[문제 풀이법]
- 데이터의 개수가 최대 천만개, 파이썬같은 경우 1초에 이천만개정도 수행
- 기본 내장 함수 sort의 경우는 nlogn 이기에 풀 수 없다.

[계수 정렬(Counting Sort)알고리즘]
- 게수 정렬은 수의 범위가 제한적일떄 사용할 수 있는 동시에 훨씬 빠른 정렬알고리즘
- 배열의 인덱스를 특정한 데이터의 값으로 여기는 정렬 방법
- 배열의 크기는 데이터의 범위를 포함할 수 있도록 설정
- 데이터가 등장한 횟수를 센다
'''
from sys import stdin

input = stdin.readline
array = [0] * 10001

n = int(input())
for _ in range(n):
    n = int(input())
    array[n] += 1

for i in range(10001):
    if array[i] != 0:
        for _ in range(array[i]):
            print(i)

