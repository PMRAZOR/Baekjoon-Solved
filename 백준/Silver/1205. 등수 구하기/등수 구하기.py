N, gigang, P = map(int, input().split())
if N == 0:
  print(1)
else:
  rank = [0 for i in range(P)]
  ranklist = list(map(int, input().split()))

  for i in range(N):
    rank[i] = ranklist[i]

  ans = 0

  if gigang <= rank[P - 1] and rank[P - 1] != 0:
    ans = -2

  elif gigang >= rank[0]:
    ans = 0

  elif gigang in rank:
    ans = rank.index(gigang)

  else:
    for i in range(P):
      if gigang >= rank[i] or rank[i] == 0:
        ans = i
        break

  print(ans + 1)
