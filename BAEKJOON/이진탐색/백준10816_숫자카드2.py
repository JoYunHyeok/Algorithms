from bisect import bisect_left, bisect_right
from sys import stdin

n = int(input())
n_list = list(map(int, stdin.readline().split()))
n_list.sort()

m = int(input())
m_list = list(map(int, stdin.readline().split()))


c_num = []
for i in m_list:
    count = bisect_right(n_list, i) - bisect_left(n_list, i)
    c_num.append(count)

print(*c_num)


