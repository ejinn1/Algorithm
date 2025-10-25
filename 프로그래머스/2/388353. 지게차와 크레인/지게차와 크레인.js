function solution(storage, requests) {
    const n = storage.length
    const m = storage[0].length
    let arr = Array.from({length: 1}, () => Array(m+2).fill(""))
    for(let i=0 ; i<n ; i++){
        arr.push(["", ... storage[i], ""])
    }
    arr.push(Array(m+2).fill(""))
    
    for(const req of requests){
        bfs(arr, req, n+2, m+2)
    }
    
    let result = 0
    for(const line of arr){
        result += line.filter((l) => l != "").length
    }
    
    return result
}

function bfs(arr, con, n, m){
    const visited = Array.from({length: n}, () => Array(m).fill(false))
    visited[0][0] = true
    const queue = [[0, 0]]
    const dir = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    let get = new Set()
    
    while(queue.length > 0){
        const [x, y] = queue.shift()
        
        for(const [dx, dy] of dir){
            const nx = x + dx
            const ny = y + dy
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue
            if(visited[nx][ny]) continue
            if(con[0] == arr[nx][ny]){
                get.add(`${nx},${ny}`)
            }
            if(con.length === 1 && arr[nx][ny] === ""){
                visited[nx][ny] = true
                queue.push([nx, ny])
            } else if(con.length === 2){
                visited[nx][ny] = true
                queue.push([nx, ny])
            }
        }
    }
    for(const key of get){
        const [x, y] = key.split(",").map(Number)
        arr[x][y] = ""
    }
}