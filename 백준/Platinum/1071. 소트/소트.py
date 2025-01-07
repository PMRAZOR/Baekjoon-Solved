N = int(input())
arr = list(map(int, input().split()))
max_num = max(arr)
counting = [0] * (max_num + 3)
count = N
nums = []  # 실제 존재하는 수들을 저장할 리스트

for i in range(N):
    if counting[arr[i]] == 0:  # 처음 나오는 수라면
        nums.append(arr[i])
    counting[arr[i]] += 1
nums.sort()  # 오름차순 정렬

while count > 0:
    for k in range(len(nums)):
        i = nums[k]
        if counting[i] > 0:
            if counting[i + 1] > 0:  # i+1이 있는 경우를 먼저 확인
                found = False
                # i+2 이상의 수 찾기 (실제 존재하는 수들 중에서만)
                for j in nums[k + 1:]:  # nums 리스트에서 현재 위치 이후의 수들만 확인
                    if j >= i + 2 and counting[j] > 0:
                        for _ in range(counting[i]):
                            print(i, end = ' ')
                            count -= 1
                        counting[i] = 0
                        print(j, end = ' ')
                        counting[j] -= 1
                        count -= 1
                        found = True
                        break
                if not found:
                    print(i + 1, end=' ')
                    counting[i + 1] -= 1
                    count -= 1
            else:  # i+1이 없는 경우
                for _ in range(counting[i]):
                    print(i, end = ' ')
                    count -= 1
                counting[i] = 0