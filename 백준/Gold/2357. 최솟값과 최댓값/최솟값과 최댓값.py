import sys
from math import ceil, log

def segment(left, right, i):
    # 중앙 도달
    if left == right:
        segment_tree[i] = (arr[left], arr[left])
        return segment_tree[i]
    # 노드의 중앙값
    mid = (right+left)//2
    leftChild = segment(left, mid, i*2)
    rightChild = segment(mid+1, right, i*2+1)
    # 세그먼트 배열에 넣을 노드들을 더한 값
    minNum = min(leftChild[0], rightChild[0])
    maxNum = max(rightChild[1], leftChild[1])
    segment_tree[i] = (minNum, maxNum)
    return segment_tree[i]

def query(node, start, end, left, right):
    # 범위 아웃 = 초기화
    if left > end or right < start:
        return (sys.maxsize, -sys.maxsize) 
    
    # 범위에 완전히 포함된 경우 노드를 트리에 추가
    if left <= start and end <= right:
        return segment_tree[node]
    
    # 범위가 부분적으로 겹치는 경우
    mid = (start + end) // 2
    left_result = query(node*2, start, mid, left, right)
    right_result = query(node*2+1, mid+1, end, left, right)
    
    return (min(left_result[0], right_result[0]),
            max(left_result[1], right_result[1]))


N, M = list(map(int, input().split()))
arr = [int(input()) for _ in range(N)]
# H = 트리의 높이
H = ceil(log(N, 2))
# 트리의 크기 = 2의 H+1 승 (비트 연산자)
tree_size = 1 << (H+1)
# 세그먼트 배열은 그만큼의 크기를 가지고 있어야함
segment_tree = [0] * tree_size
# 0 = 왼쪽, 배열크기 - 1 = 오른족, 1부터 시작
segment(0, N - 1, 1)
for i in range (M):
    a, b = list(map(int, input().split()))
    result = query(1, 0, N-1, a-1, b-1)
    print(result[0], result[1])