array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]


'''
선택정렬

- 시간복잡도 o(n^2)
'''
for i in range(len(array)):
    min_index = i
    for j in range(i + 1, len(array)):
        if array[min_index] > array[j]:
            min_index = j
    array[i], array[min_index] = array[min_index], array[i]

print(array)





'''
삽입정렬

- 현재 리스트의 데이터가 거의 정렬되어 있는 상태라면 매우 빠르게 동작
- 시간복잡도 o(n^2) 최선인 경우 o(n)
- 이미 정렬되어 있는 상태라면
'''
for i in range(1, len(array)):
    for j in range(i, 0, -1):
        if array[j] < array[j - 1]:
            array[j], array[j - 1] = array[j - 1], array[j]
        else:
            break

print(array)





'''
퀵정렬

- 기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방법
- 병합 정렬과 더불어 대부분의 프로그래밍 언어의 정렬 라이브러리의 근간이 되는 알고리즘
- 첫 번째 데이터를 기준 데이터(Pivot)으로 설정
- 이상적이 경우 분할이 절반씩 일어난다면 o(nlogn) 최악의 경우는 o(n^2)
'''
def quick_sort(array, start, end):
    if start >= end:
        return
    pivot = start
    left = start + 1
    right = end
    while(left <= right):
        while(left <= end and array[left] <= array[pivot]):
            left += 1
        while(right > start and array[right] >= array[pivot]):
            right -= 1
        if(left > right):
            array[right], array[pivot] = array[pivot], array[right]
        else:
            array[left], array[right] = array[right], array[left]

    quick_sort(array, start, right-1)
    quick_sort(array, right + 1, end)

quick_sort(array, 0, len(array)-1)
print(array)

# 파이썬의 장점을 살린방식
def py_quick_sort(array):
    if len(array) <= 1:
        return array
    pivot = array[0]
    tail = array[1:]

    left_side = [x for x in tail if x <= pivot]
    right_side = [x for x in tail if x > pivot]

    return py_quick_sort(left_side) + [pivot] + py_quick_sort(right_side)

print(py_quick_sort(array))





'''
계수정렬
- 특정한 조건이 부합할 때만 사용할 수 있지만 매우 빠르게 동작하는 정렬 알고리즘
- 데이터의 크기 범위가 제한되어 정수 형태로 표현할 수 있을때 사용 가능
- 데이터의 개수가 N, 데이터(양수) 중 최댓값이 K일 때 최악의 경우에도 수행시간 O(n+k)를 보장합니다.
- 심각한 비효율성을 초래할 수 있다.
--> 데이터가 0과 999,999로 단 2개만 존재하는 경우
- 동일한 값을 가지는 데이터가 여러 개 등장할 때 효과적으로 사용가능
--> 성적의 경우 100점을 맞은 학생이 여러 명일 수 있기 때문에 계수정렬이 효과적
'''
array = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]

count = [0] * (max(array) + 1)

for i in range(len(array)):
    count[array[i]] += 1

for i in range(len(count)):
    for j in range(count[i]):
        print(i, end=' ')














