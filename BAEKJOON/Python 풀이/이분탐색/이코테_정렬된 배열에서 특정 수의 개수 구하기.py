from bisect import bisect_left, bisect_right
from sys import stdin

n, x = map(int, stdin.readline().split())
a_list = list(map(int, stdin.readline().split()))
#
# print(bisect_right(a_list,x)-bisect_left(a_list,x))

def count_by_range(array, left_value, right_value):
    right_index = bisect_right(array, right_value)
    left_index = bisect_left(array, left_value)
    return right_index - left_index

count = count_by_range(a_list, x, x)

if count == 0:
    print(-1)

else:
    print(count)

'''
7 2
1 1 2 2 2 2 3
'''