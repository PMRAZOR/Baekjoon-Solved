from collections import deque

T = int(input())
for _ in range(T):
    command = list(input().strip(""))
    n = int(input())
    string = input()[1:-1]
    if string == "":
        arr = deque()
    else:
        arr = deque(map(int, string.split(",")))
    
    reverse = False
    error = False
    
    for i in command:
        if i == "R":
            reverse = not reverse
        elif i == "D":
            if not arr:
                error = True
                break
            else:
                if reverse:
                    arr.pop()
                else:
                    arr.popleft()
    if error:
        print("error")
    else:
        if reverse:
            arr.reverse()
        print("[" + ",".join(map(str, arr)) + "]")