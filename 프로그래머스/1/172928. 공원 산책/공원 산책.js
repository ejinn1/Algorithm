function solution(park, routes) {
    const H = park.length
    const W = park[0].length
    let x = 0
    let y = 0
    park.forEach((p, i) => {
        let j = p.indexOf('S')
        if(j !== -1){
            x = i
            y = j
        }
    })
    // 각 방향에 따른 x, y 좌표 변화량을 정의합니다.
    const d = {
        'E': [0,1],
        'W': [0,-1],
        'S': [1,0],
        'N': [-1,0]
    }
    // 주어진 명령들을 처리합니다.
    routes.forEach((route) => {
        const [op, n] = route.split(" ")
        const [dx, dy] = d[op]
        
        let newX = x
        let newY = y
        
        for(let i=0 ; i<n ; i++){
            newX += dx
            newY += dy
            
            if (newX < 0 || newX >= H || newY < 0 || newY >= W || park[newX][newY] === 'X') {
                newX = x
                newY = y
                break;
            }
        }
        x = newX
        y = newY
    })
    
    return [x, y]
}
