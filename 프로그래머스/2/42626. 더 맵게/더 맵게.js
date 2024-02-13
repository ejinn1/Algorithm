class MinHeap {
    constructor(){
        this.heap = []
    }
    
    size(){
        return this.heap.length
    }
    
    push(value){
        this.heap.push(value)
        let curIdx = this.heap.length - 1
        
        while(curIdx > 0 && this.heap[curIdx] < this.heap[Math.floor((curIdx - 1) / 2)]){
            const tmp = this.heap[curIdx]
            this.heap[curIdx] = this.heap[Math.floor((curIdx - 1) / 2)]
            this.heap[Math.floor((curIdx - 1) / 2)] = tmp
            curIdx = Math.floor((curIdx - 1) / 2)
        }
    }
    
    pop(){
        if(this.heap.length === 0) return null
        if(this.heap.length === 1) return this.heap.pop()
        
        const minValue = this.heap[0]
        this.heap[0] = this.heap.pop()
        let curIdx = 0
        
        while(curIdx * 2 + 1 < this.heap.length){
            let minChildIdx = curIdx * 2 + 2 < this.heap.length && this.heap[curIdx * 2 + 2] < this.heap[curIdx * 2 + 1] ? curIdx * 2 + 2 : curIdx * 2 + 1
            
            if(this.heap[curIdx] < this.heap[minChildIdx]){
                break
            }
            
            const tmp = this.heap[curIdx]
            this.heap[curIdx] = this.heap[minChildIdx]
            this.heap[minChildIdx] = tmp
            curIdx = minChildIdx
        }
        
        return minValue
    }
    
    peek(){
        return this.heap[0]
    }
}

function solution(scoville, K) {
    const minHeap = new MinHeap()
    
    for(const sco of scoville){
        minHeap.push(sco)
    }
    
    let cnt = 0
    
    while(minHeap.size() >= 2 && minHeap.peek() < K){
        const first = minHeap.pop()
        const second = minHeap.pop()
        const mixedScov = first + second * 2
        minHeap.push(mixedScov)
        cnt++
    }
    
    return minHeap.peek() >= K ? cnt : -1
}