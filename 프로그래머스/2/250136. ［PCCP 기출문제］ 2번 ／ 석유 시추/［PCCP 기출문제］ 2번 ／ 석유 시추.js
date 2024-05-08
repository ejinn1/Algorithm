function solution(land) {
    const n = land.length
    const m = land[0].length
    let patchID = 2
    const oilPatches = new Map()
    
    const directions = [[-1, 0], [1, 0], [0, -1], [0, 1]];
    
    function dfs(x,y,id){
        const stack = [[x,y]]
        let size = 0
        
        while(stack.length > 0){
            const [cx, cy] = stack.pop()
            if(land[cx][cy] === 1){
                land[cx][cy] = id
                size++
                for(let [dx, dy] of directions){
                    const nx = cx+dx
                    const ny = cy+dy
                    if(nx>=0 && nx<n && ny>=0 && ny<m && land[nx][ny] === 1){
                        stack.push([nx,ny])
                    }
                }
            }
        }
        return size
    }
    
    for(let i=0 ; i<n ; i++){
        for(let j=0 ; j<m ; j++){
            if(land[i][j] === 1){
                oilPatches.set(patchID, dfs(i,j,patchID))
                patchID++
            }
        }
    }
    
    let maxOil = 0
    for(let col=0 ; col<m ; col++){
        const ids = new Set()
        for(let row=0 ; row<n ; row++){
            const id = land[row][col]
            if(id > 1){
                ids.add(id)
            }
        }
        const oilAmount = Array.from(ids).reduce((acc, id) => acc + oilPatches.get(id), 0)
        maxOil = Math.max(maxOil, oilAmount)
    }
    
    return maxOil
}
