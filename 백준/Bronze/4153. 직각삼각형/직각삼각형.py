a = 1
b = 1
c = 1

while 1:
    a, b, c = input().split()
    a = int(a)
    b = int(b)
    c = int(c)

    if a+b+c == 0:
        break

    if (a*a + b*b) == c*c:
        print("right")
    elif (a*a + c*c) == b*b:
        print("right")
    elif (c*c + b*b) == a*a:
        print("right")
    else:
        print("wrong")