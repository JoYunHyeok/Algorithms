from sys import stdin
input = stdin.readline


'''
퀸은 수직, 수평, 대각선 이동 가능!
수직체크, 대각선체크를 해야함
- 이전 상단에 위치한 퀸의 위치에서 열에 해당하는 부분은 놓으면 안된다. (수직체크) : 열끼리 빼준게 0일때
- abs(이전 퀸의 열 - 현재 위치한 자리의 열) = 1 (대각선 체크)

= 행마다 조건이 만족하는, 알맞게 어디에 배치해야 되는지 위치를 구하는것으로 구현 
'''
def check(x):
    for i in range(x):
        if row[x] == row[i]: # 수직에 겹치는지
            return False
        if abs(row[x] - row[i]) == x - i: # 대각선에 겹치는지
            return False
    return True


def dfs(x):
    global result
    if x == n:
        result += 1
    else:
        for i in range(n):
            row[x] = i
            if check(x):
                dfs(x + 1)


n = int(input())
row = [0] * n
result = 0
dfs(0)
print(result)
