tc = int(input())
for test_case in range(tc):
    arr = list(map(str, input().split()))
    length = len(arr)
    start = arr.index(input())
    time = int(input())
    for i in range(time - 1):
        if start == length - 1:
            start = 0
        else:
            start += 1
    print(arr[start])