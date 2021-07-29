text_input = input()
list = []
total = 0

for i in text_input:
    if i.isalpha():
        list.append(i)
    else:
        total += int(i)

list.sort()

if total != 0:
    list.append(str(total))

print(''.join(list))
