def solver(word):
    arr = [0 for _ in range(len(word))]
    next_i = 0
    for i in range(1, len(word)):
        while next_i > 0 and word[i] != word[next_i]:
            next_i = arr[next_i - 1]
        if word[i] == word[next_i]:
            next_i += 1
            arr[i] = next_i
    # print(arr)
    return max(arr) if arr else 0

word = input()
ans = 0
for i in range(len(word)):
    ans = max(ans, solver(word[i:]))
print(ans)
