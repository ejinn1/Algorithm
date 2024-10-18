function solution(info, edges) {
    let maxSheep = 0
    
    function dfs(i, sheep, wolf, nexts){
        if(info[i] === 0){
            sheep++
        } else {
            wolf++
        }
        
        if(wolf >= sheep){
            return
        }
        
        maxSheep = Math.max(sheep, maxSheep)
        
        const possible = [...nexts]
        possible.splice(nexts.indexOf(i), 1)
        for(const [start, next] of edges){
            if(start === i){
                possible.push(next)
            }
        }
        
        for(const next of possible){
            dfs(next, sheep, wolf, possible)
        }
    }
    
    dfs(0, 0, 0, [0])
    
    return maxSheep

}
