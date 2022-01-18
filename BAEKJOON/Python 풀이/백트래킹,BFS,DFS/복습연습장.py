from collections import Counter

print(Counter('hello world'))

array = [('홍길동', 35), ('이순신', 75), ('아무개', 50)]
result = sorted(array, key=lambda x : x[1], reverse=False)
print(result)