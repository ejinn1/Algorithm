function solution(n, computers) {
    const graph = Array.from({length: n+1}, () => [])
    
    for(let i=0 ; i<n ; i++){
        for(let j=0 ; j<n ; j++){
            if(i !== j && computers[i][j] === 1){
                graph[i+1].push(j+1)
            }
        }
    }
    
    const visited = Array(n+1).fill(false)
    let result = 0
    
    
    
    function dfs(node){
        if(visited[node]) return
        
        visited[node] = true
        
        for(const next of graph[node]){
            dfs(next)
        }
    }
    
    
    for(let i=1 ; i<=n ; i++){
        if(!visited[i]){
            dfs(i)
            result++
        }
        
    }
    
    
    
    return result
}