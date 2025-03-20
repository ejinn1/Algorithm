function solution(priorities, location) {
    let res = 0
    let max = 9
    let position = Array.from({length: priorities.length}, (_, i) => i)

    while(priorities.length > 0){
        max = Math.max(...priorities)
        
        if(priorities[0] < max){
            priorities.push(priorities.shift())
            position.push(position.shift())
        } else {
            priorities.shift()
            res++
            if(position.shift() === location){
                return res
            }
        }
    }
    
    return res
}