n = int(input())

cnt = 0

while n >= 0:
    if n % 5 == 0: # 5로 나누어 떨어지는 경우
        cnt += (n // 5)
        print(cnt)
        break
    n -= 3  # 나눠 떨어지지 않는다면 3을 뺴주고 봉지 수를 올려준다.
    cnt += 1
else:
    print(-1)

