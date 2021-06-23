from sys import stdin

s = stdin.readline()

s_list = list(map(int, s.strip()))

result = s_list[0]
for i in range(1, len(s_list)):
    if s_list[i-1] == 0 or s_list[i-1] == 1:
        result = result + s_list[i]
    elif s_list[i-1] != 0:
        result = result * s_list[i]

print(result)
