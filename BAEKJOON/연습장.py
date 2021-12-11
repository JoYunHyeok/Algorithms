# 폴더 정리 (small) (BOJ 22860) (못품)

import sys
sys.setrecursionlimit(10 ** 6)

def dfs(start, duplication):
    global total_file

    for next in file_system[start]:
        name, folder_or_file = next
        if folder_or_file == '1':
            dfs(file_maps[name], duplication)

        elif folder_or_file == '0':
            total_file += 1
            if not name in duplication:
                duplication[name] = 1


n, m = map(int, input().split())
idx = 0
file_maps = {'main': idx}
idx += 1
file_system = [[] for _ in range(n + 1)]

for _ in range(n + m):
    folder, b, c = input().split()

    if c == '1':

        if not folder in file_maps:
            file_maps[folder] = idx
            idx += 1

        if not b in file_maps:
            file_maps[b] = idx
            idx += 1

    if folder in file_maps:
        file_system[file_maps[folder]].append((b, c))
print("test->", file_maps)
print("Test2 ->", file_system)

loop_cnt = int(input())
for _ in range(loop_cnt):
    inst = input().split('/')
    folder = inst[-1]

    duplication = {}
    total_file = 0
    dfs(file_maps[folder], duplication)
    print(len(duplication), total_file)

'''
2 1
main folderA 1
folderC file1 0 
main folderC 1
3
main
main/folderA
main/folderC
'''