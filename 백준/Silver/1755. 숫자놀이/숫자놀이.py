def dictionary_key(x):
    return tuple(dictionary[int(digit)] for digit in str(x))

M, N = map(int, input().split())
dictionary = {0: "zero", 1: "one", 2: "two", 3: "three", 4: "four", 5: "five", 6: "six", 7: "seven", 8: "eight", 9: "nine"}
arr = []

for i in range(M, N + 1):
    arr.append(i)

# print(arr)
arr = sorted(arr, key=dictionary_key)

for i in range(len(arr)):
    print(arr[i], end="")
    if (i + 1) % 10 == 0:
        print()
    elif i != len(arr) - 1:
        print(" ", end="")
