function solution(n, computers) {
    let res = 0
    let visited = Array.from({length: n}).fill(false)
    
    function dfs(node){
        visited[node] = true
        
        for(let j=0 ; j<computers[node].length ; j++){
            if(computers[node][j] === 1 && !visited[j]){
                dfs(j)
            }
        }
    }
    
    for(let i=0 ; i<n ; i++){
        if(!visited[i]){
            res++
            dfs(i)
        }
    }
    
    return res
}