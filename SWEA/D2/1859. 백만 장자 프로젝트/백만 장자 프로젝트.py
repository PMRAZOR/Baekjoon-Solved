T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    ma = list(map(int,input().split()))
    sum = 0
    max = 0
    for i in reversed(ma):
        if i > max:
            max = i
            # 6 7 10, 9, 2 3
        else:
            sum += max - i
            #0, 4+6, 1+2+2
 
    print("#" + str(test_case), str(sum))
