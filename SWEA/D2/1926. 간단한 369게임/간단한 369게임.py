T = int(input())
for i in range(1,T+1):
    if "3" in str(i) or "6" in str(i) or "9" in str(i):
        clap = str(i).count("3") + str(i).count("6")+ str(i).count("9")
        for i in range(clap):
            print("-", end="")
        print(" ", end="")
    else:
        print(i, end=" ")