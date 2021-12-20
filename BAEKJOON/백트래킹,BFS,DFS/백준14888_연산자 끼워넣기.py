from sys import stdin
input = stdin.readline

N = int(input())
num_list = list(map(int, input().split())) # 수
oper_list = list(map(int, input().split())) # 연산자 +, -, *, //

MAX = -1e9
MIN = 1e9

def dfs(depth, total, plus, minus, multiply, divide):
    global MAX, MIN
    if depth == N:
        MAX = max(MAX, total)
        MIN = min(MIN, total)
        return

    if plus:
        dfs(depth + 1, total + num_list[depth], plus - 1, minus, multiply, divide)
    if minus:
        dfs(depth + 1, total - num_list[depth], plus, minus - 1, multiply, divide)
    if multiply:
        dfs(depth + 1, total * num_list[depth], plus, minus, multiply - 1, divide)
    if divide:
        dfs(depth + 1, total // num_list[depth], plus, minus, multiply, divide - 1)


dfs(1, num_list[0], oper_list[0], oper_list[1], oper_list[2], oper_list[3])
print(MAX)
print(MIN)



# # 백트래킹 (Python3 통과, PyPy3도 통과)
# import sys
#
# input = sys.stdin.readline
# N = int(input())
# num = list(map(int, input().split()))
# op = list(map(int, input().split()))  # +, -, *, //
#
# maximum = -1e9
# minimum = 1e9
#
#
# def dfs(depth, total, plus, minus, multiply, divide):
#     global maximum, minimum
#     if depth == N:
#         maximum = max(total, maximum)
#         minimum = min(total, minimum)
#         return
#
#     if plus:
#         dfs(depth + 1, total + num[depth], plus - 1, minus, multiply, divide)
#     if minus:
#         dfs(depth + 1, total - num[depth], plus, minus - 1, multiply, divide)
#     if multiply:
#         dfs(depth + 1, total * num[depth], plus, minus, multiply - 1, divide)
#     if divide:
#         dfs(depth + 1, int(total / num[depth]), plus, minus, multiply, divide - 1)
#
#
# dfs(1, num[0], op[0], op[1], op[2], op[3])
# print(maximum)
# print(minimum)