# n = int(input())
#
# if n-1 == 0:
#     print(str(666))
# else:
#     print(str(n-1) + str(666))

## 규칙 ##
# 1. 666
# 2. 1666
# 3. 2666
# 4. 3666
# 5. 4666
# 6. 5666
# 7. 6660
# 8. 6661
# 9. 6662
# 10. 6663

n = int(input())
f_num = 666 # 종말의 숫자
cnt = 0

while True:
    if '666' in str(f_num):
        cnt+=1
    if n == cnt:
        print(f_num)
        break
    f_num += 1

