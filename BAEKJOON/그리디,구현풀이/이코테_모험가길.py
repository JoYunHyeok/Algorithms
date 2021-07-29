from sys import stdin

n = int(stdin.readline())

n_list = list(map(int, stdin.readline().split()))
n_list.sort() # 오름차순 정렬

result = 0 #현재 그룹의 수
count = 0 # 그룹에 포함된 모험가의 수

# 현재 그룹에 포함된 모험가의 수가 현재 확인하고 있는 공포도보다 크거나 같다면 이를 그룹으로 설정
# => 공포도가 오름차순으로 정렬되어 있다는 점에서, 항상 최소한의 모험가의 수만 포함하여 그룹을 결성하게 된다.
for i in n_list:
    count += 1
    if count >= i:
        result += 1
        count = 0

print(result)


