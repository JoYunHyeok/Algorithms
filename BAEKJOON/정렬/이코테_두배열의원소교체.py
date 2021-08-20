from sys import stdin

n, k = map(int, stdin.readline().split())
a_list = list(map(int, stdin.readline().split()))
b_list = list(map(int, stdin.readline().split()))

a_list.sort()
b_list.sort(reverse=True)

# print(a_list)
# print(b_list)

for i in range(k):
    if a_list[i] < b_list[i]:
        a_list[i], b_list[i] = b_list[i], a_list[i]
    else:
        break

print(sum(a_list))



'''
5 3
1 2 5 4 3
5 5 6 6 5
'''
