import sys
from math import ceil, log

MOD = 1000000007

def segment(left, right, i):
    # 중앙 도달
    if left == right:
        segment_tree[i] = arr[left]
        return segment_tree[i]
    # 노드의 중앙값
    mid = (right + left) // 2
    # 세그먼트 배열에 넣을 노드들을 더한 값
    segment_tree[i] = segment(left, mid, i*2) * segment(mid+1, right, i*2+1) % MOD
    return segment_tree[i]

# 배열 시작, 끝, 시작할 id, 시작값(왼쪽), 끝낼 값(오른쪽)
def query_mul(start, end, idx, left, right):
    if left > end or right < start:
        return 1
    if left <= start and right >= end:
        return segment_tree[idx]
    mid = (start + end) // 2
    return query_mul(start, mid, idx*2, left, right) * query_mul(mid+1, end, idx*2+1, left, right) % MOD 

# idx = 노드번호, val = 변경할 값
def update(start, end, node, idx, val):
    if idx < start or idx > end:
        return segment_tree[node]
    if start == end:
        segment_tree[node] = val
        return segment_tree[node]
    mid = (start + end) // 2
    segment_tree[node] = update(start, mid, node*2, idx, val) * update(mid+1, end, node*2+1, idx, val) % MOD
    return segment_tree[node]

N, M, K = list(map(int, input().split()))
arr = [int(input()) % MOD for _ in range(N)]
# H = 트리의 높이
H = ceil(log(len(arr), 2))
# 트리의 크기 = 2의 H+1 승 (비트 연산자)
tree_size = 1 << (H+1) # == 2 ** (H + 1)
# 세그먼트 배열은 그만큼의 크기를 가지고 있어야함
segment_tree = [1] * tree_size
# 0 = 왼쪽, 배열크기 - 1 = 오른족, 1부터 시작
segment(0, N - 1, 1)
for i in range (M + K):
    a, b, c = list(map(int, input().split()))
    if a == 1 :
        update(0, N - 1, 1, b - 1, c % MOD)
        # print(segment_tree)
    elif a == 2 :
        print(query_mul(0, N - 1, 1, b - 1, c - 1))