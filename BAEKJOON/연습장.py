'''
14마리
1 2 3 4 = 10 => 14 - 10 =4
1 2 = 3      =>  4 - 3 = 1
1 = 1        =>  1 - 1 = 0
'''

n = int(input())
cnt = 0
k = 1

while n != 0:
    if k > n:
        k = 1
    n -= k
    k += 1
    cnt += 1

print(cnt)