from sys import stdin

n = int(input())

km_list = stdin.readline().split() # 거리입력
price_list = stdin.readline().split() # 주요소 가격

result = 0
for i in range(len(km_list)):
    a = []
    for j in range(i+1):
        k_p = int(km_list[i]) * int(price_list[j])
        a.append(int(k_p))

    result += min(a)

print(result)


##딴사람 풀이
N = int(input())
roads = list(map(int, input().split()))
cities = list(map(int, input().split()))

minVal = cities[0]
sum = 0
for i in range(N - 1):
    if minVal > cities[i]:
        minVal = cities[i]
    sum += (minVal * roads[i])

print(sum)