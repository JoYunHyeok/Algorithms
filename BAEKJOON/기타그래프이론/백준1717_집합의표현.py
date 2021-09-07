from sys import stdin
import sys
sys.setrecursionlimit(100000)

input = stdin.readline

n, m = map(int, input().split())
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

for _ in range(m):

    k, a, b = map(int, input().split())

    if k == 1:
        if find_parent(parent, a) == find_parent(parent, b):
            print("YES")
        else:
            print("NO")

    else:
        union_parent(parent, a, b)
