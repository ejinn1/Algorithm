import sys
n = int(sys.stdin.readline())

queue = []

for _ in range(n):
    cmd, *arg = sys.stdin.readline().split()
    if cmd == 'push':
        queue.append(arg[0])
    elif cmd == 'pop':
        print(queue.pop(0) if queue else -1)
    elif cmd == 'size':
        print(len(queue))
    elif cmd == 'empty':
        print(0 if queue else 1)
    elif cmd == 'front':
        print(queue[0] if queue else -1)
    elif cmd == 'back':
        print(queue[-1] if queue else -1)
    
    
    