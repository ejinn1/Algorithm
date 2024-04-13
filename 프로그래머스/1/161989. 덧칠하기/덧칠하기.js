function solution(n, m, section) {
    
    let walls = Array.from({length: n}).map((_, i) => i+1)
    
    walls = walls.map((wall) => section.includes(wall) ? 0 : wall)
    
    let result = 0
    Array.from({length: walls.length}).forEach((_, i) => {
        if(walls[i] === 0){
            result += 1
            Array.from({length: m}).forEach((_, j) => walls[i+j] === 0 ? walls[i+j] += 1 : null)
        }
    })
    
    return result
}