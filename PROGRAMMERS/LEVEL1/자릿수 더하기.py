def solution(n):
    answer = 0
    array = list(str(n).strip())
    # print(array)
    for i in array:
        answer += int(i)

    return answer