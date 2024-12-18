N = int(input())
arr = list(map(int, input().split()))

total_max = max(arr)
total_min = min(arr)

if total_max == total_min:
    print(1)
    exit()

answer = N
last_max = -1
last_min = -1

for i in range(N):
    if arr[i] == total_max:
        if last_min != -1:
            answer = min(answer, i - last_min + 1)
        last_max = i
    elif arr[i] == total_min:
        if last_max != -1:
            answer = min(answer, i - last_max + 1)
        last_min = i

print(answer)