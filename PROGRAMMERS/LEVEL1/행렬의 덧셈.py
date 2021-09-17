arr1 = [[1],[2]]
arr2 = 	[[3],[4]]

answer = [[] * i for i in range(len(arr1))]
print(len(arr1[0]))
for i in range(len(arr1)):
    for j in range(len(arr1[0])):
        answer[i].append(arr1[i][j] + arr2[i][j])


print(answer)