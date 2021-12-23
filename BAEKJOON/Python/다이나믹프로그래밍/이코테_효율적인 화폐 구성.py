'''
ai = 금액 i를 만들 수 있는 최소한의 화폐 개수

k = 각 화폐의 단위

점화식 : 각 화폐 단위인 k를 하나씩 확인하며
        - ai-k를 만드는 방법이 존재하는 경우, ai = min(ai, ai-k + 1)
        - ai-k를 만드는 방법이 존재하지 않는 경우, ai = INF
'''

n, m = map(int, input().split())
money = []
for _ in range(n):
    money.append(int(input()))

d = [10001] * (m + 1) # 10001은 실제로 만들어질 수 없는 값을 설정해야 한다.
d[0] = 0

for i in range(n):
    for j in range(money[i], m + 1):
        if d[j - money[i]] != 10001:
            d[j] = min(d[j], d[j - money[i]] + 1)

if d[m] == 10001:
    print(-1)
else:
    print(d[m])

