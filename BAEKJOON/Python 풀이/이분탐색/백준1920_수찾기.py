from bisect import bisect_left, bisect_right
from sys import stdin

n = int(input())
n_list = list(map(int, stdin.readline().split()))
n_list.sort()

m = int(input())
m_list = list(map(int, stdin.readline().split()))


def count_num(array, left, right):
    left_index = bisect_left(n_list, left)
    right_index = bisect_right(n_list, right)
    return right_index - left_index


for i in m_list:
    count = count_num(n_list, i, i)
    if count >= 1:
        print(1)
    else:
        print(0)


