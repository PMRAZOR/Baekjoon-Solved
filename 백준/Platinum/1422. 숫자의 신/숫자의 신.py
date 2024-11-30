def custom_sort_key(num): return str(num) * 10

K, N = map(int, input().split())
arr = []
for i in range(K):
    arr.append(int(input()))
req_num = len(arr)
sorted_arr = sorted(arr, key=custom_sort_key, reverse=True)
arr.sort(reverse=True)
max_num = arr[0]

N = N - req_num
if N > 0:
    target = 0
    for i in range(K):
        if sorted_arr[i] == max_num: target = i
    for i in range(N):
        sorted_arr.insert(target + 1, max_num)
print(int(''.join(map(str, sorted_arr))))