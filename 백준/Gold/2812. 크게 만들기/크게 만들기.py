N, K = map(int, input().split())
num = list(input())
stack = []

for i in range(N):
    while stack and stack[-1] < num[i]:
        if K == 0:
            break
        stack.pop()
        K -= 1
    stack.append(num[i])
if K > 0:
    stack = stack[:-K]
print(''.join(stack))