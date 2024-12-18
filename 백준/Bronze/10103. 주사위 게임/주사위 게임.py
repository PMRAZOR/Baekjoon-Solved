N = int(input())
a = 100
b = 100
for i in range(N):
    temp_a, temp_b = input().split()
    if temp_a > temp_b:
        b -= int(temp_a)
    elif temp_b > temp_a:
        a -= int(temp_b)
print(a, end="\n")
print(b)