class MinHeap {
    constructor(){
        this.heap = []
    }
    
    swap(i, j){
        [this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]]
    }
    
    push(value){
        this.heap.push(value)
        let cur = this.heap.length - 1
        
        while(cur > 0) {
            let parent = parseInt((cur-1) / 2)
            if(this.heap[cur] < this.heap[parent]){
                this.swap(cur, parent)
                cur = parent
            } else {
                break
            }
        }
    }
    
    pop(){
        if(this.heap.length === 0) return null
        if(this.heap.length === 1) return this.heap.pop()
        
        let min = this.heap[0]
        this.heap[0] = this.heap.pop()
        this.heapify(0)
        
        return min
        
    }
    
    heapify(index){
        let small = index
        let left = index * 2 + 1
        let right = index * 2 + 2
        

        if(left < this.heap.length && this.heap[small] > this.heap[left]){
            small = left
        }

        if(right < this.heap.length && this.heap[small] > this.heap[right]){
            small = right
        }
        
        
        if(index !== small){
            this.swap(index, small)
            this.heapify(small)
        }
    }
}

function solution(scoville, K) {
    const minHeap = new MinHeap()
    
    scoville.forEach((sco) => minHeap.push(sco))
    
    let res = 0
    while(minHeap.heap.length > 1 && minHeap.heap[0] < K){
        const first = minHeap.pop()
        const second = minHeap.pop()
    
        minHeap.push(first + second * 2)
        res++
    }
    
    return minHeap.heap[0] >= K ? res : -1
}