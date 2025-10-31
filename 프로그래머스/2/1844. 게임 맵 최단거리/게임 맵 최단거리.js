function solution(maps) {
    const N = maps.length
    const M = maps[0].length
    
    const queue = [[0, 0, 1]]
    const visited = Array.from({length: N}, () => Array(M).fill(false))
    const dx = [0, 0, 1, -1]
    const dy = [1, -1, 0, 0]
    
    while(queue.length > 0){
        const [x, y, cnt] = queue.shift()
        
        if(visited[x][y]) continue
        visited[x][y] = true
        
        if(x === N-1 && y === M-1) return cnt
        
        for(let d=0 ; d<4 ; d++){
            const cx = x + dx[d]
            const cy = y + dy[d]
            
            if(cx < 0 || cx >= N || cy < 0 || cy >= M) continue
            if(visited[cx][cy]) continue
            if(maps[cx][cy] === 0) continue
            queue.push([cx, cy, cnt+1])
        }
    }
    
    return -1
}