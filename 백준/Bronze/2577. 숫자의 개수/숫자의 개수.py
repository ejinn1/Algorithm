a = int(input())
b = int(input())
c = int(input())

num = str(a*b*c)


for i in range(0,10):
    sum = 0
    for x in list(num):
        if x == str(i):
            sum += 1
    print(sum)