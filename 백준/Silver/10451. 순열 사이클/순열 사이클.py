def dfs_recursive(start, current, visited, arr, N):
    visited[current] = True
    if arr[current] == start:
        return True
    destination = arr[current]
    if visited[destination] == False:
        dfs_recursive(start, destination, visited, arr, N)
    return False

TC = int(input())
for _ in range (TC):
    N = int(input())
    arr = [0] + list(map(int, input().split()))

    visited = [False] * (N + 1)
    cnt = 0

    for i in range(1, N + 1):
        if visited[i] == False:
            dfs_recursive(i, i, visited, arr, N)
            cnt += 1
    print(cnt)

