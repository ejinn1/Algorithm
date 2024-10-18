function solution(n, edge) {
    const graph = Array.from({length: n+1}, () => [])
    
    for(const [start, end] of edge){
        graph[start].push(end)
        graph[end].push(start)
    }
    
    
    
    const distance = Array(n+1).fill(-1)
    distance[1] = 0
    
    const queue = [1]
    
    while(queue.length > 0){
        const cur = queue.shift()
        
        for(const next of graph[cur]){
            if(distance[next] === -1){
                distance[next] = distance[cur] + 1
                queue.push(next)   
            }
        }
    }
    
    const max = Math.max(...distance)
    const cnt = distance.filter((d) => d === max).length
    
    return cnt
}
