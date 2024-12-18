N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
arr.sort()
cnt = 1
for i in range(N - 1):
    if arr[i][0] + arr[i][1] < arr[i + 1][0]:
        cnt += 1
print(cnt)