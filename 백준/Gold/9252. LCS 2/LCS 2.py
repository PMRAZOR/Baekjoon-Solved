a = input().strip()
b = input().strip()
dp = [[0] * (len(b) + 1) for _ in range (len(a) + 1)]

for i in range(1, len(a) + 1):
    for j in range(1, len(b) + 1):
        if a[i - 1] == b[j - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

print(dp[len(a)][len(b)])

# print(dp)
# ACAYKP
# CAPCAK
# ACAK
# [0, 0, 0, 0, 0, 0, 0],
# [0, 0, 1, 1, 1, 1, 1] A A
# [0, 1, 1, 1, 2, 2, 2] C C
# [0, 1, 2, 2, 2, 3, 3] A A
# [0, 1, 2, 2, 2, 3, 3] Y
# [0, 1, 2, 2, 2, 3, 4] K K
# [0, 1, 2, 3, 3, 3, 4] P
#     0, 1, 2, 2, 3, 4
#  C, A, P, C, A, K
#     A,    C, A, K

ans = ""
len_a = len(a)
len_b = len(b)

while len_a > 0 and len_b > 0:
    if a[len_a - 1] == b[len_b - 1]:
        ans = a[len_a - 1] + ans
        len_a -= 1
        len_b -= 1
    elif dp[len_a - 1][len_b] > dp[len_a][len_b - 1]:
        len_a -= 1
    else:
        len_b -= 1

print(ans)