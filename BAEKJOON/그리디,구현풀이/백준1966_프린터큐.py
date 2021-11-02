from sys import stdin

input = stdin.readline
t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    queue = list(map(int, input().split()))
    queue = [(i, idx) for idx, i in enumerate(queue)]

    count = 0
    while True:
        print("test", max(queue, key=lambda x: x[0]))
        if queue[0][0] == max(queue, key=lambda x: x[0])[0]: # 현재 리스트에서 중요도가 제일 큰 수가 올때까지 회전
            count += 1
            if queue[0][1] == m: #궁금한 문서가 맞다면
                print(count)
                break
            else:
                queue.pop(0)    # 궁금한 문서가 아니라면
        else:
            queue.append(queue.pop(0))


