function solution(s) {
    s = s.split(' ').map(Number)
    
    let min = Math.min(...s)
    let max = Math.max(...s)
    
    console.log(min, max)
    
    return `${min} ${max}`
}