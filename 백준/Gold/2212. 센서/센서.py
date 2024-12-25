N = int(input())
K = int(input())
arr = list(map(int, input().split()))
arr.sort()

receiver = []
for i in range(N - 1):
    receiver.append(arr[i + 1] - arr[i])
receiver.sort()
print(sum(receiver[:N-K]))