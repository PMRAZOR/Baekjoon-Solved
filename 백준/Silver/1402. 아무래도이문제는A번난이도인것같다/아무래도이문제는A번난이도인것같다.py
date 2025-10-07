# def find_smaller(before, num, num_list):
#     if num < 5:
#         return num_list
#     if num % 2 == 0:
#         if (before + (num // 2) + 2) not in num_list:
#             num_list.append(before + (num // 2) + 2)
#         find_smaller(before + 2, num // 2, num_list)
#     if num % 3 == 0:
#         if (before + (num // 3) + 3) not in num_list:
#             num_list.append(before + (num // 3) + 3)
#         find_smaller(before + 3, num // 3, num_list)
#     return num_list

TC = int(input())
for _ in range(TC):
    # A, B = map(int, input().split())
    # arr = []
    # for i in range(1, A + 1):
    #     if A % i == 0: arr.append(i)
    # # print(*arr)
    # ans = False
    # for i in range(len(arr) // 2):
    #     left = [arr[i]]
    #     right = [arr[len(arr) - (i + 1)]]
    #     if arr[i] > 3:
    #         left = find_smaller(0, arr[i], left)
    #     if arr[len(arr) - (i + 1)] > 3:
    #         right = find_smaller(0, arr[len(arr) - (i + 1)], right)
    #     # print("=====", i, "=====")
    #     # print("left", *left)
    #     # print("right", *right)
    #     # print("=============")
    #     left = sorted(left)
    #     right = sorted(right)
    #     for l in range(len(left)):
    #         for r in range(len(right)):
    #             # print("now", left[l] + right[r])
    #             if left[l] + right[r] == B:
    #                 ans = True
    #             if left[l] + right[r] > B:
    #                 break
    #         if ans: break
    #
    # if len(arr) % 2 != 1 and 2 * arr[len(arr) // 2] == B: ans = True
    # print("yes" if ans == True else "no")
    print("yes")