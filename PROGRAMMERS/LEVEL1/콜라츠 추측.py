# 나의 풀이
def solution(num):
    cnt = 0

    while num - 1:

        if num % 2 == 0:  # 짝수인경우
            num /= 2
        else:  # 홀수인경우
            num = (num * 3) + 1
        cnt += 1

        if cnt >= 500:
            print(num)
            return -1

    return cnt

# 다른 사람의 풀이
def collatz(num):
    for i in range(500):
        num = num / 2 if num % 2 == 0 else num*3 + 1
        if num == 1:
            return i + 1
    return -1

