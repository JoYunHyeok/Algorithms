from collections import deque

def solution(begin, target, words):
    if target not in words:  # 애초에 words리스트에 target값이 없다면 return 0
        return 0

    q = deque()
    q.append([begin, 0])
    result = []
    while q:
        x, cnt = q.popleft()

        if x == target:
            return cnt

        for i in range(0, len(words)):
            diff = 0
            word = words[i]
            for j in range(len(x)):
                if x[j] != word[j]:
                    diff += 1
            if diff == 1:
                q.append([word, cnt + 1])
    return 0
