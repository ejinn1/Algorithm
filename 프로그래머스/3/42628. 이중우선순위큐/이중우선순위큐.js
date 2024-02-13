function solution(operations) {
    let queue = []
    
    for(const operation of operations){
        let [command, num] = operation.split(' ')
        num = parseInt(num, 10)
        if(command === 'I'){
            queue.push(num)
            queue.sort((a, b) => b - a)
        } else if(queue.length > 0) {
            console.log(num)
            if(num === 1){
                queue.shift()
            } else {
                queue.pop()
            }
        }
    }
    
    if(queue.length === 0){
        return [0,0]
    } else {
        return [queue[0], queue[queue.length - 1]]
    }
    
    
}