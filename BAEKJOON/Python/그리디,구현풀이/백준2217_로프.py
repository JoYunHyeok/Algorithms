n = int(input())
array = []

for _ in range(n):
    array.append(int(input()))

array.sort(reverse=True)

for index, value in enumerate(array):
    array[index] = value * (index+1)

print(max(array))
