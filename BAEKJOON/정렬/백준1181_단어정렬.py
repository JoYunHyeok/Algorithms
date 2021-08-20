from sys import stdin

n = int(input())
a = []
b = []

for _ in range(n):
    a.append(stdin.readline().split()[0])

a = sorted(set(a)) # 중복제거

for i in a: # 길이를 추가해서 b에 붙이기
    b.append([i, len(i)])

# 알파벳순으로 정렬 후 길이순으로 정렬
b.sort(key=lambda x : x[0])
b.sort(key= lambda x : x[1])

for i in b:
    print(i[0])

# # 다른사람의 풀이
# n = int(input())
# a = []
#
# for _ in range(n):
#     word = str(input())
#     a.append((word, len(word)))
#
# a = list(set(a))
#
# # 길이정렬 > 알파벳정렬
# a.sort(key= lambda x:(x[1], x[0]))
# for i in a:
#     print(i[0])