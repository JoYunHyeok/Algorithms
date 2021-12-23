# from sys import stdin
# input = stdin.readline
#
# n, m = map(int, input().split()) #폴더의 총 개수 n, 파일의 총 개수 m
#
# class Folder:
#     def __init__(self, fp_name):
#         file_list = []
#         self.folder = fp_name
#         if fp_name not in file_list:
#             file_list.append(fp_name)
#
# class File:
#     def __init__(self, fp_name):
#         self.file = fp_name
#
#
#
# window = {}
# for _ in range(n+m):
#     p, fp_name, c = input().split()
#
#     if p == 'main':
#         if c == '1':
#             window[p] = Folder(fp_name)
#         elif c == '0':
#             window[p] = File(fp_name)
#     else:
#         if c == '1':
#             window['main']['p'] = Folder(fp_name)
#
#
# print(window['main'])

import sys
sys.setrecursionlimit(10**8)
input = sys.stdin.readline


def go(target, kinds): #탐색할 함수
    global f_num
    if target not in direc: #현재 탐색할 주체가 파일이나 폴더가 없다면 종료한다
        return

    for title, val in direc[target]:
        if val == 0:
            if title not in kinds: #title은 파일명
                kinds.add(title)
            f_num += 1

        else: #폴더라면 더 탐색해서 들어감
            go(title, kinds)
    return


N, M = map(int, input().split())
direc = {} #폴더 디렉토리
for i in range(N+M):
    From, To, Id = input().rstrip().split()
    if From not in direc:
        direc[From] = []
        direc[From].append([To, int(Id)])
    else:
        direc[From].append([To, int(Id)])
print("test ->", direc)


q = int(input())
f_num = 0
for i in range(q):
    query = input().rstrip().split('/')
    SET = set()
    f_num = 0
    go(query[-1], SET)

    print(len(SET), f_num)

