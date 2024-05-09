function solution(board) {
    const n = board.length
    const m = board[0].length
    let start = [0, 0]
    let goal = [0 ,0]
    const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    
    board = board.map(row => row.split(''));
    
    for(let i=0 ; i<n ; i++){
        for(let j=0 ; j<m ; j++){
            if(board[i][j] === 'R') start = [i, j]
            if(board[i][j] === 'G') goal = [i, j]
        }
    }
    
    const queue = [[...start, 0]]
    const visited = Array.from({length: n}, () => Array(m).fill(false))
    visited[start[0]][start[1]] = true
    
    while(queue.length > 0){
        const [x, y, moves] = queue.shift()
        
        if(x === goal[0] && y === goal[1]) return moves
        
        for(let [dx, dy] of directions){
            let nx = x + dx
            let ny = y + dy
            
            while(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] !== 'D'){
                nx += dx
                ny += dy
            }
            
            nx -= dx
            ny -= dy
            
            if(!visited[nx][ny]){
                visited[nx][ny] = true
                queue.push([nx, ny, moves + 1])
            }
        }
    }
    
    return -1
    
}