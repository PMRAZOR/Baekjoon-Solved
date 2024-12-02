def is_valid_scores(n, scores):
    scores = sorted(scores)
    
    if sum(scores) != n * (n - 1) // 2:
        return False
    
    i = 0
    while i < n:
        win = scores[i]  
        lose = n - win - i - 1  
        
        for j in range(n - lose, n):
            scores[j] -= 1
            if scores[j] < 0: 
                return False
        
        scores[i] = 0 
        scores.sort() 
        i += 1
    
    return True

N = int(input())
scores = list(map(int, input().split()))
print(1 if is_valid_scores(N, scores) else -1)