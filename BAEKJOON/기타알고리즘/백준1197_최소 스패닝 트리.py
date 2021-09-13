from sys import stdin

input = stdin.readline

v, e = map(int, input().split())

parent = [i for i in range(v+1)]
array = []
result = 0

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

for _ in range(e):
    a, b, cost = map(int, input().split())
    array.append((cost, a, b))

array.sort()

for edge in array:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost

print(result)