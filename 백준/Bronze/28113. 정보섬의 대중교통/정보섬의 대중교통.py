N, A, B = map(int, input().split())
bus = A
subway = B
while True:
    if subway >= N:
        break
    subway += B
if bus < subway:
    print("Bus")
elif bus > subway:
    print("Subway")
elif bus == subway:
    print("Anything")