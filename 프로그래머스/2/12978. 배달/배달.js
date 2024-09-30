function solution(N, road, K) {
    const graph = Array.from({length: N + 1}, () => [])
    const d = Array.from({length: N + 1} , () => Infinity)
    
    for(const [from, to, dist] of road){
        graph[from].push([to, dist])
        graph[to].push([from, dist])
    }
    
    const queue = []
    queue.push([1, 0])
    d[1] = 0

    while (queue.length !== 0) {
        const [curNode, dist] = queue.shift()
        
        if(dist > d[curNode]) continue
        
        for(const [nextNode, nextDist] of graph[curNode]){
            const cost = dist + nextDist
            
            if(cost < d[nextNode]){
                d[nextNode] = cost
                queue.push([nextNode, cost])
                queue.sort((a, b) => a[1] - b[1])
            }
        }
    }

    return d.filter((dist) => dist <= K).length
}
