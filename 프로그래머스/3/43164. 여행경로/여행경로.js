function solution(tickets) {
    
    // 티켓 정렬
    tickets.sort((a, b) => a[1].localeCompare(b[1]))
    // 방문 배열
    let visited = Array(tickets.length).fill(false)
    // dfs
    let res = []
    function dfs(cur, path, cnt){
        if(cnt === tickets.length){
            res = path
            return true
        }
        
        for(let i=0 ; i<tickets.length ; i++){
            if(!visited[i] && cur === tickets[i][0]){
                visited[i] = true
                if(dfs(tickets[i][1], [...path, tickets[i][1]], cnt + 1)){
                    return true
                }
                visited[i] = false
            }
        }
    }
    
    // dfs 실행, 시작은 ICN
    dfs('ICN', ['ICN'], 0)
    
    return res
}