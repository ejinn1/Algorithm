n = int(input())
stack = []
op = []
cnt = 1
f = True

for i in range(n):
    num = int(input())
    while cnt <= num:
        stack.append(cnt)
        op.append('+')
        cnt += 1
        
    if stack[-1] == num:
        stack.pop()
        op.append('-')
    else:
        f = False
        break

if f == False:
    print('NO')
else:
    for i in op:
        print(i)