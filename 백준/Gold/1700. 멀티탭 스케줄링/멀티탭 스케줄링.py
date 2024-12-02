#백준허브테스트용
N, K = map(int, input().split())
if N >= K:
    print(0)
    exit()

arr = list(map(int, input().split()))
current = set()
cnt = 0

for i, num in enumerate(arr):
    if num in current:
        continue
    if len(current) < N:
        current.add(num)
    else:
        cnt += 1
        to_remove = max(current, key=lambda x: arr[i:].index(x) if x in arr[i:] else K)
        current.remove(to_remove)
        current.add(num)

print(cnt)