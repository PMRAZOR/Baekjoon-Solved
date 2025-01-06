string = input()
if string == "1)(" or string == ")(1" or string == "()1" or string == "1()":
    print(1)
elif string == ")1(":
    print(2)
elif string == "(1)":
    print(0)