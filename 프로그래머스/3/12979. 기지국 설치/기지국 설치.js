function solution(n, stations, w) {
    let result = 0
    const coverage = w * 2 + 1
    
    let start = 1
    stations.forEach((station) => {
        const left = station - w
        const right = station + w
        
        if (start < left) {
            const uncovered = left - start
            result += Math.ceil(uncovered / coverage)
        }
        
        start = right + 1
    })
    if (start <= n) {
        const uncovered = n - start + 1
        result += Math.ceil(uncovered / coverage)
    }

    return result
}
