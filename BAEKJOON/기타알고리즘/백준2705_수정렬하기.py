n = int(input())
a = []
for _ in range(n):
    a.append(int(input()))
a.sort()
print(*a, sep='\n')