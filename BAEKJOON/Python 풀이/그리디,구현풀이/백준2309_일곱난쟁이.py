array = [int(input()) for i in range(9)]

array.sort()
result = []

for i in range(9):
    if len(result) == 7:
        break

    for j in range(9):
        if i == j:
            continue

        if sum(array) - (array[i] + array[j]) == 100:
            for z in range(9):
                if array[z] == array[i] or array[z] == array[j]:
                    continue
                result.append(array[z])

print(*result, sep="\n")