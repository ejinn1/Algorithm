function solution(plans) {
    const result = []
    const stack = []
    
    plans = plans.map((plan) => {
        let [h,m] = plan[1].split(':').map(Number)
        return [plan[0], h*60 + m, Number(plan[2])]
    })
    
    plans = plans.sort((a, b) => a[1] - b[1])
    console.log(plans)
    
    let curTime = 0
    for(let [name, start, duration] of plans){
        const startTime = start
        const play = duration
        
        while(stack.length > 0 && curTime < startTime){
            const [stop, remain] = stack.pop()
            if(curTime + remain <= startTime){
                result.push(stop)
                curTime += remain
            } else {
                stack.push([stop, remain - (startTime - curTime)])
                curTime = start
            }
        }
        
        stack.push([name, play])
        curTime = start
    }
    
    while(stack.length > 0){
        const [name, remain] = stack.pop()
        result.push(name)
    }
    
    return result
}