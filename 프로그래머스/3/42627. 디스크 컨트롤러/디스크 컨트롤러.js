function solution(jobs){
    let currentTime = 0
    let waitTime = 0
    let i = 0
    let heap = []
    
    jobs.sort((a, b) => a[0] - b[0])
    
    while(jobs.length > i || heap.length > 0){
        while(jobs.length > i && jobs[i][0] <= currentTime){
            heap.push(jobs[i++])
            heap.sort((a, b) => a[1] - b[1])
        }
        
        if(heap.length === 0){
            currentTime = jobs[i][0]
        } else {
            const [start, work] = heap.shift()
            currentTime += work
            waitTime += currentTime - start
        }
    }
    

    return Math.floor(waitTime / jobs.length)
}