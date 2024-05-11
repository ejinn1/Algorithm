function solution(maps) {
    const n = maps.length
    const m = maps[0].length
    const directions = [[1,0], [-1,0], [0,1], [0,-1]]
    maps = maps.map((map) => map.split(''))
    
    let start = [0, 0]
    let lever = [0, 0]
    let exit = [0, 0]
    
    for(let i=0 ; i<n ; i++){
        for(let j=0 ; j<m ; j++){
            if(maps[i][j] === 'S') start = [i,j]
            else if(maps[i][j] === 'E') exit = [i,j]
            else if(maps[i][j] === 'L') lever = [i,j]
        }
    }
    
    function bfs(start, goal){
        const queue = [[...start, 0]]
        let visited = Array.from({length : n}, () => Array(m).fill(false))
        visited[start[0]][start[1]] = true
        
        while(queue.length > 0){
            let [x, y, moves] = queue.shift()
            
            if(goal[0] === x && goal[1] === y) return moves

            for(let [dx, dy] of directions){
                const nx = x + dx
                const ny = y + dy

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] !== 'X'){
                    visited[nx][ny] = true
                    queue.push([nx, ny, moves + 1])
                }
            }
        }
        return -1
    }
    
   
    // 레버 찾기
    const leverMoves = bfs(start, lever)
    if(leverMoves === -1) return -1
    
    // 출구 찾기
    const exitMoves = bfs(lever, exit)
    if(exitMoves === -1) return -1

    return leverMoves + exitMoves    
    
}