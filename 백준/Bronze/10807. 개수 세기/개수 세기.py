N = int(input())
arr = list(map(int, input().split()))
V = int(input())
cnt = 0
for i in range(N):
    if arr[i] == V : cnt = cnt+1
print(cnt)