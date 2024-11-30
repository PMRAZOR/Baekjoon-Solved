n = int(input())
arr = list(map(int, input().split()))
p_sum = [arr[0]] + [0] * (n - 1)
ans = 0

for i in range(1, n):
    p_sum[i] = p_sum[i - 1] + arr[i]

for i in range(1, n - 1):
    right = 2 * p_sum[-1] - arr[0] - arr[i] - p_sum[i]
    left = p_sum[-1] - arr[-1] - arr[i] + p_sum[i - 1]

    mid = p_sum[i] - arr[0] + p_sum[-1] - p_sum[i - 1] - arr[-1]
    ans = max(ans, right, left, mid)

print(ans)