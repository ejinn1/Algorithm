function solution(points, routes) {
    // 다음 이동할 위치
    const nextPosition = (r, c, targetR, targetC) => {
        if(r !== targetR) return r > targetR ? [r-1, c] : [r+1, c]
        if(c !== targetC) return c > targetC ? [r, c-1] : [r, c+1]
        return [r, c]
    }

    let arr = []
    let maxIndex = 0
    routes.forEach((route) => {
        let start = route.shift()
        let path = [points[start-1]]
        
        while(route.length){
            let [nowR, nowC] = path.at(-1)
            let [targetR, targetC] = points[route[0]-1]
            
            let [nextR, nextC] = nextPosition(nowR, nowC, targetR, targetC)
            
            path.push([nextR, nextC])
            if(nextR === targetR && nextC === targetC){
                route.shift()
            }
        }

        maxIndex = Math.max(maxIndex, path.length)
        arr.push(path)
    })

    let result = 0
    let index = 0
    while(index<=maxIndex){
        let crush = []
         for(let i=0; i<arr.length-1; i++){
            for(let j=i+1; j<arr.length; j++){
                if(
                    arr[i][index] && arr[j][index] &&
                    arr[i][index][0]===arr[j][index][0] 
                    && arr[i][index][1]===arr[j][index][1]
                ){
                    
                    let alreadyInclude = crush.some(
                        (point)=>point[0]===arr[i][index][0] && point[1]===arr[i][index][1]
                    )
                    if(!alreadyInclude){
                        crush.push([arr[i][index][0],arr[i][index][1]])
                        ++result 
                    }       
                }
            }
        }
        ++index
    }

    return result
}