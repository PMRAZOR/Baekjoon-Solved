def custom_sort_key(num): return str(num) * 10
N = int(input())
arr = list(map(int, input().split()))
sorted_arr = sorted(arr, key=custom_sort_key, reverse=True)
if sorted_arr[0] == 0: print(0)
else:
    for i in sorted_arr:
        print(i, end='')