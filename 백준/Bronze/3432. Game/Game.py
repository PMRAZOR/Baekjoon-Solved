def valid_check(arr, temp):
    for i in range(5):
        for j in range(5):
            if j <= 2 and temp == arr[i][j] and temp == arr[i][j+1] and temp == arr[i][j+2]:
                return True
            if i <= 2 and temp == arr[i][j] and temp == arr[i+1][j] and temp == arr[i+2][j]:
                return True
            if i <= 2 and j <= 2 and temp == arr[i][j] and temp == arr[i+1][j+1] and temp == arr[i+2][j+2]:
                return True
            if i <= 2 and j >= 2 and temp == arr[i][j] and temp == arr[i+1][j-1] and temp == arr[i+2][j-2]:
                return True
    return False

N = int(input())
for i in range(N):
    case = 0
    arr = [list(input().strip()) for _ in range(5)]
    for j in range(5):
        for k in range(5):
            temp = arr[j][k]
            if valid_check(arr, temp):
                if temp == "A" and case == 0:
                    case = 1
                elif temp == "B" and case == 0:
                    case = 2
                elif temp == "A" and case == 2:
                    case = 3
                elif temp == "B" and case == 1:
                    case = 3
        if case == 3:
            break
    if case == 1:
        print("A wins")
    elif case == 2:
        print("B wins")
    elif case == 3:
        print("draw")