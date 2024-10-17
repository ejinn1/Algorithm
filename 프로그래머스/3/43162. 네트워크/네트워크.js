function solution(n, computers) {
    const visited = Array(n).fill(false)
    let result = 0
    
    function dfs(i){
        visited[i] = true
        
        for(let j=0 ; j<n ; j++){
            if(j !== i && computers[i][j] === 1 && !visited[j]){
                dfs(j)
            }
        }
    }
    
    for(let i=0 ; i<n ; i++){
        if(!visited[i]){
            dfs(i)
            result++
        }
    }
    
    return result
}