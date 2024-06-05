function solution(park, routes) {
    const H = park.length
    const W = park[0].length
    let x = 0
    let y = 0
    
    for(let i=0 ; i<W ; i++){
        for(let j=0 ; j<H ; j++){
            if(park[i][j] === 'S'){
                x = j
                y = i
            }
        }
    }
    
    const direction = {
        'N': [-1, 0],
        'S': [1, 0],
        'W': [0, -1],
        'E': [0, 1]
    }
    
    routes.forEach((route) => {
        const [op, n] = route.split(' ')
        let cx = x
        let cy = y
        let f = true
        
        for(let i=0 ; i<n ; i++){
            const [dy, dx] = direction[op]
            cx += dx
            cy += dy
            
            if(cx < 0 || cx >= W || cy < 0 || cy >= H || park[cy][cx] === 'X'){
                f = false
                break
            }
        }
            
        if(f){
            x = cx
            y = cy
        }
    })

    return [y, x]
}
