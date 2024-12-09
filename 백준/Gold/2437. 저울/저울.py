N = int(input())
arr = list(map(int, input().split()))
arr.sort()
cnt = 1
for i in range(N):
    if cnt < arr[i]:
        break
    cnt += arr[i]
print(cnt)