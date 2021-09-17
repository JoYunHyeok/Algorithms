n = 118372

array = list(str(n).strip())
array.sort(reverse=True)

print(int(''.join(array)))