TC = int(input())
for testcase in range(TC):
    N = int(input())
    arr = list(map(int, input().split()))

    while len(arr) > 2:
        temp_arr = []
        for i in range(len(arr) // 2):
            temp_arr.append(arr[i] + arr[len(arr) - i - 1])
        if len(arr) % 2 == 1:
            temp_arr.append(arr[len(arr) // 2] * 2)
        arr = temp_arr

    print("Case #", end='')
    print(testcase + 1, end='')
    print(":", end=' ')
    print("Alice") if arr[0] > arr[1] else print("Bob")