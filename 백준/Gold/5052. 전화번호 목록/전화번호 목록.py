TC = int(input())
for test_case in range(TC):
    N = int(input())
    arr = [input().strip() for _ in range(N)]
    arr.sort()
    found = False
    for i in range(N - 1):
        if arr[i+1].startswith(arr[i]):
            found = True
            break
    print("NO" if found else "YES")