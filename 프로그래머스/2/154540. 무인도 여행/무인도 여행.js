function solution(maps) {
    const n = maps.length
    const m = maps[0].length
    const visited = Array.from({length: n}, () => Array(m).fill(false))
    const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    
    maps = maps.map((map) => map.split(''))
    
    console.log(maps)
    
    const result = []
    
    function bfs(x, y){
        const queue = [[x, y]]
        visited[x][y] = true
        let sum = 0
        
        while(queue.length > 0){
            const [cx, cy] = queue.shift()
            sum += parseInt(maps[cx][cy], 10);
            
            for(let [dx, dy] of directions){
                const nx = cx + dx
                const ny = cy + dy
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] !== 'X'){
                    visited[nx][ny] = true
                    queue.push([nx, ny])
                }
            }
        }
        return sum
    }

    for(let i=0 ; i<n ; i++){
        for(let j=0 ; j<m ; j++){
            if(!visited[i][j] && maps[i][j] !== 'X'){
                const land = bfs(i, j)
                result.push(land)
            }
        }
    }
    
    if(result.length === 0) return [-1]
    
    return result.sort((a, b) => a - b)
    
}