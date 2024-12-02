arr = input().strip()
i = 0
while i < len(arr):
    if i + 2 < len(arr) and arr[i] != arr[i + 1] and arr[i] != arr[i + 2] and arr[i + 1] != arr[i + 2]:
        print("C", end="")
        i += 3
    else:
        if arr[i] == "R":
            print("S", end="")
        elif arr[i] == "B":
            print("K", end="")
        elif arr[i] == "L":
            print("H", end="")
        i += 1