target = list(input().strip())
arr = list(input().strip())
while len(arr) != len(target):
    last = len(arr)
    if arr[last - 1] == "A":
        arr.pop()
    elif arr[last - 1] == "B":
        arr.pop()
        arr.reverse()
if arr == target:
    print(1)
else:
    print(0)