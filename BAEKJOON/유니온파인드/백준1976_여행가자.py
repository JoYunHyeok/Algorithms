from sys import stdin

input = stdin.readline

n = int(input())
m = int(input())

parent = [i for i in range(n+1)]

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

for i in range(1, n+1):
    graph = list(map(int, input().split()))

    for index, value in enumerate(graph):
        if value == 1:
            union_parent(parent, i, index + 1)


tour = list(map(int, input().split()))
result = set([find_parent(parent, i) for i in tour])

if len(result) != 1:
    print("NO")
else:
    print("YES")
