'''
2 2     3 3
2 2     3 3

2 * 4, 3 * 4

2 1 2   2 1 2   3 2 3
1 0 1   1 0 1   2 1 2
2 1 2   2 1 2   3 2 3

1 * 8, 2 * 12, 3 * 4

2 1 1 2     3 2 2 3
1 0 0 1     2 1 1 2
1 0 0 1     2 1 1 2
2 1 1 2     3 2 2 3

1 * 28, 2 * 20, 3 * 4

3면 = 4개
2면 = 8 * N - 12
1면 = 5 * (N * N) - 16 * N + 12
'''

N = int(input())
arr = list(map(int, input().split()))
min_arr = []

if arr[0] > arr[5]:
    min_arr.append(arr[5])
else:
    min_arr.append(arr[0])
if arr[2] > arr[3]:
    min_arr.append(arr[3])
else:
    min_arr.append(arr[2])
if arr[4] > arr[1]:
    min_arr.append(arr[1])
else:
    min_arr.append(arr[4])

min_arr.sort()

one = min_arr[0]
two = min_arr[0] + min_arr[1]
three = min_arr[0] + min_arr[1] + min_arr[2]

if N == 1:
    total = sum(arr)
    max_value = max(arr)
    print(total - max_value)
else:
    print(one * (5 * (N * N) - 16 * N + 12) + two * (8 * N - 12) + three * 4)