# 가능한 모든 시각의 경우를 하나씩 모두 세서 풀 수 있는 문제
# 하루는 86,400초 -> 24 * 60 * 60
# 완전 탐색(Brute Frocing)문제 유형
n = int(input())

count = 0

for i in range(n+1):
    for j in range(60):
        for k in range(60):
            # 매 시각 안에 '3'포함되면 카운트 증가
            if '3' in str(i)+str(j)+str(k):
                count += 1

print(count)

