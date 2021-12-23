string = list(input())
s = list(input())
cnt = 0
index = 0
while len(s) <= len(string) - index:
    if string[index:index+len(s)] == s:
        index += len(s)
        cnt += 1
    else:
        index += 1

print(cnt)