function solution(x, y, n) {
    if(x === y) return 0
    
    const queue = [[y,0]]
    const visited = new Set()
    visited.add(x)
    
    while(queue.length > 0){
        const [cur, cnt] = queue.shift()
        const nexts = [cur-n]

        if(cur % 2 === 0){
            nexts.push(cur/2)
        }
        if(cur % 3 === 0){
            nexts.push(cur/3)
        }
        
        for(let next of nexts){
            if(next === x) return cnt + 1
            if(next > x && !visited.has(next)){
                visited.add(next)
                queue.push([next, cnt + 1])
            }
        }
    }
    
    return -1
}