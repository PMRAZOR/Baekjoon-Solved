def solver(arr):
    for i in arr:
        if i > 59:
            return 0
    for i in arr:
        cnt = 0
        for i in arr:
            if 0 < i <= 12:
                cnt += 2
        return cnt

arr = list(map(int, input().split(sep=":")))
print(solver(arr))