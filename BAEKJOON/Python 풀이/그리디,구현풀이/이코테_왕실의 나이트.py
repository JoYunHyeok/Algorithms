n = input() # 나이트의 위치 입력받기
row = int(n[1]) # 행
col = int(ord(n[0])) - int(ord('a')) + 1 # 열은 문자라서 숫자로 변환

steps = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]

result = 0
for step in steps:
    next_row = row + step[0]
    next_col = col + step[1]
    if next_row >= 1 and next_row <= 8 and next_col >= 1 and next_col <= 8:
        result += 1

print(result)