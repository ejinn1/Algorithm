function solution(routes) {
    routes.sort((a, b) => a[1] - b[1])
    
    let camera = -Infinity
    let count = 0
    
    routes.forEach((route) => {
        const [start, end] = route
        if(camera < start){
            camera = end
            count++
        }
    })
    
    return count
}