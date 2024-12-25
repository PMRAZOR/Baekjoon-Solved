def is_palindrome(arr, left, right):
    while left < right:
        if arr[left] != arr[right]:
            return False
        left += 1
        right -= 1
    return True

def solution(s):
    left = 0
    right = len(s) - 1
    
    while left < right:
        if s[left] != s[right]:
            skip_left = is_palindrome(s, left + 1, right)
            skip_right = is_palindrome(s, left, right - 1)
            
            if skip_left or skip_right:
                return 1
            else:
                return 2
        left += 1
        right -= 1
    
    return 0

T = int(input())
for _ in range(T):
    word = input().strip()
    print(solution(word))