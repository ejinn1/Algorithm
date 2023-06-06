import sys
n = int(sys.stdin.readline())

for _ in range(n):
    stack = []
    vps = list(input())
    for v in vps:
        if v == '(':
            stack.append(v)
        elif v == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(v)
                break
    if not stack:
        print('YES')
    else:
        print('NO')
            