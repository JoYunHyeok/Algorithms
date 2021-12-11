from collections import deque

def solution(numbers, target):
    answer = 0
    q = deque()
    q.append([numbers[0], 0])
    q.append([-1 * numbers[0], 0])
    while q:
        num, idx = q.popleft()
        idx += 1
        if idx < len(numbers):
            q.append([num + numbers[idx], idx])
            q.append([num - numbers[idx], idx])

        if idx == len(numbers):  # 리스트의 모든 원소를 다썻을때
            if num == target:
                answer += 1

    return answer