function solution(book_time) {
    const bookTime = book_time.map((b) => {
        const [h1, m1] = b[0].split(':').map(Number)
        const [h2, m2] = b[1].split(':').map(Number)
        
        return [h1*60+m1, h2*60+m2]
    }).sort((a, b) => a[0] - b[0])
    
    
    const minHeap = []
    
    function addHeap(end){
        minHeap.push(end)
        minHeap.sort((a, b) => a - b)
    }
    
    for(let [start, end] of bookTime){
        const startTime = start
        const endTime = end + 10
        
        if(minHeap.length > 0 && minHeap[0] <= startTime){
            minHeap.shift()
        }
        addHeap(endTime)
    }
    
    return minHeap.length
}