function solution(dirs) {
    let x = 0
    let y = 0
    const directions = {
        'U' : [0, 1],
        "D" : [0, -1],
        "R" : [1, 0],
        "L" : [-1, 0]
    }
    
    let path = {}
    let res = 0
    for(let dir of dirs){
        let [dx, dy] = directions[dir]
        let cx = x + dx
        let cy = y + dy
        
        if(cx >= -5 && cx <= 5 && cy >= -5 && cy <= 5){
            let key1 = `${x}${y}${cx}${cy}`
            let key2 = `${cx}${cy}${x}${y}`
            if(!path[key1] && !path[key2]){
                path[key1] = true
                path[key2] = true
                res++
            }

            x = cx
            y = cy
        }
    }
    
    return res
}