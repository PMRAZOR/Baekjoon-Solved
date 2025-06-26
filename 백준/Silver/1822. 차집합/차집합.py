A, B = map(int, input().split())
arr_A = sorted(list(map(int, input().split()))) # 2 4 5
arr_B = sorted(list(map(int, input().split()))) # 1 2 3 4 5

remove_checker = [0 for i in range(A)]

index_A = 0
index_B = 0

ans = [] # 2 4 5

for i in range(A + B):
    # print("now", arr_A[index_A], arr_B[index_B])
    if index_A >= A or index_B >= B:
        # print(index_A, A, index_B, B)
        break

    if arr_A[index_A] < arr_B[index_B]:
        index_A += 1
    elif arr_A[index_A] > arr_B[index_B]:
        index_B += 1
    elif arr_A[index_A] == arr_B[index_B]:
        remove_checker[index_A] = 1
        index_A += 1
        index_B += 1

print(remove_checker.count(0))
# print(remove_checker)
for i in range(A):
    if remove_checker[i] == 0:
        print(arr_A[i], end=" ")
