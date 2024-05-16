function solution(maps) {
    
    const n = maps.length
    const m = maps[0].length
    
    const directions = [[1,0], [-1,0], [0,1], [0,-1]]
    let queue = []
    queue.push([0,0,1])
    let visited = Array.from({length: n}, () => Array.from({length: m}).fill(0))
    visited[0][0] = 1
    
    while(queue.length > 0){
        let [x,y,move] = queue.shift()
        
        if(x === n-1 && y === m-1) return move
        
        for(let [dx, dy] of directions){
            let cx = x + dx
            let cy = y + dy
            
            if(cx >= 0 && cx < n && cy >= 0 && cy < m && maps[cx][cy] === 1 && visited[cx][cy] === 0){
                visited[cx][cy] = 1
                queue.push([cx, cy, move + 1])
            }
        }
    }
    
    return -1
}