n = int(input())

for number in range(1, n+1):
    n_list = list(map(int, str(number))) # 198 -> [1, 9, 8]
    result = number + sum(n_list) # 198 + sum([1, 9, 8])
    if n == result:
        print(number)
        break
    if n == number: # 생성자가 없는 경우에는 0을 출력한다.
        print(0)