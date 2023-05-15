def solution(arr):
    if len(arr) == 1:
        return [-1]
    else:
        m = min(arr)
        arr.remove(m)
        return arr