

function solution(n, s, a, b, fares){
    const graph = Array.from({length: n+1}, () => [])
    
    for(const [start, end, dist] of fares){
        graph[start].push([end, dist])
        graph[end].push([start, dist])
    }
    
    function dijkstra(n, start, graph){
        const dist = Array(n+1).fill(Infinity)
        dist[start] = 0

        const pq = [[start, 0]]

        while(pq.length > 0){
            const [cur, curDist] = pq.shift()

            if(curDist > dist[cur]) continue

            for(const [target, weight] of graph[cur]){
                const newDist = curDist + weight
                if(newDist < dist[target]){
                    dist[target] = newDist
                    pq.push([target, newDist])
                }
            }
        }

        return dist
    }
    
    const distA = dijkstra(n, a, graph)
    const distB = dijkstra(n, b, graph)
    const distS = dijkstra(n, s, graph)
    
    let result = Infinity
    for(let i=1 ; i<=n ; i++){
        result = Math.min(result, distA[i] + distB[i] + distS[i])
    }
    
    return result
}