function solution(gems) {
    const gemKinds = new Set(gems).size
    const gemCount = new Map()
    let [start, end] = [0, 0]
    let [minStart, minEnd] = [0, gems.length - 1]
    
    while (end < gems.length) {
        gemCount.set(gems[end], (gemCount.get(gems[end]) || 0) + 1)
        end++

        while (gemCount.size === gemKinds) {
            if (end - start < minEnd - minStart + 1) {
                [minStart, minEnd] = [start, end - 1]
            }

            gemCount.set(gems[start], gemCount.get(gems[start]) - 1)
            if (gemCount.get(gems[start]) === 0) {
                gemCount.delete(gems[start])
            }
            start++
        }
    }

    return [minStart + 1, minEnd + 1]
}
