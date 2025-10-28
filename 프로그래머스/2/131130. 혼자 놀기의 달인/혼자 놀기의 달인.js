function solution(cards) {
    // 8
    // 1 2 3 4 5 6 7 8
    const graph = Array.from({length: cards.length+1}, () => [])
    
    for(let i=0 ; i<cards.length ; i++){
        graph[i+1].push(cards[i])
    }
    
    // console.table(graph)
    
    const visited = Array(cards.length+1).fill(false)
    const queue = [[1, 0]]
    const cnts = []
    
    for(const card of cards){
        if(!visited[card]){
            cnts.push(dfs(card, 0))
        }
    }
    
    // console.log(cnts)
    
    cnts.sort((a, b) => b - a)
    
    return cnts.length > 1 ? cnts[0] * cnts[1] : 0

    function dfs(node, cnt){
        const next = graph[node]
        
        if(visited[next]){
            return cnt
        }
        
        visited[next] = true
        return dfs(next, cnt+1)
    }
}

// [1, 2, 3, 4, 5, 6, 7, 8] 1
// [4, 3, 5, 8, 6, 7, 2, 10, 11, 1, 9, 13, 15, 14, 12] 20
// [2, 3, 4, 1] 0