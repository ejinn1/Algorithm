function solution(s) {
    const numMap = new Map()
    const arr = s.slice(2, -2).split('},{')
    
    arr.forEach(a => 
        a.split(',').forEach(num => 
            numMap.set(num, (numMap.get(num) || 0) + 1)
        )
    );

    return [...numMap]
        .sort((a, b) => b[1] - a[1])
        .map(([key]) => Number(key))
}
