s = input().split('-')
r_list = []
print("test1", s)

for i in s:
    s_sum = 0
    ss = i.split('+')
    print("test2", ss)
    for j in ss:
        s_sum += int(j)
    r_list.append(s_sum)


result = r_list[0]
for i in range(1, len(r_list)):
    result -= r_list[i]

print(result)
