function solution(k, m, score) {
    score = score.sort((a, b) => b - a)
    
    let idx = 0
    let sum = 0
    for(let i=0 ; i<Math.floor(score.length / m) ; i++){
        const apples = score.slice(idx, idx+m)
        sum += Math.min(...apples) * m
        idx += m
    }
    
    return sum
}