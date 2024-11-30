def solver(oc, oglist, cmdcnt, cmd):
    cmdlist = []
    onecmd = []
    for i in range(len(cmd)):
        if cmd[i] == 'I':
            cmdlist.append(list(onecmd))
            onecmd = [] # 초기화
        elif i == len(cmd) -1:
            onecmd.append(cmd[i])
            cmdlist.append(list(onecmd))
        else:
            onecmd.append(cmd[i])
    del cmdlist[0]
    #print(cmdlist)
    for j in range(len(cmdlist)):
        position = int(cmdlist[j][0])
        time = int(cmdlist[j][1])
        data = list(map(int, cmdlist[j][2:])) # 정수형 변환
        for k in range(time):
            oglist.insert(position + k, data[k])
    #print(oglist[:10])



T = 10
for test_case in range(1, T + 1):
    oc = input()
    oglist = list(map(int, input().split()))
    cmdcnt = input()
    cmd = input().split()
    solver(oc, oglist, cmdcnt, cmd)
    print(f"#{test_case}", *oglist[:10])