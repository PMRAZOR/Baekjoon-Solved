def NGE(arr, N):
    stack = []
    ans = [-1] * N
    for i in range(N):
        while stack and arr[stack[-1]] < arr[i]:
            ans[stack.pop()] = arr[i]
        stack.append(i)
    return ans

N = int(input())
arr = list(map(int, input().split()))

ans = NGE(arr, N)
print(*ans)