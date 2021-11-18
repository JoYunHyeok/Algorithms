# 첫번째 풀이
n, k = map(int, input().split())
a = list(map(int, input().split()))
a = sorted(a)
print(a[k-1])

# 두번째 풀이
def merge(array):
    if len(array) <= 1:
        return array

    mid = len(array) // 2
    left = merge(array[:mid])
    right = merge(array[mid:])

    i,j,k = 0, 0, 0

    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            array[k] = left[i]
            i += 1
        else:
            array[k] = right[j]
            j += 1
        k += 1

    if i == len(left):
        while j < len(right):
            array[k] = right[j]
            j += 1
            k += 1
    elif j == len(right):
        while i < len(left):
            array[k] = left[i]
            i += 1
            k +=1
    return array

merge_array = merge(a)
print(merge_array[k-1])