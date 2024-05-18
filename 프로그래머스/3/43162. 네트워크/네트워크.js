function solution(n, computers) {
    
    let visited = Array.from({length : n}).fill(0)
    let res = 0

    function dfs(visited, node) {
        visited[node] = 1

        for (let i=0; i<computers[node].length; i++) {
            if (computers[node][i] && visited[i] === 0) {
                dfs(visited, i)
            }
        }
    }
    
    for (let i=0; i<visited.length; i++) {
        if (visited[i] !== 1){
            res++
            dfs(visited, i)
        }
    }
    
    return res
}