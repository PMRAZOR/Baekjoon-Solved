def solver(arr, curr, i, susik, done):
    if len(arr) == i:
        if curr == 0:
            done.append(susik)
        return
    # print("current: ", susik)
    solver(arr, curr + arr[i], i + 1, susik + "+" + str(arr[i]), done)
    solver(arr, curr - arr[i], i + 1, susik + "-" + str(arr[i]), done)
    if len(susik) > 2:
        if susik[-2] == "-":
            solver(arr, (curr + arr[i - 1]) - ((arr[i - 1] * 10) + arr[i]), i + 1, susik + " " + str(arr[i]), done)
        elif susik[-2] == "+":
            solver(arr, (curr - arr[i - 1]) + ((arr[i - 1] * 10) + arr[i]), i + 1, susik + " " + str(arr[i]), done)
        elif susik[-2] == " ":
            solver(arr, (curr * 10) + arr[i], i + 1, susik + " " + str(arr[i]), done)
    elif len(susik) == 1:
        solver(arr, (curr * 10) + arr[i], i + 1, susik + " " + str(arr[i]), done)

TC = int(input())
for _ in range(TC):
    N = int(input())
    arr = [i + 1 for i in range(N)]
    susik = str(arr[0])
    ans = []
    solver(arr, arr[0], 1, susik, ans)
    ans.sort()
    for i in ans:
        print(i)
    print()