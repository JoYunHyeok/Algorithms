'''
병합정렬(Merge sort) 알고리즘

- 분할 정복 (Divide & Conquer)방식을 이용합니다.
- 절반씩 합치면서 정렬하면, 전체 리스트가 정렬됩니다.
- 시간 복잡도 O(NlogN)을 보장합니다.
'''

def merge_sort(array):
    if len(array) <= 1:
        return array

    mid = len(array) // 2
    left = merge_sort(array[:mid])
    right = merge_sort(array[mid:])
    i, j, k = 0, 0, 0
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
            k += 1
    return array


n = int(input())
array = []
for _ in range(n):
    array.append(int(input()))

print(*merge_sort(array), sep="\n")


# sorted() 활용
n = int(input())
array = []
for _ in range(n):
    array.append(int(input()))
array = sorted(array)
print(*array, sep="\n")