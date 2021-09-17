def solution(arr):
    if len(arr) == 1:
        return [-1]
    else:
        arr.remove(min(arr)) # 제일 작은 수가 하나가 아닐 수 있다!!
        return arr