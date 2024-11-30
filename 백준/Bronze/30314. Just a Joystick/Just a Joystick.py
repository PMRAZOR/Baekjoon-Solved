n = int(input())
arr = input()
target = input()
cnt = 0
for i in range(n):
    dist = abs(ord(arr[i]) - ord(target[i]))
    cnt += min(dist, 26 - dist)
print(cnt)