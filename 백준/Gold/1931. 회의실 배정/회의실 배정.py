N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

arr.sort(key=lambda x: (x[0], x[1]))
cnt = 0
start = 0
end = 0
for cur in arr:
    if start <= cur[0] < end:
        if cur[1] < end:
            start = cur[0]
            end = cur[1]
    elif end <= cur[0]:
        start = cur[0]
        end = cur[1]
        cnt += 1
print(cnt)